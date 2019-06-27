package autotest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver; 


/**
 *
 * @author hp
 */
public class Autotest {  
    /**     
     * @param args the command line arguments   
     */ 
    public static void main(String[] args) throws InterruptedException {  
        BufferedWriter wr = null;
        try {
            // Create a new instance of the Firefox driver
            System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
            WebDriver driver;
            driver = new FirefoxDriver();
            //Launch the some site
            driver.get("http://mail.google.com");
            // Print a Log In message to the screen
            System.out.println("Successfully opened the website localhost");
            driver.findElement(By.id("identifierId")).sendKeys("Enter ur email here");
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span/span")).click();
            Thread.sleep(5000);
            // Enter a password here
            driver.findElement(By.name("password")).sendKeys("Enter a password here");
            driver.findElement(By.id("passwordNext")).click();
            Thread.sleep(5000);
            //        List<WebElement> unreademeil = driver.findElements(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/div[8]/div/div[4]/div"));
            File file = new File("./unreadEmails.txt");
            wr = new BufferedWriter(new FileWriter(file));
            List<WebElement> unreadEmail = driver.findElements(By.className("zE"));
            for(WebElement x: unreadEmail){
                System.out.println(x.getText());
            }   for (int i = 0; i < unreadEmail.size(); i++) {
                System.out.println("Unread email from: " + unreadEmail.get(i).getText());
                
            }   
            
            for(WebElement x: unreadEmail){
            wr.write("\n----------------------------------------------------------\n");
            wr.write(x.getText());
            wr.write("\n----------------------------------------------------------\n");
        }
            
            driver.quit();
        } catch (IOException ex) {
            Logger.getLogger(Autotest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                wr.close();
            } catch (IOException ex) {
                Logger.getLogger(Autotest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}   
     
 
