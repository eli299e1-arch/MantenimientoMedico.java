import java.sql.*;

public class BD
{
   private String URL, usuario, clave;
   private Connection con;
   private Statement stmt;
   private ResultSet rs;
   private String ultimo_error;

   BD()
   {
      URL = "jdbc:mysql://127.0.0.1:3306/hospital_gutierrez757?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
      usuario = "root";
      clave = "";
      ultimo_error = "";
   }

   public boolean abrir()
   {
      try
      {
         ultimo_error = "";
         con = DriverManager.getConnection(URL,usuario,clave);
         stmt = con.createStatement();
         return true;
      }
      catch(Exception e)
      {
         ultimo_error = e.toString();
         System.out.println("BD abrir error " + ultimo_error);
         return false;
      }
   }

   public ResultSet executeQuery(String sql)
   {
      try
      {
         ultimo_error = "";
         if (abrir())
            rs = stmt.executeQuery(sql);
      }
      catch(Exception e)
      {
         ultimo_error = e.toString();
         System.out.println("BD executeQuery error " + ultimo_error);
      }
      return rs;
   }

   public int executeUpdate(String sql)
   {
      int filas = 0;
      try
      {
         ultimo_error = "";
         if (abrir())
         {
            filas = stmt.executeUpdate(sql);
            cerrar();
         }
      }
      catch(Exception e)
      {
         ultimo_error = e.toString();
         System.out.println("BD executeUpdate error " + ultimo_error);
      }
      return filas;
   }

   public void cerrar()
   {
      try
      {
         if (rs != null)
            rs.close();
         if (stmt != null)
            stmt.close();
         if (con != null)
            con.close();
         rs = null;
         stmt = null;
         con = null;
      }
      catch(Exception e)
      {
         ultimo_error = e.toString();
         System.out.println("BD cerrar error " + ultimo_error);
      }
   }

   public Connection getCon()
   {
      return con;
   }

   public String getUltimoError()
   {
      return ultimo_error;
   }
}
