package br.com.teste.page.buider;

import br.com.teste.page.page.ControleDeProdutoPage;
import org.openqa.selenium.WebDriver;

/*Classe que sabe construir ou adicionar um produto na tela*/
public class ProdutoBuilder {

    private String codigo  = "00001";
    private String nome =  "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "30/12/2021";

    private ControleDeProdutoPage controleDeProdutoPage;

    /*Construtor do Produtobuilder que recebe a pagina de controle de produtos*/
    public ProdutoBuilder (ControleDeProdutoPage controleDeProdutoPage){
        this.controleDeProdutoPage = controleDeProdutoPage;
    }

    /*Metodo que sabe adicionar um código ao builder*/
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /*Metodo que constroi o produto, ou seja, adiciona o produto pela tela de cadastro de produto*/
    public void build(){
        controleDeProdutoPage.escrever(controleDeProdutoPage.inputCodigo, codigo);
        controleDeProdutoPage.escrever(controleDeProdutoPage.inputNome, nome);
        controleDeProdutoPage.escrever(controleDeProdutoPage.inputQuantidade, quantidade.toString());
        controleDeProdutoPage.escrever(controleDeProdutoPage.inputValor, valor.toString());
        controleDeProdutoPage.escrever(controleDeProdutoPage.inputData, data);

        controleDeProdutoPage.buttonSalvar.click();
    }
}
