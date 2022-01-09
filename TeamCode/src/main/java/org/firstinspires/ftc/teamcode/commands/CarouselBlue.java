package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class CarouselBlue extends CommandBase {

    private SampleMecanumDrive drive;
    private Trajectory traj1;
    private Trajectory traj2;

    public CarouselBlue(SampleMecanumDrive drive){
        this.drive = drive;

    }

    @Override
    public void initialize() {
        traj1 = drive.trajectoryBuilder(new Pose2d()).strafeRight(2).build();
        traj2 = drive.trajectoryBuilder(new Pose2d()).back(16).build();

    }

    @Override
    public void execute() {
        drive.followTrajectory(traj1);
        drive.followTrajectory(traj2);

    }



    @Override
    public boolean isFinished() {
        return true;
    }
}
