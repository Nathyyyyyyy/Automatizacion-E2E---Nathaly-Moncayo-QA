# PROYECTO DE AUTOMATIZACION E2E - SAUCEDEMO

**Elaborado por:** Nathaly Moncayo  
**Fecha:** Enero 2026

![Serenity BDD](https://img.shields.io/badge/Serenity%20BDD-4.0.21-blue) ![Java](https://img.shields.io/badge/Java-17-orange) ![Maven](https://img.shields.io/badge/Maven-3.9.1-red) ![Selenium](https://img.shields.io/badge/Selenium-4.15.0-green) ![JUnit](https://img.shields.io/badge/JUnit%205-5.10.1-yellow) ![Chrome](https://img.shields.io/badge/Chrome-Latest-brightgreen) ![Status](https://img.shields.io/badge/Status-Active-success)

---

## DESCRIPCION

Prueba funcional automatizada (E2E) del flujo de compra en 
https://www.saucedemo.com/ utilizando Serenity BDD con el patron Screenplay.

## CARACTERISTICAS

- Autenticacion de usuario
- Agregacion de productos al carrito
- Visualizacion del carrito de compras
- Completamiento del formulario de checkout
- Finalizacion de compra con confirmacion

## ARQUITECTURA

Este proyecto utiliza el Patron Screenplay de Serenity BDD, que proporciona:
- UI: Definicion de elementos de pagina (Targets)
- Tasks: Acciones de alto nivel
- Questions: Validaciones y consultas
- Tests: Orquestacion del flujo

## TECNOLOGIAS

- Java: 17
- Maven: 3.9.1+
- Serenity BDD: 4.0.21
- Selenium WebDriver: 4.15.0
- JUnit 5: 5.10.1
- Chrome: Version estable reciente

## ESTRUCTURA DEL PROYECTO
```
serenity/
├── src/
│   ├── main/java/
│   │   └── com/ejercicio/
│   │       └── Main.java
│   └── test/java/
│       └── com/ejercicio/
│           ├── test/
│           │   └── SauceDemoPurchaseFlowTest.java    # Tests E2E
│           ├── tasks/                                # Acciones del usuario
│           │   ├── Login.java
│           │   ├── AddProductsToCart.java
│           │   ├── ViewCart.java
│           │   ├── ProceedToCheckout.java
│           │   ├── FillCheckoutInformation.java
│           │   └── FinishPurchase.java
│           ├── questions/                            # Validaciones
│           │   ├── ShoppingCartBadge.java
│           │   ├── CartItems.java
│           │   └── OrderConfirmation.java
│           └── ui/                                   # Elementos UI
│               ├── LoginPage.java
│               ├── ProductsPage.java
│               ├── CartPage.java
│               ├── CheckoutPage.java
│               └── CheckoutCompletePage.java
├── pom.xml                                           # Configuración Maven
├── serenity.conf                                     # Configuración Serenity
├── readme.txt                                        # Instrucciones detalladas
├── conclusiones.txt                                  # Hallazgos y conclusiones
└── README.md                                         # Este archivo
```

## INICIO RAPIDO

### PRERREQUISITOS
1. **Java JDK 17** o superior
```powershell
java -version
```
2. **Apache Maven 3.8+**
```powershell
mvn -version
```
3. **Google Chrome** (ultima version)

### INSTALACION

Paso 1: Navegar al directorio del proyecto
Paso 2: Instalar dependencias
```powershell
mvn clean install -DskipTests
```

### EJECUCION DE PRUEBAS

Ejecutar todas las pruebas:
```powershell
mvn clean verify
```
Ejecutar en modo headless:
```powershell
mvn clean verify -Denvironments=headless
```
Ejecutar una prueba especifica:
```powershell
mvn clean verify -Dtest=SauceDemoPurchaseFlowTest#completarFlujoDeCompraE2E
```

### VER REPORTES

Despues de la ejecucion, los reportes se encuentran en:
```
target/site/serenity/index.html
```
Este reporte incluye:
- Capturas de pantalla de cada paso
- Detalles de la ejecucion
- Estadisticas de exito/fallo
- Timeline de ejecucion

---

## CASOS DE PRUEBA

### Flujo Completo E2E

Test: `completarFlujoDeCompraE2E()`

Pasos:
1. Login con standard_user / secret_sauce
2. Agregar 2 productos (Backpack, Bike Light)
3. Visualizar carrito
4. Proceder a checkout
5. Llenar informacion (Nathaly, Moncayo, 12345)
6. Finalizar compra
7. Validar mensaje "THANK YOU FOR YOUR ORDER"

---

### Validacion de Autenticacion

Test: `validarAutenticacionExitosa()`
- Verifica login exitoso

---

### Agregar Productos

Test: `agregarProductosAlCarrito()`
- Valida agregar 2 productos al carrito

---

### Visualizar Carrito

Test: `visualizarCarrito()`
- Verifica visibilidad de items en carrito

---

## FLUJO DE COMPRA
```
┌─────────────────┐
│   Login Page    │
│  (standard_user)│
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│ Products Page   │
│ (Add 2 products)│
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│   Cart Page     │
│ (View items)    │
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│ Checkout Step 1 │
│ (Fill info)     │
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│ Checkout Step 2 │
│ (Review & Finish)│
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│  Complete Page  │
│  Confirmation │
└─────────────────┘
```

---

## PATRON SCREENPLAY

### Que es Screenplay?
Es un patron de diseño que hace que los tests sean mas expresivos y 
mantenibles. En lugar de centrarse en las interacciones de bajo nivel 
con la UI, Screenplay se enfoca en las tareas que realiza un actor.

### Componentes Principales:

#### 1. Actors (Actores)
```java
Actor usuario = Actor.named("Usuario Comprador");
```

#### 2. Abilities (Habilidades)
```java
usuario.can(BrowseTheWeb.with(navegador));
```

#### 3. Tasks (Tareas)
```java
Login.withCredentials("standard_user", "secret_sauce")
AddProductsToCart.addProducts(2)
```

#### 4. Questions (Preguntas)
```java
OrderConfirmation.message()
ShoppingCartBadge.count()
```

#### 5. Interactions (Interacciones)
```java
Click.on(LoginPage.LOGIN_BUTTON)
Enter.theValue(username).into(LoginPage.USERNAME_FIELD)
```

---

## CONFIGURACION DE SERENITY

El archivo serenity.conf contiene:
- Configuracion del driver (Chrome)
- Opciones del navegador
- Configuracion de reportes
- Entornos (normal/headless)

---

## REPORTES

Serenity BDD genera reportes detallados que incluyen:
- Capturas de pantalla de cada paso
- Tiempo de ejecucion
- Estadisticas de exito/fallo
- Documentacion viva del comportamiento

---

## SOLUCION DE PROBLEMAS

### Maven no se encuentra
- Descargar e instalar Maven desde: https://maven.apache.org/download.cgi
- Agregar al PATH: C:\apache-maven-3.x.x\bin

### ChromeDriver no compatible
- WebDriverManager descarga automaticamente el driver correcto
- Asegurarse de tener la ultima version de Chrome

### Tests fallan por timeout
- Verificar conexion a internet
- Ajustar timeouts en serenity.conf si es necesario

---

## DOCUMENTACION ADICIONAL

- readme.txt: Instrucciones detalladas paso a paso
- conclusiones.txt: Hallazgos, lecciones aprendidas y recomendaciones
- Serenity BDD: https://serenity-bdd.github.io/
- Screenplay Pattern: https://serenity-bdd.github.io/docs/screenplay/screenplay_fundamentals

---

## COMO CONTRIBUIR

Para agregar nuevos tests:
1. Crear nuevos elementos UI si es necesario
2. Implementar Tasks reutilizables
3. Definir Questions para validaciones
4. Escribir el test usando Given-When-Then

---

## LICENCIA

Este proyecto es para fines educativos y de demostracion.

---

## CHECKLIST DE REQUISITOS

- Autenticacion con standard_user / secret_sauce
- Agregar dos productos al carrito
- Visualizar el carrito
- Completar formulario de compra
- Finalizar compra con confirmacion "THANK YOU FOR YOUR ORDER"
- Archivo readme.txt con instrucciones
- Archivo conclusiones.txt con hallazgos
- Patron Screenplay implementado
- Reportes automaticos de Serenity

---
Desarrollado con Serenity BDD y el patron Screenplay
