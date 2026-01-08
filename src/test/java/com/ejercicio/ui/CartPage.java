package com.ejercicio.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target PAGE_TITLE = Target.the("título de la página del carrito")
            .located(By.className("title"));

    public static final Target CART_ITEMS = Target.the("items en el carrito")
            .located(By.className("cart_item"));

    public static final Target CART_ITEM_NAME = Target.the("nombre del item en el carrito")
            .located(By.className("inventory_item_name"));

    public static final Target CONTINUE_SHOPPING_BUTTON = Target.the("botón continuar comprando")
            .located(By.id("continue-shopping"));

    public static final Target CHECKOUT_BUTTON = Target.the("botón de checkout")
            .located(By.id("checkout"));

    public static final Target REMOVE_BUTTON = Target.the("botón remover item")
            .located(By.cssSelector("[class*='cart_button']"));
}

