# Applitools Cross Browser Testing Hackathon 2020

## Prerequisites 
- **Programming Language:** Kotlin 1.3.72, Java 14
- **Build Tool:** Maven 3.6.3 
- **Test Runner:** TestNG 7.1.0
- **Other Dependencies:**
    - Selenium 3.141.59
    - WebDriverManager 4.0.0
    - Applitools Eyes 3.164.0

## Instructions
### Execute Traditional Tests locally
1. Download repo using ```git clone```
2. Navigate to project folder
4. Run one of the commands below:
    - Run traditional tests against the v1 website: ```mvn test -PTraditionalSuiteV1```
    - Run traditional tests against the v2 website: ```mvn test -PTraditionalSuiteV2```

### Execute Modern Tests on UltraFast Grid
1. Download repo using ```git clone```
2. Navigate to project folder
3. Add Applitools API key to the ```modernSuiteV1.xml``` and ```modernSuiteV2.xml``` in suite parameter ```apikey```
4. Run one of the commands below:
    - Run modern tests against the v1 website: ```mvn test -PModernSuiteV1```
    - Run modern tests against the v2 website: ```mvn test -PModernSuiteV1```