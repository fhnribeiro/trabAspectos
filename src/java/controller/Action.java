package controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Teste

public interface Action {
    public void execute ( HttpServletRequest request, HttpServletResponse response ) throws IOException;
}
