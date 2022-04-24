package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;



public class cardDelivery {

    @Test
    public void cardDeliveryOrderSuccessful() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Ставрополь");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        String verificationDate = LocalDate.now() .plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=date] input").setValue(verificationDate);
        $("[data-test-id=name] input").setValue("Вячеслав");
        $("[data-test-id=phone] input").setValue("+79858883344");
        $("[data-test-id=agreement]").click();
        $x("//*[text()=\"Забронировать\"]").click();
        $("[data-test-id=notification]").shouldHave(Condition.text("Успешно!"), Duration.ofSeconds(15));

    }
}
