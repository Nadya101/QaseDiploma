package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuContainer extends BasePage {
    public MenuContainer(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-menu")
    private WebElement userMenu;

    public MenuModal openMenu() {
        userMenu.click();
        return new MenuModal(driver);
    }

}