package com.auto.test.GmailAutomationTest;



import com.auto.test.Functionalities.gmailFunctionality;

public class App {
	public static void main(String[] args) throws InterruptedException {
		
		gmailFunctionality obj=new VisitGmail();
		obj.openBrowser("FIREFOX");
		obj.login("abctest.rbc@gmail.com","seedtheman0#");
		obj.printSubjectOfEmail(); 

	
			 
		}

		
	}

