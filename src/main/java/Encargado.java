public class Encargado extends Persona {

    public Encargado(int id, String usuario, String password, String cargo) {
        super(id, usuario, password, cargo);
    }
    
    
    @Override
    public String getVista() {
        return "vistaEncargado.jsp";
    }  
}