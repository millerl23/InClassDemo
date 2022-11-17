package com.example.day3demo;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;
// THIS DOES THE LISTENING
public class ViewController
        implements View.OnClickListener {

    private TextView helloText;

    private int numClicks;
    private LinearLayout bkg;

    public ViewController(TextView _helloText, LinearLayout _bkg){
        helloText = _helloText;
        numClicks = 0;

        bkg = _bkg;
    }


    @Override
    public void onClick(View v) {
        numClicks += 1;
        if(v.getId() == R.id.goodbyeButton) {
            helloText.setText("Goodbye... (This is click " + numClicks + ")");
        }
        else {
            helloText.setText("Hello! (This is click " + numClicks + ")");
        }
    }


}
