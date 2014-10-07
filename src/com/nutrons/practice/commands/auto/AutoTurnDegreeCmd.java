/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutrons.practice.commands.auto;

import com.nutrons.practice.commands.CommandBase;

/**
 *
 * @author John
 */
public class AutoTurnDegreeCmd extends CommandBase {
    
    double targetAngle;
    double speed;
    boolean turnRight;
    double epsilon = 1;
    double k = 1;
    
    public AutoTurnDegreeCmd(double degree) {
        requires(dt);
        this.targetAngle = degree;
        this.speed = .2;
        turnRight = true;
    }
    
    public AutoTurnDegreeCmd(double degree, double speed) {
        requires(dt);
        this.targetAngle = degree;
        this.speed = speed;
        turnRight = true;
    }
    
    public AutoTurnDegreeCmd(double degree, double speed, boolean turnRight) {
        requires(dt);
        this.targetAngle = degree;
        this.speed = speed;
        this.turnRight = turnRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        dt.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Current Angle: "  + dt.getAngle() + " Speed: " + speed);
        speed = k*(targetAngle - Math.floor(dt.getAngle()))/targetAngle;
        if(turnRight) {
            dt.driveLR(speed, -speed);
        } else {
            dt.driveLR(-speed, speed);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(dt.getAngle() - targetAngle) < epsilon;
    }

    // Called once after isFinished returns true
    protected void end() {
        dt.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
