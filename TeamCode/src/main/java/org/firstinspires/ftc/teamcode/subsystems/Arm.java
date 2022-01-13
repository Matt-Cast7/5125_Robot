package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.Constants.Ka;
import static org.firstinspires.ftc.teamcode.Constants.kCos;
import static org.firstinspires.ftc.teamcode.Constants.kS;
import static org.firstinspires.ftc.teamcode.Constants.kV;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ArmFeedforward;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.Constants;

@Config
public class Arm extends SubsystemBase {

    private CRServo m_horizontal;
    private MotorEx m_vertical;
    private CRServo m_feeder;

    private ArmFeedforward feedforward;

    final boolean flipHorizontal = false;
    final boolean flipVertical = false;
    final boolean flipFeeder = false;


    public Arm(final HardwareMap hwMap){

        m_horizontal = new CRServo(hwMap, "horizontal");
        m_vertical = new MotorEx(hwMap, "vertical");

        m_vertical.setRunMode(Motor.RunMode.PositionControl);

        m_feeder = new CRServo(hwMap, "feeder");

        m_horizontal.setInverted(flipHorizontal);
        m_vertical.setInverted(flipVertical);
        m_feeder.setInverted(flipFeeder);

        m_horizontal.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        m_vertical.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);


        feedforward = new ArmFeedforward(kS, kCos, kV, Ka);


    }


    public void setHorizontal(double power){
        m_horizontal.set(power);

    }

    public void setVertical(int position){
        m_vertical.setTargetPosition((int)feedforward.calculate(position, 1, 1));
    }

    public int getVerticalPosition(){
        return m_vertical.getCurrentPosition();
    }

    public void setFeeder(double power){
        m_feeder.set(power);
    }

    public void stop(){
        m_horizontal.set(0);
        m_vertical.set(0);
        m_feeder.set(0);
    }


}
