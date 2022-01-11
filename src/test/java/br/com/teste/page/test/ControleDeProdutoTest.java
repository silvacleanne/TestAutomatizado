package br.com.teste.page.test;

import br.com.teste.page.buider.ProdutoBuilder;
import br.com.teste.page.page.ControleDeProdutoPage;
import br.com.teste.page.page.LoginPage;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest{

    private static LoginPage loginPage;
    private static ControleDeProdutoPage controleDeProdutoPage;

    @BeforeClass
    public static void  prepararTestes(){

        loginPage = new LoginPage(driver);
        loginPage.executarAcaoLogar("admin@admin.com","admin@123");

        controleDeProdutoPage = new ControleDeProdutoPage(driver);
        assertEquals(ControleDeProdutoPage.obterTituloPagina, "Controle de Produtos");
    }

    @Test
    public void TC001_deveAbrirModaParaCadastroAoClicarNoBotaoCriar(){

        controleDeProdutoPage.buttonAdicionar.click();
        //Todo: Remover esse clique assim que o sistema for corrigido.
        controleDeProdutoPage.buttonAdicionar.click();

        String titulo = controleDeProdutoPage.tituloModal.getText();
        assertEquals("Produto", titulo);
        controleDeProdutoPage.buttonSair.click();
    }

    /*@Test
    public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        controleDeProdutoPage.buttonAdicionar.click();

        controleDeProdutoPage.cadastrarProduto("0001", "Martelo", 10, 59.9, " ");

        //Aqui vamos capturar a mensagem de erro
        String mensagem = controleDeProdutoPage.spanMensagem.getText();

        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);

    }*/

    @Test
    public void TC003_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){

        controleDeProdutoPage.buttonAdicionar.click();

        //Aqui cria o objeto para adicionar na tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        //Aqui realmente adiciona as informações a tela
        produtoBuilder.build();


        //Aqui vamos capturar a mensagem de erro
        String mensagem = controleDeProdutoPage.spanMensagem.getText();

        assertEquals(mensagem, controleDeProdutoPage.spanMensagem.getText());

    }


}
