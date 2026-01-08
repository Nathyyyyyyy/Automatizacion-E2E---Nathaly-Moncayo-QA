package com.ejercicio.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {

    public static final Target PAGE_TITLE = Target.the("título de la página de productos")
            .located(By.className("title"));

    public static final Target SHOPPING_CART_BADGE = Target.the("badge del carrito de compras")
            .located(By.className("shopping_cart_badge"));

    public static final Target SHOPPING_CART_LINK = Target.the("enlace al carrito de compras")
            .located(By.className("shopping_cart_link"));

    // Productos específicos
    public static final Target BACKPACK_ADD_TO_CART = Target.the("botón agregar mochila al carrito")
            .located(By.id("add-to-cart-sauce-labs-backpack"));

    public static final Target BIKE_LIGHT_ADD_TO_CART = Target.the("botón agregar luz de bicicleta al carrito")
            .located(By.id("add-to-cart-sauce-labs-bike-light"));

    public static final Target BOLT_TSHIRT_ADD_TO_CART = Target.the("botón agregar camiseta al carrito")
            .located(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));

    public static final Target FLEECE_JACKET_ADD_TO_CART = Target.the("botón agregar chaqueta al carrito")
            .located(By.id("add-to-cart-sauce-labs-fleece-jacket"));

    // Método para construir selector dinámico de producto
    public static Target addToCartButton(String productName) {
        String productId = productName.toLowerCase()
                .replace(" ", "-")
                .replace("(", "")
                .replace(")", "");
        return Target.the("botón agregar " + productName + " al carrito")
                .located(By.id("add-to-cart-" + productId));
    }
}

