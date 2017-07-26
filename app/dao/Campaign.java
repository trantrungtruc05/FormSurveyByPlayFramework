package dao;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class Campaign {
	
	protected String id;
	protected String campaignName;
	protected String pageTitle;
	protected String fromDate;
	protected String toDate;
	protected JsonNode data;
	protected int createdBy;
	
	//test new flow
	protected String question1;
	protected List<String> answer1;
	protected String question2;
	protected String type;
	
	public Campaign(){}
	
	public Campaign(String id, String campaignName, String pageTitle, String fromDate, String toDate, JsonNode data, int createdBy) {
		this.id = id;
		this.campaignName = campaignName;
		this.pageTitle = pageTitle;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.data = data;
		this.createdBy = createdBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public JsonNode getData() {
		return data;
	}

	public void setData(JsonNode data) {
		this.data = data;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	
	//test new flow
	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public List<String> getAnswer1() {
		return answer1;
	}

	public void setAnswer1(List<String> answer1) {
		this.answer1 = answer1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
