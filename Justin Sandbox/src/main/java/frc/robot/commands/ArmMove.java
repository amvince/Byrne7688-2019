/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;


public class ArmMove extends Command 
{
  private Timer timer = new Timer();


  private int chosenDirection;  //1 = Forward, 2 = Backwards

  private double durationSeconds;


  public ArmMove(int direction_, double durationSeconds_) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    chosenDirection = direction_;
    durationSeconds = durationSeconds_;


    requires(Robot.arm);
  }


// Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    timer.reset();
    timer.start();  
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    if(chosenDirection == RobotMap.ARM_DIRECTION_FORWARD)
    {
      Robot.arm.moveArm(RobotMap.ARM_MOTOR_SPEED);
    }
    else if(chosenDirection == RobotMap.ARM_DIRECTION_BACKWARD)
    {
      Robot.arm.moveArm(-RobotMap.ARM_MOTOR_SPEED);
    }
    else
    {
      System.out.println("ERROR: Invalid turn direction, ArmMove");
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(timer.get() > durationSeconds)
    {
      return true;
    }

    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.arm.stopArm();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    System.out.println("Interrupted: ArmMove");
  }
}
