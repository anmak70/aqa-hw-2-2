import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;

public class TestCardDelivery {

    @Test
    void shouldScheduledMeeting() {
        LocalDate date = LocalDate.now().plusDays(4);
        String datePlus = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        open("http://localhost:9999");
        $("[data-test-id = city] input").setValue("Белгород");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=date] input").setValue(datePlus);
        $("[data-test-id = name] input").setValue("Иванов-Петров Иван");
        $("[data-test-id = phone] input").setValue("+79204444444");
        $("[data-test-id = agreement]").click();
        $$("button").find(Condition.exactText("Забронировать")).click();
        $("[data-test-id = notification]").waitUntil(Condition.visible, 15000);
    }

    @Test
    void shouldScheduledMeetingCityDate() {
        LocalDate date = LocalDate.now().plusDays(7);
        String datePlus = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        open("http://localhost:9999");
        $("[data-test-id = city] input").setValue("Бе");
        $$(".menu-item__control").find(Condition.text("Белгород")).click();
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=date] input").setValue(datePlus);
        $("[data-test-id = name] input").setValue("Иванов-Петров Иван");
        $("[data-test-id = phone] input").setValue("+79204444444");
        $("[data-test-id = agreement]").click();
        $$("button").find(Condition.exactText("Забронировать")).click();
        $("[data-test-id = notification]").waitUntil(Condition.visible, 15000);
    }
}
