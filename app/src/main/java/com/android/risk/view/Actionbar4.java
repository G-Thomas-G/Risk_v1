package com.android.risk.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Actionbar4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar4);
    }

    public void next(View view) {
        Intent myIntent = new Intent(Actionbar4.this, Actionbar5.class);
        Actionbar4.this.startActivity(myIntent);
    }
}
