import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReportePaciente implements ActionListener
{
   private JFrame ventana;
   private JLabel lbl_titulo, lbl_orden, lbl_nota;
   private JRadioButton rb_apellido, rb_cedula, rb_edad;
   private ButtonGroup grupo_orden;
   private JButton btn_generar;
   private JPanel panel_opciones;
   private Paciente paciente;

   ReportePaciente(JFrame v)
   {
      ventana = v;
      paciente = new Paciente();

      ventana.getContentPane().removeAll();
      ventana.getContentPane().setBackground(new Color(250,247,255));

      lbl_titulo = new JLabel("REPORTE DE PACIENTES",JLabel.CENTER);
      lbl_titulo.setFont(new Font("Arial",Font.BOLD,27));
      lbl_titulo.setForeground(new Color(92,56,125));
      lbl_titulo.setBounds(300,65,620,45);
      ventana.add(lbl_titulo);

      panel_opciones = new JPanel(null);
      panel_opciones.setBounds(390,145,430,330);
      panel_opciones.setBackground(Color.WHITE);
      panel_opciones.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createLineBorder(new Color(150,116,178),2),
         "Configuracion del reporte"));
      ventana.add(panel_opciones);

      lbl_orden = new JLabel("Seleccione una forma de ordenar");
      lbl_orden.setFont(new Font("Arial",Font.BOLD,17));
      lbl_orden.setBounds(65,40,320,30);
      panel_opciones.add(lbl_orden);

      rb_apellido = crearRadio("Apellido",90);
      rb_cedula = crearRadio("Cedula",135);
      rb_edad = crearRadio("Edad",180);

      grupo_orden = new ButtonGroup();
      grupo_orden.add(rb_apellido);
      grupo_orden.add(rb_cedula);
      grupo_orden.add(rb_edad);

      lbl_nota = new JLabel("Solo una opcion puede permanecer seleccionada",JLabel.CENTER);
      lbl_nota.setFont(new Font("Arial",Font.ITALIC,12));
      lbl_nota.setBounds(35,220,360,25);
      panel_opciones.add(lbl_nota);

      btn_generar = new JButton("Generar reporte");
      btn_generar.setBounds(115,265,200,36);
      btn_generar.setBackground(new Color(92,56,125));
      btn_generar.setForeground(Color.WHITE);
      btn_generar.setFont(new Font("Arial",Font.BOLD,14));
      btn_generar.addActionListener(this);
      panel_opciones.add(btn_generar);

      ventana.revalidate();
      ventana.repaint();
   }

   private JRadioButton crearRadio(String texto, int y)
   {
      JRadioButton radio = new JRadioButton(texto);
      radio.setFont(new Font("Arial",Font.PLAIN,16));
      radio.setBounds(130,y,180,30);
      radio.setOpaque(false);
      panel_opciones.add(radio);
      return radio;
   }

   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == btn_generar)
         generar();
   }

   private void generar()
   {
      String orden = "";
      String titulo = "";

      if (rb_apellido.isSelected())
      {
         orden = "apellido";
         titulo = "Listado de Pacientes ordenado por Apellido";
      }
      if (rb_cedula.isSelected())
      {
         orden = "CAST(SUBSTRING_INDEX(cedula,'-',1) AS UNSIGNED), " +
                 "CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(cedula,'-',2),'-',-1) AS UNSIGNED), " +
                 "CAST(SUBSTRING_INDEX(cedula,'-',-1) AS UNSIGNED)";
         titulo = "Listado de Pacientes ordenado por Cedula";
      }
      if (rb_edad.isSelected())
      {
         orden = "edad";
         titulo = "Listado de Pacientes ordenado por Edad";
      }

      if (orden.equals(""))
      {
         JOptionPane.showMessageDialog(ventana,"Debe seleccionar un orden");
         return;
      }

      paciente.reporte(orden,titulo);
      if (!paciente.getError().equals(""))
         JOptionPane.showMessageDialog(ventana,"No se pudo generar el reporte\n" + paciente.getError());
   }
}
