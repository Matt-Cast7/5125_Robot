package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.mode.Tele;

@TeleOp(name = "TeleRobot")
public class TeleRobot extends CommandOpMode {

    public static Telemetry t_telemetry;

    public static GamepadEx joy1;
    public static GamepadEx joy2;


    private RobotContainer m_robotcontainer;


    @Override
    public void initialize(){
        this.t_telemetry = super.telemetry;

        joy1 = new GamepadEx(gamepad1);
        joy2 = new GamepadEx(gamepad2);


        m_robotcontainer = new RobotContainer(hardwareMap, Tele.TELEOP);

        m_robotcontainer.getTeleOpCommands().schedule();




    }

}
