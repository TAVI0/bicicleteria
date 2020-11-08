
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo {

    private String urlRoot;
    private ActionListener listener;

    public Modelo() {
        urlRoot = "jdbc:mysql://localhost/";
        listener = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            reportException(e.getMessage());
        }
    }

    public Persona obtenerPersona(String usuario, String password) {
        Persona p = null;
        try {
            Connection con = DriverManager.getConnection(urlRoot + "bicicleteria", "", "");
            Statement stmt = con.createStatement();
            String consulta = "SELECT * FROM usuario WHERE user='" + usuario + "' AND password='" + password + "';";
            stmt.execute(consulta);
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                switch (rs.getString(4)) {
                    case "bicicletero":
                        p = new Bicicletero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                        break;
                    case "vendedor":
                        p = new Vendedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                        break;
                    case "encargado":
                        p = new Encargado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                        break;
                }    
            }
            con.close();
        } catch (SQLException e) {
            reportException(e.getMessage());
        }
        return p;
    }
    
        public void agregarPieza(String nombre, String serie, String categoria) {
        try {
            Connection con = DriverManager.getConnection(urlRoot + "bicicleteria", "", "");
            Statement stmt = con.createStatement();
            String consulta = "INSERT INTO pieza (nombre, serie, categoria) VALUES ('"+nombre+" ','"+serie+"','"+categoria+"');";
            stmt.execute(consulta);
            con.close();
        } catch (SQLException e) {
            reportException(e.getMessage());
        }        
    }
        
        public String agregarSelect(String serie, String categoria) {
            String comando="";
            try {
            Connection con = DriverManager.getConnection(urlRoot + "bicicleteria", "", "");
            Statement stmt = con.createStatement();
            String consulta = "SELECT * FROM pieza WHERE serie='"+serie+"'AND categoria='"+categoria+"';";
            stmt.execute(consulta);
            
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                comando+="<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>";
            }       
            con.close();
        } catch (SQLException e) {
            reportException(e.getMessage());
        }    
            return comando;
    }
        
        public void borrarPieza(String id) {
            try {
            Connection con = DriverManager.getConnection(urlRoot + "bicicleteria", "", "");
            Statement stmt = con.createStatement();
            String consulta = "DELETE FROM pieza WHERE id = "+id+";";
            stmt.execute(consulta);
            
            con.close();
        } catch (SQLException e) {
            reportException(e.getMessage());
        }    
    }
        
        public void crearBici(String serie) {
            try {
            Connection con = DriverManager.getConnection(urlRoot + "bicicleteria", "", "");
            Statement stmt = con.createStatement();
            String consulta = "INSERT INTO bicicleta (serie) VALUES ("+serie+");";
            stmt.execute(consulta);
            
            con.close();
        } catch (SQLException e) {
            reportException(e.getMessage());
        }           
    }
        
        public void borrarBici(String id) {
            try {
            Connection con = DriverManager.getConnection(urlRoot + "bicicleteria", "", "");
            Statement stmt = con.createStatement();
            String consulta = "DELETE FROM bicicleta WHERE id = "+id+";";
            stmt.execute(consulta);
            
            con.close();
        } catch (SQLException e) {
            reportException(e.getMessage());
        }    
    }
    
        public String agregarSelectBicis() {
            String comando="";
            try {
            Connection con = DriverManager.getConnection(urlRoot + "bicicleteria", "", "");
            Statement stmt = con.createStatement();
            String consulta = "SELECT * FROM bicicleta;";
            stmt.execute(consulta);
            
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                comando+="<option value='"+rs.getString(1)+"'> id "+ rs.getString(1) + " bici "+rs.getString(2)+"</option>";
            }       
            con.close();
        } catch (SQLException e) {
            reportException(e.getMessage());
        }    
            return comando;
    }
        
        
        public String obtenerSerie(String id) {
            String comando="";
            try {
            Connection con = DriverManager.getConnection(urlRoot + "bicicleteria", "", "");
            Statement stmt = con.createStatement();
            String consulta = "SELECT serie FROM pieza WHERE id="+id+";";
            stmt.execute(consulta);
            
            ResultSet rs = stmt.getResultSet();
            rs.next();
            comando= rs.getString(1);
            
            con.close();
        } catch (SQLException e) {
            reportException(e.getMessage());
        }    
            return comando;
    }
        
        public String selectSerieDispon() {
            String comando="";
            try {
            Connection con = DriverManager.getConnection(urlRoot + "bicicleteria", "", "");
            Statement stmt = con.createStatement();
            String consulta = "SELECT serie FROM pieza GROUP BY serie ;";
            stmt.execute(consulta);
            
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                comando+="<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";
            }       
            con.close();
        } catch (SQLException e) {
            reportException(e.getMessage());
        }    
            return comando;
    }

    private void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }

    public void addExceptionListener(ActionListener listener) {
        this.listener = listener;
    }

}
