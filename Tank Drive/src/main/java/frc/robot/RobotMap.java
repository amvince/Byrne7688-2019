/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // Drivetrain Constants for CAN Victors
  public static final int DRIVETRAIN_LEFT_FRONT = 1;
  public static final int DRIVETRAIN_LEFT_REAR = 2;
  public static final int DRIVETRAIN_RIGHT_FRONT = 3;
  public static final int DRIVETRAIN_RIGHT_REAR = 4;

  // Drivetrain Constant for speed (0 to 1)
  public static final double MOTOR_SPEED = 1;

  // Pneumatics Constants
  public static final int PN_COMPRESSOR = 0;
  public static final int PN_SOLENOID_AF = 1;
  public static final int PN_SOLENOID_AR = 2;

  // Joystick Constants
public static final int OI_DRIVER_CONTROLLER = 0;
public static final int OI_LEFT_STICK_Y = 5;
public static final int OI_LEFT_STICK_X = 4;
public static final int OI_RIGHT_STICK_Y = 1;
public static final int OI_BUTTON_X = 3;
public static final int OI_BUTTON_Y = 4;
public static final int OI_BUTTON_A = 1;
public static final int OI_BUTTON_B = 2;
  
  // Arm Map Constants
  public static final int ARM_CONTROLLER = 5;
  // As the Arm Actuator will be the only Pneumatic, it is
  // by default defined as the Pneumatic solenoid.
}
