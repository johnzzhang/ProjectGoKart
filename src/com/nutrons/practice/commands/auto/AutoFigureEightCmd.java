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
public class AutoFigureEightCmd extends CommandBase {
    double targetAngle;
    double speedLeft;
    double speedRight;
    boolean loopOne = true;
    
    public AutoFigureEightCmd() {
        requires(dt);
        this.speedLeft = .5;
        this.speedRight = .05;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        dt.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Current Angle: "  + dt.getAngle() + " Left: " + speedLeft + " Right: " + speedRight);
        if(dt.getAngle() < 360 && loopOne) {
            speedLeft *= Math.abs((1-(dt.getAngle()/200000)));
            speedRight = speedLeft / 10.0;
        }
        if(dt.getAngle() > 0 && !loopOne) {
            speedRight *= Math.abs((1-(360-dt.getAngle())/200000));
            speedLeft = speedRight / 15.0;
        }
        
        if(dt.getAngle() > 360 && loopOne) {
            speedLeft = .05;
            speedRight = .75;
            loopOne = !loopOne;
        }
        if(dt.getAngle() < 0 && !loopOne) {
            speedLeft = .5;
            speedRight = .05;
            loopOne = !loopOne;
        }
        
        dt.driveLR(speedLeft, speedRight);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
