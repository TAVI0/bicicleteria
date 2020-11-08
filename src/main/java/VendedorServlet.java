import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendedorServlet extends HttpServlet {

     
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        
        String bici =request.getParameter("bici");
        
        Modelo m = new Modelo();
        m.addExceptionListener(new VendedorServlet.ExceptionListener());
        
        request.setAttribute("biciSel", m.agregarSelectBicis());
        m.borrarBici(request.getParameter("bici"));
        
        request.setAttribute("textConfirm", "Se vendio la bicicleta con id: ");
        request.setAttribute("textData",bici);
        request.setAttribute("nombre", "");
        request.setAttribute("biciSel", m.agregarSelectBicis());
        RequestDispatcher v = request.getRequestDispatcher("vistaVendedor.jsp");
        
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
