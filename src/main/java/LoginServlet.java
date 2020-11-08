import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;

    private void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        
        Modelo m = new Modelo();
        m.addExceptionListener(new ExceptionListener());
        Persona p = m.obtenerPersona(usuario, contrasena);
        
        
        if (p == null) {
            request.setAttribute("mensajeError", "Usuario/Contraseña inexistente!");
            RequestDispatcher v = request.getRequestDispatcher("vistaError.jsp");
            v.forward(request, response);
        } else {
            request.setAttribute("user", p.getUsuario());
            
            if(p.getCargo().equals("vendedor")){
                request.setAttribute("biciSel", m.agregarSelectBicis());}
            if(p.getCargo().equals("bicicletero")){
                request.setAttribute("numSerieSel", m.selectSerieDispon());}
            
            
            RequestDispatcher v = request.getRequestDispatcher(p.getVista());
            v.forward(request, response);
            
           
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        procesarSolicitud(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        procesarSolicitud(request, response);
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
