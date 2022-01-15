package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LEDS {

    static Servo leds;


    public void init(HardwareMap hwMap){
        leds = hwMap.get(Servo.class, "leds");
    }

    public void set(double val){
        leds.setPosition(val);
    }

}
