package heisenbub19;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class TwoBrowsersTest extends SelenideBaseTest{
    SelenideDriver admin = new SelenideDriver(new SelenideConfig()
            .browser("firefox"));
    SelenideDriver user = new SelenideDriver(new SelenideConfig()
            .browser("chrome"));
    private static final String URL  = "https://todomvc.com/examples/react/#/";
    @Description(value = "Тест проверяет эквивалентность единицы единице")
    @Test
    void adminAndUser(){
        admin.open(URL);
        user.open(URL);
    }
}
