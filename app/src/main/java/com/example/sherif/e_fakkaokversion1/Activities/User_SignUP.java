package com.example.sherif.e_fakkaokversion1.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sherif.e_fakkaokversion1.Networking.RetrofitClient;
import com.example.sherif.e_fakkaokversion1.R;

import java.io.ByteArrayOutputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class User_SignUP extends Fragment {

    private AutoCompleteTextView f_name;
    private AutoCompleteTextView l_name;
    private AutoCompleteTextView phone;
    private AutoCompleteTextView username;
    private AutoCompleteTextView password;
    private AutoCompleteTextView confirmpass;
    private AutoCompleteTextView email;
    private AutoCompleteTextView contact;
    private AutoCompleteTextView createdby;
    private ImageView logo;
    private ImageView facebook;
    private ImageView google;
    private Button upload;
    private Button signup;
    private CheckBox terms;
    private static  final int RESULT_LOAD_IMAGE = 1;

    public User_SignUP() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getContext(), "User sign up", Toast.LENGTH_SHORT).show();

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
        final View view = inflater.inflate(R.layout.fragment_user__sign_u, container, false);
        f_name = view.findViewById(R.id.firstname);
        l_name = view.findViewById(R.id.lastname);
        phone = view.findViewById(R.id.phone);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        confirmpass = view.findViewById(R.id.confirm_pass);
        email = view.findViewById(R.id.mail);
        contact = view.findViewById(R.id.contact);
        createdby = view.findViewById(R.id.created_by);
        logo = view.findViewById(R.id.photo);
        facebook = view.findViewById(R.id.facebook);
        google = view.findViewById(R.id.google);
        signup = view.findViewById(R.id.signup);
        terms = view.findViewById(R.id.accept_terms);
        upload = view.findViewById(R.id.upload_photo);

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
                String f_name_ = f_name.getText().toString().trim();
                String l_name_ = l_name.getText().toString().trim();
                String name_ = f_name_ + " " + l_name_;
                String phone_ = phone.getText().toString().trim();
                String username_ = username.getText().toString().trim();
                String password_ = password.getText().toString().trim();
                String confirmpass_ = confirmpass.getText().toString().trim();
                String email_ = email.getText().toString().trim();
                String contact_ = contact.getText().toString().trim();
                String createdby_ = createdby.getText().toString().trim();


                Bitmap image = ((BitmapDrawable) logo.getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                String encodeImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);

                if(f_name_.isEmpty())
                {
                    f_name.setError("First Name is required");
                    f_name.requestFocus();
                    return;
                }
                if(l_name_.isEmpty())
                {
                    l_name.setError("Last Name is required");
                    l_name.requestFocus();
                    return;
                }
                if(phone_.isEmpty())
                {
                    phone.setError("Phone is required");
                    phone.requestFocus();
                    return;
                }
                if(phone_.length() <11 ||phone_.length() > 11)
                {
                    phone.setError("Phone is invalid");
                    phone.requestFocus();
                    return;
                }
                if(username_.isEmpty())
                {
                    username.setError("username is required");
                    username.requestFocus();
                    return;
                }
                if(password_.isEmpty())
                {
                    password.setError("password is required");
                    password.requestFocus();
                    return;
                }
                if(confirmpass_.isEmpty())
                {
                    confirmpass.setError("Password is not match");
                    confirmpass.requestFocus();
                    return;
                }
                if(email_.isEmpty())
                {
                    email.setError("E-mail is required");
                    email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email_).matches())
                {
                    email.setError("E-mail is invalid");
                    email.requestFocus();
                    return;
                }
                if(contact_.isEmpty())
                {
                    contact.setError("First Name is required");
                    contact.requestFocus();
                    return;
                }

                if(!terms.isChecked())
                {
                    terms.setTextColor(R.color.red);
                    return;
                }

                final ProgressBar progressBar = view.findViewById(R.id.progress);
                progressBar.setVisibility(View.VISIBLE);

                Call<ResponseBody>  insertUser = RetrofitClient
                        .getInstance()
                        .getApi()
                        .insertuser(name_ ,phone_ ,username_ ,password_ ,email_ ,createdby_ , encodeImage);

                insertUser.enqueue(new Callback<ResponseBody>() {
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
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
