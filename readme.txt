PROYECTO DE AUTOMATIZACION E2E - SAUCEDEMO
Elaborado por: Nathaly Moncayo
Fecha: Enero 2026

=================================================================

DESCRIPCION

Prueba funcional automatizada (E2E) del flujo de compra en
https://www.saucedemo.com/ utilizando Serenity BDD con el patron Screenplay.

El proyecto implementa:
- Autenticacion de usuario con credenciales validas
- Agregacion de productos al carrito de compras
- Visualizacion del carrito y sus contenidos
- Completamiento del formulario de checkout
- Finalizacion de compra con confirmacion de orden

=================================================================

REQUISITOS PREVIOS

1. JAVA JDK 17 o superior
   - Descargar desde: https://www.oracle.com/java/technologies/downloads/
   - Verificar instalacion: java -version

2. APACHE MAVEN 3.9.1 o superior
   - Descargar desde: https://maven.apache.org/download.cgi
   - Verificar instalacion: mvn -version

3. GOOGLE CHROME (version mas reciente)
   - El ChromeDriver se descarga automaticamente mediante WebDriverManager

4. CONEXION A INTERNET
   - Necesaria para descargar dependencias y acceder a https://www.saucedemo.com/

=================================================================

VERSIONES DE TECNOLOGIAS UTILIZADAS

- Serenity BDD: 4.0.21
- Serenity Screenplay: 4.0.21
- Selenium WebDriver: 4.15.0
- JUnit 5: 5.10.1
- Maven: 3.9.1+
- Java: 17
- WebDriverManager: 5.6.2
- Chrome Browser: Version estable reciente

=================================================================

ESTRUCTURA DEL PROYECTO

serenity/
├── src/
│   ├── main/java/
│   │   └── com/ejercicio/
│   │       └── Main.java
│   └── test/java/
│       └── com/ejercicio/
│           ├── test/
│           │   └── SauceDemoPurchaseFlowTest.java    (Pruebas principales)
│           ├── tasks/
│           │   ├── Login.java                        (Accion: Autenticarse)
│           │   ├── AddProductsToCart.java            (Accion: Agregar productos)
│           │   ├── ViewCart.java                     (Accion: Ver carrito)
│           │   ├── ProceedToCheckout.java            (Accion: Ir a checkout)
│           │   ├── FillCheckoutInformation.java      (Accion: Llenar formulario)
│           │   ├── FinishPurchase.java               (Accion: Finalizar compra)
│           │   └── WaitForPageLoad.java              (Accion: Esperar cargas)
│           ├── questions/
│           │   ├── ShoppingCartBadge.java            (Validacion: Badge carrito)
│           │   ├── CartItems.java                    (Validacion: Items visibles)
│           │   └── OrderConfirmation.java            (Validacion: Confirmacion)
│           └── ui/
│               ├── LoginPage.java                    (Elementos login)
│               ├── ProductsPage.java                 (Elementos productos)
│               ├── CartPage.java                     (Elementos carrito)
│               ├── CheckoutPage.java                 (Elementos checkout)
│               └── CheckoutCompletePage.java         (Elementos confirmacion)
├── pom.xml                                           (Configuracion Maven)
├── serenity.conf                                     (Configuracion Serenity)
├── readme.txt                                        (Este archivo)
├── README.md                                         (Documentacion extendida)
└── conclusiones.txt                                  (Hallazgos y conclusiones)

=================================================================

PASOS PARA EJECUTAR LAS PRUEBAS

PASO 1: Abrir terminal/PowerShell en la carpeta del proyecto

PASO 2: Limpiar el proyecto (opcional pero recomendado)

mvn clean

PASO 3: Instalar dependencias

mvn install -DskipTests

PASO 4: Ejecutar las pruebas

Opcion A - Ejecutar todas las pruebas:
mvn clean verify

Opcion B - Ejecutar en modo headless (sin interfaz grafica):
mvn clean verify -Denvironments=headless

Opcion C - Ejecutar una prueba especifica:
mvn clean verify -Dtest=SauceDemoPurchaseFlowTest#completarFlujoDeCompraE2E

PASO 5: Ver el reporte de resultados

Despues de la ejecucion, abrir en el navegador:
target\site\serenity\index.html

=================================================================

UBICACION DE REPORTES

Los reportes se generan automaticamente en:

target/site/serenity/index.html

Este reporte detallado incluye:
- Capturas de pantalla de cada paso
- Detalles de la ejecucion paso a paso
- Estadisticas de exito/fallo
- Timeline de ejecucion
- Informacion de navegador y entorno

=================================================================

FLUJO DE LA PRUEBA E2E

1. Navegar a https://www.saucedemo.com/

2. Autenticarse con:
   - Usuario: standard_user
   - Contrasena: secret_sauce

3. Agregar 2 productos al carrito:
   - Sauce Labs Backpack
   - Sauce Labs Bike Light

4. Visualizar el carrito

5. Proceder al checkout

6. Completar informacion personal:
   - Nombre: Nathaly
   - Apellido: Moncayo
   - Codigo Postal: 12345

7. Revisar resumen de compra

8. Finalizar compra

9. Validar mensaje: "THANK YOU FOR YOUR ORDER"

=================================================================

PRUEBAS INCLUIDAS

1. completarFlujoDeCompraE2E()
   - Prueba completa del flujo de compra desde login hasta confirmacion

2. validarAutenticacionExitosa()
   - Validacion de login con credenciales validas

3. agregarProductosAlCarrito()
   - Agregar productos al carrito y validar cantidad

4. visualizarCarrito()
   - Visualizar carrito de compras y validar items

=================================================================

SCRIPTS .bat (FUNCIONALIDAD Y USO)

El proyecto incluye scripts .bat para simplificar la ejecucion de comandos Maven
en Windows. Aunque son opcionales, proporcionan conveniencia.

descargar-dependencias.bat
- Ejecuta: mvn clean install -DskipTests
- Proposito: Descargar e instalar todas las dependencias del proyecto
- Uso: Doble clic o ejecutar en terminal

ejecutar-pruebas.bat
- Ejecuta: mvn clean verify
- Proposito: Limpiar el proyecto y ejecutar todas las pruebas
- Uso: Doble clic o ejecutar en terminal

ejecutar-headless.bat
- Ejecuta: mvn clean verify -Denvironments=headless
- Proposito: Ejecutar pruebas sin interfaz grafica del navegador
- Uso: Doble clic o ejecutar en terminal

ejecutar-prueba-especifica.bat
- Proposito: Ejecutar una prueba especifica (requiere parametro)
- Uso: Modificar el script con el nombre de la prueba deseada

NOTA IMPORTANTE:
Los scripts .bat son opcionales. Ejecutar directamente el comando Maven:
mvn clean verify
produce el mismo resultado y es recomendado para portabilidad multiplataforma.

=================================================================

PATRON SCREENPLAY

El proyecto utiliza el patron Screenplay de Serenity BDD, que proporciona:

- Actors: Usuarios/personajes que realizan acciones
- Abilities: Capacidades que poseen los actores
- Tasks: Acciones de alto nivel que realizan los actores
- Questions: Validaciones y consultas sobre el estado
- Interactions: Interacciones de bajo nivel con UI

Beneficios:
- Tests mas legibles y mantenibles
- Mejor reutilizacion de codigo
- Separacion clara de responsabilidades
- Documentacion viva del comportamiento

=================================================================

CONFIGURACION DE SERENITY

El archivo serenity.conf contiene:
- Configuracion del driver (Chrome)
- Opciones del navegador
- Desactivacion de prompts de contraseña/brechas
- Configuracion de reportes
- Entornos (normal/headless)

=================================================================

SOLUCION DE PROBLEMAS

Problema: Error "chromedriver not found"
Solucion: WebDriverManager descarga automaticamente el driver.
          Verificar conexion a internet.

Problema: Error "Address already in use"
Solucion: Cerrar instancias previas de Chrome/ChromeDriver.

Problema: Tests fallan por timeout
Solucion: Aumentar tiempo de espera en serenity.conf o
          verificar conexion a internet.

Problema: Dependencias no se descargan
Solucion: Ejecutar mvn clean install -U
          Verificar configuracion de Maven y proxy si aplica.

=================================================================

CONSIDERACIONES DE EVALUACION

1. Ejercicio E2E en SerenityBDD con ScreenPlay
   Estado: Cumplido. El proyecto usa Serenity BDD con patron Screenplay.

2. Reportes
   Estado: Reportes HTML detallados generados por Serenity BDD en
           target/site/serenity/index.html

3. Build: Maven 3.9.1 o superior
   Estado: Configurado y compatible.

4. IDE: IntelliJ IDEA
   Estado: Compatible con el proyecto.

5. JDK: 17
   Estado: Configurado y compatible.

6. Datos por parametro (CSV o JSON)
   Recomendacion: Los datos actualmente se encuentran in-line en el test.
                  Para mejora futura, considerar parametrizarlos desde
                  src/test/resources/datos/

7. README: pasos de ejecucion y ubicacion de reportes
   Estado: Cumplido. Se indica ubicacion en target/site/serenity/index.html

=================================================================

REFERENCIAS

Para mas informacion sobre Serenity BDD:
https://serenity-bdd.github.io/

Para mas informacion sobre Screenplay Pattern:
https://serenity-bdd.github.io/docs/screenplay/screenplay_fundamentals

=================================================================

