package pageObjects;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class myAccountPage extends basePage {
 
    public myAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
 
    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement myAcc;
 
    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement lnkLogout;
 
    public boolean macc() {
        return myAcc.isDisplayed();
    }
 
    public void clickLogout() {
        lnkLogout.click();
    }
}