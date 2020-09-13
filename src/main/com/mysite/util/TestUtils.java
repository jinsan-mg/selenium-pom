package main.com.mysite.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {
    public static Properties prop;

    public TestUtils() {
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/testData.properties");
            prop.load(ip);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCaptchaCode(){
        String strCaptcha = "";
        //define api methods to get the captcha
        return strCaptcha;
    }

    public String getOTP(){
        String strOTP = "";
        //define api methods to get OTP
        return strOTP;
    }
}
