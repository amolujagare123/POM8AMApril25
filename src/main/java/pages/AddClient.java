package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {
       /*@FindBy(xpath = "")
    WebElement element;*/

        /*@FindBy(xpath = "xpathvalue")
    WebElement selectorName;*/

    private WebDriver driver ;

public AddClient(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='client_name']")
    private WebElement clientName;

    @FindBy(xpath = "//input[@id='client_surname']")
    private WebElement clientSurname;

    @FindBy(xpath = "//input[@id='client_address_1']")
    private WebElement streetAddress1;

    @FindBy(xpath = "//input[@id='client_address_2']")
    private WebElement streetAddress2;

    @FindBy(xpath = "//input[@id='client_city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='client_state']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='client_zip']")
    private WebElement zipCode;

    @FindBy(xpath = "//input[@id='client_phone']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='client_fax']")
    private WebElement faxNumber;

    @FindBy(xpath = "//input[@id='client_mobile']")
    private WebElement mobileNumber;

    @FindBy(xpath = "//input[@id='client_email']")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[@id='client_web']")
    private WebElement webAddress;

    @FindBy(xpath = "//input[@id='client_vat_id']")
    private WebElement vATID;

    @FindBy(xpath = "//input[@id='client_tax_code']")
    private WebElement taxesCode;

    @FindBy(xpath = "//button[@id='btn-submit']")
    private WebElement save;

    @FindBy(xpath = "//span[@id='select2-client_language-container']")
    WebElement languageContainer;

    @FindBy(xpath = "//input[@aria-label='Search']")
    WebElement search;

    public void setLanguage(String language)
    {
        languageContainer.click();
        search.sendKeys(language);

        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();
    }
    @FindBy(xpath = "//span[@id='select2-client_country-container']")
    WebElement countryContainer;
    public void setCountry(String contry)
    {
        countryContainer.click();
        search.sendKeys(contry);

        driver.findElement(By.xpath("//li[normalize-space()='"+contry+"']")).click();
    }

    @FindBy(xpath = "//span[@id='select2-client_gender-container']")
    WebElement genderContainer;

    public void setGender(String gender)
    {
        genderContainer.click();
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();
    }


    public void enterClientName(String name) {
        clientName.sendKeys(name);
    }

    public void enterClientSurname(String surname) {
        clientSurname.sendKeys(surname);
    }

    public void enterStreetAddress1(String address) {
        streetAddress1.sendKeys(address);
    }

    public void enterStreetAddress2(String address) {
        streetAddress2.sendKeys(address);
    }

    public void enterCity(String cityName) {
        city.sendKeys(cityName);
    }

    public void enterState(String stateName) {
        state.sendKeys(stateName);
    }

    public void enterZipCode(String zip) {
        zipCode.sendKeys(zip);
    }

    public void enterPhoneNumber(String phone) {
        phoneNumber.sendKeys(phone);
    }

    public void enterFaxNumber(String fax) {
        faxNumber.sendKeys(fax);
    }

    public void enterMobileNumber(String mobile) {
        mobileNumber.sendKeys(mobile);
    }

    public void enterEmailAddress(String email) {
        emailAddress.sendKeys(email);
    }

    public void enterWebAddress(String web) {
        webAddress.sendKeys(web);
    }

    public void enterVATID(String vatId) {
        vATID.sendKeys(vatId);
    }

    public void enterTaxesCode(String taxCode) {
        taxesCode.sendKeys(taxCode);
    }

    public void clickSave() {
        save.click();
    }

}
