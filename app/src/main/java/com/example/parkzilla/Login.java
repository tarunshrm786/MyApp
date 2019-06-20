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

public class Login extends AppCompatActivity {

    private EditText emaillogin;
    private EditText passwordlogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emaillogin=findViewById(R.id.useremailreg);
        passwordlogin=findViewById(R.id.userpassreg);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void btn_loginclick(View view){

        firebaseAuth.signInWithEmailAndPassword(emaillogin.getText().toString(),passwordlogin.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(Login.this, "Login Successfully.", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Login.this, Home.class);
                    i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                    startActivity(i);
                } else {
                  //Log.e("Error", task.getException().toString());
                    Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
