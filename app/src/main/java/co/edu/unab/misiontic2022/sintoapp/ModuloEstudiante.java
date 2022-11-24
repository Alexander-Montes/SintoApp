package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModuloEstudiante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_estudiante);
        Button btnHistorialE = findViewById(R.id.btnHistorialE);
        Button btnSintomasE = findViewById(R.id.btnSintomasE);

        btnHistorialE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModuloEstudiante.this, HistorialEstudiante.class);
                startActivity(intent);
            }
        });

        btnSintomasE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModuloEstudiante.this, ReporteSintomas.class);
                startActivity(intent);
            }
        });
    }
}