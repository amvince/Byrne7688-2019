package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ArmUp extends Command {

  public ArmUp() {
    requires(Robot.m_arm);
  }

  @Override
  protected void initialize() {
    if (Robot.m_arm.isLimit()) { 
      Robot.m_arm.reverse();;
    }
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return !Robot.m_arm.isLimit();
  }

  @Override
  protected void end() {
    Robot.m_arm.stop();
  }

  @Override
  protected void interrupted() {
    end();  }
}
