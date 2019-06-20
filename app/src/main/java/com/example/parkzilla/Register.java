package com.example.parkzilla;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=findViewById(R.id.useremailreg);
        password=findViewById(R.id.userpassreg);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void btn_registerclick(View view){

        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(Register.this, "Registration Successfully.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Register.this,Login.class);
                    startActivity(i);
                } else {
                  //  Loge("Error",task.getException().toString());
                    Toast.makeText(Register.this, "Registeration failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}