package com.ejercicio.questions;

import com.ejercicio.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class CartItems implements Question<Boolean> {

    public static CartItems areVisible() {
        return new CartItems();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(CartPage.CART_ITEMS).answeredBy(actor).booleanValue();
    }
}

