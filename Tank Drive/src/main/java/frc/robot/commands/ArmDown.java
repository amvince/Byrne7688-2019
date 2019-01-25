package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ArmDown extends Command {

  public ArmDown() {
    requires(Robot.m_arm);
  }

  @Override
  protected void initialize() {
     {
    Robot.m_arm.forward(1);
    }
  }

  @Override
  protected void execute() {
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.m_arm.stop();
  }

  @Override
  protected void interrupted() {
    end();  }
}
