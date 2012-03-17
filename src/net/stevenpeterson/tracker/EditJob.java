package net.stevenpeterson.tracker;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class EditJob extends HttpServlet {
	
	public void doGetOrPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		HTMLBean htmlData = new HTMLBean();
		htmlData.setTitle("Edit Job a");

		try {
			String jobNumber = JobNumber.validateJobNumber(MethodParameters
					.getParameter(XXX.JOB_NUMBER_GET_POST_VARIABLE_NAME, req));
			try {
				JobData job = JobJDO.getJob(jobNumber);
				htmlData.setBody(JobDataFormDecorator.formFactory(job)
						.formDecoration());
			} catch (JobNumberException e) {
				htmlData.setBody(JobNumberException.htmlFeedBack(jobNumber));
			}
		} catch (JobNumberFormatException e) {
			htmlData.setBody(JobNumberFormatException.htmlFeedBack());
		}
		resp.getWriter().write(
				HTMLBeanDecorator.htmlFactory(htmlData).getHTML());
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		doGetOrPost(req,resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		doGetOrPost(req,resp);
	}
}
