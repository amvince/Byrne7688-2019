/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
 
/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem 
{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final static Compressor Compressor_ = new Compressor(RobotMap.PNEUMATICS_COMPRESSOR_PORT);

  private DoubleSolenoid armSolenoid_ = null;

  public Pneumatics()
  {
    armSolenoid_ = new DoubleSolenoid(RobotMap.PENUMATICS_SOLENOID_1_FORWARD_PORT, RobotMap.PENUMATICS_SOLENOID_1_REVERSE_PORT);
  }

  public Pneumatics()
  {
    armSolenoid_ = new     
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }   
}
