package br.com.teste.page.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Classe base que serve de herança para todas as classes de teste
* */
public class BaseTest {

    /*Driver do navegador da pagina atual* */
    protected static WebDriver driver;
    /*Caminho  base URL do sistema a ser testado*/
    private  static final String URL_BASE = "file:///C:/Users/Cleanne/Downloads/controle-de-produtos%20(1)/sistema/login.html";
    /*Caminho relativo do driver ao projeto referente ao path*/
    private static final String CAMINHO_DRIVER = "src/test/resources/chromedriver.exe";

    /*Metodo para iniciar o driver do navegador antes de qualquer classe de teste*/
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /*Metodo para finalizar o driver do navegador depois de qualquer classe de teste*/
    @AfterClass
    public static void finalizar(){
        driver.quit();
    }

}
