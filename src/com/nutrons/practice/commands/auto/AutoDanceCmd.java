/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutrons.practice.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author John
 */
public class AutoDanceCmd extends CommandGroup {
    
    public AutoDanceCmd() {
        addSequential(new AutoDriveTimeCmd(1.5, 0.2));
        addSequential(new AutoDriveTimeCmd(1.5, -0.2));
        addSequential(new WaitCommand(0.5));
        addSequential(new AutoTurnDegreeCmd(180, .3));
    }
}
