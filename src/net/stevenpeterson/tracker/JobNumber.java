package net.stevenpeterson.tracker;

import java.util.Date;

public class JobNumber {
	
	private JobNumber() {
	}

	public static String generateJobNumber() {
		return "" + new Date().getTime();
	}

	public static String validateJobNumber(String jobNumber) throws JobNumberFormatException {
		long lowerRange = 1331596748779L;

		try {
			Long parsedNumber = new Long(jobNumber);
			if(lowerRange < parsedNumber){
				return jobNumber;
			}
		} catch (NumberFormatException e) {}
		throw new JobNumberFormatException();
	}
	
}
