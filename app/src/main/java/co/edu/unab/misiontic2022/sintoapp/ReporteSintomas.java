package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.edu.unab.misiontic2022.sintoapp.network.APICliente;
import co.edu.unab.misiontic2022.sintoapp.network.APIService;

public class ReporteSintomas extends AppCompatActivity {
    Button btnEnviar;
    private APIService service;
    private int usuario_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_sintomas);
        service = APICliente.getAPIService();
        usuario_id = getIntent().getIntExtra("usuario_id", -1);
        update();
    }

    private void update(){
        btnEnviar = findViewById(R.id.btnEnviar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //NO ENTENDI COMO ENVIAR EL REPORTE DESDE SU RESPECTIVO USUARIO CON ID
        //service.enviarReporte("Bearer "+ Token.token, usuario_id, );
    }

    public void btnEnviar(View view){
        finish();
    }
}