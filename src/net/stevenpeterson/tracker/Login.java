package net.stevenpeterson.tracker;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.http.HttpServletRequest;

public class Login {


	
	public User user = null;
	public UserService userService = null;
	public String loginLocation = null;
	public String logoutLocation = null;
	
	private Login(){
	}
	
	public static Login getLogin(HttpServletRequest req){
		Login login = new Login();
		login.getUserService();
		login.getUser();
		login.obtainLoginHREF(req);
		login.obtainLogoutHREF(req);
		return login;
	}
	
	private void obtainLoginHREF(HttpServletRequest req) {
		loginLocation = userService.createLoginURL(req.getRequestURI());
	}

	private void obtainLogoutHREF(HttpServletRequest req) {
		logoutLocation = userService.createLogoutURL(req.getRequestURI());
	}
	
	
	public UserService getUserService(){
		if(userService == null){
			userService = UserServiceFactory.getUserService();
		}
		return userService;
	}
	
	
	public User getUser(){
		if(user == null){
			user = getUserService().getCurrentUser();
		}
		return user;
	}
	
	
	public String loginLogoutString(){
		String result = "";
		if(isLoggedIn()){
			result = "User: " + user.getNickname() + " Email: " + user.getEmail()
					+ " " + getLogoutString() + "<hr />\n";
		}else{
			result = "login to begin." + this.getLoginString() + "<hr />\n";
		}

		return result;
	}
	
	public boolean isLoggedIn(){
		return user != null;
	}
	
	public String getLoginString(){
		return "<a href=\"" + this.loginLocation + "\">login</a>";
	}
	
	public String getLogoutString(){
		return "<a href=\"" + this.logoutLocation + "\">logout</a>";
	}
	
	
	
}
