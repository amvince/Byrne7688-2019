package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import frc.systems.Arm;
import frc.systems.Drivetrain;
import frc.systems.Pneumatics;


public class Robot extends TimedRobot {
  public static OI oi;
  public static Drivetrain drivetrain;
  public static double m_speed = -1;
  public static Arm armAct;

  Command autonomousCommand;

  @Override
  public void robotInit() {
    drivetrain = new Drivetrain();
    oi = new OI();
    armAct = new Arm();

    CameraServer.getInstance().startAutomaticCapture();

  }

  @Override
  public void teleopPeriodic() {
    // Scheduler.getInstance().run();
     drivetrain.tankDrive(oi.joystick.getRawAxis(1)*m_speed, oi.joystick.getRawAxis(5)*m_speed);
  }

  @Override
  public void teleopInit() {
     if (autonomousCommand != null)
      autonomousCommand.cancel();
  }
}
