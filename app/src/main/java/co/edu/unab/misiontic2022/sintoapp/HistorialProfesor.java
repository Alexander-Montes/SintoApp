package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import co.edu.unab.misiontic2022.sintoapp.adapters.HistorialAdapter;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerReportes;
import co.edu.unab.misiontic2022.sintoapp.entity.Token;
import co.edu.unab.misiontic2022.sintoapp.network.APICliente;
import co.edu.unab.misiontic2022.sintoapp.network.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistorialProfesor extends AppCompatActivity {
    Button btnVolverP;
    private APIService service;
    private int usuario_id;
    private ListView listaHistorialP;
    private TextView txtFecha;
    private TextView txtR1;
    private TextView txtR2;
    private TextView txtR3;
    private TextView txtR4;
    private TextView txtR5;
    private TextView txtREstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_profesor);
        service = APICliente.getAPIService();
        usuario_id = getIntent().getIntExtra("usuario_id", -1);
        setup();
    }

    private void setup(){
        btnVolverP = findViewById(R.id.btnVolverP);
        listaHistorialP = findViewById(R.id.listaHistorialP);
        txtFecha = findViewById(R.id.txtFecha);
        txtR1 = findViewById(R.id.txtR1);
        txtR2 = findViewById(R.id.txtR2);
        txtR3 = findViewById(R.id.txtR3);
        txtR4 = findViewById(R.id.txtR4);
        txtR5 = findViewById(R.id.txtR5);
        txtREstado = findViewById(R.id.txtREstado);
    }

    @Override
    protected void onStart() {
        super.onStart();
        service.obtenerHistorial("Bearer "+ Token.token, usuario_id).enqueue(new Callback<List<ObtenerReportes>>() {
            @Override
            public void onResponse(Call<List<ObtenerReportes>> call, Response<List<ObtenerReportes>> response) {
                List<ObtenerReportes> reportes = response.body();
                cargarLista(reportes);
            }

            @Override
            public void onFailure(Call<List<ObtenerReportes>> call, Throwable t) {
                Toast.makeText(HistorialProfesor.this,
                        "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarLista(List<ObtenerReportes> reportes) {
        HistorialAdapter adapter = new HistorialAdapter(HistorialProfesor.this, reportes);
        listaHistorialP.setAdapter(adapter);

        //PORBAR CAMBIAR LO QUE SE MUESTRA//

        /*txtFecha.setText(String.valueOf(reportes));
        txtR1.setText(String.valueOf(reportes));
        txtR2.setText(String.valueOf(reportes));
        txtR3.setText(String.valueOf(reportes));
        txtR4.setText(String.valueOf(reportes));
        txtR5.setText(String.valueOf(reportes));
        txtREstado.setText(String.valueOf(reportes));*/
    }

    public void btnVolverP(View view) {
        onBackPressed();
    }
}