import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;

import static com.codeborne.selenide.Selenide.*;

public class TestCardDelivery {

    @Test
    void shouldScheduledMeeting() {
        open("http://localhost:9999");
        $("[data-test-id = city] input").setValue("Белгород");
        $("[data-test-id = name] input").setValue("Иванов-Петров Иван");
        $("[data-test-id = phone] input").setValue("+79204444444");
        $("[data-test-id = agreement]").click();
        $$("button").find(Condition.exactText("Забронировать")).click();
        $("[data-test-id = notification]").waitUntil(Condition.visible, 15000);
    }

    @Test
    void shouldScheduledMeetingCity() {
        open("http://localhost:9999");
        $("[data-test-id = city] input").setValue("Бе");
        //Thread.sleep(5000);
        $$(".menu-item__control").first().click();
        $("[data-test-id = name] input").setValue("Иванов-Петров Иван");
        $("[data-test-id = phone] input").setValue("+79204444444");
        $("[data-test-id = agreement]").click();
        $$("button").find(Condition.exactText("Забронировать")).click();
        $("[data-test-id = notification]").waitUntil(Condition.visible, 15000);
    }

//    @Test
//    void shouldScheduledMeetingDate() throws InterruptedException {
//        LocalDate date = LocalDate.now().plusDays(7);
//        String date7 = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        open("http://localhost:9999");
//        $("[data-test-id = city] input").setValue("Бе");
//        $$(".menu-item__control").first().click();
//        $("[data-test-id = date] .icon_name_calendar").click();
//        Thread.sleep(5000);
//        $("[data-test-id = date] [class = input__control]").setValue(date7);
//        Thread.sleep(5000);
//        $("[data-test-id = name] input").setValue("Иванов-Петров Иван");
//        $("[data-test-id = phone] input").setValue("+79204444444");
//        $("[data-test-id = agreement]").click();
//        $$("button").find(Condition.exactText("Забронировать")).click();
//        $("[data-test-id = notification]").waitUntil(Condition.visible, 15000);
//    }

}
