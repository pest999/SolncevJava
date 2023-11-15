package heisenbub19;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TodoMvcTest extends SelenideBaseTest{

    @Story(value = "One")
    @ParameterizedTest
    @ValueSource(strings = {"get up", "brake"})
    @Step("Проверка разности числа")
    void simpleFlow(String todoItem){
        step("1");
        $$(".todo-list .view").shouldHave(size(0));
        step("2");

        $(".new-todo").val(todoItem).pressEnter();
        step("3");

        $$(".todo-list .view").shouldHave(size(1));
        step("4");

        sleep(5000);
    }

    @Story(value = "One")
    @Test
    @Owner("Artem")
    @Description("One site")
     void hurdFlow(){
        open("https://todomvc.com/examples/react/");
        localStorage().clear();
        refresh();

        $$(".todo-list .view").shouldHave(size(0));
        $(".new-todo").val("todoItem").pressEnter();
        $$(".todo-list .view").shouldHave(size(1));
        sleep(5000);
    }
}
