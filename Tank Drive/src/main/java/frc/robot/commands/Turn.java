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
  double P=0.02, I=0.006, D = 0.0; // Try P=.5K, I=.5K/Time of Oscillation
  double integral, targetAngle, previous_error, error = 0;
  double rcw, gyroAngle;
  int counter=0;

  public Turn() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
    /* this.targetAngle = 90;
    Robot.drivetrain.m_gyro.reset();
    this.integral=0; */
    reset(90);
  }

  public Turn(double targetAngle) {
    reset(targetAngle);

  }
  private void reset(double targetAngle) {
    Robot.drivetrain.m_gyro.reset();
    this.targetAngle = targetAngle;
    this.integral=0;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    this.gyroAngle = Robot.drivetrain.m_gyro.getAngle()%360;
    // double speedFactor = 0;
    this.error = (this.targetAngle - this.gyroAngle);
    this.integral += (this.error*.02);
    double derivative = (this.error - this.previous_error) / 0.02;
    this.rcw = P*error + I * this.integral + D*derivative;
    System.out.println("Pointing: "+ gyroAngle + " Correction: "+this.error);
    System.out.println(" Integral: "+this.integral + " Derivative: "+derivative);
    
    System.out.println("RCW: "+this.rcw);
    /* 
    if (this.rcw > .6) { this.rcw = Math.min(.6, this.rcw/2);
    } else if (this.rcw < -1) { this.rcw = -Math.min(.6, this.rcw/2); }
    else {speedFactor = 0.0; }
    */ 
    
    Timer.delay(0.004);
    if (this.rcw > 0.6) this.rcw = 0.6;
    if (this.rcw < -0.6) this.rcw = -.6;
    this.previous_error = this.error;
    Robot.drivetrain.arcadeDrive(0,this.rcw);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //if (Math.abs(this.error) < 0.4) {counter++} 
    //else counter=0;
    counter += (Math.abs(this.error)<5) ? 1 : -counter;
    return (counter>20);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.m_gyro.reset();
    Robot.drivetrain.arcadeDrive(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
