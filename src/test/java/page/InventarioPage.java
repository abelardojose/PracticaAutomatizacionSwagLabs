package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventarioPage extends BasePage {
    public InventarioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement btnProducto;

    @FindBy(className = "shopping_cart_badge")
    private WebElement btnCarrito;

    public void seleccionarArticulo(){
        wait.until(ExpectedConditions.visibilityOf(btnProducto));
        btnProducto.click();
    }

    public void seleccionarCarritoCompras(){
        btnCarrito.click();
    }



}
