package app;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import packUtils.Menu;

public class UD3Ejer1701 { 
    public static void main(String[] args)  { 

        try {
            MenuOpciones.conectarOracle();
            
            Menu.Mostrar();
            
            MenuOpciones.desconectarOracle();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UD3Ejer1701.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UD3Ejer1701.class.getName()).log(Level.SEVERE, null, ex);
        }
      
  }
      
}

