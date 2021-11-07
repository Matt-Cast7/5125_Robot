package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Gyro;

public class ResetAngle extends CommandBase {

    private Gyro gyro;

    public ResetAngle(Gyro gyro){
        this.gyro = gyro;
    }

    @Override
    public void execute() {
        gyro.resetAngle();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
