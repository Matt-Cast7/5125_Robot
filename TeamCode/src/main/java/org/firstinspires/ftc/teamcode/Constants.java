package org.firstinspires.ftc.teamcode;


public class Constants {

    public static double CPR = 1120;
    public static double RPM = 160;

    public static double diameter = 3.779528;
    public static double circumfrence = Math.PI*(diameter);


    public static int inchesToTicks(double inches){
        return (int)((inches/circumfrence)*(1/(16.0/32.0))*(double)CPR);
    }

}
