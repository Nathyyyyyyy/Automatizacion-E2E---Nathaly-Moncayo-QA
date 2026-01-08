package com.ejercicio.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.page.TheWebPage.title;

public class WaitForPageLoad implements Task {

    public static WaitForPageLoad complete() {
        return instrumented(WaitForPageLoad.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Espera simple para asegurar que la página cargue completamente
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

