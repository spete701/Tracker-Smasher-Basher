package net.stevenpeterson.tracker;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ViewJobs extends HttpServlet {
	
	public void doGetOrPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		Login login = Login.getLogin(req);
		String body = login.loginLogoutString();		
		if(login.isLoggedIn()){
			body += "View Jobs:" + onlyIfLoggedIn();
		}else{
			body += "Login to view jobs";
		}

		resp.getWriter().write(body);
	}

	private String onlyIfLoggedIn() throws IOException {
		StringBuilder sb = new StringBuilder();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(JobData.class);
		try {
			@SuppressWarnings("unchecked")
			List<JobData> results = (List<JobData>) query.execute();
			if (!results.isEmpty()) {
				for (JobData e : results) {
					sb.append(JobDataListDecorator.listing(e));
				}
			} else {
				sb.append("No Jobs To Report");
			}
		} finally {
			query.closeAll();
		}		
		HTMLBean htmlData = new HTMLBean();
		htmlData.setTitle("View Jobs");
		htmlData.setBody("<div id=\"container\">\n" + sb.toString() 
				+ XXX.ADD_JOB_LINK +"\n</div>\n");
		HTMLBeanDecorator htmlDecorator = HTMLBeanDecorator.htmlFactory(htmlData);		
		return htmlDecorator.getHTML();
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
