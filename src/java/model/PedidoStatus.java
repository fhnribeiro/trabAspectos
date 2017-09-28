package model;

public interface PedidoStatus {
    
    public String getStatus();
    
    public int getStatusID();
    
    public void Recebido();
    
    public void EmPreparacao();
    
    public void SaiuEntrega();
    
    public void Cancelado();
}
