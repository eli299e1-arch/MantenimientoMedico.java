import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReporteMedico implements ActionListener
{
   private JFrame ventana;
   private JLabel lbl_titulo, lbl_orden, lbl_nota;
   private JRadioButton rb_apellido, rb_codigo, rb_especialidad;
   private ButtonGroup grupo_orden;
   private JButton btn_generar;
   private JPanel panel_opciones;
   private Medico medico;

   ReporteMedico(JFrame v)
   {
      ventana = v;
      medico = new Medico();

      ventana.getContentPane().removeAll();
      ventana.getContentPane().setBackground(new Color(242,250,248));

      lbl_titulo = new JLabel("REPORTE DE MEDICOS",JLabel.CENTER);
      lbl_titulo.setFont(new Font("Arial",Font.BOLD,27));
      lbl_titulo.setForeground(new Color(22,112,101));
      lbl_titulo.setBounds(300,65,620,45);
      ventana.add(lbl_titulo);

      panel_opciones = new JPanel(null);
      panel_opciones.setBounds(390,145,430,330);
      panel_opciones.setBackground(Color.WHITE);
      panel_opciones.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createLineBorder(new Color(74,151,140),2),
         "Configuracion del reporte"));
      ventana.add(panel_opciones);

      lbl_orden = new JLabel("Seleccione una forma de ordenar");
      lbl_orden.setFont(new Font("Arial",Font.BOLD,17));
      lbl_orden.setBounds(65,40,320,30);
      panel_opciones.add(lbl_orden);

      rb_apellido = crearRadio("Apellido",90);
      rb_codigo = crearRadio("Codigo",135);
      rb_especialidad = crearRadio("Especialidad",180);

      grupo_orden = new ButtonGroup();
      grupo_orden.add(rb_apellido);
      grupo_orden.add(rb_codigo);
      grupo_orden.add(rb_especialidad);

      lbl_nota = new JLabel("El reporte incluye numero de registro",JLabel.CENTER);
      lbl_nota.setFont(new Font("Arial",Font.ITALIC,12));
      lbl_nota.setBounds(35,220,360,25);
      panel_opciones.add(lbl_nota);

      btn_generar = new JButton("Generar reporte");
      btn_generar.setBounds(115,265,200,36);
      btn_generar.setBackground(new Color(22,112,101));
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
         titulo = "Listado de Medicos ordenado por Apellido";
      }
      if (rb_codigo.isSelected())
      {
         orden = "codigo";
         titulo = "Listado de Medicos ordenado por Codigo";
      }
      if (rb_especialidad.isSelected())
      {
         orden = "especialidad";
         titulo = "Listado de Medicos ordenado por Especialidad";
      }

      if (orden.equals(""))
      {
         JOptionPane.showMessageDialog(ventana,"Debe seleccionar un orden");
         return;
      }

      medico.reporte(orden,titulo);
      if (!medico.getError().equals(""))
         JOptionPane.showMessageDialog(ventana,"No se pudo generar el reporte\n" + medico.getError());
   }
}
