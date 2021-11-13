package org.firstinspires.ftc.teamcode;


import com.arcrobotics.ftclib.geometry.Vector2d;

public class Constants {

    public static double CPR = 1120;
    public static double RPM = 160;

    public static double diameter = 3.779528;
    public static double circumfrence = Math.PI*(diameter);

    public static double gearRatio = 16.0/32.0;

    public static double distancePerPulse = 0;


    public static int inchesToTicks(double inches){
        return (int)((inches/circumfrence)*(1/(16.0/32.0))*(double)CPR);
    }



    /**
     *
     * a = (x+y)/2, b = (-x+y)/2, VecA(a, a), VecB(-b, b)
     *
     * @param displacement
     * @return
     */
    public static Vector2d[] robotWheelVectors(Vector2d displacement){

        double a = ((double)displacement.getX() + (double)displacement.getY())/2.0;
        double b = (-(double)displacement.getX() + (double)displacement.getY())/2.0;

        Vector2d vecA = new Vector2d(a, a);
        Vector2d vecB = new Vector2d(-b, b);

        return new Vector2d[]{vecA, vecB};


    }

}
