package br.com.teste.page.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para a criação das novas peges.
 * Todas as paginas devem ser herdadas desta classe.
 */
public abstract class BasePage {

    /**Driver base que será usado pelas pages */
    protected WebDriver driver;

    /**
     * Construtor base para criação da fabrica de elementos (PageFactory).
     * @param driver Driver da página atual.
     */
    public BasePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*Metodo que retorna o titulo da pagina atual */
    public String  obterTituloPagina(){
        return driver.getTitle();
    }

    /*Metodo que sabe escrever em qualquer WebElement do tipo input*/
    public  void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

}
