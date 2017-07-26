package controllers;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.ddth.commons.utils.JacksonUtils;

import dao.KeySurvey;
import forms.InfoCampaignForm;
import forms.ResultForm;
import modules.registry.RegistryGlobal;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Result;


public class SurveyPageController extends BasePageController  {

	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public final static String VIEW_SURVEY = "contentSurvey";
	public final static String VIEW_DONE = "done";
	private  String timeStart = "";
	private static  String surveyId = "";
	
	public Result survey() throws Exception {
		timeStart = sdf.format(new Date());
		surveyId = request().getQueryString("sid");
		
		KeySurvey key = getKey();
		
		String qa = RegistryGlobal.registry.getJdbcSurvey().getQA(key.getCampaignId());
		
		JsonNode json = Json.parse(qa);
		
		JsonNode content_q1 = Json.parse(json.get("question_1").toString());
		JsonNode content_q2 = Json.parse(json.get("question_2").toString());
		
		String type = JacksonUtils.getValue(content_q1,  "type", String.class);
		String q1 = JacksonUtils.getValue(content_q1,  "content", String.class);
		String q2 = JacksonUtils.getValue(content_q2,  "content", String.class);
		
		List<String> a1 = new ArrayList<>();

		for (int i=0; i<content_q1.get("answer").size(); i++) {
			a1.add(content_q1.get("answer").get(i).asText());
		}
		
		InfoCampaignForm info = new InfoCampaignForm(type, q1, a1, q2);
		
		return ok(render(VIEW_SURVEY, info));
	}
	
	public Result submitSurvey() throws Exception{
		ResultForm res = getResultForm();
		res.setTimeSubmit(sdf.format(new Date()));
		KeySurvey key = getKey();
		RegistryGlobal.registry.getJdbcSurvey().updateResultSurvey(key, res);
		return ok(render(VIEW_DONE));
	}
	
	public ResultForm getResultForm(){
		DynamicForm requestData = createForm().bindFromRequest();
		String question1 = requestData.get("question1");
		String answer1 = requestData.get("answer1");
		String question2 = requestData.get("question2");
		String answer2 = requestData.get("answer2");
		
		Map<String, String> content = new HashMap<>();
		
		content.put("question1", question1);
		content.put("answer1", answer1);
		content.put("question2", question2);
		content.put("answer2", answer2);
		
		JsonNode resultJson = Json.toJson(content);
		
		ResultForm result = new ResultForm(timeStart, "", resultJson);
		
		return result;
		
	}
	
	public KeySurvey getKey() throws SQLException{
		return RegistryGlobal.registry.getJdbcSurvey().getKey(surveyId);
	}
	
}
