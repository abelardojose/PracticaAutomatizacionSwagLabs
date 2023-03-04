package step;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.CarritoComprasPage;
import page.InventarioPage;
import page.LoginPage;

public class CarritoCompraStep {

    LoginPage loginPage;
    InventarioPage inventarioPage;
    CarritoComprasPage carritoComprasPage;


    public CarritoCompraStep() {
        loginPage = new LoginPage(Hooks.driver);
        inventarioPage = new InventarioPage(Hooks.driver);
        carritoComprasPage = new CarritoComprasPage(Hooks.driver);
    }

    @Given("el usuario ingresa a la pagina Swag Labs")
    public void elUsuarioIngresaALaPaginaSwagLabs() {
        Hooks.driver.get("https://www.saucedemo.com/");
    }

    @And("el usuario realiza el login")
    public void elUsuarioRealizaElLogin() {
        loginPage.ingresarDatos();
    }

    @When("selecciona el articulo a comprar")
    public void seleccionaElArticuloAComprar() {
        inventarioPage.seleccionarArticulo();
    }

    @And("se dirije al carrito de compras")
    public void seDirijeAlCarritoDeCompras() {
        inventarioPage.seleccionarCarritoCompras();
    }

    @And("realiza el Checkout")
    public void realizaElCheckout() {
        carritoComprasPage.realizarCheckout();
    }

    @And("confirma sus datos")
    public void confirmaSusDatos(DataTable dataTable) {
    carritoComprasPage.ingresarDatosCheckout(dataTable);
    }

    @And("realiza la compra")
    public void realizaLaCompra() {
        carritoComprasPage.finalizarCompra();
    }

    @Then("validamos que la compra fue exitosa {string}")
    public void validamosQueLaCompraFueExitosa(String lblPagoExitoso) {
        Assert.assertEquals(lblPagoExitoso,carritoComprasPage.validarCompra());
    }

}
