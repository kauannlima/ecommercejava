package dbutil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class DatabaseInitializationServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // Inicializar o banco de dados
        DatabaseInitializer.initializeDatabase();
    }
}
