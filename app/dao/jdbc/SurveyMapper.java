package dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.ddth.dao.jdbc.IRowMapper;

import dao.KeySurvey;
import dao.Survey;
import forms.ResultForm;
import play.libs.Json;

public class SurveyMapper implements IRowMapper<Survey> {
	
	public final static SurveyMapper INSTANCE = new SurveyMapper();
	
	private final static String COL_CAMPAIGN_ID = "r_campaign_id";
	private final static String COL_USER_ID = "r_user_id";
	private final static String COL_SURVEY_ID = "r_survey_id";
	private final static String COL_TIME_SEND = "r_time_send";
	private final static String COL_TMIME_START = "r_time_start";
	private final static String COL_TIME_SUBMIT = "r_time_submit";
	private final static String COL_RESULT = "r_result";
	
	public final static String _CLAUSE_WHERE_KEY = COL_SURVEY_ID + " =? ";
	public final static String _VALUE_UPDATE_SURVEY = COL_TMIME_START + "= ?, " + COL_TIME_SUBMIT + "= ?, "
			+ COL_RESULT + "= ? ";
	public final static String _CLAUSE_WHERE_UPDATE = COL_CAMPAIGN_ID + " =? AND " + COL_USER_ID + " =? ";
	
	public static Object[] valueForSelect(String id) {
        return new Object[] { id };
    }
	
	public static Object[] valueForUpdate(KeySurvey key, ResultForm res) {
        return new Object[] { res.getTimeStart(), res.getTimeSubmit(), res.getResult().toString(), key.getCampaignId(), key.getUserId() };
    }

	@Override
	public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
		Survey bo = new Survey();
		bo.setCampaignId(rs.getString(COL_CAMPAIGN_ID));
		bo.setUserId(rs.getString(COL_USER_ID));
		bo.setSurveyId(rs.getString(COL_SURVEY_ID));
		bo.setTimeSend(rs.getString(COL_TIME_SEND));
		bo.setTimeStart(rs.getString(COL_TMIME_START));
		bo.setTimeSubmit(rs.getString(COL_TIME_SUBMIT));
		bo.setResult(Json.toJson(rs.getString(COL_RESULT)));
		
		return bo;
	}

}
