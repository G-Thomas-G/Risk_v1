package com.android.risk.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Actionbar3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar3);
    }

    public void next(View view) {
        Intent myIntent = new Intent(Actionbar3.this, Actionbar4.class);
        Actionbar3.this.startActivity(myIntent);
    }
}
