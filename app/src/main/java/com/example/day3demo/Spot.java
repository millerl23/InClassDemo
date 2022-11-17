package com.example.day3demo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/* This class represents a circle that can
    be drawn on a canvas
 */
public class Spot {
    // private float x, y;
    private float centers[];
    private float radius;
    private Paint color;

    public Spot()
    {
        centers = new float[2];
        centers[0] = centers[1] = 50;
        // x = y = 50;
        radius = 50;
        color = new Paint();
        color.setARGB(255,255,0,0);
    }
    /*
        // Normal constructor looks like this:
        Spot aSpot = new Spot();
        // Duplication requires a COPY Constructor
        Spot duplicateSpot = new Spot(aSpot);
        duplicateSpot.setRandomColor(); // Only changes the color of duplicateSpot
        Spot bSpot = aSpot; // This gives me a second reference to the
                            // original aSpot.
        bSpot.setRandomColor(); // Change color of aSpot (also known as bSpot)

     */
    public Spot(Spot other)
    {
        // Goal of a copy constructor is to copy all of the data from the other
        // object into THIS object. (This object is a NEW one)
        // NEED AT LEAST AS MANY 'NEW'S AS WERE IN THE ORIGINAL CONSTRUCTOR

        // this.x = other.x ;
        // this.y = other.y;
        // First create NEW container, then copy each into the new container
        centers = new float[2]; // Exact line from default constructor
        for ( int i = 0; i < centers.length; i++)
        {
            // If the original item is an Object that was allocated Anywhere
            // with a NEW, this must also create a NEW Object... but floats are
            // primitive so no need here.
            centers[i] = other.centers[i]; // Okay because primitive
        }

        this.radius = other.radius;
        // this.color = other.color; // This is called a Shallow Copy... no no
        this.color = new Paint(other.color); // Paint is not a primitive type!!!
                                  // This is a deep copy. requires allocating new
                                  // memory just like we had to did in the normal
                                  // constructor.

    }

    public Spot(int R, int G, int B){
        centers = new float[2];
        centers[0] = centers[1] = 50;
        radius = 50;
        color = new Paint();
        color.setARGB(255,R,G,B);

    }

    public void draw(Canvas canvas){
        canvas.drawCircle(centers[0],centers[1],radius,color);
    }

    public void setRadius(float r)
    {
        if(r > 0)
        {
            radius = r;
        }

    }

    public void setCenters(float _x, float _y)
    {
        centers[0] = _x;
        centers[1] = _y;

    }

    public void setRandomColor(){


    }
    public void setA(int _alpha) {
        if (_alpha < 256) {
            color.setAlpha(_alpha);
        } else {
            color.setAlpha(500-_alpha);
        }


    }
}
