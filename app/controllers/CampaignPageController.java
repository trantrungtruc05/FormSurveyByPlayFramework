package controllers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.ddth.commons.utils.JacksonUtils;

import dao.Campaign;
import forms.CampaignForm;
import forms.InfoCampaignForm;
import modules.registry.RegistryGlobal;
import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;

public class CampaignPageController extends BasePageController {

	public final static String VIEW_INDEX = "index";
	public final static String VIEW_FORM_CAMPAIGN = "formCampaign";
	public final static String VIEW_LIST_CAMPAIGN = "listCampaign";
	
	private String action = "";

	public Result index() throws Exception {
		Campaign campaign = new Campaign();
		InfoCampaignForm info = new InfoCampaignForm("", "", new ArrayList<>(), "");
		return ok(render(VIEW_INDEX, campaign, info, new ArrayList<String>()));
	}

	public Result listAllCampaign() throws Exception {
		List<Campaign> listCampaign = RegistryGlobal.registry.getJdbcSurvey().list();
		return ok(render(VIEW_LIST_CAMPAIGN, listCampaign));
	}

	public Result updateCampaign() throws Exception {
		String id = request().getQueryString("id");
		action = request().getQueryString("action");
		Logger.info(id);
		Campaign campaign = RegistryGlobal.registry.getJdbcSurvey().getById(id);
		JsonNode data = Json.parse(campaign.getData().asText());

		JsonNode content_q1 = Json.parse(data.get("question_1").toString());
		JsonNode content_q2 = Json.parse(data.get("question_2").toString());

		String type = JacksonUtils.getValue(content_q1,  "type", String.class);
		
		String q1 = JacksonUtils.getValue(content_q1,  "content", String.class);
		
		String q2 = JacksonUtils.getValue(content_q2,  "content", String.class);

		List<String> a1 = new ArrayList<>();

		for (int i=0; i<content_q1.get("answer").size(); i++) {
			a1.add(content_q1.get("answer").get(i).asText());
		}
		
		InfoCampaignForm info = new InfoCampaignForm(type, q1, a1, q2);
		
		return ok(render(VIEW_INDEX, campaign, info, new ArrayList<String>()));
	}

	public Result finishedCampaign() throws Exception {
		Form<Campaign> form = createForm(Campaign.class).bindFromRequest();
		Campaign camp = form.bindFromRequest().get();
		
		InfoCampaignForm info = new InfoCampaignForm(camp.getType(), camp.getQuestion1(), camp.getAnswer1(), camp.getQuestion2()); 
		
		CampaignForm formValidate = new CampaignForm(camp, info);
		
		List<String> messageValidate = formValidate.validate();
		if(messageValidate.size() >0){
			return ok(render(VIEW_INDEX, camp, info, messageValidate));
		}
		
		if (action.equals("edit")) {
			RegistryGlobal.registry.getJdbcSurvey().update(camp.getId(), camp);
		} else {
			RegistryGlobal.registry.getJdbcSurvey().insert(camp);
		}
		
		action = "";
		
		return redirect(routes.CampaignPageController.listAllCampaign());
	
	}
	
	public Result deleteCampaign() throws Exception{
		String id = request().getQueryString("id");
		RegistryGlobal.registry.getJdbcSurvey().delete(id);
		
		return redirect(routes.CampaignPageController.listAllCampaign());
	}
	
	

}


