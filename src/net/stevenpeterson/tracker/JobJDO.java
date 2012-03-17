package net.stevenpeterson.tracker;

import javax.jdo.PersistenceManager;

public class JobJDO {
	private JobJDO() {
	}

	public static JobData getJob(String jobNumber) throws JobNumberException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			if (jobNumber != null) {
				return pm.getObjectById(JobData.class, jobNumber);
				//What happens if a job cannot be obtained?
			}
		} finally {
			pm.close();
		}
		throw new JobNumberException();
	}
	
	public static void newJob(JobData job){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(job);
		} finally {
			pm.close();
		}
	}
}
