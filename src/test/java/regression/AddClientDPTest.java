package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;

import static util.ForDataProvider.getMyData;

public class AddClientDPTest {
    WebDriver driver ;
    @BeforeClass
    public void doLogin()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");

        Login login = new Login(driver);


        login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();
    }

    @Test (dataProvider = "getData")
    public void addClientTest(String clientName, String clientSurname, String language, String street1,
                              String street2, String city, String state, String zip, String country,
                              String gender, String birthdate, String phone, String fax,
                              String mobile, String email, String web, String vat, String tax
    ,String expected,String xpathActual) {

        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClientPage = new AddClient(driver);

        addClientPage.enterClientName(clientName);
        addClientPage.enterClientSurname(clientSurname);
        addClientPage.setLanguage(language);
        addClientPage.enterStreetAddress1(street1);
        addClientPage.enterStreetAddress2(street2);
        addClientPage.enterCity(city);
        addClientPage.enterState(state);
        addClientPage.enterZipCode(zip);
        addClientPage.setCountry(country);
        addClientPage.setGender(gender);
        addClientPage.setBirthdate(birthdate);
        addClientPage.enterPhoneNumber(phone);
        addClientPage.enterFaxNumber(fax);
        addClientPage.enterMobileNumber(mobile);
        addClientPage.enterEmailAddress(email);
        addClientPage.enterWebAddress(web);
        addClientPage.enterVATID(vat);
        addClientPage.enterTaxesCode(tax);
        addClientPage.clickSave();

        String actual = "";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect or no error message");
    }

    @DataProvider
    Object[][] getData() throws IOException {
        return getMyData("Data/ClientData.xlsx","Sheet1");
    }
}
