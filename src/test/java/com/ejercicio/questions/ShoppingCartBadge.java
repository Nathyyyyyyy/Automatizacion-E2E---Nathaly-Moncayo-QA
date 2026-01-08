package com.ejercicio.questions;

import com.ejercicio.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ShoppingCartBadge implements Question<String> {

    public static ShoppingCartBadge count() {
        return new ShoppingCartBadge();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ProductsPage.SHOPPING_CART_BADGE).answeredBy(actor);
    }
}


