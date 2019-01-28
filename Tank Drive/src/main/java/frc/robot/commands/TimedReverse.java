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

public class TimedReverse extends Command {
  private double d_time = 1.0;
  private Timer m_time;

  public TimedReverse() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_arm);
  }

  public TimedReverse(double time) {
    requires(Robot.m_arm);
    d_time = time;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_time = new Timer();
    Robot.m_arm.forward(-0.5);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return m_time.hasPeriodPassed(d_time);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_arm.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
