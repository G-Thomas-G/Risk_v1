package com.android.risk.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.risk.R;

import androidx.appcompat.app.AppCompatActivity;

public class Actionbar2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar2);
    }

    public void next(View view) {
        Intent myIntent = new Intent(Actionbar2.this, Actionbar3.class);
        Actionbar2.this.startActivity(myIntent);
    }
}
