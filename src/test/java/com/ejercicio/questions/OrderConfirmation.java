package com.ejercicio.questions;

import com.ejercicio.ui.CheckoutCompletePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class OrderConfirmation implements Question<String> {

    public static OrderConfirmation message() {
        return new OrderConfirmation();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CheckoutCompletePage.COMPLETE_HEADER).answeredBy(actor);
    }
}

