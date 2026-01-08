package com.ejercicio.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutCompletePage {

    public static final Target COMPLETE_HEADER = Target.the("encabezado de confirmación")
            .located(By.className("complete-header"));

    public static final Target COMPLETE_TEXT = Target.the("texto de confirmación")
            .located(By.className("complete-text"));

    public static final Target PONY_EXPRESS_IMAGE = Target.the("imagen de confirmación")
            .located(By.className("pony_express"));

    public static final Target BACK_HOME_BUTTON = Target.the("botón volver al inicio")
            .located(By.id("back-to-products"));

    public static final Target THANK_YOU_MESSAGE = Target.the("mensaje de agradecimiento")
            .located(By.xpath("//*[contains(text(), 'THANK YOU FOR YOUR ORDER')]"));
}

