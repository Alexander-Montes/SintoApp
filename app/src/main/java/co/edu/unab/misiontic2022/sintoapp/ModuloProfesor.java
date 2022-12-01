package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerDocente;
import co.edu.unab.misiontic2022.sintoapp.entity.Token;
import co.edu.unab.misiontic2022.sintoapp.network.LoginAPICliente;
import co.edu.unab.misiontic2022.sintoapp.network.LoginAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModuloProfesor extends AppCompatActivity {
    private Spinner listaVerCursos;
    Button btnHistorialP;
    Button btnSintomasP;
    private LoginAPIService service;
    private long user_id;
    private TextView txtNombreP;
    private TextView txtApellidoP;
    private TextView txtProfesion;
    private TextView txtEstadoP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_profesor);
        service = LoginAPICliente.getLoginAPIService();
        user_id = getIntent().getIntExtra("usuario_id", -1);
        setup();
    }

    private void setup() {
        listaVerCursos = findViewById(R.id.listaVerCursos);
        btnHistorialP = findViewById(R.id.btnHistorialP);
        btnSintomasP = findViewById(R.id.btnSintomasP);
        txtNombreP = findViewById(R.id.txtNombreP);
        txtApellidoP = findViewById(R.id.txtApellidoP);
        txtProfesion = findViewById(R.id.txtProfesion);
        txtEstadoP = findViewById(R.id.txtEstadoP);

        String[] cursos = new String[]{"Ver cursos", "Grupo 43", "Grupo 106"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                ModuloProfesor.this, android.R.layout.simple_spinner_dropdown_item, cursos);
        listaVerCursos.setAdapter(adapter);
        listaVerCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).toString().equals("Grupo 106")) {
                    Intent intent = new Intent(ModuloProfesor.this, ListaEstudiantes.class);
                    startActivity(intent);
                } else if (adapterView.getItemAtPosition(i).toString().equals("Grupo 43")) {
                    Intent intent = new Intent(ModuloProfesor.this, ListaEstudiantes.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void btnHistorialP (View view) {
        Intent intent = new Intent(ModuloProfesor.this, HistorialProfesor.class);
        startActivity(intent);
    }

    public void btnSintomasP (View view) {
        Intent intent = new Intent(ModuloProfesor.this, ReporteSintomas.class);
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
                Toast.makeText(ModuloProfesor.this,
                        "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mostrarDatos(ObtenerDocente obdocente) {
        txtNombreP.setText(String.valueOf(obdocente.getNombres()));
        txtApellidoP.setText(String.valueOf(obdocente.getApellidos()));
        txtProfesion.setText(String.valueOf(obdocente.getProfesion()));
        if ((obdocente.getEstado()) == 0){
            txtEstadoP.setText(String.valueOf("Estado: No habilitado"));
        } else {
            txtEstadoP.setText(String.valueOf("Estado: Habilitado"));
        }
    }
}