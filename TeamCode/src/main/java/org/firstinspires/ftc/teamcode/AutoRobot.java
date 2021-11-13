package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.Warehouse;
import org.firstinspires.ftc.teamcode.mode.Auto;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;


@Autonomous(name="AutoRobot")
public class AutoRobot extends CommandOpMode {

    public Telemetry a_telemetry;

    private RobotContainer m_robotcontainer;

    @Override
    public void initialize(){
        this.a_telemetry = super.telemetry;

        m_robotcontainer = new RobotContainer(hardwareMap, Auto.AUTONOMOUS);

        m_robotcontainer.getAutoCommand().schedule();

    }

    
}
