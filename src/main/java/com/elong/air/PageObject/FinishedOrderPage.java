package com.elong.air.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elong.air.AbstractObject.AbstractPageObject;
import com.elong.air.exception.AirException;

public class FinishedOrderPage extends AbstractPageObject{

	public FinishedOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(css=".btn_view.ml10")
public WebElement viewOrderButton;

public void verify () throws AirException{
	viewOrderButton.isDisplayed();
}
}
