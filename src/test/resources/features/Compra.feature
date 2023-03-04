Feature:Compra de productos de Ropa

  @Compra1
  Scenario:Compra de una prenda
  Given el usuario ingresa a la pagina Swag Labs
  And el usuario realiza el login
  When selecciona el articulo a comprar
  And se dirije al carrito de compras
  And realiza el Checkout
  And confirma sus datos
    |first-name|last-name|postal-code |
    |abelardo |capunay |431        |
  And realiza la compra
  Then validamos que la compra fue exitosa "Thank you for your order!"



