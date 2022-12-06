package co.edu.unab.misiontic2022.sintoapp.entity;

public class ObtenerCursos {
    private int id;
    private int docente_id;
    private String codigo;
    private String nombre;
    private String dias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocente_id() {
        return docente_id;
    }

    public void setDocente_id(int docente_id) {
        this.docente_id = docente_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "ObtenerCursos{" +
                "id=" + id +
                ", docente_id=" + docente_id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dias='" + dias + '\'' +
                '}';
    }
}
