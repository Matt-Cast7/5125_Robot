package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class ParkRed extends CommandBase {

    private SampleMecanumDrive drive;
    private Trajectory traj1;
    private Trajectory traj2;

    public ParkRed(SampleMecanumDrive drive){
        this.drive = drive;
    }

    @Override
    public void initialize() {
        traj1 = drive.trajectoryBuilder(new Pose2d()).forward(16).build();

        traj2 = drive.trajectoryBuilder(new Pose2d()).strafeRight(24).build();
    }

    @Override
    public void execute() {
        traj1.start();

        traj2.start();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
