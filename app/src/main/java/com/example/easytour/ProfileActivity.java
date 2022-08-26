package com.example.easytour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    FirebaseUser user;
    DatabaseReference reference;

    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference().child("Users");
        userID =user.getUid();

        final TextView greedingTextView=(TextView)findViewById(R.id.greeding);
        final TextView fullnameTextView=(TextView)findViewById(R.id.fullName);
        final TextView emailTextView=(TextView)findViewById(R.id.emailAddress);
        final TextView ageTextView=(TextView)findViewById(R.id.age);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User userProfile =snapshot.getValue(User.class);

                if (userProfile !=null){
                    String fullname=userProfile.fullname;
                    String email= userProfile.email;

                    greedingTextView.setText(fullname);
                    fullnameTextView.setText(fullname);
                    emailTextView.setText(email);
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

                Toast.makeText(getApplicationContext(),"Something Happen!",Toast.LENGTH_SHORT).show();

            }
        });

    }
}