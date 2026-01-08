package com.ejercicio.tasks;

import com.ejercicio.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FinishPurchase implements Task {

    public static FinishPurchase now() {
        return instrumented(FinishPurchase.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }
}

