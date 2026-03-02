OpenCart Automation Framework
==============================

Project Overview
----------------
This project is a Selenium-based automation framework developed to automate key user flows in the OpenCart e-commerce web application.

The framework is designed using Java and follows the Page Object Model (POM) design pattern to ensure maintainability and scalability.

Technologies Used
-----------------
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Git

Automated Test Scenarios
------------------------
- User Registration
- Login Functionality
- Product Search
- Add to Cart
- Checkout Validation

Framework Design
----------------
- Page Object Model implemented for better code organization
- Separate test classes and reusable utility methods
- TestNG used for test execution and reporting
- Maven used for dependency management
- testng.xml used for suite configuration

Project Structure
-----------------
src/main/java      -> Page classes and base setup  
src/test/java      -> Test classes  
testng.xml,master.xml         -> Test suite execution file  
pom.xml            -> Maven dependencies  

How to Run the Project
----------------------
1. Clone the repository
    git clone https://github.com/priyankamrk-cloud/openCart.git
2. Open the project in Eclipse or IntelliJ
3. Install Maven dependencies 
    Maven will automatically download dependencies from pom.xml.
    If not, right-click project → Maven → Update Project.
4. Run the testng.xml file as
    Run As → TestNG Suite

Author
------
Priyanka M
