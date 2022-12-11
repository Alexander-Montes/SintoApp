package co.edu.unab.misiontic2022.sintoapp.entity;

public class ObtenerLista {
    private int id;
    private int user_id;
    private int documento;
    private String nombres;
    private String apellidos;
    private String programa;
    private int estado;
    private String url_foto;
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

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
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

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    @Override
    public String toString() {
        return "ObtenerLista{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", documento=" + documento +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", programa='" + programa + '\'' +
                ", estado=" + estado +
                ", url_foto='" + url_foto + '\'' +
                ", curso_id=" + curso_id +
                '}';
    }
}
