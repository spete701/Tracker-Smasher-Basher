package net.stevenpeterson.tracker;

import javax.servlet.http.HttpServletRequest;

public class MethodParameters {
	private MethodParameters(){
	}
	
	public static String getParameter(String parameterName, HttpServletRequest req) throws JobNumberFormatException{
		String[] values  = req.getParameterValues(parameterName);
		String result = "Not Initialized";
		if(values==null){
			throw new JobNumberFormatException();
		}
		if(values.length > 1){
			throw new JobNumberFormatException();
		}
		if(values.length == 1){
			result = values[0];
		}
		return result;
	}
	

	public static JobData createJobDataFromForm(HttpServletRequest req) throws JobNumberFormatException{
		JobData job = new JobData();
		job.setArrivalTime(getParameter("arrivedAt", req));
		job.setContact(getParameter("contacts", req));
		job.setContactPhone(getParameter("contactPhone", req));
		job.setDescription(getParameter("description", req));
		job.setFinishedAt(getParameter("finishedAt", req));
		job.setTravelTo(getParameter("travelToSite", req));
		job.setTravelFrom(getParameter("travelFromSite", req));
		job.setDate(getParameter("date", req));
		job.setAddress(getParameter("address", req));
		job.setJobId(getParameter("jobID", req));
		job.setJobNumber(getParameter("jobNumber", req));
		return job;
	}

	
}
