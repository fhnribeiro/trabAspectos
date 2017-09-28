package model;

public class PedidoSaiuEntrega implements PedidoStatus{

    @Override
    public String getStatus() {
        return "Saiu para entrega";
    }

    @Override
    public void Recebido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // MUDAR ESTADO DO PEDIDO
        // return "Pedido finalizado com sucesso.";
    }

    @Override
    public void EmPreparacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // return "Pedido não pode voltar para preparação após ter saído para entrega.";
    }

    @Override
    public void SaiuEntrega() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return "O pedido já se encontra saindo para entrega."
    }

    @Override
    public void Cancelado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // return "Não é possível cancelar um pedido que já saiu para entrega."
    }

    @Override
    public int getStatusID() {
        return 3;
    }
    
}
