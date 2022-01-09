package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotContainer;
import org.firstinspires.ftc.teamcode.mode.Auto;

@Autonomous(name="ParkRed")
public class ParkRed extends CommandOpMode {

    public Telemetry a_telemetry;

    private RobotContainer m_robotcontainer;

    @Override
    public void initialize() {
        this.a_telemetry = super.telemetry;

        m_robotcontainer = new RobotContainer(hardwareMap, Auto.AUTONOMOUS, true);

        m_robotcontainer.getParkRed().schedule();
    }


}
