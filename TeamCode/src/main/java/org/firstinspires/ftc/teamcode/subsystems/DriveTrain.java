package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Vector2D;

public class DriveTrain extends SubsystemBase {

    DcMotor L1;
    DcMotor L2;
    DcMotor R1;
    DcMotor R2;

    HardwareMap hwMap;

    public DriveTrain(final HardwareMap hwMap){

        L1 = hwMap.get(DcMotor.class, "L1");
        L2 = hwMap.get(DcMotor.class, "L2");
        R1 = hwMap.get(DcMotor.class, "R1");
        R2 = hwMap.get(DcMotor.class, "R2");

        R1.setDirection(DcMotorSimple.Direction.REVERSE);
        R2.setDirection(DcMotorSimple.Direction.REVERSE);


    }

    public void set(Vector2D vector){
        
    }

    public void set(double left, double right){
        L1.setPower(left);
        L2.setPower(left);
        R1.setPower(right);
        R2.setPower(right);
    }

    public void set(double left1, double left2, double right1, double right2){
        L1.setPower(left1);
        L2.setPower(left2);
        R1.setPower(right1);
        R2.setPower(right2);
    }

    public void set(double power){
        L1.setPower(-power);
        L2.setPower(power);

        R1.setPower(power);
        R2.setPower(-power);
    }

    public void strafe(double power){
        L1.setPower(-power);
        L2.setPower(power);

        R1.setPower(power);
        R2.setPower(-power);
    }


    @Override
    public void periodic() {

    }

}
