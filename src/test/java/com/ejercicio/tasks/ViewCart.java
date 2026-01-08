package com.ejercicio.tasks;

import com.ejercicio.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ViewCart implements Task {

    public static ViewCart now() {
        return instrumented(ViewCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.SHOPPING_CART_LINK)
        );

        // Espera para que el carrito cargue completamente
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

