package tesrcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {

	public static void main(String[] args) throws IOException, InterruptedException  {

		System.setProperty("webdriver.chrome.driver", "C:/Users/SP/eclipse-workspace/CucumberBDD/src/test/resources/drivers/chromedriver.exe");
		
		ExcelFileDemo obj =  new ExcelFileDemo();
		ArrayList<String> username = obj.userName(); 
		ArrayList<String> password = obj.password();

		for(int i=0;i<username.size();i++)
		{
			WebDriver dr = new ChromeDriver();
			dr.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

			dr.findElement(By.xpath("//input[@id='email']")).sendKeys(username.get(i));
			dr.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password.get(i));
			dr.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
			
			if(dr.getTitle().equals("My account - My Store"))
			{ 
				System.out.println("Login passed for user "+username.get(i));
			}
			else
			{
				System.out.println("Login Failed for user "+username.get(i));
			}
	   
		dr.close();

		}


	}
}


