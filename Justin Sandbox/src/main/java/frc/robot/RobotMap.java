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
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;


  //Drivetrain Constants
    //Used Parts
      public static final int DRIVETRAIN_LEFT_FRONT = 1;
      public static final int DRIVETRAIN_LEFT_REAR = 2;
      public static final int DRIVETRAIN_RIGHT_FRONT = 3;
      public static final int DRIVETRAIN_RIGHT_REAR = 4;

    //Control
      public static final int DRIVETRAIN_MODE_MANUAL = 1;
      public static final int DRIVETRAIN_MODE_JOYSTICK = 2;

    //Control
      public static final double DRIVETRAIN_MOTOR_SPEED = -0.4; //-0.4
      //public static final double DRIVETRAIN_MOTOR_SPEED = -1.0; //FOR MEMES 

      //Turning
        public static final int DRIVETRAIN_TURN_DIRECTION_COUNTERCLOCKWISE = 1; //Left
        public static final int DRIVETRAIN_TURN_DIRECTION_CLOCKWISE = 2; //Right

        public static final double DRIVETRAIN_TURN_90DEG_DURATION = 1.52;
        public static final double DRIVETRAIN_TURN_90DEG_SPEED = -0.4; //-0.4
        
        //public static final double DRIVETRAIN_TURN_90DEG_SPEED = -1.0; // FOR MEMES

  //Joystick Constants
    //Used Parts
      public static final int OI_DRIVER_CONTROLLER = 0;

    //Analog
      public static final int OI_LEFT_STICK_Y = 5;
      public static final int OI_LEFT_STICK_X = 4;
      public static final int OI_RIGHT_STICK_Y = 1;

    //Buttons
      public static final int OI_BUTTON_X = 3;
      public static final int OI_BUTTON_Y = 4;
      public static final int OI_BUTTON_A = 1;
      public static final int OI_BUTTON_B = 2;

      public static final int OI_BUTTON_SHOULDER_L = 5;
      public static final int OI_BUTTON_SHOULDER_R = 6;
    
  //Arm Constants
    //Used Parts
      public static final int ARM_MOTOR_PORT = 5;

    //Control
      public static final int ARM_MOTOR_SPEED = 1;

      public static final int ARM_DIRECTION_FORWARD = 1;
      public static final int ARM_DIRECTION_BACKWARD = 2;


  
  //Ultrasonic Sensor Constants
    public static final int ULTRASONIC_SENSOR = 0;  //Analog Input



  //Gyroscope Constants
    //Parts Used
    public static final int GYROSCOPE_PORT = 0;

    //


  //Pneumatics Constants
    //Parts Used
    public static final int PNEUMATICS_COMPRESSOR_PORT = 0;
    public static final int PENUMATICS_SOLENOID_1_FORWARD_PORT = 0;
    public static final int PENUMATICS_SOLENOID_1_REVERSE_PORT = 1;

    //control
    
    
}
