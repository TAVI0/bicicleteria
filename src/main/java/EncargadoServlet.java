import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncargadoServlet extends HttpServlet {
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        
        String nombre = request.getParameter("nombre");
        String serie = request.getParameter("serie");
        String categoria = request.getParameter("categoria");
        
        Modelo m = new Modelo();
        m.addExceptionListener(new EncargadoServlet.ExceptionListener());
        m.agregarPieza(nombre, serie, categoria);
        
        
        request.setAttribute("nombre", "");
        request.setAttribute("textConfirm", "Se agrego la pieza: ");
        request.setAttribute("textData",nombre);
        RequestDispatcher v = request.getRequestDispatcher("vistaEncargado.jsp");
        v.forward(request, response);       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private class ExceptionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String exception = event.getActionCommand();
            request.setAttribute("mensajeError", exception);
            RequestDispatcher vista = request.getRequestDispatcher("vistaError.jsp");
            try {
                vista.forward(request, response);
            } catch (ServletException ex) {  
            } catch (IOException ex) {       
            }
        }
    }
    
}
