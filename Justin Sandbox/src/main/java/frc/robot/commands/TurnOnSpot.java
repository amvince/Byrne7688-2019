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



public class TurnOnSpot extends Command {

  private int chosenDirection;
  private double durationSeconds;
  private double speed;

  private Timer timer = new Timer();

  public TurnOnSpot(int direction_, double durationSeconds_, double speed_)
  {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    chosenDirection = direction_;
    durationSeconds = durationSeconds_;
    speed = speed_;

    requires(Robot.drivetrain);
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
    if(chosenDirection == RobotMap.DRIVETRAIN_TURN_DIRECTION_CLOCKWISE)  //Left
    {
      Robot.drivetrain.tankDrive(-speed, speed);
    }
    else if(chosenDirection == RobotMap.DRIVETRAIN_TURN_DIRECTION_COUNTERCLOCKWISE) //right
    {
      Robot.drivetrain.tankDrive(speed, -speed);
    }
    else
    {
      System.out.println("ERROR: Invalid turn direction, TurnOnSpot");
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
    Robot.drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
    System.out.println("Interrupted: TurnOnSpot");
  }
}
