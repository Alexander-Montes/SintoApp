package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReporteSintomas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_sintomas);

        Button btnEnviar = findViewById(R.id.btnEnviar);
        Button btnOmitir = findViewById(R.id.btnOmitir);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReporteSintomas.this,ModuloProfesor.class);
                startActivity(intent);
            }
        });
        btnOmitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReporteSintomas.this,ModuloEstudiante.class);
                startActivity(intent);
            }
        });
    }
}