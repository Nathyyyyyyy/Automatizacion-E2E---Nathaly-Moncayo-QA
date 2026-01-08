package com.ejercicio.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    // Checkout Step One - Information
    public static final Target FIRST_NAME_FIELD = Target.the("campo de nombre")
            .located(By.id("first-name"));

    public static final Target LAST_NAME_FIELD = Target.the("campo de apellido")
            .located(By.id("last-name"));

    public static final Target POSTAL_CODE_FIELD = Target.the("campo de código postal")
            .located(By.id("postal-code"));

    public static final Target CONTINUE_BUTTON = Target.the("botón continuar")
            .located(By.id("continue"));

    public static final Target CANCEL_BUTTON = Target.the("botón cancelar")
            .located(By.id("cancel"));

    // Checkout Step Two - Overview
    public static final Target FINISH_BUTTON = Target.the("botón finalizar")
            .located(By.id("finish"));

    public static final Target PAYMENT_INFO = Target.the("información de pago")
            .located(By.className("summary_value_label"));

    public static final Target SHIPPING_INFO = Target.the("información de envío")
            .located(By.cssSelector("[data-test='shipping-info-value']"));

    public static final Target SUBTOTAL = Target.the("subtotal")
            .located(By.className("summary_subtotal_label"));

    public static final Target TAX = Target.the("impuesto")
            .located(By.className("summary_tax_label"));

    public static final Target TOTAL = Target.the("total")
            .located(By.className("summary_total_label"));

    public static final Target CART_ITEMS = Target.the("items del carrito en overview")
            .located(By.className("cart_item"));
}

