/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArmSolenoid extends Command {
  private int dir;

  public ArmSolenoid(int dir) {
    requires(Robot.m_arm);
    this.dir = dir;

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    switch (dir) {
      case 1: Robot.m_arm.extend();
              break;
      case -1:  Robot.m_arm.retract();
              break;
      default: Robot.m_arm.off();
              break;
    }
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_arm.off();
  }
}
