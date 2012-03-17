package net.stevenpeterson.tracker;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class JobUpdateFeedback extends HttpServlet {
		public void doGetOrPost(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
			resp.setContentType("text/html");
			HTMLBean htmlData = new HTMLBean();
			htmlData.setTitle("Job Update Feedback");
			try{
				JobData job = MethodParameters.createJobDataFromForm(req);
				JobJDO.newJob(job);
				htmlData.setBody(XXX.JOB_SAVED);
			}catch(JobNumberFormatException e){
				htmlData.setBody(JobNumberFormatException.htmlFeedBack());
			}
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
