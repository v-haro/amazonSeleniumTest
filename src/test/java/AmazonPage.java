import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AmazonPage {

    private WebDriver driver;

    // Locators
    private By searchTextBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By successMessageLocator = By.xpath("//span[@class=\"a-color-state a-text-bold\"]");
    private By firstArticle = By.xpath("(//div[contains(@class, 's-main-slot')]/div[@data-component-type='s-search-result'])[1]//h2/a");

    private By secondArticle = By.xpath("(//div[contains(@class, 's-main-slot')]/div[@data-component-type='s-search-result'])[2]//h2/a");
    private By productTitleLocator = By.id("productTitle");
    private By productPriceLocator = By.xpath("//span[contains(@class, 'a-price')]//span[@class='a-offscreen']");
    private By productRatingLocator = By.xpath("(//a[@class=\"a-popover-trigger a-declarative\"]/span[@class=\"a-size-base a-color-base\"])[1]");
    private By productDescriptionLocator = By.id("productDescription");

    // Constructor
    public AmazonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchText(String text) {
        driver.findElement(searchTextBox).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessageLocator).getText().trim();
    }

    public void clickFirstArticle() {
        driver.findElement(firstArticle).click();
    }

    public void clickSecondArticle() {
        driver.findElement(secondArticle).click();
    }

    public String getProductTitle() {
        return driver.findElement(productTitleLocator).getText().trim();
    }

    public String getProductPrice() {
        try {
            return driver.findElement(productPriceLocator).getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public String getProductRating() {
        return driver.findElement(productRatingLocator).getText().trim();
    }

    public String getProductDescription() {
        try {
            return driver.findElement(productDescriptionLocator).getText().trim();
        } catch (NoSuchElementException e) {
            return "";
        }
    }


}
