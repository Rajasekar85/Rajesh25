package com.baseclass;



	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.math.BigDecimal;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;
	import java.util.Properties;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		public static WebDriver driver;
		
		
		private void implicitywait() {
		}
		
		public String getPropertyValue(String key) throws IOException {
			Properties properties= new Properties();
			FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	       properties.load(stream);
	       Object obj = properties.get(key);
	       String value = (String)obj;
		return value;
		}
		public static void getAllDriver(String browserName) {
			switch (browserName) {
			case "CHROME":
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				break;
			case "IE":
				WebDriverManager.iedriver().setup();
				 driver = new InternetExplorerDriver();
				 break;
				 
			case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
				 break;
			default:
				break;
			}
		}

		public String getvalueFromExcel(String sheetName, int r, int c) throws IOException {
			File file = new File("C:\\Users\\DELL\\eclipse-workspace\\A\\Homeexel\\Adactinhotel.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(r);
			Cell cell = row.getCell(c);
			String data = null;
			CellType cellType = cell.getCellType();
			switch (cellType) {
			case STRING:
				data = cell.getStringCellValue();

				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
					data = format.format(date);

				} else {
					double numericCellValue = cell.getNumericCellValue();
					BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
					data = valueOf.toString();

				}

				break;

			default:
				break;

			}
			return data;
		}

		private void UpdateData(String pathname, String sheetName, int r, int c, String oldName, String newName)
				throws IOException {
			File file = new File(pathname);
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(r);
			Cell cell = row.getCell(c);
			String value = cell.getStringCellValue();
			if (value.equals(oldName)) {
				cell.setCellValue(newName);
				FileOutputStream out = new FileOutputStream(file);
				workbook.write(out);
			}

		}

		public void writeData(String sheetName, int r, int c, String value) throws IOException {
			File file = new File("C:\\Users\\DELL\\eclipse-workspace\\A\\Homeexel\\Adactinhotel.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(r);
			Cell createCell = row.createCell(c);

			createCell.setCellValue(value);
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);

		}
		private void implicitly() {
	           
		}

		public static void getDriver(String url) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
		}

		public static void enterUrl(String url) {
			driver.get(url);

		}

		public WebElement type(WebElement element, String data) {

			element.sendKeys(data);
			return element;
		}

		public void click(WebElement element) {
			element.click();
		}

		public WebElement FindelementId(String attributeValue) {
			WebElement findElement = driver.findElement(By.id(attributeValue));
			return findElement;

		}

		public WebElement FindElementName(String name) {
			WebElement findElement = driver.findElement(By.name(name));
			return findElement;
		}

		public WebElement FindElementClassName(String className) {
			WebElement findElement = driver.findElement(By.className(className));
			return findElement;
		}

		public String getText() {
			String title = driver.getTitle();
			return title;
		}

		public String getCurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}

		public String getAttribute(WebElement element, String name) {
			String attribute = element.getAttribute(name);
			return attribute;
		}

		public String getAttribute(WebElement element) {
			String attribute = element.getAttribute("value");
			return attribute;
		}

		public int selectoptionsbyIndex(WebElement element, int index) {
			Select select = new Select(element);
			select.selectByIndex(index);
			return index;
		}

		public void selectOptionsbyVissibleText(WebElement element, String text) {
			Select select = new Select(element);
			select.selectByVisibleText(text);

		}

		public void SelectOptionsByAttribute(WebElement element, String value) {
			Select select = new Select(element);
			select.selectByValue(value);

		}

		public void typeJs(WebElement element, String text) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("argument[0],setAttribute('value','" + text + "'", element);
		}

		public WebElement SendKeys(WebElement element, String value) {
			element.clear();
			element.sendKeys(value);
			return element;
		}

		public WebElement finfElementbypath(String value) {
			WebElement findElement = driver.findElement(By.xpath(value));
			return findElement;
		}

		public void Alertsdismiss() {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}

		public void Aletrssaccept() {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}

		public static void Maximum() {
			driver.manage().window().maximize();
		}

		public static void Close() {
			driver.close();
		}

		public static void quit() {
			driver.quit();
		}

		public void Navigate(String url) {
			driver.navigate().to(url);
		}

		public void Navigate1() {
			driver.navigate().toString();
		}

		public void navigate3() {
			driver.navigate().forward();
		}

		public void Navigate4() {
			driver.navigate().back();

		}

		public void Navigate5() {
			driver.navigate().refresh();
		}

		public void Threds(int millis) throws InterruptedException {
			Thread.sleep(millis);
		}

		public String gettext(WebElement element) {
			String text1 = element.getText();
			return text1;
		}

		public void THreads2(int millis, int nanos) throws InterruptedException {
			Thread.sleep(millis, nanos);
		}

		public void Action1(WebElement target) {
			Actions action = new Actions(driver);
			action.moveToElement(target).perform();

		}

		public void Action2(WebElement source, WebElement target) {
			Actions action = new Actions(driver);
			action.dragAndDrop(source, target).perform();

		}

		public void robot1() throws AWTException {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_0);
		}

		public void Action3(WebElement element) {
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();
		}

		public void Screeshot(String string, File srcFile, File destFile) throws IOException {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File(string);
			FileUtils.copyFile(srcFile, destFile);

		}

		public void getScreenshot(WebElement element, String value, File srcFile, File destFile) throws IOException {
			File screenshotAs = element.getScreenshotAs(OutputType.FILE);
			File d = new File(value);
			FileUtils.copyFile(srcFile, destFile);
		}

		public void js3(WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguements[0].click()", element);

		}

		public List<WebElement> getOption(WebElement element) {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			return options;
		}

		public List<WebElement> get(WebElement element) {
			Select select = new Select(element);
			List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			return allSelectedOptions;
		}

		public WebElement Firsselected(WebElement element) {
			Select select = new Select(element);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			return firstSelectedOption;
		}

		public boolean ismult(WebElement element) {
			Select select = new Select(element);
			boolean multiple = select.isMultiple();
			return multiple;
		}

		public void deselec(WebElement element) {
			Select select = new Select(element);
			select.deselectAll();
		}

		public void Byindex(WebElement element, int index) {
			Select select = new Select(element);
			select.deselectByIndex(index);
		}

		public void byvalue(WebElement element, String value) {
			Select select = new Select(element);
			select.deselectByValue(value);
		}

		public void byvissible(WebElement element, String text) {
			Select select = new Select(element);
			select.deselectByVisibleText(text);
		}

		public List<WebElement> findingElementsClassName(String className) {
			List<WebElement> elements = driver.findElements(By.className("className"));
			return elements;
		}

		public WebElement findingElementsXpath(String xpathExpression) {
			WebElement element = driver.findElement(By.xpath("xpathExpression"));
			return element;
		}

		public List<WebElement> findingElementsLinkText(String linkText) {
			List<WebElement> elements = driver.findElements(By.linkText("linkText"));
			return elements;
		}

		public List<WebElement> findingElementsPlinkText(String partialLinkText) {
			List<WebElement> elements = driver.findElements(By.partialLinkText("partialLinkText"));
			return elements;
		}

		public List<WebElement> findingElementsTagName(String tagName) {
			List<WebElement> elements = driver.findElements(By.tagName("tagName"));
			return elements;
		}

	}


