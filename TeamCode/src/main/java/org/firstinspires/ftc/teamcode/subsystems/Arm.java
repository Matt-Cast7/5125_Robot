package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.Constants.Ka;
import static org.firstinspires.ftc.teamcode.Constants.kCos;
import static org.firstinspires.ftc.teamcode.Constants.kS;
import static org.firstinspires.ftc.teamcode.Constants.kV;
import static org.firstinspires.ftc.teamcode.Constants.m_power;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ArmFeedforward;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

@Config
public class Arm extends SubsystemBase {

    private ServoEx m_horizontal;
    private MotorEx m_vertical;
    private CRServo m_feeder;

    private ArmFeedforward feedforward;

    final boolean flipHorizontal = true;
    final boolean flipVertical = true;
    final boolean flipFeeder = false;

    Telemetry telemetry;


    public Arm(final HardwareMap hwMap, Telemetry telemetry){
        this.telemetry = telemetry;

        m_horizontal = new SimpleServo(hwMap, "horizontal", 0, 2755);
        m_vertical = new MotorEx(hwMap, "vertical");

        m_feeder = new CRServo(hwMap, "feeder");

        m_horizontal.setInverted(flipHorizontal);
        m_vertical.setInverted(flipVertical);
        m_feeder.setInverted(flipFeeder);


        m_vertical.setRunMode(Motor.RunMode.RawPower);

        m_vertical.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        m_vertical.resetEncoder();


    }



    @Override
    public void periodic() {
        telemetry.addLine().addData("Vertical Position", m_vertical.getCurrentPosition());
        //m_vertical.set(m_power);
        telemetry.addLine().addData("Horizontal angle", m_horizontal.getAngle());
    }

    public void setHorizontal(double angle){

        m_horizontal.rotateByAngle(angle);
//

    }

    public void setVertical(double angle){
        //double targetAngle = (((m_vertical.getCurrentPosition()/(double)Constants.CPR)*360)+angle+22.2)+180;
        //telemetry.addLine().addData("Target Angle", targetAngle);

        //ouble val = feedforward.calculate(Math.toRadians(targetAngle), 0.5, 1);
        //telemetry.addLine().addData("Feedforward Value", val);

        //m_vertical.set(val);

        if(angle == 0){

        }else{
            //m_vertical.setTargetPosition(m_vertical.getCurrentPosition()+(int)angle);
        }

        double val = Range.clip((0.22 + angle), 0, 0.70);

        m_vertical.set(val);


        //m_vertical.set(((double)position)/100);
    }

    public int getVerticalPosition(){
        return m_vertical.getCurrentPosition();
    }

    public void setFeeder(double power){
        m_feeder.set(power);
    }

    public void stop(){
        m_vertical.set(0);
        m_feeder.set(0);
    }


}
