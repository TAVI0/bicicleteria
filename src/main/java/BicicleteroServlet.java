import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BicicleteroServlet extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        
        String serie = request.getParameter("serie");
        
        Modelo m = new Modelo();
        m.addExceptionListener(new BicicleteroServlet.ExceptionListener());
        
        request.setAttribute("serie",serie);
      
        
        request.setAttribute("cuadroSel", m.agregarSelect(serie, "cuadro"));
        request.setAttribute("ruedaSel", m.agregarSelect(serie, "rueda"));
        request.setAttribute("manubrioSel", m.agregarSelect(serie, "manubrio"));
        request.setAttribute("asientoSel", m.agregarSelect(serie, "asiento"));
        request.setAttribute("pedalSel", m.agregarSelect(serie, "pedal"));
        request.setAttribute("kitSel", m.agregarSelect(serie, "kit"));
        
        
        request.setAttribute("nombre", "");
        request.setAttribute("numSerieSel", m.selectSerieDispon());
        
        
        RequestDispatcher v = request.getRequestDispatcher("vistaBicicleteroSeleccion.jsp");
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