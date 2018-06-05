package com.android.risk.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by alex on 22.04.18.
 */

public class GameActivity extends AppCompatActivity {


    /**
     * getting called on obj. creation, ow. def.
     *
     * @param savedInstanceState test
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_game);


    }

    @Override
    protected void onResume() {      //func getting called on resumption of the app, overwrites default
        super.onResume();
        //hides navbar, statusbar, changes layout, shows tooltip
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }

    @Override                       //getting called on press of system-backbttn, overwrites default
    public void onBackPressed() {

    }

    public void next1() {

        ViewFlipper vf = (ViewFlipper) findViewById(R.id.vf);
        vf.setDisplayedChild(1);
    }

    public void next2() {

        ViewFlipper vf = (ViewFlipper) findViewById(R.id.vf);
        vf.setDisplayedChild(2);
    }


}
