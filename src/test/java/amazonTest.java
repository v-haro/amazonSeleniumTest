
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.qameta.allure.Description;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.List;
import utils.AssertionHelper;
import utils.JsonUtil;
import utils.ScreenshotHelper;

public class amazonTest {

    private WebDriver driver;
    private AmazonPage amazonPage;
    private ScreenshotHelper screenshotHelper;
    private SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        amazonPage = new AmazonPage(driver);
        screenshotHelper = new ScreenshotHelper(driver);
    }

    @DataProvider(name = "articleProvider")
    public Object[][] provideArticles() throws IOException {
        List<String> articles = JsonUtil.getArticlesFromJson("src/main/resources/articles.json");
        Object[][] data = new Object[articles.size()][1];
        for (int i = 0; i < articles.size(); i++) {
            data[i][0] = articles.get(i);
        }
        return data;
    }

    @Test(description = "Amazon product search", dataProvider = "articleProvider")
    @Description("Tests the feedback form by filling and submitting it.")
    public void searchArticleAmazon(String article) throws IOException {
        System.out.println("Testing article: " + article);

        SoftAssert softAssert = new SoftAssert();

        driver.get("https://www.amazon.com");
        amazonPage.enterSearchText(article);
        amazonPage.clickSearchButton();

        String text = amazonPage.getSuccessMessage();
        String textWithoutQuotes = text.replace("\"", "");
        System.out.println("article is: " + textWithoutQuotes);

        Assert.assertTrue(textWithoutQuotes.equals(article));
        amazonPage.clickFirstArticle();

        String productTitle = amazonPage.getProductTitle();
        String productPrice = amazonPage.getProductPrice();
        String productRating = amazonPage.getProductRating();
        String productDescription = amazonPage.getProductDescription();

        // For the first product
        screenshotHelper.captureScreenshot("product1_" + article);

        String productURL = driver.getCurrentUrl();
        driver.navigate().back();

        amazonPage.clickSecondArticle();  // This is assumed to be the second product

        String productTitle2 = amazonPage.getProductTitle();
        String productPrice2 = amazonPage.getProductPrice();
        String productRating2 = amazonPage.getProductRating();
        String productDescription2 = amazonPage.getProductDescription();

        // For the second product
        screenshotHelper.captureScreenshot("product2_" + article);

        AssertionHelper.softAssertNotEquals(softAssert, productTitle, productTitle2, "product titles are the same!");
        if (!productPrice.equals("") && !productPrice2.equals("")) {
        AssertionHelper.softAssertNotEquals(softAssert, productPrice, productPrice2, "Prices are the same!");
        }
        softAssert.assertAll();
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
