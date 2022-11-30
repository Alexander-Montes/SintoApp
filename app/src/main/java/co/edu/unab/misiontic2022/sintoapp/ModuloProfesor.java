package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ModuloProfesor extends AppCompatActivity {
    Spinner listaVerCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_profesor);

        listaVerCursos = findViewById(R.id.listaVerCursos);
        Button btnHistorialP = findViewById(R.id.btnHistorialP);
        Button btnSintomasP = findViewById(R.id.btnSintomasP);

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

        String [] cursos = new String[]{"Ver cursos","Grupo 43", "Grupo 106"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                ModuloProfesor.this,android.R.layout.simple_spinner_dropdown_item, cursos);
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