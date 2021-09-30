package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

public class DriveMode extends CommandBase {

    public DriveMode(){

    }

    @Override
    public void execute() {
        TankDrive.state = !TankDrive.state;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
