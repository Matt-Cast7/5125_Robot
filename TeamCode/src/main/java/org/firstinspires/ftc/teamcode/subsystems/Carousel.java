package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.function.DoubleSupplier;

public class Carousel extends SubsystemBase {

    private MotorEx carousel;

    public Carousel(HardwareMap hwMap) {
        carousel = new MotorEx(hwMap, "carousel");
        carousel.setInverted(true);
        //carousel.setRunMode(Motor.RunMode.VelocityControl);

    }

    public void spin(boolean red) {
        if(red){
            carousel.set(0.2);
        }else{
            carousel.set(-0.2);
        }
    }

    public void spin(DoubleSupplier rtrigger, DoubleSupplier ltrigger) {

        carousel.set(rtrigger.getAsDouble() - ltrigger.getAsDouble());
    }

    public void set(double power) {
    carousel.set(0);
}

}
