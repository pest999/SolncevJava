package heisenbub19;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestListener implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause){
/*        Object instance = context.getRequiredTestInstance();
        WebDriver driver = null;
        try {
            driver = instance.getClass().getDeclaredField("driver").get(instance);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        Allure.getLifecycle().addAttachment(
                "screenshot","img/png", "png",
                ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)
        );

        driver.close();
        driver.quit();*/
    }
}
