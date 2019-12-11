package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/* import frc.robot.commands.ArmDown;
import frc.robot.commands.ArmSolenoid;
import frc.robot.commands.ArmUp;
import frc.robot.commands.Release;
import frc.robot.commands.ToggleSpeed; */

public class OI {
  
  public Joystick joystick = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
  Button buttonX = new JoystickButton(joystick, RobotMap.OI_BUTTON_X);
  Button buttonY = new JoystickButton(joystick, RobotMap.OI_BUTTON_Y);
  Button buttonA = new JoystickButton(joystick, RobotMap.OI_BUTTON_A);
  Button buttonB = new JoystickButton(joystick, RobotMap.OI_BUTTON_B);
  Button buttonT = new JoystickButton(joystick, RobotMap.OI_BUTTON_7);


  public OI() {
    // ArmUp and ArmDown map properly for Stick and Controller inputs
    //buttonX.whileHeld(new ArmDown());
    //buttonY.whileHeld(new ArmUp());
    
    // buttonA also maps to Trigger on Stick input
     //buttonA.whenPressed(new Release());
     
     //buttonT.whenPressed(new ToggleSpeed());
     /* TOOD: Add lifter buttons - but not for the rookie year
     buttonWHATEVER.whileHeld(new LiftSolenoid(1));
     buttonWHATEVER.whileHeld(new LiftSolenoid(-1));

     */
  }
}
