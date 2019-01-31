/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * Add your docs here.
 */
public class Arm extends Subsystem {
  
  WPI_TalonSRX armMotor = new WPI_TalonSRX(RobotMap.ARM_MOTOR_PORT);

  
  public Arm()
  {


  }

  public void moveArm(double speed_)
  {
    armMotor.set(speed_ * RobotMap.ARM_MOTOR_SPEED);
  }

  public void stopArm()
  {
    armMotor.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
