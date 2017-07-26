package dao.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.ddth.dao.jdbc.BaseJdbcDao;

import dao.Campaign;
import dao.ISurveyDAO;
import dao.KeySurvey;
import dao.Survey;
import forms.ResultForm;

public class JdbcSurveyDAO extends BaseJdbcDao implements ISurveyDAO {

	@Override
	public JdbcSurveyDAO init() {
		super.init();
		return this;
	}

	private final String SQL_INSERT_CAMPAIGN = "INSERT INTO survey_campaign ("
			+ StringUtils.join(CampaignMapper._COLS_ALL, ",") + ") VALUES (" + CampaignMapper._VALUE_INSERT_CAMPAIGN
			+ ")";

	@Override
	public void insert(Campaign campaign) throws SQLException {
		execute(SQL_INSERT_CAMPAIGN, CampaignMapper.valueForInsert(campaign));

	}

	private final String SQL_UPDATE_CAMPAIGN = "UPDATE survey_campaign SET " + CampaignMapper._VALUE_UPDATE_CAMPAIGN
			+ " WHERE " + CampaignMapper._CLAUSE_WHERE_KEY;

	@Override
	public void update(String id, Campaign campaign) throws SQLException {
		execute(SQL_UPDATE_CAMPAIGN, CampaignMapper.valueForUpdate(id, campaign));

	}

	private final String SQL_DELETE_CAMPAIGN = "DELETE from survey_campaign where " + CampaignMapper._CLAUSE_WHERE_KEY;

	@Override
	public void delete(String id) throws SQLException {
		execute(SQL_DELETE_CAMPAIGN, CampaignMapper.valueForSelect(id));
	}

	private final String SQL_SELECT_ALL_CAMPAIGN = "SELECT " + StringUtils.join(CampaignMapper._COLS_ALL, ",")
			+ " FROM survey_campaign";

	@Override
	public List<Campaign> list() throws SQLException {
		return executeSelect(CampaignMapper.INSTANCE, SQL_SELECT_ALL_CAMPAIGN);
	}

	private final String SQL_SELECT_CAMPAIGN_BY_ID = "SELECT " + StringUtils.join(CampaignMapper._COLS_ALL, ",")
			+ " FROM survey_campaign WHERE " + CampaignMapper._CLAUSE_WHERE_KEY;

	@Override
	public Campaign getById(String id) throws SQLException {
		List<Campaign> lsCampaign = executeSelect(CampaignMapper.INSTANCE, SQL_SELECT_CAMPAIGN_BY_ID,
				CampaignMapper.valueForSelect(id));
		return lsCampaign != null && lsCampaign.size() > 0 ? lsCampaign.get(0) : null;
	}

	@Override
	public String getQA(String campaignId) throws SQLException {
		Campaign campaign = getById(campaignId);
		return campaign.getData().asText();
	}

	private final String SQL_SELECT_SURVEY_BY_SURVEY_ID = "SELECT * FROM survey_result WHERE "
			+ SurveyMapper._CLAUSE_WHERE_KEY;

	@Override
	public KeySurvey getKey(String surveyId) throws SQLException {
		List<Survey> lsSurvey = executeSelect(SurveyMapper.INSTANCE, SQL_SELECT_SURVEY_BY_SURVEY_ID,
				SurveyMapper.valueForSelect(surveyId));
		Survey survey = lsSurvey != null && lsSurvey.size() > 0 ? lsSurvey.get(0) : null;

		KeySurvey key = new KeySurvey(survey.getCampaignId(), survey.getUserId());

		return key;
	}

	private final String SQL_UPDATE_SURVEY = "UPDATE survey_result SET " + SurveyMapper._VALUE_UPDATE_SURVEY + " WHERE "
			+ SurveyMapper._CLAUSE_WHERE_UPDATE;

	@Override
	public void updateResultSurvey(KeySurvey key, ResultForm result) throws SQLException {
		execute(SQL_UPDATE_SURVEY, SurveyMapper.valueForUpdate(key, result));

	}

}
