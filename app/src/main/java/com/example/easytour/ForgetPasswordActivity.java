package com.example.easytour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {
    Button btn,btnRe;
    private EditText editText,nameUser;
    private ProgressBar processber;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        btn=findViewById(R.id.fsignIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgetPasswordActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        editText=(EditText) findViewById(R.id.mail);
        nameUser=(EditText) findViewById(R.id.nUser);
        btnRe=(Button) findViewById(R.id.rePass);
        processber = (ProgressBar) findViewById(R.id.proBer);
        mAuth=FirebaseAuth.getInstance();
        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }

    private void resetPassword() {
        String users=nameUser.getText().toString().trim();
        String email=editText.getText().toString().trim();
        if(users.isEmpty())
        {
            nameUser.setError("User Name is required");
            nameUser.requestFocus();
            return;
        }

        if(email.isEmpty())
        {
            editText.setError("Email is required");
            editText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editText.setError("Please provide Valid Email");
            editText.requestFocus();
            return;
        }
        processber.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(ForgetPasswordActivity.this,"Check Your email and Reset password!",Toast.LENGTH_LONG).show();
                    processber.setVisibility(View.GONE);

                }
                else {
                    Toast.makeText(ForgetPasswordActivity.this,"Mail send Failed! Try again!",Toast.LENGTH_LONG).show();
                    processber.setVisibility(View.GONE);
                }


            }
        });
    }
}