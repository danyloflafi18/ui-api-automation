package ui.steps;

import com.google.inject.Inject;
import com.kw.auto.driver.WebDriverRunner;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.entity.User;
import ui.utils.DataHolder;
import ui.utils.JavaScriptProvider;

import java.time.Duration;

public abstract class BaseSteps {
    static final int MEDIUM_WAIT = 20;
    static final int POLLING_TIME = 300;
    private static final ThreadLocal<DataHolder> THREAD_LOCAL_DATA_HOLDER = new ThreadLocal<>();

    private final WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 20);

    @Inject
    private JavaScriptProvider javaScriptProvider;
    protected User currentUser = getDataHolder().getCurrentUser();

    public static DataHolder getDataHolder() {
        return THREAD_LOCAL_DATA_HOLDER.get();
    }

    public static void setDataHolder(final DataHolder dataHolder) {
        THREAD_LOCAL_DATA_HOLDER.set(dataHolder);
    }

    public final FluentWait<WebDriver> getFluentWait() {
        return new FluentWait<>(WebDriverRunner.getWebDriver())
                .withTimeout(Duration.ofSeconds(MEDIUM_WAIT))
                .pollingEvery(Duration.ofMillis(POLLING_TIME))
                .ignoring(StaleElementReferenceException.class, ElementClickInterceptedException.class);
    }

    public final WebDriverWait getWait() {
        return wait;
    }

    public final JavaScriptProvider getJavaScriptProvider() {
        return javaScriptProvider;
    }
}
