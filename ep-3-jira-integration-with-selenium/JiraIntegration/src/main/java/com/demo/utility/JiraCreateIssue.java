package com.demo.utility;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Retention;

	@Retention(RetentionPolicy.RUNTIME)
	public @interface JiraCreateIssue {
		boolean isCreateIssue();
	}
