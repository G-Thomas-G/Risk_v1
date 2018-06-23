package com.android.risk.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.android.risk.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class Actionbar1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar1);

        //Dialog
        //set onclicklistener
        findViewById(R.id.dest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //init Dialog
                final androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(Actionbar1.this);

                //title
                builder.setTitle("Select Dest");

                //init Array
                final String[] countries = new String[]{
                        "Germany",
                        "Russia",
                        "Italy",
                        "Swiss"
                };

                //set choice
                builder.setSingleChoiceItems(
                        countries,
                        -1, //none=-1
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String selectedItem = Arrays.asList(countries).get(i);

                                //displ. on snackbar
                                Snackbar.make(
                                        findViewById(R.id.ac1l),
                                        "checked : " + selectedItem,
                                        Snackbar.LENGTH_INDEFINITE
                                ).show();
                            }
                        }
                );
                //builder.setPositiveButton()
                //bit.ly/2t5iH9U
            }
        });


    }

    public void dest(View v) {
        System.out.print("Test");
    }

}
