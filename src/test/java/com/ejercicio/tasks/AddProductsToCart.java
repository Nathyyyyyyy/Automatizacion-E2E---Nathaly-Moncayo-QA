package com.ejercicio.tasks;

import com.ejercicio.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductsToCart implements Task {

    private final int numberOfProducts;

    public AddProductsToCart(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public static AddProductsToCart addProducts(int numberOfProducts) {
        return instrumented(AddProductsToCart.class, numberOfProducts);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Agregar los primeros N productos al carrito
        if (numberOfProducts >= 1) {
            actor.attemptsTo(
                    Click.on(ProductsPage.BACKPACK_ADD_TO_CART)
            );
            waitABit();
        }

        if (numberOfProducts >= 2) {
            actor.attemptsTo(
                    Click.on(ProductsPage.BIKE_LIGHT_ADD_TO_CART)
            );
            waitABit();
        }

        if (numberOfProducts >= 3) {
            actor.attemptsTo(
                    Click.on(ProductsPage.BOLT_TSHIRT_ADD_TO_CART)
            );
            waitABit();
        }

        if (numberOfProducts >= 4) {
            actor.attemptsTo(
                    Click.on(ProductsPage.FLEECE_JACKET_ADD_TO_CART)
            );
            waitABit();
        }
    }

    private void waitABit() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

