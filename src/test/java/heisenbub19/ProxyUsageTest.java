package heisenbub19;

import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProxyUsageTest extends SelenideBaseTest{
     @Test
    void downloadFile(){
        open("https://the-internet.herokuapp.com/download");
        File download = $(byText("test.txt")).download();
        sleep(3000);

    }
}
