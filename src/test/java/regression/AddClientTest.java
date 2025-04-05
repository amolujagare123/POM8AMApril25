package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;

public class AddClientTest {
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

    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClientPage = new AddClient(driver);

        addClientPage.enterClientName("Rajesh");
        addClientPage.enterClientSurname("Sharma");
        addClientPage.setLanguage("English");
        addClientPage.enterStreetAddress1("56 MG Road");
        addClientPage.enterStreetAddress2("Near Lotus Temple");
        addClientPage.enterCity("Mumbai");
        addClientPage.enterState("Maharashtra");
        addClientPage.enterZipCode("400001");
        addClientPage.setCountry("India");
        addClientPage.setGender("Female");
        addClientPage.setBirthdate("05-Sep-1985");
        addClientPage.enterPhoneNumber("9876543210");
        addClientPage.enterFaxNumber("0223456789");
        addClientPage.enterMobileNumber("9898989898");
        addClientPage.enterEmailAddress("rajesh.sharma@example.in");
        addClientPage.enterWebAddress("www.rajeshsharma.in");
        addClientPage.enterVATID("VAT987654");
        addClientPage.enterTaxesCode("TAX123456");
        addClientPage.clickSave();



    }
}
