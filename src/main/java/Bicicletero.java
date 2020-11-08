public class Bicicletero extends Persona{

    public Bicicletero(Integer id, String usuario, String password, String cargo) {
        super(id, usuario, password, cargo);
    }
    @Override
    public String getVista() {
        return "vistaBicicletero.jsp";
    } 
}
