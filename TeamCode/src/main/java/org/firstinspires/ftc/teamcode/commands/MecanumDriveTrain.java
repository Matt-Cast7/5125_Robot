package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.Gyro;
import org.firstinspires.ftc.teamcode.subsystems.LEDS;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class MecanumDriveTrain extends CommandBase {

    private final DriveTrain m_DriveTrain;

    private final Gyro gyro;

    private final DoubleSupplier forward, strafe, turn;

    private final Telemetry telemetry;

    public static boolean state = false;


    /**
     *
     * @param m_DriveTrain drive train subsystem
     * @param forward forward values
     * @param strafe strafing values
     * @param turn turning values
     * @param telemetry telemetry object for telemetry
     */
    public MecanumDriveTrain(DriveTrain m_DriveTrain, Gyro gyro, DoubleSupplier forward, DoubleSupplier strafe, DoubleSupplier turn,
                             Telemetry telemetry) {
        this.m_DriveTrain = m_DriveTrain;
        this.gyro = gyro;


        this.forward = forward;
        this.strafe = strafe;
        this.turn = turn;

        this.telemetry = telemetry;

        addRequirements(m_DriveTrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {


        if(state){
            m_DriveTrain.driveFieldCentric(-strafe.getAsDouble(), -forward.getAsDouble(), turn.getAsDouble(), gyro.globalAngle);
            telemetry.addLine()
                    .addData("Field Centric", "");

        }else{
            m_DriveTrain.driveRobotCentric(-strafe.getAsDouble(), -forward.getAsDouble(), turn.getAsDouble());
            telemetry.addLine()
                    .addData("Robot Centric", "");

        }

        telemetry.addLine().addData("Angle", gyro.globalAngle);


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
