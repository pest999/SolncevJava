package Pack;

import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;


@ExtendWith(TextReportExtension.class)

public class ListenerTest {
    private static final Logger log = LoggerFactory.getLogger(ListenerTest.class);
    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("logger", new LogEventListener() {
            @Override
            public void afterEvent(LogEvent currentLog) {
                log.info("after {} {}", currentLog.getElement(), currentLog.getStatus());
            }

            @Override
            public void beforeEvent(LogEvent currentLog) {
                log.info("before {} {}", currentLog.getElement(), currentLog.getStatus());
            }
        });

        open("https://todomvc.com/examples/react/");
        localStorage().clear();
        refresh();
    }

    @ParameterizedTest
    @ValueSource(strings = {"get up", "brake"})
    void simpleFlow(String todoItem){
        setUp();

        $$(".todo-list .view").shouldHave(size(0));
        $(".new-todo").val(todoItem).pressEnter();
        $$(".todo-list .view").shouldHave(size(1));
        sleep(5000);
    }
}
