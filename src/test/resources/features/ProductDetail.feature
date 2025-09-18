Feature: Product Detail

  Background: Precondicion de Login
    Given El usuario detalla el item con nombre "Sauce Labs Fleece Jacket"

  @regression @smoke
  Scenario: Verificar la UI del detalle
    Then El usuario verifica que la UI de la pagina de detalle del producto sea correcta

  @regression
  Scenario: Retornar pagina shopping desde detalle producto
    When El usuario hace clic en el botón Back to Products
    Then El usuario retorna al listado de Productos