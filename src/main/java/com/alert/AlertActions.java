package com.alert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.driver.DriverFactory;
import com.report.ExtentFactory;

public class AlertActions {

	private Logger logger = LogManager.getLogger(AlertActions.class);

	private Alert alert;

	public void switchToAlert() {

		try {
			alert = DriverFactory.getInstance().getDriver().switchTo().alert();
			logger.info("Switched to Alert.");
			ExtentFactory.getInstance().passTest("Switched to Alert.");
		}
		catch(NoAlertPresentException e) {
			logger.error("Exception occured while switching to alert.");
			ExtentFactory.getInstance().failTest("Exception occured while switiching to alert.");

		}
	}


	public void acceptAlert() {
		try {
			this.alert.accept();
			logger.info("Clicked on OK button");
			ExtentFactory.getInstance().passTest("Clicked on OK button");
		}
		catch(Exception e) {
			logger.error("Exception occured while Clicking on OK button");
			ExtentFactory.getInstance().failTest("Exception occured while Clicking on OK button");

		}

	}
	
	public void cancelAlert() {
		try {
			this.alert.dismiss();
			logger.info("Clicked on Cancel button");
			ExtentFactory.getInstance().passTest("Clicked on Cancel button");
		}
		catch(Exception e) {
			logger.error("Exception occured while Clicking on Cancel button");
			ExtentFactory.getInstance().failTest("Exception occured while Clicking on Cancel button");

		}

	}

}
