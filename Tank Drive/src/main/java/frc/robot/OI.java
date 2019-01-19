package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.commands.Release;
import frc.commands.SolenoidExtend;
import frc.commands.SolenoidOff;
import frc.commands.SolenoidRetract;


public class OI {

    public Joystick joystick = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
    public Button buttonX = new JoystickButton(joystick, RobotMap.OI_BUTTON_X);
    public Button buttonY = new JoystickButton(joystick, RobotMap.OI_BUTTON_Y);
    public Button buttonA = new JoystickButton(joystick, RobotMap.OI_BUTTON_A);
    public Button buttonB = new JoystickButton(joystick, RobotMap.OI_BUTTON_B);
    
    public OI() {
        buttonX.whenPressed(new SolenoidExtend());
        buttonX.whenReleased(new SolenoidOff());
        buttonY.whenPressed(new SolenoidRetract());
        buttonY.whenReleased(new SolenoidOff());
        buttonA.whenPressed(new Release());
    }
}