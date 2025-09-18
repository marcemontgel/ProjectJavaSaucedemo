Feature: Footer

  Background: Precondicion login correcto

    Given El usuario ingresa con credenciales validas a la pagina de Inventario

  @regression
  Scenario: Verificar las redes sociales del footer
    Then Verificar que los enlaces sean correctos "https://twitter.com/saucelabs", "https://www.linkedin.com/company/sauce-labs/", "https://www.facebook.com/saucelabs"