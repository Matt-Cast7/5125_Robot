package org.firstinspires.ftc.teamcode;

public class Vector2D {

    public double x;
    public double y;

    public double theta;
    public float magnitude;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
        this.theta = (Math.atan2(y, x) * 180 / Math.PI);
        if(this.theta < 0){
            this.theta = 360.0 - (-this.theta);
        }
        this.magnitude = (float)Math.sqrt((x * x) + (y * y));

    }


    public Vector2D(double theta, float magnitude){
        this.theta = theta;
        this.magnitude = magnitude;

        this.x = magnitude * (double)Math.cos(this.theta);
        this.y = magnitude * (double)Math.sin(this.theta);

    }

    public void update(double x, double y){
        this.x = x;
        this.y = y;
        this.theta = (Math.atan2(y, x) * 180 / Math.PI);
        if(this.theta < 0){
            this.theta = 360.0 - (-this.theta);
        }
        this.magnitude = (float)Math.sqrt((x * x) + (y * y));
    }

    public void update(double theta, float magnitude){
        this.theta = theta;
        this.magnitude = magnitude;

        this.x = magnitude * (double)Math.cos(this.theta);
        this.y = magnitude * (double)Math.sin(this.theta);
    }





}
