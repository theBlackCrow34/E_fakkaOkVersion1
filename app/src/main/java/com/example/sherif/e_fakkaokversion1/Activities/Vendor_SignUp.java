package com.example.sherif.e_fakkaokversion1.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sherif.e_fakkaokversion1.Networking.RetrofitClient;
import com.example.sherif.e_fakkaokversion1.R;

import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;


public class Vendor_SignUp extends Fragment {

    private AutoCompleteTextView name;
    private AutoCompleteTextView phone;
    private AutoCompleteTextView username;
    private AutoCompleteTextView password;
    private AutoCompleteTextView confirmpass;
    private AutoCompleteTextView email;
    private AutoCompleteTextView contact;
    private Spinner industry;
    private ImageView logo;
    private CheckBox terms;
    private Button upload;
    private Button signup;
    private  static final int RESULT_LOAD_IMAGE = 1;



    public Vendor_SignUp() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && data!=null){

            logo.setVisibility(View.VISIBLE);
            Uri selectImage = data.getData();
            logo.setImageURI(selectImage);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_vendor__sign_up, container, false);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        confirmpass = view.findViewById(R.id.confirmpass);
        email = view.findViewById(R.id.mail);
        contact = view.findViewById(R.id.contact);
        industry = view.findViewById(R.id.industry);
        logo = view.findViewById(R.id.logo);
        terms = view.findViewById(R.id.accept_terms);
        upload = view.findViewById(R.id.upload_logo);
        signup = view.findViewById(R.id.signup);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.industry_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        industry.setAdapter(adapter);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gellery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gellery,RESULT_LOAD_IMAGE);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String name_ = name.getText().toString().trim();
                String phone_ = phone.getText().toString().trim();
                String username_ = username.getText().toString().trim();
                String password_ = password.getText().toString().trim();
                String confirmpass_ = confirmpass.getText().toString().trim();
                String email_ = email.getText().toString().trim();
                String contact_ = contact.getText().toString().trim();
                String industry_ = industry.getSelectedItem().toString().trim();

                Bitmap image = ((BitmapDrawable) logo.getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                String encodeImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);

                if(name_.isEmpty())
                {
                    name.setError("Name Is Required");
                    name.requestFocus();
                    return;
                }
                if(phone_.isEmpty())
                {
                    phone.setError("phone Is Required");
                    phone.requestFocus();
                    return;
                }
                if(phone_.length() < 11 || phone_.length() > 11)
                {
                    phone.setError("phone Is in valid");
                    phone.requestFocus();
                    return;
                }
                if(username_.isEmpty())
                {
                    username.setError("username Is Required");
                    username.requestFocus();
                    return;
                }
                if(password_.isEmpty())
                {
                    password.setError("password Is Required");
                    password.requestFocus();
                    return;
                }
                if(confirmpass_.isEmpty())
                {
                    confirmpass.setError("confirm password Is Required");
                    confirmpass.requestFocus();
                    return;
                }
                if(!confirmpass_.equals(password_))
                {
                    confirmpass.setError("confirm password Is not match");
                    confirmpass.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email_).matches())
                {
                    email.setError("email Is not valid");
                    email.requestFocus();
                    return;
                }
                if(email_.isEmpty())
                {
                    email.setError("email Is required");
                    email.requestFocus();
                    return;
                }
                if(contact_.isEmpty())
                {
                    contact.setError("Name Is Required");
                    contact.requestFocus();
                    return;
                }

                if(!terms.isChecked())
                {
                    terms.setTextColor(R.color.red);
                    return;
                }

                final ProgressBar progressBar = view.findViewById(R.id.progress);
                Call<ResponseBody>  insertVendor = RetrofitClient
                        .getInstance()
                        .getApi()
                        .insertVendor(name_ ,phone_ ,email_ ,username_ ,password_ ,industry_ ,contact_ ,encodeImage);

                insertVendor.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(view.getContext(),response.toString(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(view.getContext(),t.toString(),Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
