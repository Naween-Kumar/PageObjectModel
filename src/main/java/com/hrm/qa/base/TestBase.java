package com.hrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static File file;
	static String filepath;

	public TestBase() throws IOException {

		try {
			prop = new Properties();
			file = new File("J:\\java-learning-workspace\\OrangeHrmAutomation\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties");
			fis = new FileInputStream(file);
				
			prop.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public void initialization() {

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "J:\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if (browsername.equals("ff")) {

			System.setProperty("webdriver.gecko.driver", "J:\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
