package com.ejercicio.tasks;

import com.ejercicio.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillCheckoutInformation implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public FillCheckoutInformation(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static FillCheckoutInformation withData(String firstName, String lastName, String postalCode) {
        return instrumented(FillCheckoutInformation.class, firstName, lastName, postalCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_FIELD),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE_FIELD),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }
}

