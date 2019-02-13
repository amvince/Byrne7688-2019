/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lifter extends Subsystem {
  private DoubleSolenoid ds = new DoubleSolenoid(RobotMap.PN_SOLENOID_LD, RobotMap.PN_SOLENOID_LU);

  public void extend() {
    ds.set(Value.kForward);
  }

  public void retract() {
    ds.set(Value.kReverse);
  }

  public void off() {
    ds.set(Value.kOff);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
