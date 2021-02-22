package com.w2a.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;
import com.w2a.base.Page;

import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;

import com.w2a.utilities.Utilities;

public class CustomListeners extends Page implements ITestListener, ISuiteListener {

	public String messagebody;
	public void onTestStart(ITestResult result) {
		
		tests = repo.startTest(result.getName().toUpperCase());
		//runmode - Y
		/*
		 * if(!TestUtil.isTestRunnable(result.getName().toUpperCase(), excel)) { throw
		 * new SkipException("Skipping the test" + result.getName().toUpperCase() +
		 * "as the run mode is NO"); }
		 */
		
	}

	public void onTestSuccess(ITestResult result) {
		
		tests.log(LogStatus.PASS, result.getName().toUpperCase() + " PASS.");
		repo.endTest(tests);
		repo.flush();
		
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tests.log(LogStatus.FAIL, result.getName().toUpperCase() + " FAILED." + result.getThrowable());
		tests.log(LogStatus.FAIL, tests.addScreenCapture(Utilities.screenshotName));
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href="+ Utilities.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+ Utilities.screenshotName + "><img src ="+ Utilities.screenshotName +" height=200 width=200></img></a>");
		
		
		
		
		repo.endTest(tests);
		repo.flush();
		
	}

	public void onTestSkipped(ITestResult result) {
		
		tests.log(LogStatus.SKIP, result.getName().toUpperCase() + "skipped the test as Runmode is NO");
		repo.endTest(tests);
		repo.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
	
MonitoringMail mail = new MonitoringMail();
		
		
		try {
			messagebody = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/job/PageObjectModelLiveProject1/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(messagebody);
		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messagebody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	

}
