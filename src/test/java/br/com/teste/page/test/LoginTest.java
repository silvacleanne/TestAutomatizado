package br.com.teste.page.test;

import br.com.teste.page.page.LoginPage;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{

    private static LoginPage loginPage;


    @BeforeClass
    public static void  prepararTestes(){

        loginPage = new LoginPage(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){


        /*loginPage.escrever(loginPage.inputEmail, "");
        loginPage.escrever(loginPage.inputSenha, "");

        loginPage.buttonEntrar.click();*/

        loginPage.executarAcaoLogar("","");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailErradoESenhaVazios(){

        /*loginPage.escrever(loginPage.inputEmail, "teste");
        loginPage.escrever(loginPage.inputSenha, "");

        loginPage.buttonEntrar.click();*/

        loginPage.executarAcaoLogar("teste","");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaErrada(){

        /*loginPage.escrever(loginPage.inputEmail, "");
        loginPage.escrever(loginPage.inputSenha, "teste");

        loginPage.buttonEntrar.click();*/

        loginPage.executarAcaoLogar("","teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailESenhaErrado(){

        /*loginPage.escrever(loginPage.inputEmail, "teste");
        loginPage.escrever(loginPage.inputSenha, "teste");

        loginPage.buttonEntrar.click();*/

        loginPage.executarAcaoLogar("teste","teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaErrada(){

        /*loginPage.escrever(loginPage.inputEmail, "admin@admin.com");
        loginPage.escrever(loginPage.inputSenha, "teste");

        loginPage.buttonEntrar.click();*/

        loginPage.executarAcaoLogar("admin@admin.com","teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailErradoESenhaCorreta(){

        /*loginPage.escrever(loginPage.inputEmail, "Aadmin@admin.com");
        loginPage.escrever(loginPage.inputSenha, "admin@123");

        loginPage.buttonEntrar.click();*/

        loginPage.executarAcaoLogar("Aadmin@admin.com","admin@123");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

    @Test
    public void TC007_deveLogarNoSistemaComEmailESenhaCorretos(){

        /*loginPage.escrever(loginPage.inputEmail, "admin@admin.com");
        loginPage.escrever(loginPage.inputSenha, "admin@123");

        loginPage.buttonEntrar.click();*/

        loginPage.executarAcaoLogar("admin@admin.com","admin@123");

        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");

    }
}
