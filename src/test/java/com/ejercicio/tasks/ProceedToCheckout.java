package com.ejercicio.tasks;

import com.ejercicio.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProceedToCheckout implements Task {

    public static ProceedToCheckout now() {
        return instrumented(ProceedToCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON)
        );
    }
}

