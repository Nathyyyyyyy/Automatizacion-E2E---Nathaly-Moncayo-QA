package com.ejercicio.test;

import com.ejercicio.questions.CartItems;
import com.ejercicio.questions.OrderConfirmation;
import com.ejercicio.questions.ShoppingCartBadge;
import com.ejercicio.tasks.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(SerenityJUnit5Extension.class)
@DisplayName("Prueba E2E de flujo de compra en SauceDemo")
public class SauceDemoPurchaseFlowTest {

    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver navegador;

    Actor usuario;

    @BeforeEach
    public void configurarActor() {
        usuario = Actor.named("Usuario Comprador");
        usuario.can(BrowseTheWeb.with(navegador));
    }

    @Test
    @DisplayName("Completar flujo de compra E2E en SauceDemo - Debería completar el flujo de compra exitosamente desde login hasta confirmación")
    public void completarFlujoDeCompraE2E() {

        givenThat(usuario).wasAbleTo(
                Login.withCredentials("standard_user", "secret_sauce")
        );

        when(usuario).attemptsTo(
                AddProductsToCart.addProducts(2)
        );

        then(usuario).should(
                seeThat("El badge muestra 2 productos",
                        ShoppingCartBadge.count(), equalTo("2"))
        );

        when(usuario).attemptsTo(
                ViewCart.now()
        );

        when(usuario).attemptsTo(
                ProceedToCheckout.now(),
                FillCheckoutInformation.withData("Nathaly", "Moncayo", "12345"),
                FinishPurchase.now()
        );

        then(usuario).should(
                seeThat("El mensaje de confirmación es correcto",
                        OrderConfirmation.message(),
                        containsStringIgnoringCase("THANK YOU FOR YOUR ORDER"))
        );
    }

    @Test
    @Disabled("Deshabilitado - Solo ejecutar el flujo completo E2E")
    @DisplayName("Validar autenticación exitosa - Debería autenticarse correctamente con credenciales válidas")
    public void validarAutenticacionExitosa() {

        givenThat(usuario).wasAbleTo(
                Open.url("https://www.saucedemo.com/")
        );

        when(usuario).attemptsTo(
                Login.withCredentials("standard_user", "secret_sauce")
        );

        then(usuario).should(
                seeThat("El badge del carrito está visible",
                        ShoppingCartBadge.count(), notNullValue())
                        .orComplainWith(AssertionError.class,
                                "No se pudo autenticar correctamente")
        );
    }

    @Test
    @Disabled("Deshabilitado - Solo ejecutar el flujo completo E2E")
    @DisplayName("Agregar productos al carrito - Debería poder agregar 2 productos al carrito correctamente")
    public void agregarProductosAlCarrito() {

        givenThat(usuario).wasAbleTo(
                Login.withCredentials("standard_user", "secret_sauce")
        );

        when(usuario).attemptsTo(
                AddProductsToCart.addProducts(2)
        );

        then(usuario).should(
                seeThat("El badge muestra 2 productos",
                        ShoppingCartBadge.count(), equalTo("2"))
        );
    }

    @Test
    @Disabled("Deshabilitado - Solo ejecutar el flujo completo E2E")
    @DisplayName("Visualizar carrito de compras - Debería poder visualizar los productos en el carrito")
    public void visualizarCarrito() {

        givenThat(usuario).wasAbleTo(
                Login.withCredentials("standard_user", "secret_sauce"),
                AddProductsToCart.addProducts(2)
        );

        when(usuario).attemptsTo(
                ViewCart.now()
        );

        then(usuario).should(
                seeThat("Los items están visibles en el carrito",
                        CartItems.areVisible(), is(true))
        );
    }
}

