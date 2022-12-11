package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import co.edu.unab.misiontic2022.sintoapp.adapters.CursosAdapter;
import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerCursos;
import co.edu.unab.misiontic2022.sintoapp.entity.Token;
import co.edu.unab.misiontic2022.sintoapp.network.APICliente;
import co.edu.unab.misiontic2022.sintoapp.network.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CursosAsignados extends AppCompatActivity {
    Button btnVolverCursos;
    private APIService service;
    private int user_id;
    private ListView listaCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos_asignados);
        service = APICliente.getAPIService();
        user_id = getIntent().getIntExtra("usuario_id", -1);
        setup();

        listaCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(CursosAsignados.this, ListaEstudiantes.class);
                startActivity(intent);
            }
        });
    }

    private void setup(){
        btnVolverCursos = findViewById(R.id.btnVolverCursos);
        listaCursos =findViewById(R.id.listaCursos);
    }

    @Override
    protected void onStart() {
        super.onStart();
        service.obtenerCursos("Bearer "+ Token.token, user_id).enqueue(new Callback<List<ObtenerCursos>>() {
            @Override
            public void onResponse(Call<List<ObtenerCursos>> call, Response<List<ObtenerCursos>> response) {
                List<ObtenerCursos> cursos = response.body();
                cargarLista(cursos);
            }

            @Override
            public void onFailure(Call<List<ObtenerCursos>> call, Throwable t) {
                Toast.makeText(CursosAsignados.this,"Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarLista(List<ObtenerCursos> cursos){
        CursosAdapter adapter = new CursosAdapter(CursosAsignados.this, cursos);
        listaCursos.setAdapter(adapter);
    }

    public void btnVolverCursos(View view){
        onBackPressed();
    }
}