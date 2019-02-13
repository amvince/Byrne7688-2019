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
import edu.wpi.first.wpilibj.Timer;
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
  
  double lastPosition;
  double P=0.05, I=0.2, D = 0; // Try P=.5K, I=.5K/Time of Oscillation
  double integral, setPoint, previous_error = 0;
  double rcw;

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

    turnToFace(0);
    
  }

  private void turnToFace(int targetAngle) {
    this.setPoint = targetAngle;
    double gyroAngle = m_gyro.getAngle()%360;
    // double speedFactor = 0;
    double error = (targetAngle - gyroAngle);

    this.integral += (error*.02);
    double derivative = (error - this.previous_error) / 0.02;
    this.rcw = P*error + I * this.integral + D*derivative;

    System.out.println("Pointing: "+ gyroAngle + " Correction: "+error);
    System.out.println("RCW: "+this.rcw);
    /* 
    if (error > 1) { speedFactor = Math.min(1.0, error/5);
    } else if (error < -1) { speedFactor = -Math.min(1.0, -error/5); }
    else {speedFactor = 0.0; }
    */ 
    Timer.delay(0.004);
    // this.previous_error = gyroAngle;
    m_myRobot.arcadeDrive(0,this.rcw);
    // m_myRobot.tankDrive(0.5 * speedFactor, -0.5 * speedFactor);
  }
  
}
