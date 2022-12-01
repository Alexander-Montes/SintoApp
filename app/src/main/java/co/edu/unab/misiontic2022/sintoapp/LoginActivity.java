package co.edu.unab.misiontic2022.sintoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.unab.misiontic2022.sintoapp.entity.Token;
import co.edu.unab.misiontic2022.sintoapp.entity.RespuestaLogin;
import co.edu.unab.misiontic2022.sintoapp.network.LoginAPICliente;
import co.edu.unab.misiontic2022.sintoapp.network.LoginAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private LoginAPIService service;
    private EditText txtEmail;
    private EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = LoginAPICliente.getLoginAPIService();
        setup();
    }

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
        }
    }
}