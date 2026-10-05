import java.sql.*;
import javax.swing.table.*;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

public class Medico extends Persona
{
   private String codigo, especialidad, sql, error;
   private int pacientes_mes, pacientes_anual;
   private BD bd;

   Medico()
   {
      super();
      codigo = "";
      especialidad = "";
      pacientes_mes = 0;
      pacientes_anual = 0;
      error = "";
      bd = new BD();
   }

   public void setCodigo(String c)
   {
      codigo = c;
   }
   public String getCodigo()
   {
      return codigo;
   }

   public void setEspecialidad(String e)
   {
      especialidad = e;
   }
   public String getEspecialidad()
   {
      return especialidad;
   }

   public void setPacientesMes(int p)
   {
      pacientes_mes = p;
   }
   public int getPacientesMes()
   {
      return pacientes_mes;
   }

   public void setPacientesAnual(int p)
   {
      pacientes_anual = p;
   }
   public int getPacientesAnual()
   {
      return pacientes_anual;
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
      sql = "select * from medico where codigo = '" + prepararTexto(codigo) + "'";

      try
      {
         ResultSet rs = bd.executeQuery(sql);
         if (rs != null && rs.next())
         {
            id = rs.getInt("id");
            codigo = rs.getString("codigo");
            cedula = rs.getString("cedula");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            direccion = rs.getString("direccion");
            telefono = rs.getString("telefono");
            especialidad = rs.getString("especialidad");
            pacientes_mes = rs.getInt("pacientes_mes");
            pacientes_anual = rs.getInt("pacientes_anual");
            existe = true;
         }
         else
         {
            cedula = "";
            nombre = "";
            apellido = "";
            direccion = "";
            telefono = "";
            especialidad = "";
            pacientes_mes = 0;
            pacientes_anual = 0;
         }
         error = bd.getUltimoError();
         bd.cerrar();
      }
      catch(Exception e)
      {
         error = e.toString();
         System.out.println("Medico buscar error " + error);
      }
      return existe;
   }

   public boolean agregar()
   {
      error = "";
      sql = "insert into medico(codigo,cedula,nombre,apellido,direccion,telefono,especialidad,pacientes_mes,pacientes_anual) values('" +
            prepararTexto(codigo) + "','" + prepararTexto(cedula) + "','" + prepararTexto(nombre) + "','" +
            prepararTexto(apellido) + "','" + prepararTexto(direccion) + "','" + prepararTexto(telefono) + "','" +
            prepararTexto(especialidad) + "'," + pacientes_mes + "," + pacientes_anual + ")";

      int filas = bd.executeUpdate(sql);
      error = bd.getUltimoError();
      return filas > 0;
   }

   public boolean modificar()
   {
      error = "";
      sql = "update medico set cedula='" + prepararTexto(cedula) + "', nombre='" + prepararTexto(nombre) +
            "', apellido='" + prepararTexto(apellido) + "', direccion='" + prepararTexto(direccion) +
            "', telefono='" + prepararTexto(telefono) + "', especialidad='" + prepararTexto(especialidad) +
            "', pacientes_mes=" + pacientes_mes + ", pacientes_anual=" + pacientes_anual +
            " where codigo='" + prepararTexto(codigo) + "'";

      int filas = bd.executeUpdate(sql);
      error = bd.getUltimoError();
      return filas > 0;
   }

   public boolean eliminar()
   {
      error = "";
      sql = "delete from medico where codigo='" + prepararTexto(codigo) + "'";
      int filas = bd.executeUpdate(sql);
      error = bd.getUltimoError();
      return filas > 0;
   }

   public void listar(DefaultTableModel dtm_medico)
   {
      error = "";
      dtm_medico.setColumnCount(0);
      dtm_medico.setRowCount(0);
      dtm_medico.addColumn("No.");
      dtm_medico.addColumn("Cedula");
      dtm_medico.addColumn("Nombre");
      dtm_medico.addColumn("Apellido");
      dtm_medico.addColumn("Telefono");
      dtm_medico.addColumn("Especialidad");

      Object[] fila = new Object[6];
      int numero_registro = 1;
      sql = "select * from medico order by apellido";

      try
      {
         ResultSet rs = bd.executeQuery(sql);
         while (rs != null && rs.next())
         {
            fila[0] = numero_registro;
            fila[1] = rs.getString("cedula");
            fila[2] = rs.getString("nombre");
            fila[3] = rs.getString("apellido");
            fila[4] = rs.getString("telefono");
            fila[5] = rs.getString("especialidad");
            dtm_medico.addRow(fila);
            numero_registro++;
         }
         error = bd.getUltimoError();
         bd.cerrar();
      }
      catch(Exception e)
      {
         error = e.toString();
         System.out.println("Medico listar error " + error);
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

         JasperPrint jasperPrint = JasperFillManager.fillReport("Gutierrez757_Medico.jasper",parametro,bd.getCon());
         JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
         jasperViewer.setVisible(true);
         JasperExportManager.exportReportToPdfFile(jasperPrint,"Reporte_Medicos_Gutierrez757.pdf");
         bd.cerrar();
      }
      catch(Exception e)
      {
         error = e.toString();
         System.out.println("Medico reporte error " + error);
         bd.cerrar();
      }
   }
}
