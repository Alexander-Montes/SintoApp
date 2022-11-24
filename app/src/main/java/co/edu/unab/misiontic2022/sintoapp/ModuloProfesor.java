package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import co.edu.unab.misiontic2022.sintoapp.entity.Cursos;

public class ModuloProfesor extends AppCompatActivity {
    Spinner listaVerCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_profesor);
        listaVerCursos = findViewById(R.id.listaVerCursos);
        View btnHistorialP = findViewById(R.id.btnHistorialP);
        View btnSintomasP = findViewById(R.id.btnSintomasP);

        btnHistorialP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModuloProfesor.this,HistorialProfesor.class);
                startActivity(intent);
            }
        });

        btnSintomasP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModuloProfesor.this, ReporteSintomas.class);
                startActivity(intent);
            }
        });

        ArrayList<Cursos> cursos = new ArrayList<>();
        cursos.add(new Cursos("Ver cursos"));
        cursos.add(new Cursos("Grupo 43"));
        cursos.add(new Cursos("Grupo 106"));

        ArrayAdapter<Cursos> adapter = new ArrayAdapter<>(this,
                com.google.android.material.R.layout
                .support_simple_spinner_dropdown_item, cursos);
        listaVerCursos.setAdapter(adapter);

        listaVerCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).toString().equals ("Grupo 106")){
                    Intent intent = new Intent(ModuloProfesor.this, ListaEstudiantes.class);
                    startActivity(intent);
                } else if (adapterView.getItemAtPosition(i).toString().equals ("Grupo 43")){
                    Intent intent = new Intent(ModuloProfesor.this, ListaEstudiantes.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}