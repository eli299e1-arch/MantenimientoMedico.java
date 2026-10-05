import java.sql.*;
import javax.swing.table.*;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

public class Paciente extends Persona
{
   private String provincia, sexo, sql, error;
   private int edad;
   private BD bd;

   Paciente()
   {
      super();
      provincia = "";
      sexo = "";
      edad = 0;
      error = "";
      bd = new BD();
   }

   public void setProvincia(String p)
   {
      provincia = p;
   }
   public String getProvincia()
   {
      return provincia;
   }

   public void setEdad(int e)
   {
      edad = e;
   }
   public int getEdad()
   {
      return edad;
   }

   public void setSexo(String s)
   {
      sexo = s;
   }
   public String getSexo()
   {
      return sexo;
   }

   public String getError()
   {
      return error;
   }

   private String prepararTexto(String texto)
   {
      return texto.replace("'","''");
   }

   public boolean buscar()
   {
      boolean existe = false;
      error = "";
      sql = "select * from paciente where cedula = '" + prepararTexto(cedula) + "'";

      try
      {
         ResultSet rs = bd.executeQuery(sql);
         if (rs != null && rs.next())
         {
            id = rs.getInt("id");
            cedula = rs.getString("cedula");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            direccion = rs.getString("direccion");
            telefono = rs.getString("telefono");
            provincia = rs.getString("provincia");
            edad = rs.getInt("edad");
            sexo = rs.getString("sexo");
            existe = true;
         }
         else
         {
            nombre = "";
            apellido = "";
            direccion = "";
            telefono = "";
            provincia = "";
            edad = 0;
            sexo = "";
         }
         error = bd.getUltimoError();
         bd.cerrar();
      }
      catch(Exception e)
      {
         error = e.toString();
         System.out.println("Paciente buscar error " + error);
      }
      return existe;
   }

   public boolean agregar()
   {
      error = "";
      sql = "insert into paciente(cedula,nombre,apellido,direccion,telefono,provincia,edad,sexo) values('" +
            prepararTexto(cedula) + "','" + prepararTexto(nombre) + "','" + prepararTexto(apellido) + "','" +
            prepararTexto(direccion) + "','" + prepararTexto(telefono) + "','" + prepararTexto(provincia) + "'," +
            edad + ",'" + prepararTexto(sexo) + "')";

      int filas = bd.executeUpdate(sql);
      error = bd.getUltimoError();
      return filas > 0;
   }

   public boolean modificar()
   {
      error = "";
      sql = "update paciente set nombre='" + prepararTexto(nombre) + "', apellido='" + prepararTexto(apellido) +
            "', direccion='" + prepararTexto(direccion) + "', telefono='" + prepararTexto(telefono) +
            "', provincia='" + prepararTexto(provincia) + "', edad=" + edad + ", sexo='" +
            prepararTexto(sexo) + "' where cedula='" + prepararTexto(cedula) + "'";

      int filas = bd.executeUpdate(sql);
      error = bd.getUltimoError();
      return filas > 0;
   }

   public boolean eliminar()
   {
      error = "";
      sql = "delete from paciente where cedula='" + prepararTexto(cedula) + "'";
      int filas = bd.executeUpdate(sql);
      error = bd.getUltimoError();
      return filas > 0;
   }

   public void listar(DefaultTableModel dtm_paciente)
   {
      error = "";
      dtm_paciente.setColumnCount(0);
      dtm_paciente.setRowCount(0);
      dtm_paciente.addColumn("Cedula");
      dtm_paciente.addColumn("Nombre");
      dtm_paciente.addColumn("Apellido");
      dtm_paciente.addColumn("Telefono");
      dtm_paciente.addColumn("Provincia");

      Object[] fila = new Object[5];
      sql = "select * from paciente order by apellido";

      try
      {
         ResultSet rs = bd.executeQuery(sql);
         while (rs != null && rs.next())
         {
            fila[0] = rs.getString("cedula");
            fila[1] = rs.getString("nombre");
            fila[2] = rs.getString("apellido");
            fila[3] = rs.getString("telefono");
            fila[4] = rs.getString("provincia");
            dtm_paciente.addRow(fila);
         }
         error = bd.getUltimoError();
         bd.cerrar();
      }
      catch(Exception e)
      {
         error = e.toString();
         System.out.println("Paciente listar error " + error);
      }
   }

   public void reporte(String orden, String titulo)
   {
      error = "";
      try
      {
         if (!bd.abrir())
         {
            error = bd.getUltimoError();
            return;
         }

         Map<String,Object> parametro = new HashMap<String,Object>();
         parametro.put("orden",orden);
         parametro.put("titulo",titulo);

         JasperPrint jasperPrint = JasperFillManager.fillReport("Gutierrez757_Paciente.jasper",parametro,bd.getCon());
         JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
         jasperViewer.setVisible(true);
         JasperExportManager.exportReportToPdfFile(jasperPrint,"Reporte_Pacientes_Gutierrez757.pdf");
         bd.cerrar();
      }
      catch(Exception e)
      {
         error = e.toString();
         System.out.println("Paciente reporte error " + error);
         bd.cerrar();
      }
   }
}
