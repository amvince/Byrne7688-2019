/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
// import frc.robot.commands.ArmDown;
import frc.robot.RobotMap;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX m_talon = new WPI_TalonSRX(5);
  DoubleSolenoid ds = new DoubleSolenoid(RobotMap.PN_SOLENOID_AF, RobotMap.PN_SOLENOID_AR);
  Compressor c = new Compressor(RobotMap.PN_COMPRESSOR);
  DigitalInput reverseLimit = new DigitalInput(0);

  public void forward(double m_speed) {
    m_talon.set(m_speed);
  }

  public boolean isLimit() {
    return reverseLimit.get();
  }
  public void stop() {
    m_talon.set(0.0);
  }

  public void extend() {
    ds.set(DoubleSolenoid.Value.kForward);
  }

  public void retract() {
    ds.set(DoubleSolenoid.Value.kReverse);
  }

  public void off() {
    ds.set(DoubleSolenoid.Value.kOff);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new ArmDown());
  }
}
