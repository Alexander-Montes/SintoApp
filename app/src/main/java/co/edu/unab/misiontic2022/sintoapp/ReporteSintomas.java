package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReporteSintomas extends AppCompatActivity {
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_sintomas);
        update();
    }

    private void update(){
        btnEnviar = findViewById(R.id.btnEnviar);
    }

    public void btnEnviar(View view){
        Intent intent = new Intent(ReporteSintomas.this,ModuloProfesor.class);
        startActivity(intent);
    }
}