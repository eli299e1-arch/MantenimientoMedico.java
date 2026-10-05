import javax.swing.*;
import java.awt.*;

public class Presentacion
{
   private JFrame ventana;
   private JLabel lbl_universidad, lbl_facultad, lbl_materia, lbl_proyecto;
   private JLabel lbl_nombre, lbl_pasaporte, lbl_grupo, lbl_profesor, lbl_sistema;
   private JPanel panel_datos;

   Presentacion(JFrame v)
   {
      ventana = v;
      ventana.getContentPane().removeAll();
      ventana.getContentPane().setBackground(new Color(245,241,250));

      lbl_universidad = crearEtiqueta("UNIVERSIDAD TECNOLOGICA DE PANAMA",28,Font.BOLD);
      lbl_universidad.setForeground(new Color(73,45,102));
      lbl_universidad.setBounds(180,45,900,42);
      ventana.add(lbl_universidad);

      lbl_facultad = crearEtiqueta("FACULTAD DE INGENIERIA EN SISTEMAS COMPUTACIONALES",20,Font.BOLD);
      lbl_facultad.setBounds(170,92,920,34);
      ventana.add(lbl_facultad);

      lbl_materia = crearEtiqueta("DESARROLLO DE SOFTWARE III (JAVA 2)",19,Font.PLAIN);
      lbl_materia.setBounds(250,132,760,32);
      ventana.add(lbl_materia);

      lbl_proyecto = crearEtiqueta("PROYECTO FINAL - BASE DE DATOS",29,Font.BOLD);
      lbl_proyecto.setForeground(new Color(31,108,99));
      lbl_proyecto.setBounds(245,185,770,45);
      ventana.add(lbl_proyecto);

      panel_datos = new JPanel(null);
      panel_datos.setBounds(330,260,600,245);
      panel_datos.setBackground(Color.WHITE);
      panel_datos.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createLineBorder(new Color(124,91,153),2),
         "Datos de la estudiante"));
      ventana.add(panel_datos);

      lbl_nombre = crearDato("Nombre: Elizabeth Gutiérrez",35);
      panel_datos.add(lbl_nombre);

      lbl_pasaporte = crearDato("Pasaporte: 20-53-8757",82);
      panel_datos.add(lbl_pasaporte);

      lbl_grupo = crearDato("Grupo: 2026_1_1GS221_DS3",129);
      panel_datos.add(lbl_grupo);

      lbl_profesor = crearDato("Profesor: Ricardo Chan",176);
      panel_datos.add(lbl_profesor);

      lbl_sistema = crearEtiqueta("Sistema de control de Pacientes y Medicos",21,Font.BOLD);
      lbl_sistema.setForeground(new Color(73,45,102));
      lbl_sistema.setBounds(250,545,760,38);
      ventana.add(lbl_sistema);

      ventana.revalidate();
      ventana.repaint();
   }

   private JLabel crearEtiqueta(String texto, int tamano, int estilo)
   {
      JLabel etiqueta = new JLabel(texto,JLabel.CENTER);
      etiqueta.setFont(new Font("Arial",estilo,tamano));
      return etiqueta;
   }

   private JLabel crearDato(String texto, int y)
   {
      JLabel etiqueta = new JLabel(texto);
      etiqueta.setFont(new Font("Arial",Font.PLAIN,20));
      etiqueta.setBounds(55,y,500,32);
      return etiqueta;
   }
}
