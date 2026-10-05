import java.io.File;
import net.sf.jasperreports.engine.JasperCompileManager;

public class CompilarReportes
{
   public static void main(String[] args)
   {
      try
      {
         String carpeta = System.getProperty("user.dir");
         String separador = File.separator;

         JasperCompileManager.compileReportToFile(
            carpeta + separador + "Gutierrez757_Paciente.jrxml",
            carpeta + separador + "Gutierrez757_Paciente.jasper");

         JasperCompileManager.compileReportToFile(
            carpeta + separador + "Gutierrez757_Medico.jrxml",
            carpeta + separador + "Gutierrez757_Medico.jasper");

         System.out.println("Reportes compilados correctamente");
         System.out.println("Se agrego numero de registro al reporte de medicos");
      }
      catch(Exception e)
      {
         System.out.println("Error al compilar reportes");
         e.printStackTrace();
         System.exit(1);
      }
   }
}
