package net.stevenpeterson.tracker;

@SuppressWarnings("serial")
public class JobNumberFormatException extends Exception{
	public static String htmlFeedBack(){
		return "<div id=\"container\">Unable to lookup the Job Number</div>\n";
	}
}
