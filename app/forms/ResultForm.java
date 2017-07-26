package forms;

import com.fasterxml.jackson.databind.JsonNode;

public class ResultForm {
	
	private String timeStart;
	private String timeSubmit;
	private JsonNode result;
	
	public ResultForm(){};
	public ResultForm(String timeStart, String timeSubmit, JsonNode result) {
		super();
		this.timeStart = timeStart;
		this.timeSubmit = timeSubmit;
		this.result = result;
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
