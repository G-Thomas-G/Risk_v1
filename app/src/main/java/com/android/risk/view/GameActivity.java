package com.android.risk.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import com.android.risk.R;

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


        ViewFlipper vf = findViewById(R.id.vf);
        vf.setDisplayedChild(vf.indexOfChild(findViewById(R.id.include1)));


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
        Intent myIntent = new Intent(GameActivity.this, MainActivity.class);
        GameActivity.this.startActivity(myIntent);
    }

    public void next1(View v) {

        ViewFlipper vf = findViewById(R.id.vf);
        vf.setDisplayedChild(vf.indexOfChild(findViewById(R.id.include2)));
    }

    public void next2(View v) {

        ViewFlipper vf = findViewById(R.id.vf);
        vf.setDisplayedChild(vf.indexOfChild(findViewById(R.id.include3)));
    }

    public void dest(View v) {

    }

}
