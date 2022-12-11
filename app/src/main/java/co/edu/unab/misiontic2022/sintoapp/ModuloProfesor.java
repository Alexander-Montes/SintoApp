package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerDocente;
import co.edu.unab.misiontic2022.sintoapp.entity.Token;
import co.edu.unab.misiontic2022.sintoapp.network.APICliente;
import co.edu.unab.misiontic2022.sintoapp.network.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModuloProfesor extends AppCompatActivity {
    ImageButton btnCursos;
    Button btnHistorialP;
    Button btnSintomasP;
    private APIService service;
    private int user_id;
    private int usuario_id;
    private TextView txtNombreP;
    private TextView txtApellidoP;
    private TextView txtProfesion;
    private TextView txtEstadoP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_profesor);
        service = APICliente.getAPIService();
        user_id = getIntent().getIntExtra("usuario_id", -1);
        usuario_id = getIntent().getIntExtra("usuario_id",-1);
        setup();
    }

    private void setup() {
        btnCursos = findViewById(R.id.btnCursos);
        btnHistorialP = findViewById(R.id.btnHistorialP);
        btnSintomasP = findViewById(R.id.btnSintomasP);
        txtNombreP = findViewById(R.id.txtNombreP);
        txtApellidoP = findViewById(R.id.txtApellidoP);
        txtProfesion = findViewById(R.id.txtProfesion);
        txtEstadoP = findViewById(R.id.txtEstadoP);
    }

    public void btnHistorialP (View view) {
        Intent intent = new Intent(ModuloProfesor.this, HistorialProfesor.class);
        intent.putExtra("usuario_id", usuario_id);
        startActivity(intent);
    }

    public void btnSintomasP (View view) {
        Intent intent = new Intent(ModuloProfesor.this, ReporteSintomas.class);
        startActivity(intent);
    }

    public void btnCursos(View view){
        Intent intent = new Intent(ModuloProfesor.this, CursosAsignados.class);
        intent.putExtra("usuario_id", user_id);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        service.obtenerDocente("Bearer "+ Token.token, user_id).enqueue(new Callback<ObtenerDocente>() {
            @Override
            public void onResponse(Call<ObtenerDocente> call, Response<ObtenerDocente> response) {
                ObtenerDocente obdocente = response.body();
                mostrarDatos(obdocente);
            }

            @Override
            public void onFailure(Call<ObtenerDocente> call, Throwable t) {
                Toast.makeText(ModuloProfesor.this,"Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mostrarDatos(ObtenerDocente obdocente) {
        txtNombreP.setText(String.valueOf(obdocente.getNombres()));
        txtApellidoP.setText(String.valueOf(obdocente.getApellidos()));
        txtProfesion.setText(String.valueOf(obdocente.getProfesion()));
        if ((obdocente.getEstado()) == 0){
            txtEstadoP.setText(String.valueOf("No habilitado"));
        } else {
            txtEstadoP.setText(String.valueOf("Habilitado"));
        }
    }
}