package com.crm.listeners;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.VtigerBase;

public class VtigerListeners extends VtigerBase implements ITestListener{

	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String vname = result.getMethod().getMethodName();
		Reporter.log(vname+"is executed");
		test=report.createTest(vname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String vname = result.getMethod().getMethodName();
		test.log(Status.PASS, vname+"is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String vname = result.getMethod().getMethodName();
		test.log(Status.FAIL, vname+"is failure");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(screenshot);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String vname = result.getMethod().getMethodName();
		test.log(Status.SKIP, vname+"is skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		LocalDateTime date= LocalDateTime.now();
		String time = date.toString().replace(":", "-");
		spark= new ExtentSparkReporter("./ExtentReports/CreateOrganization"+time+".html");
		spark.config().setDocumentTitle("CreateOrg");
		spark.config().setReportName("Aakanksha");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.setSystemInfo("Os", "Windoow-10");
		report.setSystemInfo("Browser", "Chrome-100");
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
