import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;

public class NewSelenium extends TestBase {


    @Test
    public void wrongData() throws InterruptedException {
        wrongAuth();//мы вынесли тест в отдельный метод, и вызываем его здесь,
        // чтобы укоротить код теста. В данном случае тест с неправильными данными

    }

    @Test
    public void validData() throws InterruptedException {
        validAuth();//тест с правильными данными
        logOut();
    }

    @Test
    public void validAuthAfterNotValid() throws InterruptedException {
        //проверка ввода валидных данных после неправильных
        wrongData();
        validData();
        checkLink();
    }

    @Test //выполняется полный тест с валидной авторизацией, откр раздел клиенты,
    // поиск по строке несуществующей компании Амазон,поиск по имени, и тд
    public void searchInLine() throws InterruptedException {
        searchLine();
    }


    @AfterTest
    public void afterTest() {
        wd.close();
        wd.quit();
    }


}

