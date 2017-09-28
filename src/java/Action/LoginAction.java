package Action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import percistence.UsuarioDAO;

public class LoginAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");        
        String senha = request.getParameter("senha");
        if (email.equals("") || senha.equals("")) {
            response.sendRedirect("login_fail.jsp");
        } else {
            Usuario usuario = null;
            usuario = UsuarioDAO.getInstance().Login(email,senha);
            if(usuario == null) {
                response.sendRedirect("login_falha.html");
            }
            else {
                response.sendRedirect("index.jsp");
            }
        }
    }

}