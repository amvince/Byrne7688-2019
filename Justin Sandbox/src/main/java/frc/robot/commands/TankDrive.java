/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
//import frc.robot.subsystems.Drivetrain;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class TankDrive extends Command {

  private double leftSpeed;
  private double rightSpeed;

  private int chosenMode;

  public TankDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);

    chosenMode = 1;

    leftSpeed = Robot.m_oi.joystick.getRawAxis(1) * RobotMap.DRIVETRAIN_MOTOR_SPEED;
    rightSpeed = Robot.m_oi.joystick.getRawAxis(5) * RobotMap.DRIVETRAIN_MOTOR_SPEED;
  }


  public TankDrive(double leftSpeed_, double rightSpeed_)
  {
    requires(Robot.drivetrain);

    chosenMode = 2;

    leftSpeed = leftSpeed_;
    rightSpeed = rightSpeed_;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    if(chosenMode == 1)
    {
      Robot.drivetrain.tankDrive(Robot.m_oi.joystick.getRawAxis(1) * RobotMap.DRIVETRAIN_MOTOR_SPEED,
                                 Robot.m_oi.joystick.getRawAxis(5) * RobotMap.DRIVETRAIN_MOTOR_SPEED);
    }
    if(chosenMode == 2)
    {
      Robot.drivetrain.tankDrive(leftSpeed, rightSpeed);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
    Robot.drivetrain.tankDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
