package UITesting;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenBrowser;

import static util.UITestsUtil.*;

public class LoginTest extends OpenBrowser {
    Login login;
    @BeforeClass
    public void initLogin()
    {
        login = new Login(driver);
    }

    @Test
    public void txtUsernameVisibilityTest()
    {
        boolean expected = true;
        /*boolean actual = false;
        try {
             actual = login.txtUsername.isDisplayed();
        }
        catch (Exception e)
        {

        }*/

        boolean actual = elementVisibility(login.txtUsername);

        Assert.assertEquals(actual,expected,"element not visible on page");
    }

    @Test
    public void txtPasswordVisibilityTest()
    {
        boolean expected = true;
        boolean actual = elementVisibility(login.txtPassword);
        Assert.assertEquals(actual,expected,"element not visible on page");
    }


    @Test
    public void txtPasswordEnabilityTest()
    {
        boolean expected = true;
        boolean actual = elementEnability(login.txtPassword);
        Assert.assertEquals(actual,expected,"element not Enabled on page");
    }

    @Test
    public void txtUsernameEnabilityTest()
    {
        boolean expected = true;
        boolean actual = elementEnability(login.txtUsername);
        Assert.assertEquals(actual,expected,"element not Enabled on page");
    }

    @Test
    public void labelEmailSpellCheck()
    {
        String expected = "Email";
        String actual = spellCheck(login.lblEmail);
        Assert.assertEquals(actual,expected,"wrong spelling");
    }

    @Test
    public void labelPasswordSpellCheck()
    {
        String expected = "Password";
        String actual = spellCheck(login.lblPassword);
        Assert.assertEquals(actual,expected,"wrong spelling");
    }

    @Test
    public void labelPasswordFontSizeCheck()
    {
        String expected = "14px";
        String actual = getStyleProperty(login.lblPassword,"font-size");
        Assert.assertEquals(actual,expected,"in correct font");
    }

    @Test
    public void labelPasswordFontCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = getStyleProperty(login.lblPassword,"font-family");
        Assert.assertEquals(actual,expected,"in correct font");
    }

    @Test
    public void labelPasswordColorCheck()
    {
        String expected = "#2C8EDD";
        String elementColor = getStyleProperty(login.btnLogin ,  "background-color");

        String actual =  Color.fromString(elementColor).asHex().toUpperCase();

        Assert.assertEquals(actual,expected,"in correct font");
    }
}



