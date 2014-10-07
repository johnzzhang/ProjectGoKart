
package com.nutrons.practice;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    Joystick driverPad = new Joystick(RobotMap.DRIVER_PAD);
    
    public double getLeftJoystick() {
        return driverPad.getRawAxis(2);
    }
    
    public double getRightJoystick() {
        return driverPad.getRawAxis(4);
    }
}

