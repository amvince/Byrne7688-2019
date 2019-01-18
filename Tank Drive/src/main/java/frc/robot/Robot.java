package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.systems.Arm;
import frc.systems.Drivetrain;


public class Robot extends TimedRobot {
  public static OI oi;
  public static Drivetrain drivetrain;
  public static double m_speed = -1;
  public static Arm arm = null;

  @Override
  public void robotInit() {
    drivetrain = new Drivetrain();
    oi = new OI();
    arm = new Arm();
    
    CameraServer.getInstance().startAutomaticCapture();

  }

  @Override
  public void teleopPeriodic() {
    drivetrain.tankDrive(oi.joystick.getRawAxis(1)*m_speed, oi.joystick.getRawAxis(5)*m_speed);
  }
}
