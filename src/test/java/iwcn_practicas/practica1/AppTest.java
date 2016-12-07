package iwcn_practicas.practica1;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@WebIntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringMvcThymeleafApp.class)
public class AppTest{
	private static final long timeout=30;
	private WebDriver driver;
	@BeforeClass
	public static void setupClass(){
		System.setProperty("webdriver.chrome.driver", "D:"+File.separator+"chromedriver.exe");
	}
	@Before
	public void setupTest(){
		driver=new ChromeDriver();
	}
	@After
	public void teardown(){
		if (driver!=null){
			driver.quit();
		}
	}
	@Test
	public void test(){
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		
	}
}
