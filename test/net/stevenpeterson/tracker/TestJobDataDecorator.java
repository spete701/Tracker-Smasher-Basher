package net.stevenpeterson.tracker;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJobDataDecorator {

	private JobData job;
	private JobDataFormDecorator decorator;

	@Before
	public void setupData() {
		job = new JobData();
		job.setJobNumber("test123");
		job.setAddress("123 SteveLand Drive NE");
		job.setArrivalTime("8:05");
		job.setContact("Heather Locklier");
		job.setContactPhone("123-456-7890");
		job.setDate("03-29-12");
		job.setDescription("Technical issue with swimsuit catelog");
		job.setFinishedAt("8:06");
		job.setTravelFrom("35");
		job.setTravelTo("25");
		job.setJobId("aaaa11111aaaaa");
		decorator = JobDataFormDecorator.formFactory(job);
	}

	@After
	public void tearItDown() {
		job = null;
		decorator = null;
	}

	@Test
	public void testConfigureForm() {
		String expected = "<div id='container'>Job Number: "
				+ job.getJobNumber()
				+ "</div><hr />\n<div id='container'>\n<form id='editJob'>\n";
		assertEquals("placement and presence of jobnumber", 
				expected,
				decorator.configureForm());
	}
	
	@Test
	public void testAddressField(){
		assertEquals("Placement and presence of address field",
				"<div class='inputElement'><div class='label'>Address: </div><input type='text' name='address' value='"
						+ job.getAddress() +"'/><br /></div>", 
				decorator.addressField());
	}
	
	@Test 
	public void testArrivalTimeField(){
		assertEquals("Placement and presence of arrival time field",
				"<div class='inputElement'><div class='label'>Arrival Time: </div><input type='text' value='"
				+ job.getArrivalTime() +"' name='arivedAt' /><br /></div>)", 
				decorator.arrivalTimeField());
	}
	
	@Test
	public void testContactField(){
		assertEquals("Placement and presence of contact (contact nameField) field",
				"<div class='inputElement'><div class='label'>Contact[s]: </div><input type='text' value='"
				+ job.getContact() +"' name='contacts' /><br /></div>)", 
				decorator.contactField());
	}


	@Test
	public void testContactPhoneField(){
		assertEquals("Placement and presence of contactPhone (contact nameField) field",
				"<div class='inputElement'><div class='label'>Contact[s]: </div><input type='text' value='"
				+ job.getContactPhone() +"' name='contactPhone' /><br /></div>)", 
				decorator.contactPhoneField());
	}
	
	@Test
	public void testDateField(){
		assertEquals("Placement and presence of date",
				"<div class='inputElement'><div class='label'>Date: </div><input type='text' value='"
				+ job.getDate() +"' name='date' /><br /></div>)", 
				decorator.dateField() );
	}
	
	@Test
	public void testDescriptionField(){
		assertEquals("Placement and presence of descriptionField",
				"<div class='inputElement'><div class='label'>Description: </div><textarea class='formDescription'>"+job.getDescription()+"</textarea><br /></div>", 
				decorator.descriptionField());
	}
	
	@Test
	public void testFinishedField(){
		assertEquals("Placement and presence of finishedAtField",
				"<div class='inputElement'><div class='label'>Finished at: </div><input type='text' value='"
						+ job.getFinishedAt() +"' name='finishedAt' /><br /></div>)", 
						decorator.finishedAtField() );
	}
	
	
	@Test
	public void testTravelFromField(){
		assertEquals("Placement and presence of travelFrom field",
				"<div class='inputElement'><div class='label'>Travel from site to office(minutes): </div><input type='text' value='"
						+ job.getTravelFrom() +"' name='travelFrom' /><br /></div>)", 
						decorator.travelFromField() );
	}
	
	
	@Test
	public void testTravelToField(){
		assertEquals("Placement and presence of travel to",
				"<div class='inputElement'><div class='label'>Travel to site(minutes): </div><input type='text' value='"
						+ job.getTravelTo() +"' name='travelTo' /><br /></div>)", 
						decorator.travelToField() );
	}
	
	@Test
	public void testJobIdField(){
		assertEquals("Placement and presence of JobIDField",
				"<div class='inputElement'><div class='label'>JobID-DONE-ID: </div><input type='text' value='"
						+ job.getJobId() +"' name='jobID' /><br /></div>)", 
						decorator.jobIDField() );
	}
	
}
