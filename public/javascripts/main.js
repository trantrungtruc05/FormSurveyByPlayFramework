function doFunction(){
	  var id = $( "#type" ).val();
	  $("#test").append(id);
	  
	  var singleSelect = "<div id=\"answerData\"><div class=\"radio\" id=\"answer1[0]\"><label><input type=\"radio\" name=\"optradio\" value=\"opt1\"><input type=\"text\" placeholder=\"Answer\" name=\"answer1[0]\"></label></div><div class=\"radio\" id=\"answer1[1]\"><label><input type=\"radio\" name=\"optradio\" value=\"opt2\"><input type=\"text\" placeholder=\"Answer\" name=\"answer1[1]\"></label></div></div><div class=\"radio\"><a href=\"javascript:addAnswerRadio()\">Add New</a></div>";
	  var multiSelect = "\<div id=\"answerData\"><label class=\"checkbox-inline\" id=\"answer1[0]\"><input type=\"checkbox\" value=\"ckb1\"><input type=\"text\" placeholder=\"Answer\" name=\"answer1[0]\"></label><label class=\"checkbox-inline\" id=\"answer1[1]\"><input type=\"checkbox\" value=\"ckb1\"><input type=\"text\" placeholder=\"Answer\" name=\"answer1[1]\"></label></div><a href=\"javascript:addAnswerCheckbox()\">Add New</a>";
	  var text = "<input type=\"text\" id=\"answer\" class=\"form-control\">"
	  if (id == 1) {
		  $("#answer1").empty();
		  $("#answer1").append(singleSelect);
		}
	  else if(id == 2) {
		  	$("#answer1").empty();
			$("#answer1").append(multiSelect);
	  }else{
			console.log("doNothing");
		}
	
}

function addAnswerRadio(){
	var numberAnswer = $("#answerData > div").length;
	var addRadio = "<div class=\"radio\" id=\"answer1[replaceThis]\"><label><input type=\"radio\" name=\"optradio\"><input type=\"text\" placeholder=\"Answer\" name=\"answer1[replaceThis]\"></label><a style=\"cursor: pointer;\" id=\"answer1[replaceThis]\">x</a></div>";
	$("#answerData").append(addRadio.replace(/replaceThis/g , numberAnswer));
}

function addAnswerCheckbox(){
	var numberAnswer = $("#answerData > label").length;
	var addCheckbox = "<label class=\"checkbox-inline\" id=\"answer1[replaceThis]\"><input type=\"checkbox\"><input type=\"text\" placeholder=\"Answer\" name=\"answer1[replaceThis]\" ><a style=\"cursor: pointer;\" id=\"answer1[replaceThis]\">x</a></label>";
	$("#answerData").append(addCheckbox.replace(/replaceThis/g, numberAnswer));
}

$(document).on('click', 'a', function() {
	  var id = this.id;
	  $("div#" + String(id.replace("[", "\\[").replace("]", "\\]"))).remove();
	  $("label#" + String(id.replace("[", "\\[").replace("]", "\\]"))).remove();
	});

$(function () {
    $('#fromdatePicker').datetimepicker();
    $('#todatePicker').datetimepicker();
});






