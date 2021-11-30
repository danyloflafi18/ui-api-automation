package ui.utils;

import com.kw.auto.driver.WebDriverRunner;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

@Log4j2
public final class ElementUtils {
    private ElementUtils() {
    }

    private static FluentWait<WebDriver> getFluentWait() {
        return new FluentWait<>(WebDriverRunner.getWebDriver())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(600))
                .ignoring(StaleElementReferenceException.class);
    }

    public static void click(WebElement webElement) {

        LocalDateTime stopPoint = LocalDateTime.now().plusSeconds(20);
        while (stopPoint.isAfter(LocalDateTime.now())) {
            try {
                getFluentWait().until(elementToBeClickable(webElement)).click();
                break;
            } catch (StaleElementReferenceException ex) {
                log.info(ex.getMessage());
            }
        }
    }
}
