package co.edu.unab.misiontic2022.sintoapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

@SuppressLint("CustomSplashScreen")
public class PantallaCarga extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(PantallaCarga.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
