/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutrons.practice.commands.drivetrain;

import com.nutrons.practice.commands.CommandBase;

/**
 *
 * @author John
 */
public class TankDriveCmd extends CommandBase {

    public TankDriveCmd() {
        requires(dt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        dt.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        dt.driveLR(oi.getLeftJoystick(), oi.getRightJoystick());
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
