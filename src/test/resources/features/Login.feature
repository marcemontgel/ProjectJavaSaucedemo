Feature: Login

  Background: Precondicion de Login

    Given El usuario navega a la pagina de login

  @regression
  Scenario: Credenciales invalidas
    When El usuario escribe las credenciales "standard_user" con password "secret_sauc5"
    Then Debe aparecer un mensaje indicando "Epic sadface: Username and password do not match any user in this service"

  @regression @smoke
  Scenario: Verificar la UI de la pagina
    Then El usuario verifica que la UI de la pagina de login sea


