package co.edu.unab.misiontic2022.sintoapp.entity;

public class ObtenerEstudiante {
    private int id;
    private int user_id;
    private String nombres;
    private String apellidos;
    private String programa;
    private int estado;
    private int curso_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    @Override
    public String toString() {
        return "ObtenerEstudiante{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", programa='" + programa + '\'' +
                ", estado=" + estado +
                ", curso_id=" + curso_id +
                '}';
    }
}
