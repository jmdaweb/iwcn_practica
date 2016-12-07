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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		ChromeOptions opciones=new ChromeOptions();
		opciones.setBinary("D:"+File.separator+"GoogleChromePortable64"+File.separator+"GoogleChromePortable.exe");
		driver=new ChromeDriver(opciones);
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
		driver.get("http://localhost:8080/login");
		driver.findElement(By.id("username")).sendKeys("Administrador");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
		Assert.assertTrue(ExpectedConditions.textToBePresentInElementLocated(By.className("btn-success"), "LISTA DE PELÍCULAS").apply(driver));
	}
}
