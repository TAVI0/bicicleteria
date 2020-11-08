import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BicicleteroSeleccionServlet extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        
        
        
        Modelo m = new Modelo();
        m.addExceptionListener(new BicicleteroSeleccionServlet.ExceptionListener());
        
        String serie = m.obtenerSerie(request.getParameter("cuadro"));
        m.crearBici(serie);
        
        m.borrarPieza(request.getParameter("cuadro"));
        m.borrarPieza(request.getParameter("rueda"));
        m.borrarPieza(request.getParameter("manubrio"));
        m.borrarPieza(request.getParameter("asiento"));
        m.borrarPieza(request.getParameter("pedal"));
        m.borrarPieza(request.getParameter("kit"));
        
        request.setAttribute("nombre", "");
        request.setAttribute("textConfirm", "Se agrego la bicicleta serie: ");
        request.setAttribute("textData",serie);
        request.setAttribute("numSerieSel", m.selectSerieDispon());
        RequestDispatcher v = request.getRequestDispatcher("vistaBicicletero.jsp");
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