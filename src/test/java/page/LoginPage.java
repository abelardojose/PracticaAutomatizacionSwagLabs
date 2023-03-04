package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    private WebElement txtUserName;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    public void ingresarDatos() {
        wait.until(ExpectedConditions.visibilityOf(txtUserName));
        txtUserName.sendKeys("standard_user");
        txtPassword.sendKeys("secret_sauce");
        btnLogin.click();
    }
}
