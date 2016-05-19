package main.hav.command.factory;


import main.hav.command.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String, ICommand> commands = new HashMap<String, ICommand>();
    private static final Logger LOGGER = Logger.getLogger(CommandFactory.class);
    private static ICommand noCommand = new NoCommand();;

    static {
        commands.put("Login", new Login());
        commands.put("Logout", new Logout());
        commands.put("Evaluate", new Evaluate());
        commands.put("ShowRegPage", new ShowRegPage());
        commands.put("ShowLoginPage", new ShowLoginPage());
        commands.put("Register", new Register());
        commands.put("DeleteUser", new DeleteUser());
        commands.put("EditUser", new EditUser());
        commands.put("UpdateUser", new UpdateUser());
    }

    public static ICommand getCommand (HttpServletRequest request) {
        LOGGER.debug("Command factory starts to work");
        String value = request.getParameter("command");
        LOGGER.debug(" value is: " + value);
        ICommand command = commands.get(value);
        LOGGER.info("COMMAND is: " + command);


        if (command == null) {
            command = noCommand;
        }

        LOGGER.info("COMMAND to excecute: " + command);
        return command;
    }

}