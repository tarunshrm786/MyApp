package com.example.parkzilla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private TextView txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtemail = (TextView)findViewById(R.id.useremail);
        txtemail.setText(getIntent().getExtras().getString("Email"));
    }
}
