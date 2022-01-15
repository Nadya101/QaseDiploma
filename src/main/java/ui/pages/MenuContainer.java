package ui.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class MenuContainer extends BasePage {
    public MenuContainer(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-menu")
    private WebElement userMenu;

    public MenuModal openMenu() {
        log.info("Click on 'User menu' button");
        userMenu.click();
        return new MenuModal(driver);
    }

}