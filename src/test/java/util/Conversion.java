package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String getCountry(String shortCountry)
    {
        String convertedCountry = "";

        switch (shortCountry)
        {
            case "IN": convertedCountry = "India"; break;
            case "US": convertedCountry = "United States"; break;
            case "CA": convertedCountry = "Canada"; break;
            case "GB": convertedCountry = "United Kingdom"; break;
            case "AU": convertedCountry = "Australia"; break;
            case "FR": convertedCountry = "France"; break;
            case "DE": convertedCountry = "Germany"; break;
            case "JP": convertedCountry = "Japan"; break;
            case "IT": convertedCountry = "Italy"; break;
            case "ES": convertedCountry = "Spain"; break;
            case "BR": convertedCountry = "Brazil"; break;
            case "MX": convertedCountry = "Mexico"; break;
            case "CN": convertedCountry = "China"; break;
            case "RU": convertedCountry = "Russia"; break;
            case "SA": convertedCountry = "Saudi Arabia"; break;
            case "ZA": convertedCountry = "South Africa"; break;
            case "KR": convertedCountry = "South Korea"; break;
            case "AE": convertedCountry = "United Arab Emirates"; break;
            case "NG": convertedCountry = "Nigeria"; break;

        }

        return convertedCountry;
    }

    public static String getGender(String genderCode)
    {
        String gender = "";

        switch (genderCode)
        {
            case "0":
                gender = "Male";
                break;
            case "1":
                gender = "Female";
                break;
            case "3":
                gender = "Other";
                break;
            default:
                gender = "Invalid Code";
                break;
        }

        return gender;
    }

    public static String convertDate(String dbDate) throws ParseException // 1990-01-10 --> yyyy-dd-MM
    {
        Date date = new SimpleDateFormat("yyyy-dd-MM").parse(dbDate);

        return new SimpleDateFormat("dd-MMM-yyyy").format(date);
    }

}
