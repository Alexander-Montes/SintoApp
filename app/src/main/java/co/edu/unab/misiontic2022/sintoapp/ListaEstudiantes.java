    package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerLista;
import co.edu.unab.misiontic2022.sintoapp.entity.Token;
import co.edu.unab.misiontic2022.sintoapp.network.APICliente;
import co.edu.unab.misiontic2022.sintoapp.network.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class ListaEstudiantes extends AppCompatActivity {
    Button btnVolverLista;
    private APIService service;
    private int curso_id;
    private int user_id;
    private ListView listaEstudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);
        service = APICliente.getAPIService();
        user_id = getIntent().getIntExtra("usuario_id", -1);
        curso_id = getIntent().getIntExtra("curso_id", -1);
        setup();
    }

    private void setup(){
        btnVolverLista = findViewById(R.id.btnVolverLista);
        listaEstudiantes = findViewById(R.id.listaEstudiantes);
    }

    @Override
    protected void onStart() {
        super.onStart();
        service.obtenerLista("Bearer "+ Token.token, user_id, curso_id).enqueue(new Callback<List<ObtenerLista>>() {
            @Override
            public void onResponse(Call<List<ObtenerLista>> call, Response<List<ObtenerLista>> response) {
                List<ObtenerLista> obLista = response.body();
                cargarLista(obLista);
            }

            @Override
            public void onFailure(Call<List<ObtenerLista>> call, Throwable t) {
                Toast.makeText(ListaEstudiantes.this,"Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarLista(List<ObtenerLista> obLista){
        ArrayAdapter adapter = new ArrayAdapter(ListaEstudiantes.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, obLista);
        listaEstudiantes.setAdapter(adapter);
    }

    public void btnVolverLista(View view) {
        onBackPressed();
    }
}