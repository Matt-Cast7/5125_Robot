package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.commands.Warehouse;
import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;

@Autonomous(name="AutoRobot")
public class AutoRobot extends CommandOpMode {

    private Command warehouse;
    private DriveTrain driveTrain;


    @Override
    public void initialize(){
        driveTrain = new DriveTrain(hardwareMap);
        warehouse = new Warehouse(driveTrain);
        warehouse.schedule();

    }





//    @Override
//    public void runOpMode() throws InterruptedException {
//        super.runOpMode();
//        waitForStart();
//
//
//
//    }
}
