package co.edu.unab.misiontic2022.sintoapp.entity;

public class ObtenerDocente {
    private int id;
    private int user_id;
    private String nombres;
    private String apellidos;
    private String profesion;
    private int estado;
    private String url_foto;

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

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
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

    @Override
    public String toString() {
        return "ObtenerDocente{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", profesion='" + profesion + '\'' +
                ", estado=" + estado + '\'' +
                ", url_foto=" + url_foto +
                '}';
    }
}
