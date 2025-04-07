package util;

import org.openqa.selenium.WebElement;

public class UITestsUtil {


    public static boolean elementVisibility(WebElement element)
    {

        boolean result = false;
        try {
            result = element.isDisplayed();
        }
        catch (Exception e)
        {

        }
            return result;
    }

    public static boolean elementEnability(WebElement element)
    {

        boolean result = false;
        try {
            result = element.isEnabled();
        }
        catch (Exception e)
        {

        }
        return result;
    }

    public static String spellCheck(WebElement element)
    {

        String result = "";
        try {
            result = element.getText();
        }
        catch (Exception e)
        {

        }
        return result;
    }

    public static String getStyleProperty(WebElement element,String cssValue)
    {

        String result = "";
        try {
            result = element.getCssValue(cssValue);
        }
        catch (Exception e)
        {

        }
        return result;
    }
}
