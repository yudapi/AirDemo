package com.elong.air.PageObject;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.elong.air.AbstractObject.AbstractPageObject;
import com.elong.air.commonUtils.ReadFromProperty;
import com.elong.air.commonUtils.SelectUtils;

public class PaymentPage extends AbstractPageObject{

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="#txtCreditCard")
	public WebElement creditCardInputTextField;
	
	@FindBy(css="#txtCardName")
	public WebElement accountNameInputTextField;
	
	@FindBy(css="#selValidityMonth")
	public WebElement monthTextField;
	
	@FindBy(css="#selCertificateType")
	public WebElement Cardtype;
	
	@FindBy(css="#selValidityYear")
	public WebElement yearTextField;
	
	@FindBy(css="#txtCertificate")
	public WebElement cardIdInputTextField;
	
	@FindBy(css="#btnPaymentSumbit")
	public WebElement summitButton;
	
	public FinishedOrderPage inputBankInformation() throws Exception {
		ReadFromProperty rfp = new ReadFromProperty();
		Map<String, String> bankaInfo = rfp.readBankInfo();
		System.out.print("名字" + bankaInfo.get("AccountName"));
		System.out.print("银行" + bankaInfo.get("AccountNum"));
		System.out.print("身份证" + bankaInfo.get("cardId"));
		System.out.print("类型" + bankaInfo.get("selCertificateType"));
		this.setInputText(creditCardInputTextField, bankaInfo.get("AccountNum"));
		this.setInputText(accountNameInputTextField,
				bankaInfo.get("AccountName"));
		SelectUtils su = new SelectUtils(driver);
		su.selectByValue(monthTextField, bankaInfo.get("month"));
		su.selectByValue(yearTextField, bankaInfo.get("year"));
		su.selectByText(Cardtype, bankaInfo.get("selCertificateType"));
		this.setInputText(cardIdInputTextField, bankaInfo.get("cardId"));
		this.click(summitButton);
return new FinishedOrderPage(driver);
	}
//	public static void main(String[] args) {
//		PaymentPage p=new PaymentPage();
//	}

}
