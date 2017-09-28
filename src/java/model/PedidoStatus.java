/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fábio
 */
public interface PedidoStatus {
    
    public String getStatus();
    
    public int getStatusID();
    
    public void Recebido();
    
    public void EmPreparacao();
    
    public void SaiuEntrega();
    
    public void Cancelado();
}
