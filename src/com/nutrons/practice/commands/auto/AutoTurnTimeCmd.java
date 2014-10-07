/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutrons.practice.commands.auto;

import com.nutrons.practice.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author John
 */
public class AutoTurnTimeCmd extends CommandBase {

    double time;
    double speed;
    boolean turnRight;
    Timer timer = new Timer();

    public AutoTurnTimeCmd(double time) {
        requires(dt);
        this.time = time;
        this.speed = .2;
        turnRight = true;
    }
    
    public AutoTurnTimeCmd(double time, double speed) {
        requires(dt);
        this.time = time;
        this.speed = speed;
        turnRight = true;
    }
    
    public AutoTurnTimeCmd(double time, double speed, boolean turnRight) {
        requires(dt);
        this.time = time;
        this.speed = speed;
        this.turnRight = turnRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.reset();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(turnRight) {
            dt.driveLR(speed, -speed);
        } else {
            dt.driveLR(-speed, speed);
        }
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
