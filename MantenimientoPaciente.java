import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class MantenimientoPaciente implements ActionListener
{
   private JFrame ventana;
   private JLabel lbl_titulo, lbl_cedula, lbl_nombre, lbl_apellido;
   private JLabel lbl_direccion, lbl_telefono, lbl_provincia, lbl_edad, lbl_sexo;
   private JTextField tf_cedula, tf_nombre, tf_apellido, tf_direccion;
   private JTextField tf_telefono, tf_provincia, tf_edad;
   private JRadioButton rb_masculino, rb_femenino;
   private ButtonGroup bg_sexo;
   private JButton btn_limpiar, btn_buscar, btn_agregar;
   private JButton btn_modificar, btn_eliminar, btn_listar;
   private DefaultTableModel dtm_paciente;
   private JTable jt_paciente;
   private JScrollPane jsp_paciente;
   private Paciente paciente;

   MantenimientoPaciente(JFrame v)
   {
      ventana = v;
      paciente = new Paciente();

      ventana.getContentPane().removeAll();
      ventana.getContentPane().setBackground(new Color(250,247,255));

      lbl_titulo = new JLabel("MANTENIMIENTO DE PACIENTES",JLabel.CENTER);
      lbl_titulo.setFont(new Font("Arial",Font.BOLD,25));
      lbl_titulo.setForeground(new Color(92,56,125));
      lbl_titulo.setBounds(250,20,700,35);
      ventana.add(lbl_titulo);

      lbl_cedula = new JLabel("Cedula");
      lbl_cedula.setBounds(80,80,120,25);
      ventana.add(lbl_cedula);
      tf_cedula = new JTextField();
      tf_cedula.setBounds(210,80,250,25);
      ventana.add(tf_cedula);

      lbl_nombre = new JLabel("Nombre");
      lbl_nombre.setBounds(80,115,120,25);
      ventana.add(lbl_nombre);
      tf_nombre = new JTextField();
      tf_nombre.setBounds(210,115,250,25);
      ventana.add(tf_nombre);

      lbl_apellido = new JLabel("Apellido");
      lbl_apellido.setBounds(80,150,120,25);
      ventana.add(lbl_apellido);
      tf_apellido = new JTextField();
      tf_apellido.setBounds(210,150,250,25);
      ventana.add(tf_apellido);

      lbl_direccion = new JLabel("Direccion");
      lbl_direccion.setBounds(80,185,120,25);
      ventana.add(lbl_direccion);
      tf_direccion = new JTextField();
      tf_direccion.setBounds(210,185,350,25);
      ventana.add(tf_direccion);

      lbl_telefono = new JLabel("Telefono");
      lbl_telefono.setBounds(80,220,120,25);
      ventana.add(lbl_telefono);
      tf_telefono = new JTextField();
      tf_telefono.setBounds(210,220,150,25);
      ventana.add(tf_telefono);

      lbl_provincia = new JLabel("Provincia");
      lbl_provincia.setBounds(80,255,120,25);
      ventana.add(lbl_provincia);
      tf_provincia = new JTextField();
      tf_provincia.setBounds(210,255,250,25);
      ventana.add(tf_provincia);

      lbl_edad = new JLabel("Edad");
      lbl_edad.setBounds(80,290,120,25);
      ventana.add(lbl_edad);
      tf_edad = new JTextField();
      tf_edad.setBounds(210,290,100,25);
      ventana.add(tf_edad);

      lbl_sexo = new JLabel("Sexo");
      lbl_sexo.setBounds(80,325,120,25);
      ventana.add(lbl_sexo);

      rb_masculino = new JRadioButton("Masculino");
      rb_masculino.setBounds(205,325,120,25);
      rb_masculino.setOpaque(false);
      ventana.add(rb_masculino);

      rb_femenino = new JRadioButton("Femenino");
      rb_femenino.setBounds(330,325,120,25);
      rb_femenino.setOpaque(false);
      ventana.add(rb_femenino);

      bg_sexo = new ButtonGroup();
      bg_sexo.add(rb_masculino);
      bg_sexo.add(rb_femenino);

      btn_limpiar = new JButton("Limpiar");
      btn_limpiar.setBounds(650,85,130,30);
      btn_limpiar.addActionListener(this);
      ventana.add(btn_limpiar);

      btn_buscar = new JButton("Buscar");
      btn_buscar.setBounds(800,85,130,30);
      btn_buscar.addActionListener(this);
      ventana.add(btn_buscar);

      btn_agregar = new JButton("Agregar");
      btn_agregar.setBounds(650,130,130,30);
      btn_agregar.addActionListener(this);
      ventana.add(btn_agregar);

      btn_modificar = new JButton("Modificar");
      btn_modificar.setBounds(800,130,130,30);
      btn_modificar.addActionListener(this);
      ventana.add(btn_modificar);

      btn_eliminar = new JButton("Eliminar");
      btn_eliminar.setBounds(650,175,130,30);
      btn_eliminar.addActionListener(this);
      ventana.add(btn_eliminar);

      btn_listar = new JButton("Listar");
      btn_listar.setBounds(800,175,130,30);
      btn_listar.addActionListener(this);
      ventana.add(btn_listar);

      dtm_paciente = new DefaultTableModel();
      jt_paciente = new JTable(dtm_paciente);
      jsp_paciente = new JScrollPane(jt_paciente);
      jt_paciente.setRowHeight(24);
      jt_paciente.getTableHeader().setFont(new Font("Arial",Font.BOLD,13));
      jt_paciente.setGridColor(new Color(190,175,205));
      jsp_paciente.setBounds(80,390,1000,230);
      ventana.add(jsp_paciente);

      limpiar();
      ventana.revalidate();
      ventana.repaint();
   }

   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == btn_limpiar)
         limpiar();
      if (e.getSource() == btn_buscar)
         buscar();
      if (e.getSource() == btn_agregar)
         agregar();
      if (e.getSource() == btn_modificar)
         modificar();
      if (e.getSource() == btn_eliminar)
         eliminar();
      if (e.getSource() == btn_listar)
         listar();
   }

   private void limpiar()
   {
      tf_cedula.setText("");
      tf_nombre.setText("");
      tf_apellido.setText("");
      tf_direccion.setText("");
      tf_telefono.setText("");
      tf_provincia.setText("");
      tf_edad.setText("");
      bg_sexo.clearSelection();

      tf_cedula.setEnabled(true);
      habilitar_campos(false);

      btn_limpiar.setEnabled(true);
      btn_buscar.setEnabled(true);
      btn_agregar.setEnabled(false);
      btn_modificar.setEnabled(false);
      btn_eliminar.setEnabled(false);
      btn_listar.setEnabled(true);
      tf_cedula.requestFocus();
   }

   private void habilitar_campos(boolean estado)
   {
      tf_nombre.setEnabled(estado);
      tf_apellido.setEnabled(estado);
      tf_direccion.setEnabled(estado);
      tf_telefono.setEnabled(estado);
      tf_provincia.setEnabled(estado);
      tf_edad.setEnabled(estado);
      rb_masculino.setEnabled(estado);
      rb_femenino.setEnabled(estado);
   }

   private void estado_agregar()
   {
      tf_cedula.setEnabled(false);
      habilitar_campos(true);
      btn_buscar.setEnabled(false);
      btn_agregar.setEnabled(true);
      btn_modificar.setEnabled(false);
      btn_eliminar.setEnabled(false);
      btn_listar.setEnabled(true);
      btn_limpiar.setEnabled(true);
      tf_nombre.requestFocus();
   }

   private void estado_modificar()
   {
      tf_cedula.setEnabled(false);
      habilitar_campos(true);
      btn_buscar.setEnabled(false);
      btn_agregar.setEnabled(false);
      btn_modificar.setEnabled(true);
      btn_eliminar.setEnabled(true);
      btn_listar.setEnabled(true);
      btn_limpiar.setEnabled(true);
   }

   private void buscar()
   {
      if (tf_cedula.getText().trim().equals(""))
      {
         JOptionPane.showMessageDialog(ventana,"Debe escribir la cedula");
         return;
      }

      paciente.setCedula(tf_cedula.getText().trim());
      boolean existe = paciente.buscar();

      if (!paciente.getError().equals(""))
      {
         JOptionPane.showMessageDialog(ventana,"Error al buscar\n" + paciente.getError());
         return;
      }

      if (existe)
      {
         tf_nombre.setText(paciente.getNombre());
         tf_apellido.setText(paciente.getApellido());
         tf_direccion.setText(paciente.getDireccion());
         tf_telefono.setText(paciente.getTelefono());
         tf_provincia.setText(paciente.getProvincia());
         tf_edad.setText(String.valueOf(paciente.getEdad()));
         if (paciente.getSexo().equalsIgnoreCase("M"))
            rb_masculino.setSelected(true);
         else
            rb_femenino.setSelected(true);
         estado_modificar();
      }
      else
      {
         tf_nombre.setText("");
         tf_apellido.setText("");
         tf_direccion.setText("");
         tf_telefono.setText("");
         tf_provincia.setText("");
         tf_edad.setText("");
         bg_sexo.clearSelection();
         estado_agregar();
         JOptionPane.showMessageDialog(ventana,"La cedula no existe. Puede agregar el paciente");
      }
   }

   private boolean validar_campos()
   {
      if (tf_nombre.getText().trim().equals("") ||
          tf_apellido.getText().trim().equals("") ||
          tf_direccion.getText().trim().equals("") ||
          tf_telefono.getText().trim().equals("") ||
          tf_provincia.getText().trim().equals("") ||
          tf_edad.getText().trim().equals("") ||
          (!rb_masculino.isSelected() && !rb_femenino.isSelected()))
      {
         JOptionPane.showMessageDialog(ventana,"Debe llenar todos los campos");
         return false;
      }

      if (tf_cedula.getText().trim().length() > 15)
      {
         JOptionPane.showMessageDialog(ventana,"La cedula permite un maximo de 15 caracteres");
         return false;
      }

      if (tf_telefono.getText().trim().length() > 7)
      {
         JOptionPane.showMessageDialog(ventana,"El telefono permite un maximo de 7 caracteres");
         return false;
      }

      try
      {
         Integer.parseInt(tf_edad.getText().trim());
      }
      catch(Exception e)
      {
         JOptionPane.showMessageDialog(ventana,"La edad debe ser numerica");
         return false;
      }
      return true;
   }

   private void pasar_tf_paciente()
   {
      paciente.setCedula(tf_cedula.getText().trim());
      paciente.setNombre(tf_nombre.getText().trim());
      paciente.setApellido(tf_apellido.getText().trim());
      paciente.setDireccion(tf_direccion.getText().trim());
      paciente.setTelefono(tf_telefono.getText().trim());
      paciente.setProvincia(tf_provincia.getText().trim());
      paciente.setEdad(Integer.parseInt(tf_edad.getText().trim()));
      if (rb_masculino.isSelected())
         paciente.setSexo("M");
      else
         paciente.setSexo("F");
   }

   private void agregar()
   {
      if (!validar_campos())
         return;

      pasar_tf_paciente();
      if (paciente.agregar())
      {
         JOptionPane.showMessageDialog(ventana,"El paciente se grabo correctamente");
         limpiar();
      }
      else
         JOptionPane.showMessageDialog(ventana,"No se pudo grabar\n" + paciente.getError());
   }

   private void modificar()
   {
      if (!validar_campos())
         return;

      pasar_tf_paciente();
      if (paciente.modificar())
      {
         JOptionPane.showMessageDialog(ventana,"El paciente se modifico correctamente");
         limpiar();
      }
      else
         JOptionPane.showMessageDialog(ventana,"No se pudo modificar\n" + paciente.getError());
   }

   private void eliminar()
   {
      int respuesta = JOptionPane.showConfirmDialog(ventana,"Desea eliminar el paciente?","Eliminar",JOptionPane.YES_NO_OPTION);
      if (respuesta != JOptionPane.YES_OPTION)
         return;

      paciente.setCedula(tf_cedula.getText().trim());
      if (paciente.eliminar())
      {
         JOptionPane.showMessageDialog(ventana,"El paciente se borro correctamente");
         limpiar();
      }
      else
         JOptionPane.showMessageDialog(ventana,"No se pudo borrar\n" + paciente.getError());
   }

   private void listar()
   {
      paciente.listar(dtm_paciente);
      if (!paciente.getError().equals(""))
         JOptionPane.showMessageDialog(ventana,"Error al listar\n" + paciente.getError());
   }
}
