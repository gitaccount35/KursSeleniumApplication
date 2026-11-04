# KursSeleniumApplication

A Java and Selenium WebDriver learning project containing browser automation examples and TestNG tests. The examples demonstrate common UI automation tasks against public Selenium practice pages and a few live demo sites, including locating elements, interacting with forms, handling browser windows and iframes, waiting for dynamic content, and working with browser drivers.

## Technology

- Java 11
- Maven
- Selenium WebDriver 4
- TestNG
- WebDriverManager

## Requirements and running the tests

- JDK 11 or later and Maven
- Internet access to reach the sites used by the tests
- Microsoft Edge, Firefox, and Chrome for tests that launch those browsers

Run the suite from the project root:

```shell
mvn test
```

Tests open real browsers and interact with external sites, so results can depend on browser availability and changes to those sites. `SeleniumTest` uses machine-specific WebDriver executable paths; update `getDriver()` in that class for your environment. `UploadFileTest` also uses an absolute path to `sample.txt`; change it to the location of that file in your checkout before running the upload test.

## Test inventory

| Test class | What it exercises |
|---|---|
| `ActionsClickTest` | Right-click/context-click and double-click interactions. |
| `ActionsHoverTest` | Moving the pointer over an element. |
| `BasicActionsTest` | Form navigation and entry, alerts, checkbox and radio selection, dropdown selection, and reading hidden text. |
| `ElementIstnieje` | Checking element existence, visibility, enabled state, and checkbox selection. |
| `GetPageInfo` | Reading the current page title and URL. |
| `IframeTest` | Switching into an iframe, entering text, and returning to the main page. |
| `ImageTest` | Reading an image's natural height and asserting the expected value. |
| `JavascriptExecutorTest` | Clicking a link and setting an input value with JavaScript. |
| `NewWindowTest` | Switching between browser windows and interacting with each page. |
| `SecondTest` (default package) | Opening a demo shop and asserting that a product is displayed. |
| `SelectorTest` | Finding elements with Selenium locators and CSS selectors, including structural selectors. |
| `SeleniumTest` | Searching Bing and asserting that a Selenium-related result is displayed. |
| `UploadFileTest` | Selecting `sample.txt` in a file input and saving a screenshot. |
| `WaitTest` | Waiting for dynamically displayed content with explicit and fluent waits. |
| `WebDriverManagerTest` | Starting Firefox, Edge, and Chrome and opening Google. |
| `XpathTest` | Finding elements with XPath expressions, attributes, axes, and logical operators. |
| `Adnotations.FirstTest` | TestNG examples for waiting on dynamic content and checking its visibility and text with hard and soft assertions. |
| `Adnotations.SecondTest` | Repeating dynamic-content waits in tests that inherit TestNG lifecycle hooks. |
| `Adnotations.ThirdTest` | TestNG test ordering with priorities. |
| `Adnotations.FourthTest` | TestNG method dependencies and execution ordering. |

`Adnotations.BaseTest`, `Adnotations.DriverFactory`, and `Adnotations.SampleTestListener` provide shared driver lifecycle and failure-screenshot examples for the annotation tests.
