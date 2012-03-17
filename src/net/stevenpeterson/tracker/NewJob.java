package net.stevenpeterson.tracker;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class NewJob extends HttpServlet {
	public void doGetOrPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		HTMLBean htmlData = new HTMLBean();
		htmlData.setTitle("New Job");
		JobData job = new JobData();
		job.setJobNumber(JobNumber.generateJobNumber());
		//JobJDO.newJob(job);
		htmlData.setBody(JobDataFormDecorator.formFactory(job).formDecoration());
		resp.getWriter().write(
				HTMLBeanDecorator.htmlFactory(htmlData).getHTML());
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doGetOrPost(req, resp);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doGetOrPost(req, resp);
	}
}