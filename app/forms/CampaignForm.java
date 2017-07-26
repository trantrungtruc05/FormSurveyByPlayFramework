package forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import dao.Campaign;

public class CampaignForm extends Campaign {
	
	public CampaignForm(){
		super();
	}
	
	public CampaignForm(Campaign campaign, InfoCampaignForm info){
		super(campaign.getId(), campaign.getCampaignName(), campaign.getPageTitle(), campaign.getFromDate(),
				campaign.getToDate(), campaign.getData(), campaign.getCreatedBy());
		this.question1 = info.getQuestion1();
		this.question2 = info.getQuestion2();
		this.answer1 = info.getAnswer1();
		this.type = info.getType();
	}
	
	public  List<String> validate() {
		
		List<String> errors = new ArrayList<>();
		if (StringUtils.isBlank(campaignName)) {
			errors.add("Campaign Name is empty");
		}
		if(StringUtils.isBlank(pageTitle)){
			errors.add("Page Title is empty");
		}
		if(StringUtils.isBlank(fromDate)){
			errors.add("From Date is empty");
		}
		if(StringUtils.isBlank(toDate)){
			errors.add("To Date is empty");
		}
		if(type.equals("0")){
			errors.add("Type is empty");
		}
		if(StringUtils.isBlank(question1)){
			errors.add("Question 1 is empty");
		}
		if(answer1.size()<2){
			errors.add("Answer 1 must more 2 value");
		}
		if(StringUtils.isBlank(question2)){
			errors.add("Question 2 is empty");
		}
		
		return errors != null ? errors : null;

	}
}
