Feature: Login

  Background: Precondicion de Login

    Given El usuario ingresa con credenciales validas a la pagina de Inventario

  @regression
  Scenario: Verificar la UI
    Then El usuario verifica que la pagina de Productos cargue de manera correcta


  @regression
  Scenario: Verificar los precios
    When Leo los productos esperados de excel
    Then Verificando que los productos de Excel sean los mismos que la pagina