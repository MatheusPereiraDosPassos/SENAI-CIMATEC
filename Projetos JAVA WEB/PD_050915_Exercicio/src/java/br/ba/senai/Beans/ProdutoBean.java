/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.senai.Beans;


import br.ba.senai.exercicio050915.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Matthew
 */
@ManagedBean(name = "pdBean")
@SessionScoped
public class ProdutoBean {

    private Produto produto;
    private List<Produto> produtos;

    public ProdutoBean() {
        produto = new Produto();
        produtos = new ArrayList<Produto>();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto>  produtos) {
        this.produtos = produtos;
    }

    public void salvar() {
        if(produtos.indexOf(produto)==-1){
            produtos.add(produto);
            produto = new Produto();
        }else{
            produtos.set(produtos.indexOf(produto),produto);
        }
    }

    public void editar(Produto p) {
        produto = p;
    }

    public void excluir(Produto p) {
        produtos.remove(p);
    }
}
