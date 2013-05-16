/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server;

import net.griddynamics.server.commands.ExecutableCommand;

/**
 *
 * @author one
 */
public class ExecutableCommandHolder<Z>{
        ExecutableCommand<Z> ecmd;

        public ExecutableCommandHolder(ExecutableCommand<Z> ecmd) {
            this.ecmd = ecmd;
        }

        public ExecutableCommand<Z> getEcmd() {
            return ecmd;
        }        
    }
