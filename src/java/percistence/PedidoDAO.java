package percistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import model.Produto;
import model.Usuario;


public class PedidoDAO {
    private static PedidoDAO instance = new PedidoDAO();
    
    private PedidoDAO(){}
    
    public static PedidoDAO getInstance(){
        return instance;
    }
    
    public void Save(Pedido pedido) throws SQLException{
        
        Connection conn = null;
        PreparedStatement  stmt = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            
            stmt = conn.prepareStatement("INSERT INTO pedido (idUsuario,status) values (?, 1)",Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, Integer.toString(pedido.getUsuario().getId()));
            int idPedido = stmt.executeUpdate();
            pedido.setId(idPedido);
            
            ArrayList<Produto> produtos = (ArrayList<Produto>) pedido.getProdutos();
            
            for (Produto temp : produtos) {
                stmt = conn.prepareStatement("INSERT INTO produtosPedido (idPedido,idProduto,quantidade) values (?, ?, 1)");
                stmt.setString(1, Integer.toString(pedido.getId()));
                stmt.setString(2, Integer.toString(temp.getId())); 
                stmt.executeUpdate();
            }
            
        } catch(SQLException e) {
            
            throw e;
            
        } finally {
            
            closeResources(conn, stmt);
            
        }

    }
    
    public void Edit(Pedido pedido) throws SQLException{
        
        Connection conn = null;
        PreparedStatement  stmt = null;
        
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            
            stmt = conn.prepareStatement("UPDATE pedido (idUsuario,status) values (?, ?) WHERE idPedido=?",Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, Integer.toString(pedido.getUsuario().getId()));
            stmt.setString(1, Integer.toString(pedido.getStatus()));
            stmt.setString(1, Integer.toString(pedido.getId()));
            
            
            ArrayList<Produto> produtos = (ArrayList<Produto>) pedido.getProdutos();
            
            for (Produto prod : produtos) {
                stmt = conn.prepareStatement("INSERT INTO produtosPedido (idPedido,idProduto,quantidade) values (?, ?, 1) ON DUPLICATE KEY UPDATE quantidade=1");
                stmt.setString(1, Integer.toString(pedido.getId()));
                stmt.setString(2, Integer.toString(prod.getId())); 
                stmt.executeUpdate();
            }
            
        } catch(SQLException e) {
            
            throw e;
            
        } finally {
            
            closeResources(conn, stmt);
            
        }

    }
    
    public void closeResources(Connection conn, Statement st){
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();

        } catch(SQLException e) {

        }
    }
    
}
