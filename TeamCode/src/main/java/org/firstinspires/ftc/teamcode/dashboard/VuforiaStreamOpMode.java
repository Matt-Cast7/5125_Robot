package org.firstinspires.ftc.teamcode.dashboard;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.teamcode.R;

/*
 * This sample demonstrates how to stream frames from Vuforia to the dashboard. Make sure to fill in
 * your Vuforia key below and select the 'Camera' preset on top right of the dashboard. This sample
 * also works for UVCs with slight adjustments.
 */
@Autonomous
public class VuforiaStreamOpMode extends LinearOpMode {

    // TODO: fill in
    public static final String VUFORIA_LICENSE_KEY = "AZBvjMn/////AAABmRvYg913S0qkoqmflyByhqNFdXTx3qKoESecl4WUW48rfFU3+SbkiiwTz1ovvubWWso3VHkgS48l06bCCHmuTeHWxlyxqeW8Se4vxH0cOr6kN+BbwCZKoabRjoy246WjNWdFPKsFJf76rgXlSaeDbP7lRPEPOV3ScYym/IFxdTEMsUpwAjIEJ3arGmtaa42mkYUBeyBI9JuD1r+Yly8REAumac0fTu6UzYSd2/Fu905T38l8SSt47z72cQJrgOmNIuzzniAPJfWVnC9Wi/3o2PVQM041Ix84afgscOtERO3j0Yq/ut+VduwCu8AkV3efWt0V0pDNeTB0+meG879l5+hw0QHTQtMUTOJAMSUpUbq6";

    @Override
    public void runOpMode() throws InterruptedException {
        // gives Vuforia more time to exit before the watchdog notices
        msStuckDetectStop = 2500;

        VuforiaLocalizer.Parameters vuforiaParams = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        vuforiaParams.vuforiaLicenseKey = VUFORIA_LICENSE_KEY;
        vuforiaParams.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;


        VuforiaLocalizer vuforia = ClassFactory.getInstance().createVuforia(vuforiaParams);

        FtcDashboard.getInstance().startCameraStream(vuforia, 30);

        waitForStart();

        while (opModeIsActive());
    }
}