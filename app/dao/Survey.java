package dao;

import com.fasterxml.jackson.databind.JsonNode;

public class Survey {
	
	private String campaignId;
	private String userId;
	private String surveyId;
	private String timeSend;
	private String timeStart;
	private String timeSubmit;
	private JsonNode result;
	
	public Survey(){}
	
	public Survey(String campaignId, String userId, String surveyId, String timeSend, String timeStart,
			String timeSubmit, JsonNode result) {
		this.campaignId = campaignId;
		this.userId = userId;
		this.surveyId = surveyId;
		this.timeSend = timeSend;
		this.timeStart = timeStart;
		this.timeSubmit = timeSubmit;
		this.result = result;
	}
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public String getTimeSend() {
		return timeSend;
	}
	public void setTimeSend(String timeSend) {
		this.timeSend = timeSend;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeSubmit() {
		return timeSubmit;
	}
	public void setTimeSubmit(String timeSubmit) {
		this.timeSubmit = timeSubmit;
	}
	public JsonNode getResult() {
		return result;
	}
	public void setResult(JsonNode result) {
		this.result = result;
	}
	
	

}
