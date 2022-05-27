package mx.efr.organizadordehorario;

public class AsignaturaClass {

    //region Atributos
    private String nombre;
    private String grupo;
    private String clave;
    private String horaInicio;
    private String horaFinal;
    private String dias;
    private String profesor;
    //endregion

    //region Contructor
    public AsignaturaClass(){} // Constructor vacío

    public AsignaturaClass(String nombre, String grupo, String clave, String horaInicio, String horaFinal, String dias, String profesor)
    {
        this.nombre = nombre;
        this.grupo = grupo;
        this.clave = clave;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.dias = dias;
        this.profesor = profesor;
    }
    //endregion

    //region Getter y Setter
    public String getNombre() {return nombre;}
    public void setNombre(String nombre)
    {
        if(nombre == null)
        {
            this.nombre = "Asignatura desconocida";
        }
        else
        {
            this.nombre = nombre;
        }
    }

    public String getGrupo() {return grupo;}
    public void setGrupo(String grupo)
    {
        if(grupo == null)
        {
            this.grupo = "0";
        }
        else
        {
            this.grupo = grupo;
        }
    }

    public String getClave() {return clave;}
    public void setClave(String clave)
    {
        if(clave == null)
        {
            this.clave = "0000";
        }
        else
        {
            this.clave = clave;
        }
    }

    public String getHoraInicio() {return horaInicio;}
    public void setHoraInicio(String horaInicio)
    {
        if(horaInicio == null)
        {
            this.horaInicio = "0";
        }
        else
        {
            this.horaInicio = horaInicio;
        }
    }

    public String getHoraFinal() {return horaFinal;}
    public void setHoraFinal(String horaFinal)
    {
        if(horaFinal == null)
        {
            this.horaFinal = "0";
        }
        else
        {
            this.horaFinal = horaFinal;
        }
    }

    public String getDias() {return dias;}
    public void setDias(String dias)
    {
        if(dias == null)
        {
            this.dias = new String("Lun");
        }
        else
        {
            this.dias = dias;
        }
    }

    public String getProfesor() {return profesor;}
    public void setProfesor(String profesor)
    {
        if(profesor == null)
        {
            this.profesor = new String("Sin asignar");
        }
        else
        {
            this.profesor = profesor;
        }
    }
    //endregion
}
