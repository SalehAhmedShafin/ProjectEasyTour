package com.example.easytour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText eadd,passw;
    private TextView btn;
    private ProgressBar progBer;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn=findViewById(R.id.forgetPassword);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
        eadd = (EditText) findViewById(R.id.editTextEmail);
        passw = (EditText) findViewById(R.id.editTextPassword);
        progBer = (ProgressBar) findViewById(R.id.progBer);
        btn=findViewById(R.id.signin);
        mAuth=FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });
    }

    private void checkUser() {

        String email=eadd.getText().toString().trim();
        String pass=passw.getText().toString().trim();

        if(email.isEmpty())
        {
            eadd.setError("Email is required");
            eadd.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            eadd.setError("Please provide Valid Email");
            eadd.requestFocus();
            return;
        }
        if(pass.isEmpty())
        {
            passw.setError("Password is required");
            passw.requestFocus();
            return;
        }
        if(pass.length()<6)
        {
            passw.setError("Password must be more than 6 character");
            passw.requestFocus();
            return;
        }

        progBer.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(LoginActivity.this,"Log in Successfully!",Toast.LENGTH_LONG).show();
                    progBer.setVisibility(View.GONE);
                    openDialog();
                }
                else {
                    Toast.makeText(LoginActivity.this,"Log in Failed!Try again",Toast.LENGTH_LONG).show();
                    progBer.setVisibility(View.GONE);
                }

            }

        });

    }

    public void openDialog() {

        WhatsNew whatsNew=new WhatsNew();
        whatsNew.show(getSupportFragmentManager(),"What's New Dialog");
    }

}