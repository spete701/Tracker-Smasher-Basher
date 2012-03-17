package net.stevenpeterson.tracker;

public class JobDataListDecorator {

	private JobData job;

	private JobDataListDecorator(JobData job) {
		this.job = job;
	}

	public static JobDataListDecorator factory(JobData job) {
		return new JobDataListDecorator(job);
	}

	public String getListEntry() {
		return listEntry(job.getAddress(), job.getDate(), job.getContact(),
				editLink());
	}

	private String editLink() {
		return "<a href=\"EditJob?" + XXX.JOB_NUMBER_GET_POST_VARIABLE_NAME
				+ "=" + this.job.getJobNumber() + "\" > VIEW OR CHANGE JOB</a>";
	}

	public static String listEntry(String address, String date, String contact,
			String editLink) {
		return "<div id=\"listing\">Address: " + address + " <br />\nDate: "
				+ date + "<br />\nContact " + contact + "<br />\n" + editLink
				+ "</div>\n";
	}

	public static String listing(JobData job) {
		return new JobDataListDecorator(job).getListEntry();
	}
}
