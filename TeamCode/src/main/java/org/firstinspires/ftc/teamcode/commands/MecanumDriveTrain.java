package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.Gyro;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class MecanumDriveTrain extends CommandBase {

    private final DriveTrain m_DriveTrain;

    private final Gyro gyro;

    private final DoubleSupplier forward, strafe, turn;

    private final Telemetry telemetry;

    public static boolean state = false;

    public MecanumDriveTrain(DriveTrain m_DriveTrain,
                             Gyro gyro, DoubleSupplier forward, DoubleSupplier strafe, DoubleSupplier turn,
                             Telemetry telemetry) {
        this.m_DriveTrain = m_DriveTrain;
        this.gyro = gyro;

        this.forward = forward;
        this.strafe = strafe;
        this.turn = turn;

        this.telemetry = telemetry;

        addRequirements(m_DriveTrain, gyro);
    }

    @Override
    public void execute() {

        if(state){
            m_DriveTrain.driveFieldCentric(strafe.getAsDouble(), forward.getAsDouble(), turn.getAsDouble(), gyro.getAngle());
            telemetry.addLine()
                    .addData("Field Centric", "");

        }else{
            m_DriveTrain.driveRobotCentric(strafe.getAsDouble(), forward.getAsDouble(), turn.getAsDouble());
            telemetry.addLine()
                    .addData("Robot Centric", "");

        }

        telemetry.addLine().addData("Angle", gyro.getAngle());


        telemetry.update();

    }


    @Override
    public boolean isFinished() {
        return false;
    }


    @Override
    public void end(boolean interuppted){
        m_DriveTrain.stop();
    }

}