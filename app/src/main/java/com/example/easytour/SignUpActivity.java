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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    private Button btnsignup2;
    private ProgressBar processber;
    private EditText username2, eaddress, password,cPassword;
    private Button btn,btn_Resister;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn = findViewById(R.id.signin2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        username2 = (EditText) findViewById(R.id.username2);
        eaddress = (EditText) findViewById(R.id.eaddress);
        password = (EditText) findViewById(R.id.password);
        cPassword= (EditText) findViewById(R.id.confarmpassword);
        processber = (ProgressBar) findViewById(R.id.processber);
        btn_Resister = findViewById(R.id.btnsignup2);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null)
        {

        }

        btn_Resister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeruser();
            }
        });
    }



    private void registeruser() {

        String email=eaddress.getText().toString().trim();
        String username=username2.getText().toString().trim();
        String pass=password.getText().toString().trim();
        String conPass=cPassword.getText().toString().trim();
        if(username.isEmpty())
        {
            username2.setError("User Name is required");
            username2.requestFocus();
            return;
        }

        if(email.isEmpty())
        {
            eaddress.setError("Email is required");
            eaddress.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            eaddress.setError("Please provide Valid Email");
            eaddress.requestFocus();
            return;
        }
        if(pass.isEmpty())
        {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }
        if(pass.length()<6)
        {
            password.setError("Password must be more than 6 character");
            password.requestFocus();
            return;
        }
        if(!pass.equals(conPass))
        {
            password.setError("Password does not match");
            password.requestFocus();
            return;
        }

        processber.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    User user =new User(username,email);
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()) {

                                Toast.makeText(SignUpActivity.this,"Resister Successfully!",Toast.LENGTH_LONG).show();
                                processber.setVisibility(View.GONE);
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));

                            }
                            else{

                                Toast.makeText(SignUpActivity.this,"Resister Failed! Try again!",Toast.LENGTH_LONG).show();
                                processber.setVisibility(View.GONE);

                            }


                        }
                    });

                }
                else {
                    Toast.makeText(SignUpActivity.this,"Resister Failed! Try again!",Toast.LENGTH_LONG).show();
                    processber.setVisibility(View.GONE);
                }

            }
        });


    }
}

