package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.systems.Drivetrain;


public class Robot extends TimedRobot {
  public static OI oi;
  public static Drivetrain drivetrain;

  @Override
  public void robotInit() {
    drivetrain = new Drivetrain();
    oi = new OI();
    CameraServer.getInstance().startAutomaticCapture();


  }

  @Override
  public void teleopPeriodic() {
    drivetrain.tankDrive(oi.joystick.getRawAxis(1), oi.joystick.getRawAxis(5));
  }
}
