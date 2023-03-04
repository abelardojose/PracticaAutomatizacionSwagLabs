package page;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public class CarritoComprasPage extends BasePage {
    public CarritoComprasPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "checkout")
    private WebElement btncheckout;

    @FindBy(className = "title")
    private WebElement lblTituloValidar;

    @FindBy(id = "continue")
    private WebElement btnContinue;

    @FindBy(id = "finish")
    private WebElement btnFinalizar;

    @FindBy(className = "complete-header")
    private WebElement lblConfirmacion;

    public void realizarCheckout(){
        btncheckout.click();
    }

    public void ingresarDatosCheckout(DataTable dataTable){
        if (lblTituloValidar.isDisplayed()){
            List<Map<String,String>> lista =dataTable.asMaps(String.class,String.class);
            for (int i = 0; i < lista.size(); i++) {
                driver.findElement(By.id("first-name")).sendKeys(lista.get(i).get("first-name"));
                driver.findElement(By.id("last-name")).sendKeys(lista.get(i).get("last-name"));
                driver.findElement(By.id("postal-code")).sendKeys(lista.get(i).get("postal-code"));
            }
            btnContinue.click();
        }else {
            System.out.println("no se muestra el valor "+lblTituloValidar.getText());
        }
    }

    public void finalizarCompra(){
        btnFinalizar.click();
    }

    public String validarCompra(){
        wait.until(ExpectedConditions.visibilityOf(lblConfirmacion));
        return lblConfirmacion.getText();
    }
}
