package com.inter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.log.Log;
import com.redstage.RentokilUAT;

import testBase.Testbase;

public class ImplementListener implements ITestListener {

	static Testbase testbase = new Testbase();

	@Override
	public void onTestStart(ITestResult result) {
		Log.log.info("Test has started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testbase.takesScreenshot(RentokilUAT.methodName);
		Log.log.info("Test has passed, please refer screenshot " + Testbase.fileName);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		testbase.takesScreenshot(RentokilUAT.methodName);
		Log.log.fatal("Test has failed, please refer screenshot " + Testbase.fileName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Log.log.warn("Test has been skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
