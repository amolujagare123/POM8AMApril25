package DBTesting;

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
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static util.Conversion.*;
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
                              String mobile, String email, String web, String vat, String tax) throws ClassNotFoundException, SQLException, ParseException {

        Menu menu = new Menu(driver);
        menu.clickAddClient();


        ArrayList<String> expected = new ArrayList<>();
        expected.add(clientName);
        expected.add(clientSurname);
        expected.add(language.toLowerCase());
        expected.add(street1);
        expected.add(street2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);


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



        // steps to hit the database

        // 1. loading a Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. create a connection
        String user = "root";
        String password = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(connectionUrl,user,password);

        //3. create a statement object
        Statement st = con.createStatement();

        // 4. execute query - DDL
        String sql = "select * from ip_clients where client_name='"+clientName+"'";
        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");
            String fullCountry = getCountry(shortCountry);

            actual.add(fullCountry);



            actual.add(getGender(rs.getString("client_gender")));


            actual.add(convertDate(rs.getString("client_birthdate")));


            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);


      //  Assert.assertEquals(actual,expected);
    }

    @DataProvider
    Object[][] getData() throws IOException {
        return getMyData("Data/ClientData.xlsx","Sheet2");
    }
}
