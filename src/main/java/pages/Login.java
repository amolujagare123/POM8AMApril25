package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    /*WebDriver driver;
    WebElement element = driver.findElement(By.id("email"));*/

    @FindBy (id="email")
    public WebElement txtUsername;

    @FindBy (id="password")
    public WebElement txtPassword;

    @FindBy(xpath = "//a[normalize-space()='I forgot my password']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//label[normalize-space()='Email']")
    public WebElement lblEmail;

    @FindBy(xpath = "//label[normalize-space()='Password']")
    public WebElement lblPassword;

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath="//button[normalize-space()='Login']")
    public WebElement btnLogin;

    public void setTxtUsername(String username)
    {
        txtUsername.sendKeys(username);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }


    public void clickForgotPassword()
    {
        forgotPassword.click();
    }



}
