package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	public Logger logger;

	public static WebDriver driver;
	public Properties p;

	@BeforeClass(groups= {"Master","Sanity","Regression"})
		public void Setup() throws IOException {
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		System.out.println("Initializing ChromeDriver...");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); // Allow all origins
	    driver = new ChromeDriver(options);
		

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void TearDown() {
		
		driver.quit();
		
	}
	
	public String randomString() {
		// Corrected method name
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomenum() {
		// Corrected method name
		String generatednum = RandomStringUtils.randomNumeric(10);
		return generatednum;
	}

	public String randomealphanum() {
		// Corrected method name
		String generatednum = RandomStringUtils.randomNumeric(10);
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		
		return(generatednum+"@"+generatedString);
	}
	
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"//screenshots//" + tname + "_" + timeStamp + ".png";

		File target=new File(targetFilePath);
		source.renameTo(target);
		return targetFilePath;



		
	}
}
