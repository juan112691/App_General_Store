Feature: Prueba de compra en la app General Store

  Scenario: Seleccionar país, ingresar nombre y validar pantalla de productos
    Given que la aplicación está abierta
    When selecciono "El Salvador" como país
    And ingreso el nombre "JUAN"
    And selecciono el género masculino
    And presiono el botón "Let's Shop"
    Then debería mostrarse la pantalla de productos