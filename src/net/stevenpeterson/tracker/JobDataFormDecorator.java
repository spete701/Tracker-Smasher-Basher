package net.stevenpeterson.tracker;

public class JobDataFormDecorator {

	private JobData job;

	private JobDataFormDecorator(JobData job) {
		super();
		this.job = job;
	}

	public static JobDataFormDecorator formFactory(JobData job) {
		return new JobDataFormDecorator(job);
	}

	public String formDecoration() {
		StringBuilder sb = new StringBuilder();
		sb.append(configureForm());
		sb.append(dateField());
		sb.append(addressField());
		sb.append(contactField());
		sb.append(contactPhoneField());
		sb.append(travelToField());
		sb.append(arrivalTimeField());
		sb.append(descriptionField());
		sb.append(finishedAtField());
		sb.append(travelFromField());
		sb.append(jobIDField());
		sb.append(jobNumberField());
		sb.append(closeForm());
		return sb.toString();
	}

	// Include a submit button, and close the form.
	public String closeForm() {
		return "<input type='submit' name='submit' value='Save Job'/><br /></form>";
	}

	// Setup of form
	// Setup of form action
	// Label form with JobNumber
	public String configureForm() {
		return "<div id='container'>Job Number: " + this.job.getJobNumber()
				+ "</div><hr />\n<div id='container'>\n<form id='editJob' method='post' action='JobUpdateFeedback' >\n";
	}

	public String arrivalTimeField() {
		return buildTextBox("Arrival Time", job.getArrivalTime(), "arrivedAt");
	}

	public String contactField() {
		return buildTextBox("Contact[s]", job.getContact(), "contacts");
	}

	public String contactPhoneField() {
		return buildTextBox("Contact Phone", job.getContactPhone(),
				"contactPhone");
	}

	public String descriptionField() {
		return buildTextArea("Description", job.getDescription(), "description");
	}

	public String finishedAtField() {
		return buildTextBox("Finished Job At", job.getFinishedAt(),
				"finishedAt");
	}

	public String travelToField() {
		return buildTextBox("Travel To Site From Office (minutes)",
				job.getTravelTo(), "travelToSite");
	}

	public String travelFromField() {
		return buildTextBox("Travel From Site To Office (minutes)",
				job.getTravelFrom(), "travelFromSite");
	}

	public String dateField() {
		return buildTextBox("Date", job.getDate(), "date");
	}

	public String addressField() {
		return buildTextBox("Address", job.getAddress(), "address");
	}
	
	public String jobIDField() {
		return buildTextBox("JobID - DONE ID", job.getJobId(), "jobID");
	}
	
	public String jobNumberField(){
		return buildHiddenValue(job.getJobNumber(), "jobNumber");
	}

	public String buildHiddenValue(String value, String name) {
		return "<input type=\"hidden\" name=\""+name+"\" value=\""+value+"\" />\n";
	}

	public static String buildTextBox(String labelString, String value,
			String formElementName) {
		return "<div class='inputElement'><div class='label'>" + labelString
				+ ": </div><input type='text' value='" + value + "' name='"
				+ formElementName + "' /><br /></div>\n";
	}

	public static String buildTextArea(String labelString, String value,
			String formElementName) {
		return "<div class='inputElement'><div class='label'>" + labelString
				+ ": </div><textarea name='" + formElementName
				+ "' class='formDescription'>" + value
				+ "</textarea><br /></div>\n";
	}

}
