package com.example.sherif.e_fakkaokversion1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sherif.e_fakkaokversion1.R;

public class MainActivity extends AppCompatActivity {
    private Button sign_in;
    private Button sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign_in = (Button) findViewById(R.id.signin);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
        sign_up = (Button) findViewById(R.id.signup);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });





    }
}
