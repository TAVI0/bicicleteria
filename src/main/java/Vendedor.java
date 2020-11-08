public class Vendedor extends Persona {

    public Vendedor(Integer id, String usuario, String password, String cargo) {
        super(id, usuario, password, cargo);
    }
    @Override
    public String getVista() {
        return "vistaVendedor.jsp";
    }
}
