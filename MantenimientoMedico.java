import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class MantenimientoMedico implements ActionListener
{
   private JFrame ventana;
   private JLabel lbl_titulo, lbl_codigo, lbl_cedula, lbl_nombre, lbl_apellido;
   private JLabel lbl_direccion, lbl_telefono, lbl_especialidad;
   private JLabel lbl_pacientes_mes, lbl_pacientes_anual;
   private JTextField tf_codigo, tf_cedula, tf_nombre, tf_apellido, tf_direccion;
   private JTextField tf_telefono, tf_especialidad, tf_pacientes_mes, tf_pacientes_anual;
   private JButton btn_limpiar, btn_buscar, btn_agregar;
   private JButton btn_modificar, btn_eliminar, btn_listar;
   private DefaultTableModel dtm_medico;
   private JTable jt_medico;
   private JScrollPane jsp_medico;
   private Medico medico;

   MantenimientoMedico(JFrame v)
   {
      ventana = v;
      medico = new Medico();

      ventana.getContentPane().removeAll();
      ventana.getContentPane().setBackground(new Color(242,250,248));

      lbl_titulo = new JLabel("MANTENIMIENTO DE MEDICOS",JLabel.CENTER);
      lbl_titulo.setFont(new Font("Arial",Font.BOLD,25));
      lbl_titulo.setForeground(new Color(22,112,101));
      lbl_titulo.setBounds(250,20,700,35);
      ventana.add(lbl_titulo);

      lbl_codigo = new JLabel("Codigo");
      lbl_codigo.setBounds(80,65,120,25);
      ventana.add(lbl_codigo);
      tf_codigo = new JTextField();
      tf_codigo.setBounds(210,65,150,25);
      ventana.add(tf_codigo);

      lbl_cedula = new JLabel("Cedula");
      lbl_cedula.setBounds(80,100,120,25);
      ventana.add(lbl_cedula);
      tf_cedula = new JTextField();
      tf_cedula.setBounds(210,100,250,25);
      ventana.add(tf_cedula);

      lbl_nombre = new JLabel("Nombre");
      lbl_nombre.setBounds(80,135,120,25);
      ventana.add(lbl_nombre);
      tf_nombre = new JTextField();
      tf_nombre.setBounds(210,135,250,25);
      ventana.add(tf_nombre);

      lbl_apellido = new JLabel("Apellido");
      lbl_apellido.setBounds(80,170,120,25);
      ventana.add(lbl_apellido);
      tf_apellido = new JTextField();
      tf_apellido.setBounds(210,170,250,25);
      ventana.add(tf_apellido);

      lbl_direccion = new JLabel("Direccion");
      lbl_direccion.setBounds(80,205,120,25);
      ventana.add(lbl_direccion);
      tf_direccion = new JTextField();
      tf_direccion.setBounds(210,205,350,25);
      ventana.add(tf_direccion);

      lbl_telefono = new JLabel("Telefono");
      lbl_telefono.setBounds(80,240,120,25);
      ventana.add(lbl_telefono);
      tf_telefono = new JTextField();
      tf_telefono.setBounds(210,240,150,25);
      ventana.add(tf_telefono);

      lbl_especialidad = new JLabel("Especialidad");
      lbl_especialidad.setBounds(80,275,120,25);
      ventana.add(lbl_especialidad);
      tf_especialidad = new JTextField();
      tf_especialidad.setBounds(210,275,250,25);
      ventana.add(tf_especialidad);

      lbl_pacientes_mes = new JLabel("Pacientes mes");
      lbl_pacientes_mes.setBounds(80,310,120,25);
      ventana.add(lbl_pacientes_mes);
      tf_pacientes_mes = new JTextField();
      tf_pacientes_mes.setBounds(210,310,100,25);
      ventana.add(tf_pacientes_mes);

      lbl_pacientes_anual = new JLabel("Pacientes anual");
      lbl_pacientes_anual.setBounds(80,345,120,25);
      ventana.add(lbl_pacientes_anual);
      tf_pacientes_anual = new JTextField();
      tf_pacientes_anual.setBounds(210,345,100,25);
      ventana.add(tf_pacientes_anual);

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

      dtm_medico = new DefaultTableModel();
      jt_medico = new JTable(dtm_medico);
      jsp_medico = new JScrollPane(jt_medico);
      jt_medico.setRowHeight(24);
      jt_medico.getTableHeader().setFont(new Font("Arial",Font.BOLD,13));
      jt_medico.setGridColor(new Color(155,195,188));
      jsp_medico.setBounds(80,405,1000,215);
      ventana.add(jsp_medico);

      limpiar();
      ventana.revalidate();
      ventana.repaint();
   }

   public void actionPerformed(ActionEvent e)
   {
      System.out.println("En ActionPerformed");
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
      tf_codigo.setText("");
      tf_cedula.setText("");
      tf_nombre.setText("");
      tf_apellido.setText("");
      tf_direccion.setText("");
      tf_telefono.setText("");
      tf_especialidad.setText("");
      tf_pacientes_mes.setText("");
      tf_pacientes_anual.setText("");

      tf_codigo.setEnabled(true);
      habilitar_campos(false);

      btn_limpiar.setEnabled(true);
      btn_buscar.setEnabled(true);
      btn_agregar.setEnabled(false);
      btn_modificar.setEnabled(false);
      btn_eliminar.setEnabled(false);
      btn_listar.setEnabled(true);
      tf_codigo.requestFocus();
   }

   private void habilitar_campos(boolean estado)
   {
      tf_cedula.setEnabled(estado);
      tf_nombre.setEnabled(estado);
      tf_apellido.setEnabled(estado);
      tf_direccion.setEnabled(estado);
      tf_telefono.setEnabled(estado);
      tf_especialidad.setEnabled(estado);
      tf_pacientes_mes.setEnabled(estado);
      tf_pacientes_anual.setEnabled(estado);
   }

   private void estado_agregar()
   {
      tf_codigo.setEnabled(false);
      habilitar_campos(true);
      btn_buscar.setEnabled(false);
      btn_agregar.setEnabled(true);
      btn_modificar.setEnabled(false);
      btn_eliminar.setEnabled(false);
      btn_listar.setEnabled(true);
      btn_limpiar.setEnabled(true);
      tf_cedula.requestFocus();
   }

   private void estado_modificar()
   {
      tf_codigo.setEnabled(false);
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
      if (tf_codigo.getText().trim().equals(""))
      {
         JOptionPane.showMessageDialog(ventana,"Debe escribir el codigo");
         return;
      }

      medico.setCodigo(tf_codigo.getText().trim());
      boolean existe = medico.buscar();

      if (!medico.getError().equals(""))
      {
         JOptionPane.showMessageDialog(ventana,"Error al buscar\n" + medico.getError());
         return;
      }

      if (existe)
      {
         tf_cedula.setText(medico.getCedula());
         tf_nombre.setText(medico.getNombre());
         tf_apellido.setText(medico.getApellido());
         tf_direccion.setText(medico.getDireccion());
         tf_telefono.setText(medico.getTelefono());
         tf_especialidad.setText(medico.getEspecialidad());
         tf_pacientes_mes.setText(String.valueOf(medico.getPacientesMes()));
         tf_pacientes_anual.setText(String.valueOf(medico.getPacientesAnual()));
         estado_modificar();
      }
      else
      {
         tf_cedula.setText("");
         tf_nombre.setText("");
         tf_apellido.setText("");
         tf_direccion.setText("");
         tf_telefono.setText("");
         tf_especialidad.setText("");
         tf_pacientes_mes.setText("");
         tf_pacientes_anual.setText("");
         estado_agregar();
         JOptionPane.showMessageDialog(ventana,"El codigo no existe. Puede agregar el medico");
      }
   }

   private boolean validar_campos()
   {
      if (tf_cedula.getText().trim().equals("") ||
          tf_nombre.getText().trim().equals("") ||
          tf_apellido.getText().trim().equals("") ||
          tf_direccion.getText().trim().equals("") ||
          tf_telefono.getText().trim().equals("") ||
          tf_especialidad.getText().trim().equals("") ||
          tf_pacientes_mes.getText().trim().equals("") ||
          tf_pacientes_anual.getText().trim().equals(""))
      {
         JOptionPane.showMessageDialog(ventana,"Debe llenar todos los campos");
         return false;
      }

      if (tf_codigo.getText().trim().length() > 4)
      {
         JOptionPane.showMessageDialog(ventana,"El codigo permite un maximo de 4 caracteres");
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
         Integer.parseInt(tf_pacientes_mes.getText().trim());
         Integer.parseInt(tf_pacientes_anual.getText().trim());
      }
      catch(Exception e)
      {
         JOptionPane.showMessageDialog(ventana,"Pacientes mes y anual deben ser numericos");
         return false;
      }
      return true;
   }

   private void pasar_tf_medico()
   {
      medico.setCodigo(tf_codigo.getText().trim());
      medico.setCedula(tf_cedula.getText().trim());
      medico.setNombre(tf_nombre.getText().trim());
      medico.setApellido(tf_apellido.getText().trim());
      medico.setDireccion(tf_direccion.getText().trim());
      medico.setTelefono(tf_telefono.getText().trim());
      medico.setEspecialidad(tf_especialidad.getText().trim());
      medico.setPacientesMes(Integer.parseInt(tf_pacientes_mes.getText().trim()));
      medico.setPacientesAnual(Integer.parseInt(tf_pacientes_anual.getText().trim()));
   }

   private void agregar()
   {
      if (!validar_campos())
         return;

      pasar_tf_medico();
      if (medico.agregar())
      {
         JOptionPane.showMessageDialog(ventana,"El medico se grabo correctamente");
         limpiar();
      }
      else
         JOptionPane.showMessageDialog(ventana,"No se pudo grabar\n" + medico.getError());
   }

   private void modificar()
   {
      if (!validar_campos())
         return;

      pasar_tf_medico();
      if (medico.modificar())
      {
         JOptionPane.showMessageDialog(ventana,"El medico se modifico correctamente");
         limpiar();
      }
      else
         JOptionPane.showMessageDialog(ventana,"No se pudo modificar\n" + medico.getError());
   }

   private void eliminar()
   {
      int respuesta = JOptionPane.showConfirmDialog(ventana,"Desea eliminar el medico?","Eliminar",JOptionPane.YES_NO_OPTION);
      if (respuesta != JOptionPane.YES_OPTION)
         return;

      medico.setCodigo(tf_codigo.getText().trim());
      if (medico.eliminar())
      {
         JOptionPane.showMessageDialog(ventana,"El medico se borro correctamente");
         limpiar();
      }
      else
         JOptionPane.showMessageDialog(ventana,"No se pudo borrar\n" + medico.getError());
   }

   private void listar()
   {
      medico.listar(dtm_medico);
      if (!medico.getError().equals(""))
         JOptionPane.showMessageDialog(ventana,"Error al listar\n" + medico.getError());
   }
}
