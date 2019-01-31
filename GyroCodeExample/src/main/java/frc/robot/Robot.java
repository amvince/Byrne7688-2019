/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a sample program to demonstrate how to use a gyro sensor to make a
 * robot drive straight. This program uses a joystick to drive forwards and
 * backwards while the gyro is used for direction keeping.
 */
public class Robot extends TimedRobot {
  
  ADXRS450_Gyro m_gyro = new ADXRS450_Gyro();
  private static final int kJoystickPort = 0;
  private static final int kLeftMotorPort = 1, kRightMotorPort = 3;
  private final DifferentialDrive m_myRobot
      = new DifferentialDrive(new WPI_VictorSPX(kLeftMotorPort),
      new WPI_VictorSPX(kRightMotorPort)); 
  private final Joystick m_joystick = new Joystick(kJoystickPort);
  

  @Override
  public void robotInit() {
   m_gyro.calibrate();
  }

  /**
   * The motor speed is set from the joystick while the RobotDrive turning
   * value is assigned from the error between the setpoint and the gyro angle.
   */
  @Override
  public void teleopInit() {
  }
  
   @Override
  public void teleopPeriodic() {

    turnToFace(90);
    
  }

  private void turnToFace(double targetAngle) {
    double gyroAngle = m_gyro.getAngle()%360;
    double speedFactor = 0;
    double turningValue = (targetAngle - gyroAngle);

    System.out.println("Pointing: "+ gyroAngle + " Correction: "+turningValue);

    if (turningValue > 1) { speedFactor = Math.min(1.0, turningValue/5);
    } else if (turningValue < -1) { speedFactor = -Math.min(1.0, -turningValue/5); }
    else {speedFactor = 0.0; }

    m_myRobot.tankDrive(0.5 * speedFactor, -0.5 * speedFactor);
  }
  
}
