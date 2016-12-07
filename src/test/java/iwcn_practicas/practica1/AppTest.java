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
import org.openqa.selenium.Keys;
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
		opciones.setBinary("C:"+File.separator+"Users"+File.separator+"angel"+File.separator+"AppData"+File.separator+"Local"+File.separator+"Google"+File.separator+"Chrome"+File.separator+"Application"+File.separator+"chrome.exe");
		driver=new ChromeDriver(opciones);
	}
	
	@After
	public void teardown(){
		if (driver!=null){
			driver.quit();
		}
	}
	
	@Test
	public void testLogin(){
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/login");
		driver.findElement(By.id("username")).sendKeys("Administrador");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
		Assert.assertTrue(ExpectedConditions.textToBePresentInElementLocated(By.className("btn-success"), "LISTA DE PELÍCULAS").apply(driver));
	}
	
	@Test
	public void testBuscar(){
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/login");
		driver.findElement(By.id("username")).sendKeys("Administrador");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.name("consulta")).sendKeys("Harry Potter");
		driver.findElement(By.className("btn-primary")).click();
		Assert.assertTrue(ExpectedConditions.urlContains("resultados").apply(driver));
	}
	
	@Test
	public void testNuevoUsuario(){
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/login");
		driver.findElement(By.id("username")).sendKeys("Administrador");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
		driver.get("http://localhost:8080/users");
		driver.findElement(By.className("btn-primary")).click();
		driver.findElement(By.id("name")).sendKeys("Eduardo");
		driver.findElement(By.id("email")).sendKeys("eduardo@test.com");
		driver.findElement(By.id("password")).sendKeys("edu@123");
		driver.findElement(By.className("btn-success")).click();
		Assert.assertTrue(ExpectedConditions.urlContains("add/confirm").apply(driver));
	}
	
	@Test
	public void testSesionCerrada(){
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/login");
		driver.findElement(By.id("username")).sendKeys("Administrador");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
		driver.get("http://localhost:8080/logout");
		driver.findElement(By.className("btn-success")).click();
		driver.get("http://localhost:8080/peliculas");
		Assert.assertTrue(ExpectedConditions.urlContains("login").apply(driver));
	}
	
	@Test
	public void testNuevaPelicula(){
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/login");
		driver.findElement(By.id("username")).sendKeys("Administrador");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.name("consulta")).sendKeys("Harry Potter");
		driver.findElement(By.className("btn-primary")).click();
		driver.findElement(By.id("tt6002946")).sendKeys("https://www.youtube.com/watch?v=9hXH0Ackz6w", Keys.TAB, Keys.ENTER);
		Assert.assertTrue(ExpectedConditions.urlContains("peliculas/add").apply(driver));
	}
}
