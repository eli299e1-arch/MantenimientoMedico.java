import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Gutierrez757ProyFinal implements ActionListener
{
   private JFrame ventana;
   private JMenuBar barra_menu;
   private JMenu menu_inicio, menu_mantenimiento, menu_reporte;
   private JMenuItem item_presentacion, item_salir;
   private JMenuItem item_paciente, item_medico;
   private JMenuItem item_reporte_paciente, item_reporte_medico;

   public static void main(String[] args)
   {
      new Gutierrez757ProyFinal();
   }

   Gutierrez757ProyFinal()
   {
      ventana = new JFrame("Hospital Santa Isabel - Proyecto Final");
      ventana.setBounds(40,40,1250,720);
      ventana.setLayout(null);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);

      barra_menu = new JMenuBar();
      barra_menu.setBackground(new Color(78,52,112));
      barra_menu.setBorder(BorderFactory.createEmptyBorder(4,8,4,8));

      menu_inicio = crearMenu("Inicio");
      item_presentacion = crearItem("Presentacion");
      item_salir = crearItem("Salir");
      menu_inicio.add(item_presentacion);
      menu_inicio.addSeparator();
      menu_inicio.add(item_salir);
      barra_menu.add(menu_inicio);

      menu_mantenimiento = crearMenu("Mantenimiento");
      item_paciente = crearItem("Paciente");
      item_medico = crearItem("Medico");
      menu_mantenimiento.add(item_paciente);
      menu_mantenimiento.add(item_medico);
      barra_menu.add(menu_mantenimiento);

      menu_reporte = crearMenu("Reporte");
      item_reporte_paciente = crearItem("Reporte de Pacientes");
      item_reporte_medico = crearItem("Reporte de Medicos");
      menu_reporte.add(item_reporte_paciente);
      menu_reporte.add(item_reporte_medico);
      barra_menu.add(menu_reporte);

      ventana.setJMenuBar(barra_menu);
      ventana.setVisible(true);
      new Presentacion(ventana);
   }

   private JMenu crearMenu(String texto)
   {
      JMenu menu = new JMenu(texto);
      menu.setForeground(Color.WHITE);
      menu.setFont(new Font("Arial",Font.BOLD,15));
      return menu;
   }

   private JMenuItem crearItem(String texto)
   {
      JMenuItem item = new JMenuItem(texto);
      item.setFont(new Font("Arial",Font.PLAIN,14));
      item.addActionListener(this);
      return item;
   }

   public void actionPerformed(ActionEvent e)
   {
      System.out.println("En ActionPerformed");
      if (e.getSource() == item_presentacion)
         new Presentacion(ventana);

      if (e.getSource() == item_salir)
      {
         int respuesta = JOptionPane.showConfirmDialog(ventana,"Desea cerrar el sistema?","Salir",JOptionPane.YES_NO_OPTION);
         if (respuesta == JOptionPane.YES_OPTION)
            System.exit(0);
      }

      if (e.getSource() == item_paciente)
         new MantenimientoPaciente(ventana);

      if (e.getSource() == item_medico)
         new MantenimientoMedico(ventana);

      if (e.getSource() == item_reporte_paciente)
         new ReportePaciente(ventana);

      if (e.getSource() == item_reporte_medico)
         new ReporteMedico(ventana);
   }
}
