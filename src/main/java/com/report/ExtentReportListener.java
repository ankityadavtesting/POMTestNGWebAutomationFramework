package com.report;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportListener implements ITestListener {

	private static Logger logger = LogManager.getFormatterLogger(ExtentReportListener.class);
	
	private ExtentReports extentreports;
	
	private ExtentTest extentTest;
	
	public void onTestStart(ITestResult result) {
		this.extentTest = extentreports.createTest(result.getName());
		
		ExtentFactory.getInstance().setExtent(extentTest);
		logger.info("test is added in pool.");
	}

	
	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().passTest(result.getName());
	}

	
	public void onTestFailure(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().fail("Exception Details "+result.getThrowable().getMessage());
	}

	
	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().log(Status.SKIP, "test case "+ result.getName()+" is skipped");
	}

	
	public void onStart(ITestContext context) {
		this.extentreports = ExtentReportManager.setUpExtentReport();
	}

	
	public void onFinish(ITestContext context) {
		this.extentreports.flush();
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

		
	}

	

