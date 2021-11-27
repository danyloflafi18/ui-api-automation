package ui.pages;

import com.google.inject.Inject;
import com.kw.auto.driver.WebDriverRunner;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utils.JavaScriptProvider;

import java.time.Duration;
import java.util.List;

import static com.kw.auto.driver.WebDriverRunner.getWebDriver;
import static java.lang.String.format;

public abstract class BasePage {
    static final int SHORT_WAIT = 5;
    static final int MEDIUM_WAIT = 25;
    static final int POLLING_TIME = 300;

    @Inject
    private JavaScriptProvider javaScriptProvider;

    private final WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 30);

    protected BasePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(WebDriverRunner.getWebDriver(),
                        SHORT_WAIT),
                this);
    }

    public static void hover(final WebElement element) {
        Actions action = new Actions(getWebDriver());
        action.moveToElement(element).build().perform();
    }

    public final WebDriverWait getWait() {
        return wait;
    }

    protected final FluentWait<WebDriver> getFluentWait() {
        return new FluentWait<>(WebDriverRunner.getWebDriver())
                .withTimeout(Duration.ofSeconds(MEDIUM_WAIT))
                .pollingEvery(Duration.ofMillis(POLLING_TIME))
                .ignoring(StaleElementReferenceException.class, ElementClickInterceptedException.class);
    }

    public final JavaScriptProvider getJavaScriptProvider() {
        return javaScriptProvider;
    }
}
