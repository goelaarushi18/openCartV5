package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountRegistrationPage extends basePage {

	public accountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cnfmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		LastName.sendKeys(lname);
	}

	public void setEmail(String emailId) {
		Email.sendKeys(emailId);
	}
	
	public void setTelephone(String tel) {
		telephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setConfirmPwd(String cnfmPwd) {
		cnfmPassword.sendKeys(cnfmPwd);
	}
	
	public void clickchkbox() {
		chkbox.click();
	}
	
	public void clickContinueButton() {
		continueBtn.click();
	}
	
	public String getConfirmationMsg() {
		try {
			String message=msgConfirmation.getText();
			return message;
		}
		catch(Exception e){
			return(e.getMessage());
			
			
		}
	}
	
}
