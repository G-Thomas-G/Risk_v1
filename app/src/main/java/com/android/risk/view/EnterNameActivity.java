package com.android.risk.view;

import android.os.Bundle;
import android.widget.ViewFlipper;

import com.android.risk.R;

import androidx.appcompat.app.AppCompatActivity;

public class EnterNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.name_enter);


        ViewFlipper vf = findViewById(R.id.vf);
        vf.setDisplayedChild(vf.indexOfChild(findViewById(R.id.include1)));


    }
}
