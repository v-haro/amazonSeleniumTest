# amazonSeleniumTest
Amazon Selenium Testing Project
This project automates UI tests for Amazon using Selenium and TestNG. The main goal of the project is to search for products on Amazon and validate the product details using assertions.

**Features** 
**Search Automation**: Automated searching of products on Amazon. 
**Product Validation**: Automated validation of product details like title, price, rating, etc.
**Soft Assertions**: Uses the TestNG soft assertions feature to accumulate assertion failures and report them all at once.
**Page Object Model (POM)**: Implements the POM design pattern for maintainability and readability.
**Screenshots**: Automatically captures screenshots for validation purposes.
**Technologies Used**
**Selenium WebDriver**: For automating browser actions.
*TestNG*: Provides the testing framework.
**Maven**: For project management and dependencies.
**WebDriverManager**: Helps to automate the management of the browser drivers required by Selenium.
**Allure**: For better reporting (if you decide to use it in the future).
**Setup**
Clone the repository:
bash
Copy code
git clone [Your Repository URL]
Navigate to the project directory:
bash
Copy code
cd [Your Project Directory Name]
Install the dependencies using Maven:
Copy code
mvn clean install
Run the tests:
bash
Copy code
mvn test
Project Structure
src/main/java: Contains utility classes like WebDriver manager, screenshot helper, and assertion helper.
src/main/resources: Contains data files (like JSON data for products).
src/test/java: Contains the test classes and the Page Object Model classes.
