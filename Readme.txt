1. Download Maven plugin for Eclipse (if NA)
2. Create a Maven project with basic skeleton
3. Add Selenium and TestNG dependencies to POM.XML
4. Install TestNG plugin
5. Create TestNG class, add @BeforeTest and @AfterTest
6. Right click test class and select Convert to TestNG
7. Set parallel="false" on testng.xml
8. In POM.XML, add plugins for maven-compiler and maven-surefire. Add testng.xml as suite file for surefire.
9. Right-click project and run as 'Maven Test'

Next->
1. Create page and test folder. Create resources/testData and put excel under it
2. Add page methods inside
3. Add apache poi and poi xml dependencies
4. Add screenshot capability with @AfterMethod tag
5. Put try catch around all selenium commands and set Assert.fail
