package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerEstudiante;
import co.edu.unab.misiontic2022.sintoapp.entity.Token;
import co.edu.unab.misiontic2022.sintoapp.network.LoginAPICliente;
import co.edu.unab.misiontic2022.sintoapp.network.LoginAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModuloEstudiante extends AppCompatActivity {
    Button btnHistorialE;
    Button btnSintomasE;
    private LoginAPIService service;
    private long user_id;
    private TextView txtNombreE;
    private TextView txtApellidoE;
    private TextView txtPrograma;
    private TextView txtEstadoE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_estudiante);
        service = LoginAPICliente.getLoginAPIService();
        user_id = getIntent().getIntExtra("usuario_id", -1);
        setup();
    }
    private void setup(){
        btnHistorialE = findViewById(R.id.btnHistorialE);
        btnSintomasE = findViewById(R.id.btnSintomasE);
        txtNombreE = findViewById(R.id.txtNombreE);
        txtApellidoE = findViewById(R.id.txtApellidoE);
        txtPrograma = findViewById(R.id.txtPrograma);
        txtEstadoE = findViewById(R.id.txtEstadoE);
    }

    public void btnHistorialE(View view){
        Intent intent = new Intent(ModuloEstudiante.this, HistorialEstudiante.class);
        startActivity(intent);
    }

    public void btnSintomasE(View view){
        Intent intent = new Intent(ModuloEstudiante.this, ReporteSintomas.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        service.obtenerEstudiante("Bearer "+ Token.token, user_id).enqueue(new Callback<ObtenerEstudiante>() {
            @Override
            public void onResponse(Call<ObtenerEstudiante> call, Response<ObtenerEstudiante> response) {
                ObtenerEstudiante obestudiante = response.body();
                mostrarDatos(obestudiante);
            }

            @Override
            public void onFailure(Call<ObtenerEstudiante> call, Throwable t) {
                Toast.makeText(ModuloEstudiante.this,
                        "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mostrarDatos(ObtenerEstudiante obestudiante){
        txtNombreE.setText(String.valueOf(obestudiante.getNombres()));
        txtApellidoE.setText(String.valueOf(obestudiante.getApellidos()));
        txtPrograma.setText(String.valueOf(obestudiante.getPrograma()));
        if ((obestudiante.getEstado()) == 0){
            txtEstadoE.setText(String.valueOf("Estado: No habilitado"));
        } else {
            txtEstadoE.setText(String.valueOf("Estado: Habilitado"));
        }
    }
}