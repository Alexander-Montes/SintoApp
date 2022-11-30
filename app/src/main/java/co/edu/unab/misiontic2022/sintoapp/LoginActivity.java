package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import co.edu.unab.misiontic2022.sintoapp.entity.ObtenerDocente;
import co.edu.unab.misiontic2022.sintoapp.entity.Reporte;
import co.edu.unab.misiontic2022.sintoapp.entity.Token;
import co.edu.unab.misiontic2022.sintoapp.entity.RespuestaLogin;
import co.edu.unab.misiontic2022.sintoapp.network.LoginAPICliente;
import co.edu.unab.misiontic2022.sintoapp.network.LoginAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private LoginAPIService service;
    private LoginAPIService service2;
    private EditText txtEmail;
    private EditText txtPass;
    private int user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = LoginAPICliente.getLoginAPIService();
        service2 = LoginAPICliente.getLoginAPIService();
        user_id = getIntent().getIntExtra("user_id", -1);
        setup();
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        service2.obtenerHistorial("Bearer"+Token.token, user_id).enqueue(new Callback<List<Reporte>>() {
            @Override
            public void onResponse(Call<List<Reporte>> call, Response<List<Reporte>> response) {
                List<Reporte> reportes = response.body();
                Log.d("APIREST", String.valueOf(reportes));
            }

            @Override
            public void onFailure(Call<List<Reporte>> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    private void setup() {
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
    }

    public void btnLogin(View view){
        String email = txtEmail.getText().toString();
        String clave = txtPass.getText().toString();

        if (TextUtils.isEmpty(email)||TextUtils.isEmpty(clave)) {
            Toast.makeText(this, "Datos Incompletos", Toast.LENGTH_SHORT).show();
            if (TextUtils.isEmpty(email)){
                txtEmail.setError("Campo Requerido");
                txtEmail.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(clave)){
                txtPass.setError("Campo Requerido");
                txtPass.requestFocus();
                return;
            }
        } else {
            service.login(txtEmail.getText().toString(),txtPass.getText().toString()).enqueue(new Callback<RespuestaLogin>() {
                @Override
                public void onResponse(Call<RespuestaLogin> call, Response<RespuestaLogin> response) {
                    if (response.isSuccessful()){
                        RespuestaLogin respuesta = response.body();
                        Token.token = respuesta.getToken();
                        if (respuesta.getDocente_id()!=-1){
                            Intent intent = new Intent(LoginActivity.this, ModuloProfesor.class);
                            intent.putExtra("usuario_id", respuesta.getDocente_id());
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(LoginActivity.this, ModuloEstudiante.class);
                            intent.putExtra("usuario_id", respuesta.getEstudiante_id());
                            startActivity(intent);
                        }
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<RespuestaLogin> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Error="+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            service.obtenerDocente("Bearer"+Token.token, user_id).enqueue(new Callback<ObtenerDocente>() {
                @Override
                public void onResponse(Call<ObtenerDocente> call, Response<ObtenerDocente> response) {
                    ObtenerDocente doc = response.body();
                    Log.d("APIREST", String.valueOf(doc));
                }

                @Override
                public void onFailure(Call<ObtenerDocente> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Error"+t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}