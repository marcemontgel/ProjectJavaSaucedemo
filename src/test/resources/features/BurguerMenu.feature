Feature: Burguer Menu

  Background: Precondicion de Login
    Given El usuario ingresa correctamente y abre el burguer menu

  @regression @smoke
  Scenario: Logout
    When El usuario hace click en la opción de Log Out
    Then El usuario es redirigido a la pagina de login