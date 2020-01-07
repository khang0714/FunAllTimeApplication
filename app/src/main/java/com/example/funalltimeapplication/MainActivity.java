package com.example.funalltimeapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.funalltimeapplication.Login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginFragment fragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.firstLayout, fragment).commit();

    }
}
