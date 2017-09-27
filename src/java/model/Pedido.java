/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Fábio
 */
public class Pedido {
    protected int id;
    protected Date date;
    protected Date ultimaAlteracao;
    protected int status;//1 - Pedido, 2 - Em preparacao,3 - Saiu pra entrega, 0 - Cancelado
    protected Usuario usuario;
    protected List<Produto> produtos;

    public Pedido(int id, Date date, Date ultimaAlteracao, int status, Usuario usuario, List<Produto> produtos) {
        this.id = id;
        this.date = date;
        this.ultimaAlteracao = ultimaAlteracao;
        this.status = status;
        this.usuario = usuario;
        this.produtos = produtos;
    }

    public Pedido(int id, Usuario usuario, List<Produto> produtos) {
        this.id = id;
        this.usuario = usuario;
        this.produtos = produtos;
        date=new Date();
        ultimaAlteracao=new Date();
        status=1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        this.ultimaAlteracao=new Date();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
