package com.example.day3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.SeekBar;
import android.widget.TextView;
// In Main, NEVER any new:
// button, text, seeks, surface, etc.
// setContentView call does that and adds
// everything from XML file
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView helloText = findViewById(R.id.helloText);
        TextView progressText = findViewById(R.id.progressText);
        helloText.setText("Lessgetit");

        // 1: find the views wanting to link to the viewController
        Button goodbyeButton = findViewById(R.id.goodbyeButton);
        Button helloButton = findViewById(R.id.helloButton);
        Button blazeButton = findViewById(R.id.blaze);
        SeekBar seekBar = findViewById(R.id.seekBar);
        LinearLayout bkg = findViewById(R.id.bkg);
        MySurfaceView surfaceView = findViewById(R.id.surfaceView);

        surfaceView.setCircleProgressTxt(progressText);
        surfaceView.setOnTouchListener(surfaceView);


        // 2: link the view to an action (listener)
        ViewController viewController = new ViewController(helloText, bkg);


        // 3: set listeners for various views
        goodbyeButton.setOnClickListener(viewController);
        helloButton.setOnClickListener(viewController);
        seekBar.setOnSeekBarChangeListener(surfaceView);
        blazeButton.setOnClickListener(surfaceView);
        // seekBar.setOnSeekBarChangeListener(surfaceView);





    }
}