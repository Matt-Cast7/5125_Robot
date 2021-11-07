package org.firstinspires.ftc.teamcode.dashboard;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DataManager {

    public static boolean streamdata = true;
    private FtcDashboard dashboard;
    private OpMode opMode;

    public DataManager(OpMode opMode){
        this.dashboard = FtcDashboard.getInstance();
        this.opMode = opMode;
        opMode.telemetry = dashboard.getTelemetry();
    }

    public void update(){
        if(streamdata){

            opMode.telemetry.update();


        }
    }

}
