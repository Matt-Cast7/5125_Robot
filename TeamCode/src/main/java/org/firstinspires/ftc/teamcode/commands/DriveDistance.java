package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

public class DriveDistance extends CommandBase {

    private DriveTrain driveTrain;

    public DriveDistance(DriveTrain driveTrain){
        this.driveTrain = driveTrain;
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }
}
