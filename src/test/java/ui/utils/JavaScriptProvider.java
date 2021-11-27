package ui.utils;

import com.kw.auto.driver.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public final class JavaScriptProvider {

    public JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) WebDriverRunner.getWebDriver();
    }

    public void scrollTop() {
        getJavascriptExecutor().executeScript("window.scrollTo(0, document.body.scrollTop);");
    }

    public void scrollTo(WebElement element) {
        JavascriptExecutor js = getJavascriptExecutor();
        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
    }
}
