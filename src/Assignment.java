/* Hi, I am Mohd Azeem Farooq, I am btech from NIT Warangal and Mtech from Thapar institute of technology and patiala (mtech) via Gate cs/it 2020.
 * I like solving problems using data structures and algorithms and learning new languages(python,typescript etc) and have command over database query language SQL.
 * Inclined towards mathematical aptitudes and reasoning skills. Please connect over linkedin https://www.linkedin.com/in/azeem-mohd-127869ba/
 */
/*
 * steps to recreate
1. Install eclipse or any IDE.
2. Create new project "Fitpeo".
3. Right click the project and convert the project into Maven project.
4. Pom.xml is created
5. Open pom.xml and make <dependencies> tag open and close it.
   <dependencies></dependencies>
6. put this dependency in dependencies tag
   <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.25.0</version>
   </dependency>
7. All selenium dependencies will be included.
8. Create a java class named Assignment and put my code from same location and run.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calling ChromeDriver and WebDriver interface object
		WebDriver driver=new ChromeDriver();
		// opening the fitpeo website
		driver.get("https://www.+++++.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Webdriver will wait for 30 seconds if conditions is not met else it will continue
		//clicking revenue calculator 
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Revenue Calculator']"))).click();
		
		
		//Created a slider element and sliding it with help of Actions class(inbuilt)
		// Slided the slider till 823 since xoffset value should be int type and cannot be double 
        WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class, 'MuiSlider-thumb')]")));
        
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 94, 0).perform();
        
        //Verifying the set value and printing it to console
        WebElement sliderValueField = driver.findElement(By.xpath("//input[@type='number']")); // Replace with actual field ID
        String sliderValue = sliderValueField.getAttribute("value");
        if ("823".equals(sliderValue)) {
            System.out.println("Slider successfully set to 823.");
        } else {
            System.out.println("Slider value not updated to 823.");
        }
        //Cleared previous set value and entered 560 in the field
        //sliderValueField.clear();
        sliderValueField.click();
        sliderValueField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "560");
        
        //Confirming with the slider
        String updatedSliderValue = sliderValueField.getAttribute("value");
        if ("560".equals(updatedSliderValue)) {
            System.out.println("Slider updated to 560 successfully.");
        } else {
            System.out.println("Slider not updated to 560.");
        }
        
        //Created list of checkboxes to be clicked
        //found parent webelement with the help of child element 
        //then found the corresponding checkbox and clicked
        List<String> l=Arrays.asList("CPT-99091", "CPT-99453","CPT-99454","CPT-99474");
        for(String s:l) {
        	WebElement childElement = driver.findElement(By.xpath("//p[text()='" + s + "']"));
            WebElement parentElement = childElement.findElement(By.xpath("./.."));
            parentElement.findElement(By.xpath(".//input[@type='checkbox']")).click();
            
        	
        }
        //scrolled to top
        js.executeScript("window.scrollTo(0, 0);");
        
      
        //driver.close();
        
       
        
        
        
        

        
     
        

		
		


		
	}

}
