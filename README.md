# amazonSeleniumTest
Amazon Selenium Testing Project
This project automates UI tests for Amazon using Selenium and TestNG. The main goal of the project is to search for products on Amazon and validate the product details using assertions.

# **Features** 
**Search Automation**: Automated searching of products on Amazon. 
**Product Validation**: Automated validation of product details like title, price, rating, etc.
**Soft Assertions**: Uses the TestNG soft assertions feature to accumulate assertion failures and report them all at once.
**Page Object Model (POM)**: Implements the POM design pattern for maintainability and readability.
**Screenshots**: Automatically captures screenshots for validation purposes.
# **Technologies Used**
**Selenium WebDriver**: For automating browser actions.
*TestNG*: Provides the testing framework.
**Maven**: For project management and dependencies.
**WebDriverManager**: Helps to automate the management of the browser drivers required by Selenium.
**Allure**: For better reporting (if you decide to use it in the future).
# **Setup**
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


Generating Allure Report with Java:
Prerequisites:

Ensure you have Java installed.
Allure CLI needs to be installed. If you haven't installed it yet, you can do so using one of the following methods:
bash
Copy code
# For macOS users:
brew install allure

# For Windows users using scoop:
scoop install allure

# For Linux:
# Follow instructions for your specific distribution from Allure's GitHub page.
Annotations:
Make sure you have used appropriate Allure annotations in your test code. For example: @Step, @Feature, @Story, etc. This will help Allure to generate a detailed report.

Test Execution:
When you run your tests, Allure generates data in a directory (by default allure-results). This directory should be in the root of your project or in the target directory if you're using Maven.

Generating Report:
After running the tests, navigate to the project directory in the terminal and execute the following command:

bash
Copy code
allure serve [directory]
Here, [directory] is the path to the directory where Allure results were saved during test execution (usually allure-results). The command will start a local server and open the report in your default browser.

Maven:
If you are using Maven, you can add the Allure Maven plugin to the <build> section of your pom.xml:

xml
Copy code
<build>
    <plugins>
        <plugin>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-maven</artifactId>
            <version>2.10.0</version>
            <configuration>
                <reportVersion>2.13.8</reportVersion>
            </configuration>
        </plugin>
    </plugins>
</build>
After your tests are executed, you can generate the report using the command:

bash
Copy code
mvn allure:report
The report will be generated in the target/site/allure-maven-plugin directory.

Continuous Integration (CI):
If you're using a CI/CD tool, there are Allure plugins available for most of the popular CI/CD tools like Jenkins, Bamboo, TeamCity, etc. These plugins can be configured to automatically generate and publish Allure reports after each test run.

Remember to share this report generation process with your team or anyone who needs to view the test reports, so they can set up their environment appropriately.
