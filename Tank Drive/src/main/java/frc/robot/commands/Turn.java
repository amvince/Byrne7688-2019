/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Turn extends Command {

  double lastPosition;
  double P=0.05, I=0.2, D = 0; // Try P=.5K, I=.5K/Time of Oscillation
  double integral, targetAngle, previous_error, error = 0;
  double rcw;

  public Turn() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
    this.targetAngle = 90;
  }

  public Turn(double targetAngle) {
    requires(Robot.drivetrain);
    this.targetAngle = targetAngle;
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drivetrain.m_gyro.calibrate();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double gyroAngle = Robot.drivetrain.m_gyro.getAngle()%360;
    // double speedFactor = 0;
    this.error = (targetAngle - gyroAngle);
    this.integral += (this.error*.02);
    double derivative = (this.error - this.previous_error) / 0.02;
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
    Robot.drivetrain.arcadeDrive(0,this.rcw);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (this.error-this.previous_error)==0;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.m_gyro.reset();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
