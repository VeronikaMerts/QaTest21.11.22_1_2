import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver wd;


    @BeforeTest
    public void prepare() throws InterruptedException {
        wd = new ChromeDriver();
        wd.get("https://derrick686.softr.app/login");
        wd.manage().window().maximize();
        Thread.sleep(2000);
    }

    public void jumpDown() {
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void jumpUp() {
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    public void logOut() throws InterruptedException {
    jumpUp();
    WebElement bhElement = wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[5]/a"));
    bhElement.click();
    WebElement signOut = wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[5]/div/a/span/span"));
    signOut.click();
    Thread.sleep(2000);
    }

    public void wrongAuth() throws InterruptedException {
        WebElement wrongEmail = wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[3]/input"));
        wrongEmail.click();
        wrongEmail.clear();
        wrongEmail.sendKeys("billyeexample.com");
        Thread.sleep(2000);

        WebElement wrongPassword = wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[4]/div/input"));
        wrongPassword.click();
        wrongPassword.clear();
        wrongPassword.sendKeys("123");

        jumpDown();
        WebElement submitForm = wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[5]/a[1]"));

        submitForm.click();
        String text = "Invalid email or password";
        Assert.assertEquals(wd.getPageSource().contains(text), Boolean.TRUE);

    }

    public void validAuth() throws InterruptedException {
        WebElement validEmail = wd.findElement(By.id("sw-form-capture-email-input"));
        validEmail.click();
        validEmail.clear();

        validEmail.sendKeys("billye@example.com");
        Thread.sleep(2000);
        jumpDown();
        WebElement validPassword = wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[4]/div/input"));

        validPassword.click();
        validPassword.clear();
        validPassword.sendKeys("123456");
        Thread.sleep(2000);
        jumpDown();

        WebElement submitForm = wd.findElement(By.id("sw-sign-in-submit-btn"));
        submitForm.click();
        Thread.sleep(2000);
        WebElement clienstLink = wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[2]/a"));

        String text = "Invalid email or password";
        Assert.assertEquals(wd.getPageSource().contains(text), Boolean.FALSE);
    }

    public void checkLink() throws InterruptedException {
        wd.manage().window().maximize();
        jumpUp();
        WebElement clienstLink = wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[2]/a"));
        Thread.sleep(3000);
    }

    public void searchLine() throws InterruptedException {
        validData();
        wd.manage().window().maximize();
        jumpUp();
        WebElement clienstLink = wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[2]/a"));
        clienstLink.click();
        Thread.sleep(2000);
        WebElement search = wd.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div/div/input"));
        Thread.sleep(2000);

        search.click();
        search.sendKeys("Amazon");
        String text = "No results found, try adjusting your search and filters.";
        Thread.sleep(5000);
        Assert.assertEquals(wd.getPageSource().contains(text), Boolean.TRUE);

        search.click();
        search.clear();
        search.sendKeys("montag");
        String billye = "billye";
        String edra = "edra";
        Thread.sleep(5000);
        Assert.assertEquals(wd.getPageSource().contains(billye), Boolean.TRUE);
        Assert.assertEquals(wd.getPageSource().contains(edra), Boolean.TRUE);

        searchOneClient();
        nameLoree();
        nameLucie();
        logOut();
    }

    public void searchUnknownComp() throws InterruptedException {
        WebElement search = wd.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div/div/input"));
        Thread.sleep(2000);
        search.click();
        search.sendKeys("Amazon");
        String text = "No results found, try adjusting your search and filters.";
        Thread.sleep(5000);
        Assert.assertEquals(wd.getPageSource().contains(text), Boolean.TRUE);

    }

    public void searchTwoClients() throws InterruptedException {
        WebElement search = wd.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div/div/input"));
        Thread.sleep(2000);
        search.click();
        search.sendKeys("montag");
        String billye = "billye";
        String edra = "edra";
        Thread.sleep(5000);
        Assert.assertEquals(wd.getPageSource().contains(billye), Boolean.TRUE);
        Assert.assertEquals(wd.getPageSource().contains(edra), Boolean.TRUE);

    }

    public void searchOneClient() throws InterruptedException {
        WebElement search = wd.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div/div/input"));
        Thread.sleep(2000);
        search.click();
        search.clear();
        search.sendKeys("worman");
        Thread.sleep(2000);
        String worman = "worman";
        Thread.sleep(2000);
        Assert.assertEquals(wd.getPageSource().contains(worman), Boolean.TRUE);
    }

    public void nameLoree() throws InterruptedException {
        WebElement search = wd.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div/div/input"));
        Thread.sleep(2000);
        search.click();
        search.clear();
        search.sendKeys("Loree");
        Thread.sleep(2000);
        String loree = "Loree";
        Thread.sleep(2000);
        Assert.assertEquals(wd.getPageSource().contains(loree), Boolean.TRUE);
    }

    public void nameLucie() throws InterruptedException {
        WebElement search = wd.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div/div/input"));
        Thread.sleep(2000);
        search.click();
        search.clear();
        search.sendKeys("Lucie");
        Thread.sleep(2000);
        String lucie = "Lucie";
        Thread.sleep(2000);
        Assert.assertEquals(wd.getPageSource().contains(lucie), Boolean.TRUE);
    }

    public void validData() throws InterruptedException {
        validAuth(); //тест с правильными данными
    }
}