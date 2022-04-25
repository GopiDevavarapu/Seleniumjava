package first;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gopi Devarapu\\eclipse-workspace\\Seleniumjava\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mlrmultisoftsolutions.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Thread.sleep(3000);
		System.out.println("No. of links are: "+links.size());
		
		for(WebElement element : links) {
			String url = element.getAttribute("href");
			URL link = new URL(url);
			HttpURLConnection httpconnect = (HttpURLConnection)link.openConnection();
			httpconnect.connect();
			if(httpconnect.getResponseCode()!=200 || httpconnect.getResponseCode()!=201) {
				System.out.println(url + httpconnect.getResponseCode() + " is in valied link");
			}
			else {
				System.out.println(url + httpconnect.getResponseCode() + " is valid link");
			}
		}
		driver.quit();
	}

}
