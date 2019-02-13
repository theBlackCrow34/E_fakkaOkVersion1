package com.example.sherif.e_fakkaokversion1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sherif.e_fakkaokversion1.Models.User;
import com.example.sherif.e_fakkaokversion1.Networking.RetrofitClient;
import com.example.sherif.e_fakkaokversion1.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private Button button;
    private AutoCompleteTextView username;
    private AutoCompleteTextView password;
    public static String type = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.signin_really);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_ = username.getText().toString().trim();
                String password_ = password.getText().toString().trim();

                if(username_.isEmpty())
                {
                    username.setError("User name is required");
                    username.requestFocus();
                    return;
                }
                if(password_.isEmpty())
                {
                    password.setError("Password is required");
                    password.requestFocus();
                    return;
                }

                final ProgressBar progressBar = findViewById(R.id.progress);
                if(type.equals("User"))
                {
                    progressBar.setVisibility(View.VISIBLE);
                    Call<ResponseBody> UserLogin = RetrofitClient
                            .getInstance()
                            .getApi()
                            .loguser(username_ , password_);

                    UserLogin.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            progressBar.setVisibility(View.GONE);

                            try {
                                JSONObject jsonObject = new JSONObject(response.body().toString());
                                JSONObject user = jsonObject.getJSONObject("user");

                                Toast.makeText(username.getContext(),jsonObject.toString(),Toast.LENGTH_LONG).show();
                                Toast.makeText(username.getContext(),response.message(),Toast.LENGTH_SHORT).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                Toast.makeText(username.getContext(),response.body().string(),Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(username.getContext(),t.toString(),Toast.LENGTH_LONG).show();

                        }
                    });

                }else if(type.equals("Branch"))
                {

                }else if(type.equals("Vendor"))
                {
                    Call<ResponseBody> UserLogin = RetrofitClient
                            .getInstance()
                            .getApi()
                            .logVendor(username_ , password_);

                }
            }
        });
    }
}
