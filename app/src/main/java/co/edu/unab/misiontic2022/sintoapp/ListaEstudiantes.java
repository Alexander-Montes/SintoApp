package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

public class ListaEstudiantes extends AppCompatActivity {
    Button btnVolverLista;
    private APIService service;
    private int user_id;
    private ListView listaCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);
        service = APICliente.getAPIService();
        user_id = getIntent().getIntExtra("usuario_id", -1);
        setup();
    }

    private void setup(){
        btnVolverLista = findViewById(R.id.btnVolverLista);
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
                Toast.makeText(ListaEstudiantes.this,"Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarLista(List<ObtenerCursos> cursos){
        //CursosAdapter adapter = new CursosAdapter(ListaEstudiantes.this, cursos);
        //listaCursos.setAdapter(adapter);
        ArrayAdapter adapter = new ArrayAdapter<>(ListaEstudiantes.this, android.R.layout.simple_list_item_1, cursos);
        listaCursos.setAdapter(adapter);
    }

    public void btnVolverLista(View view){
        onBackPressed();
    }
}