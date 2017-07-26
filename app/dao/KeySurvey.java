package dao;

public class KeySurvey {
	
	private String campaignId;
	private String userId;
	public KeySurvey(){};
	public KeySurvey(String campaignId, String userId) {
		this.campaignId = campaignId;
		this.userId = userId;
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
	
	

}
