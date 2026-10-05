public class Persona
{
   protected int id;
   protected String cedula, nombre, apellido, direccion, telefono;

   Persona()
   {
      id = 0;
      cedula = "";
      nombre = "";
      apellido = "";
      direccion = "";
      telefono = "";
   }

   public void setId(int i)
   {
      id = i;
   }
   public int getId()
   {
      return id;
   }

   public void setCedula(String c)
   {
      cedula = c;
   }
   public String getCedula()
   {
      return cedula;
   }

   public void setNombre(String n)
   {
      nombre = n;
   }
   public String getNombre()
   {
      return nombre;
   }

   public void setApellido(String a)
   {
      apellido = a;
   }
   public String getApellido()
   {
      return apellido;
   }

   public void setDireccion(String d)
   {
      direccion = d;
   }
   public String getDireccion()
   {
      return direccion;
   }

   public void setTelefono(String t)
   {
      telefono = t;
   }
   public String getTelefono()
   {
      return telefono;
   }
}
