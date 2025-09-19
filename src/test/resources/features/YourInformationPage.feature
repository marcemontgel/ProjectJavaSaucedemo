Feature: Your Information

  Background: Precondicion de Login
    Given El usuario navega a la pagina para ingresar su informacion

  @regression
  Scenario Outline: Mensajes de error
    When El usuario ingresa nombre <name> apellido <lastName> zipcode <zipcode> y da clic en Continue
    Then Mostrar el mensaje de error indicado <messageError>

    Examples:
      | name   | lastName   | zipcode      | messageError                     |
      | ""     | "apellido" | "zipcode123" | "Error: First Name is required"  |
      | "name" | ""         | "zipcode123" | "Error: Last Name is required"   |
      | "name" | "apellido" | ""           | "Error: Postal Code is required" |