package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerReportes;
import co.edu.unab.misiontic2022.sintoapp.entity.Token;
import co.edu.unab.misiontic2022.sintoapp.network.LoginAPICliente;
import co.edu.unab.misiontic2022.sintoapp.network.LoginAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistorialEstudiante extends AppCompatActivity {
    Button btnVolverE;
    private LoginAPIService service;
    private long usuario_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_estudiante);
        service = LoginAPICliente.getLoginAPIService();
        usuario_id = getIntent().getIntExtra("usuario_id", -1);
        setup();
    }

    private void setup(){
        btnVolverE = findViewById(R.id.btnVolverE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //NO SIRVEEEEEEE
        service.obtenerHistorial("Bearer "+ Token.token, usuario_id).enqueue(new Callback<List<ObtenerReportes>>() {
            @Override
            public void onResponse(Call<List<ObtenerReportes>> call, Response<List<ObtenerReportes>> response) {
                List<ObtenerReportes> reportes = response.body();
                Log.d("PRUEBA", String.valueOf(reportes));
            }

            @Override
            public void onFailure(Call<List<ObtenerReportes>> call, Throwable t) {
                Toast.makeText(HistorialEstudiante.this,
                        "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btnVolverE(View view) {
        onBackPressed();
    }
}