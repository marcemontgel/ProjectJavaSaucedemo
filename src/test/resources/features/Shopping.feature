Feature: Login

  Background: Precondicion de Login

    Given El usuario ingresa con credenciales validas a la pagina de Inventario

  @regression
  Scenario: Verificar la UI
    Then El usuario verifica que la pagina de Productos cargue de manera correcta