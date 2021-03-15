package com.bae.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = { "classpath:user-schema.sql",
"classpath:position-schema.sql "}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SeleniumTests {

	@LocalServerPort
	private int port;
	
	private RemoteWebDriver driver;
	
	
	@BeforeEach
	void setup() {
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		this.driver = new ChromeDriver(options);
		
		this.driver.manage().window().maximize();
		
		System.setProperty("webdriver.chrome.driver", "/C11CryptoBackEnd/chromedriver.exe");
	}
	
	
//this bit actually works
//	@Test
//	void testLogin() {
//		this.driver.get("http://localhost:" + port);
//		
//		this.driver.findElementById("name").sendKeys("Bobby");
//		
//		this.driver.findElementById("loginButton").click();
//		
//	}
	
	@Test
	void testCreate() {
		this.driver.get("http://localhost:" + port);
		
		this.driver.findElementById("name").sendKeys("Bobby");
		
		this.driver.findElementById("loginButton").click();
		
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		this.driver.get("http://localhost:" + port + "/app.html");
		
		this.driver.findElementById("assetDropdownHeader").click();
		
		this.driver.findElementById("Bitcoin").click();
		
		this.driver.findElementById("quantityBox").click();
		
		this.driver.findElementById("quantityBox").sendKeys("2");
		
		this.driver.findElementById("obtain-quote").click();
		
		this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		this.driver.findElementById("placeTrade").click();
		
	}
}
