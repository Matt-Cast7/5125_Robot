package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.commands.TankDrive;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.Gyro;

@TeleOp(name = "TeleRobot")
public class TeleRobot extends CommandOpMode {

    private GamepadEx joy1;

    private DriveTrain m_DriveTrain;
    private Gyro gyro;

    private Command teleOp;

    @Override
    public void initialize(){
        joy1 = new GamepadEx(gamepad1);

        gyro = new Gyro(hardwareMap);
        m_DriveTrain = new DriveTrain(hardwareMap);

        teleOp = new TankDrive(
                m_DriveTrain,
                gyro,
                joy1::getLeftY,
                joy1::getLeftX,
                joy1::getRightX,
                () -> joy1.getButton(GamepadKeys.Button.START));

        register(m_DriveTrain);
        m_DriveTrain.setDefaultCommand(teleOp);

    }
}
