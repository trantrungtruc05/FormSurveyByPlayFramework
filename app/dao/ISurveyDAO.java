package dao;

import java.sql.SQLException;
import java.util.List;

import forms.ResultForm;

public interface ISurveyDAO {
	
	public void insert(Campaign campaign) throws SQLException;
	public void update(String id, Campaign campaign) throws SQLException;
	public void delete(String id) throws SQLException;
	public List<Campaign> list() throws SQLException;
	public Campaign getById(String id) throws SQLException;
	public String getQA(String campaignId) throws SQLException;
	
	public KeySurvey getKey(String surveyId) throws SQLException;
	public void updateResultSurvey(KeySurvey key, ResultForm result) throws SQLException;
	
}
