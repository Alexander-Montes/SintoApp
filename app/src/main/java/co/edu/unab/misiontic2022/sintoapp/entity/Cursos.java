package co.edu.unab.misiontic2022.sintoapp.entity;

public class Cursos {
    private String grupo;

    public Cursos() {
    }

    public Cursos(String grupo) {
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return grupo;
    }
}
