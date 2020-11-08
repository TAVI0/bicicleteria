public abstract class Persona {

    private int id;
    private String usuario;
    private String password;
    private String cargo;
    
    public Persona(int id,String usuario, String password,String cargo) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.cargo = cargo;
    }
  
    
    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getCargo() {
        return cargo;
    }

    
    public abstract String getVista();
    
}
