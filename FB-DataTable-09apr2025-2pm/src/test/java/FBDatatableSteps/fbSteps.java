package FBDatatableSteps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class fbSteps {
	public static WebDriver driver;

	@Given("user is on register page")
	public void user_is_on_register_page() {

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/reg");
	}

	@When("user enter valid firstname, lastname , username and password")
	public void user_enter_valid_firstname_lastname_username_password(DataTable datatable) {
		// by using asLists() method
		// | Sonali | Khalate | khalatesonali@gmail.com | khalatesonali@123 |
		List<List<String>> ls = datatable.asLists();
		String fname = ls.get(0).get(0);
		String lname = ls.get(0).get(1);
		String emailId = ls.get(0).get(2);
		String pass = ls.get(0).get(3);

		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("reg_email__")).sendKeys(emailId);
		driver.findElement(By.name("reg_passwd__")).sendKeys(pass);

	}

	@When("user select valid DOB")
	public void user_select_valid_DOB(DataTable datatable) {
		// by using the cells()
		// | 14 | Mar | 2024 |

		List<List<String>> ls1 = datatable.cells();
		String bdate = ls1.get(0).get(0);
		String bmonth = ls1.get(0).get(1);
		String byear = ls1.get(0).get(2);

		WebElement bbdate = driver.findElement(By.name("birthday_day"));
		Select sel = new Select(bbdate);
		sel.selectByVisibleText(bdate);

		WebElement bbmonth = driver.findElement(By.name("birthday_month"));
		Select sel1 = new Select(bbmonth);
		sel1.selectByVisibleText(bmonth);

		WebElement bbyear = driver.findElement(By.name("birthday_year"));
		Select sel2 = new Select(bbyear);
		sel2.selectByVisibleText(byear);
	}

	@When("user select the gender")
	public void user_select_the_gender(DataTable datatable) {
// by using asMaps() 

		List<Map<String, String>> mp = datatable.asMaps();

		String gender = mp.get(0).get("gender");

		List<WebElement> ls = driver.findElements(By.xpath("//span[@class='_5k_2 _5dba']"));

		for (WebElement wbNew : ls) {
			if (wbNew.getText().equalsIgnoreCase(gender)) {
				wbNew.click();
				break;
			}
		}
//		| gender |
//	      | Female |
	}

}
