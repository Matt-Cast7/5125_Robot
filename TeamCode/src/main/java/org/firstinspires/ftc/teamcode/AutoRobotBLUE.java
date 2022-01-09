package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.mode.Auto;


@Autonomous(name="AutoRobotBLUE")
public class AutoRobotBLUE extends CommandOpMode {

    public Telemetry a_telemetry;

    private RobotContainer m_robotcontainer;

    @Override
    public void initialize(){
        this.a_telemetry = super.telemetry;

        m_robotcontainer = new RobotContainer(hardwareMap, Auto.AUTONOMOUS, false);

        m_robotcontainer.getBlueAuto().schedule();

    }

    
}
