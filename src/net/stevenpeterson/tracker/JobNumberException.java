package net.stevenpeterson.tracker;

@SuppressWarnings("serial")
public class JobNumberException extends Exception{

	public static String htmlFeedBack(String jobNumber){
		return "<div id=\"container\">Unable to lookup Job Number: " + jobNumber + "</div>\n";
	}
	
	
}
