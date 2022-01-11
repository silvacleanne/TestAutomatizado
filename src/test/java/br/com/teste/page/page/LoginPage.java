package br.com.teste.page.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{

    //***Região dos WebElements****//

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    //**** Região dos Construtor ****//

    /**
     * Construtor padrão para criação de uma nova instancia da pagina de login.
     *
     * @param driver Driver da página de login.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //**** Região dos Metodo ****//

    /*Metodo que obtem a mensagem disparada na tela*/
    public String obterMensagem(){

        return spanMensagem.getText();
    }
    
    /* Metodo  que tenta executar a ação de logar no sistema */
    public void executarAcaoLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click();
    }

    public String obterTituloPagina(){

        return driver.getTitle();
    }
}
