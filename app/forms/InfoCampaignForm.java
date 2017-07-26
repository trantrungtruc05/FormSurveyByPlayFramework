package forms;

import java.util.List;

public class InfoCampaignForm {
	
	private String type;
	private String question1;
	private List<String> answer1;
	private String question2;
	
	public InfoCampaignForm(){};
	
	public InfoCampaignForm(String type, String question1, List<String> answer1, String question2) {
		this.type = type;
		this.question1 = question1;
		this.answer1 = answer1;
		this.question2 = question2;
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
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

}
