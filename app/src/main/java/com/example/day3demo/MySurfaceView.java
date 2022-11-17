package com.example.day3demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
// GOES THROUGH THE CONTROLLER
// 5: ***** Need to link this class to the SurfaceView layout element
// ******** In the XML file, so that it knows to use this more specific
// ******** version of a SurfaceView

// 1: Create a subclass of SurfaceView in order to draw my own things
public class MySurfaceView extends SurfaceView
        implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, View.OnTouchListener {

    private MonopolyState.Token token;

    private Spot theBigBlueSpot;
    private Spot theBigRedSpot;
    private SeekBar seekBar;
    private TextView circleProgressTxt;
    private Paint imgPaint;
    private boolean blazeVal = true;
    private int blazeX, blazeY = 50;
    private ArrayList<Spot> spots;


   // private TextView progressText;


    public MySurfaceView(Context context, AttributeSet attrs)
    {
        super(context, attrs); // Call parent constructor
        // 2: Enable drawing
        setWillNotDraw(false);
        // 3: Setup any required member variables
        theBigRedSpot = new Spot(255, 0, 0); // this is at (50,50) and red
        theBigRedSpot.setCenters(500,500);
        theBigBlueSpot = new Spot(0, 0, 255);
        theBigBlueSpot.setCenters(500,500);
        // progressText.setText("Progress");
        // progressText = _progressText;
        imgPaint = new Paint();
        imgPaint.setColor(Color.BLACK);
        spots = new ArrayList<>();


    }

    // 4: Tell the view what to draw/how to draw
    protected void onDraw(Canvas canvas)
    {
        // DO NOT, if at all possible, ALLOCATE ANYTHING IN THE DRAW METHOD
        // (memory use optimization)
        // This method could run 100+ times per second
        theBigRedSpot.draw(canvas);
        theBigBlueSpot.draw(canvas);

        if (blazeVal)
        {
            Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.blaze);
            canvas.drawBitmap(image, blazeX, blazeY, imgPaint);
        }

        for(Spot s : spots)
        {
            s.draw(canvas);
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
      //  progressText.setText(""+progress);
        theBigRedSpot.setRadius(progress);
        theBigRedSpot.setA(progress);
        theBigBlueSpot.setRadius(500-progress);
        theBigBlueSpot.setA(500-progress);
        blazeX = blazeY = progress;
        invalidate();       // TELL the surface view (this) that the old view
                            // is no longer valid so it should redraw at its
                            // earliest convenience

        circleProgressTxt.setText(""+progress);


        // int currentColor = bkg.setBackgroundColor();
        //String opacity = Integer.toHexString(progress);
        // bkg.setBackgroundColor();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void setCircleProgressTxt(TextView txt){
        circleProgressTxt = txt;
    }


    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.blaze)
        {
            if (blazeVal)
            {
                blazeVal = false;
            }
            else {
                blazeVal = true;
            }
            invalidate();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        //spots.add(new Spot());
        // Check that it was the first tap
        if(event.getActionMasked() == MotionEvent.ACTION_DOWN)
        {
            // Get the tap location
            float x = event.getX();
            float y = event.getY();
            Random rand = new Random();

            // step 1, create the new spot
            Spot touchSpot = new Spot((int) rand.nextInt(255), (int)rand.nextInt(255), (int)rand.nextInt(255));
            //Spot touchSpot = new Spot(0, 255, 0);

            // step 2, make sure it knows where to draw
            touchSpot.setCenters(x,y);

            // step 3, add this new spot to list of spots
            spots.add(touchSpot);

            // step 4, tell to update/draw again soon
            invalidate();

            return true; // "Consumed" the event
        }


        return false; // In this case we didn't do anything
    }




}
