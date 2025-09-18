Feature: Login

  Background: Precondicion de Login

    Given El usuario navega a la pagina de login

  @regression
  Scenario: Credenciales no existentes
    When El usuario escribe las credenciales "standard_user" con password "secret_sauc1"
    Then Para usuario no existente debe mostrar "Epic sadface: Username and password do not match any user in this service"

  @regression
  Scenario: Credenciales invalidas
    When El usuario escribe las credenciales "locked_out_user" con password "secret_sauce"
    Then Para usuario invalido debe mostrar "Epic sadface: Sorry, this user has been locked out."

  @regression
  Scenario: Credenciales validas
    When El usuario escribe las credenciales "standard_user" con password "secret_sauce"

  @regression @smoke
  Scenario: Verificar la UI de la pagina
    Then El usuario verifica que la UI de la pagina de login sea


