package com.android.risk.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.android.risk.R;

public class Actionbar1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar1);
    }


    public void next(View view) {
        GameActivity aRef = new GameActivity();
        aRef.next2();

    }
}
