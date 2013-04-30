/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server;

import net.griddynamics.api.approach3.CommandFacade;
import net.griddynamics.api.approach3.commands.Command;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author one
 */
public class SimpleCommandFacade implements CommandFacade{
    private ServerContext context;
            
    @Override
    public <T> T executeRemotely(Command<T> command) {
        return command.exec(context);
    }

    @Required
    public void setContext(ServerContext context) {
        this.context = context;
    }
}
