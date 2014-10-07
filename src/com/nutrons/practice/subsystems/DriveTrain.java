
package com.nutrons.practice.subsystems;

import com.nutrons.practice.RobotMap;
import com.nutrons.practice.commands.drivetrain.TankDriveCmd;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drive Train Code
 */
public class DriveTrain extends Subsystem {
    
    // drive motors
    Victor leftMotor = new Victor(RobotMap.LEFT_MOTOR);
    Victor rightMotor = new Victor(RobotMap.RIGHT_MOTOR);
    Gyro gyro = new Gyro(RobotMap.GYRO);

    public void initDefaultCommand() {
        setDefaultCommand(new TankDriveCmd());
    }
    
    public void driveLR(double leftSpeed, double rightSpeed) {
        leftMotor.set(leftSpeed);
        rightMotor.set(rightSpeed);
    }
    
    public void stop() {
        leftMotor.set(0);
        rightMotor.set(0);
    }
    
    public void resetGyro() {
        gyro.reset();
    }
    
    public double getAngle() {
        return gyro.getAngle()+360.0;
    }
}

