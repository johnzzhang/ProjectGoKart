/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nutrons.practice.commands.auto;

import com.nutrons.practice.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author John
 * Drives robot forward for number of seconds at speed.
 */
public class AutoDriveTimeCmd extends CommandBase {

    double time;
    double speed;
    Timer timer = new Timer();

    public AutoDriveTimeCmd(double time) {
        requires(dt);
        this.time = time;
        this.speed = .2;
    }
    
    public AutoDriveTimeCmd(double time, double speed) {
        requires(dt);
        this.time = time;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.reset();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        dt.driveLR(speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > time;
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
