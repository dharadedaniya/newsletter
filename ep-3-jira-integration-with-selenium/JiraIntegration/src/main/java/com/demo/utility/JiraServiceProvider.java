package com.demo.utility;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider 
{
	private JiraClient Jira;

     private String projectKey;

     private String jiraUrl;		

     public JiraServiceProvider(String JiraUrl, String username, String password, String project) {

    	 this.jiraUrl = JiraUrl;

         BasicCredentials creds = new BasicCredentials(username, password);

         Jira = new JiraClient(JiraUrl, creds);

         this.projectKey = project;

     }

		public void createJiraIssue(String issueType, String summary, String description) 
		{
			try 
			{
	            //Avoid Creating Duplicate Issue
	            Issue.SearchResult sr = Jira.searchIssues("summary ~ \""+summary+"\"");
	
	            if(sr.total!=0) {
	
	                System.out.println("Same Issue Already Exists on Jira");
	
	                return;
	            }
            
	            //Create issue if not exists
	
	            FluentCreate fleuntCreate = Jira.createIssue(projectKey, issueType);
	
	            fleuntCreate.field(Field.SUMMARY, summary);
	
	            fleuntCreate.field(Field.DESCRIPTION, description);
	
	            Issue newIssue = fleuntCreate.execute();
	
	            System.out.println("********************************************");
	
	            System.out.println("New issue created in Jira with ID: " + newIssue);
	
	            System.out.println("New issue URL is :"+jiraUrl+"/browse/"+newIssue);
	
	            System.out.println("*******************************************");

        } catch (JiraException e) {

            e.printStackTrace();

        }
    }
}