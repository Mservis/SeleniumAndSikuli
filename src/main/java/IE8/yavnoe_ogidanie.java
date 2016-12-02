package IE8;

//import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import  static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class yavnoe_ogidanie {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new InternetExplorerDriver();
        String baseUrl;
        //baseUrl = "http://tender.sk.kz/";
      //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void IE8_sozdat_cenovoe() throws Exception {
        driver.manage().window().maximize();
        // driver.navigate().to("https://tender.sk.kz");
        driver.navigate().to("https://tender.sk.kz/OA_HTML/AppsLocalLogin.jsp");
        // Thread.sleep(3000);
        //**********************************

        Pattern ok2 = new Pattern("c:\\forsikuli\\ie8\\ok.png");
        Pattern inputPass = new Pattern("c:\\forsikuli\\ie8\\pass.png");
        Pattern ok3 = new Pattern("c:\\forsikuli\\ie8\\ok2.png");
        Pattern gotovotpravit = new Pattern("c:\\forsikuli\\gotovotpravit.png");
        Pattern podpisat = new Pattern("c:\\forsikuli\\ie8\\podpisat.png");
        Pattern input2 = new Pattern("c:\\forsikuli\\input2.png");
        Pattern ok4 = new Pattern("c:\\forsikuli\\ie8\\ok3.png");
        Pattern otpravit = new Pattern("c:\\forsikuli\\otpravit.png");
        Pattern otpravil = new Pattern("c:\\forsikuli\\ie8\\otpravil.png");
        Pattern pwdOk = new Pattern("c:\\forsikuli\\ie8\\pwdOk.png");

        WebDriverWait wait = new WebDriverWait(driver, 30000);
        WebElement element = wait.until(presenceOfElementLocated(By.id("passwordField")));
        element.sendKeys("123456");
        //driver.findElement(By.id("passwordField")).sendKeys("123456");
        driver.findElement(By.id("SubmitButton")).click();
        //for (int ip = 0; ip <100; ip++) {

        //*********************************


            // metka
                element = wait.until(presenceOfElementLocated(By.xpath("//a[contains(text(),'1099408')]")));
                baseUrl = driver.getCurrentUrl();
                element.click();
                element = wait.until(presenceOfElementLocated(By.linkText("Строки")));
                element.click();
                while (!isElementPresent(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[2]/td[4]/span"))) {
                    if (isElementPresent(By.cssSelector("h1.x5r"))) {
                        driver.get(baseUrl);
                       // break metka;
                    }

                }

            String myrez0 = driver.findElement(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[2]/td[4]/span")).getText();
            // element = wait.until(presenceOfElementLocated(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[2]/td[4]/span")));
            //  String myrez0 = element.getText();

            System.out.println(myrez0);
            element = wait.until(presenceOfElementLocated(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[3]/td[4]/span")));
            String myrez1 = element.getText();
            System.out.println(myrez1);
            String str0 = "";
            int i = 0;
            for (i = 0; myrez0.charAt(i) != '.'; i++) {
                if (myrez0.charAt(i) != ',') {
                    str0 += myrez0.charAt(i);
                }
            }
            String str1 = "";
            for (i = 0; i < myrez1.length(); i++) {
                if (myrez1.charAt(i) != ',') {
                    str1 += myrez1.charAt(i);
                }
            }
            Double dbl0 = new Double(str0);
            Double dbl1 = new Double(str1);
            Random myRandom = new Random();
            int n = myRandom.nextInt(49);

            System.out.println("" + n);

            Double dbl00 = new Double(n);
            System.out.println("" + dbl00);
            int int0 = (int) (dbl0 * (0.95 + (dbl00 / 1000)));
            int int1 = (int) (dbl1 * (0.95 + (dbl00 / 1000)));
            // System.out.println(dbl0);
            //System.out.println(dbl1);
            //заполняет первое поле
            element = wait.until(presenceOfElementLocated(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[2]/td[5]/input")));
            element.click();
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys("" + int0);
            //h1.x5r
            //By.cssSelector("h1.x5r")

            element = wait.until(presenceOfElementLocated(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[3]/td[5]/input")));
            element.click();//поле ввода 2
            //проверяет перщиталось или нет
            element = wait.until(presenceOfElementLocated(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[2]/td[7]/span")));
            str0 = element.getText();// количесво 1
            int kolichestvo = Integer.parseInt(str0);
            int povtor = 0;
            do {
                do {
                    Thread.sleep(500);
                    element = wait.until(presenceOfElementLocated(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[2]/td[8]/span")));
                    str0 = element.getText();//общая цена 2
                    str1 = ("str" + str0);
                   }  while (str1 == "str");
                System.out.println("Строка1   " + str0);
                System.out.println("Повтор1   " + povtor);
                povtor++;
            }
            while (int0 != (Integer.parseInt(str0) / kolichestvo));
            System.out.println("Общая цена 1   " + int0);
            System.out.println("Количество 1   " + kolichestvo);
            System.out.println("Цена за шт 1    " + (Integer.parseInt(str0) / kolichestvo));
            // закончил проверку
            //заполняет второе поле
            element = wait.until(presenceOfElementLocated(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[3]/td[5]/input")));
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys("" + int1);
            element.sendKeys(Keys.TAB);

            //проверяет пресчет 2 поля
            element = wait.until(presenceOfElementLocated(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[3]/td[7]/span")));
            str0 = element.getText();// количесво 2
            kolichestvo = Integer.parseInt(str0);
            povtor = 0;
            do {

                do {
                    Thread.sleep(500);
                    element = wait.until(presenceOfElementLocated(By.xpath("//span[@id='BidItemPricesTableVO']/table[2]/tbody/tr[3]/td[8]/span")));
                    str0 = element.getText();//общая цена 2
                     str1 = ("str" + str0);
                   } while (str1 == "str");
                System.out.println("Строка2   " + str0);
                System.out.println("Повтор2   " + povtor);
                povtor++;
            }
            while (int1 != (Integer.parseInt(str0) / kolichestvo));
            System.out.println("Общая цена 2   " + int1);
            System.out.println("Количество 2   " + kolichestvo);
            System.out.println("Цена за шт 2    " + (Integer.parseInt(str0) / kolichestvo));
            element = wait.until(presenceOfElementLocated(By.xpath("//div[6]/div/table/tbody/tr/td[2]/table/tbody/tr/td[10]/button")));
            element.click();//нажать продолжить

            element = wait.until(presenceOfElementLocated(By.xpath("//div[6]/div/table/tbody/tr/td[2]/table/tbody/tr/td[10]/button")));
            element.click();// создать ценовое
            element = wait.until(presenceOfElementLocated(By.xpath("//a[@id='FileListRNEx:SignItem:1']/img")));
            element.click();// подписать
        Region okwindow = new Region(754,485,115,73);
        okwindow.setRect(754,485,115,73);
        okwindow.wait(ok2, 10000);
        okwindow.click(ok2);
        //окно джава просит пароль
        okwindow.setRect(618,433,271,82);
        okwindow.wait(inputPass,20000);
        okwindow.paste(inputPass,"123456");
        okwindow.click(ok3);
        //подписать
        okwindow.setRect(123,628,90,32);
        okwindow.wait(podpisat, 10000);
        okwindow.click(podpisat);
        okwindow.setRect(597,433,245,54);
        okwindow.wait(input2, 10000);
        povtor = 1;
        do {
            okwindow.paste(input2, "123456");
            System.out.println("Ввод пароля   " + povtor);
            povtor++;
        }while (okwindow.exists(pwdOk, 1) == null);
        okwindow.click(ok4);
        okwindow.setRect(31,625,97,40);
        okwindow.wait(gotovotpravit, 10000);
        okwindow.setRect(217,625,84,38);
        okwindow.click(otpravit);
        okwindow.setRect(31,625,97,40);
        okwindow.wait(gotovotpravit, 10000);

        //Thread.sleep(3000);//удалить заявку
        /*element = wait.until(presenceOfElementLocated(By.xpath("//a[@id='FileListRNEx:DeleteItem:1']/img"))); //удалить заявку
        element.click();
        Region okwin = new Region(749,479,100,49);
        okwin.click(ok2);//jjj*/



            //driver.get(baseUrl);
        //}

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {

            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    private void zaitivzayavku()
    {

    }
    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
