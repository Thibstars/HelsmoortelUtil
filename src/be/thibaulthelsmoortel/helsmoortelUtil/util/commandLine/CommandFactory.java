/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.commandLine;

import java.lang.reflect.Method;

/**
 * Singleton factory class regulating the use of commands of the Command class.
 *
 * @author Thibault Helsmoortel
 */
public final class CommandFactory {
    private static CommandFactory classInstance = new CommandFactory();

    /**
     * Private constructor - publicly unavailable
     */
    private CommandFactory() {
        //Constructor not publicly available
    }

    /**
     * Creates and returns a Command object.
     *
     * @param command the name of the command
     * @param method  the method of the command
     * @return the newly created command
     */
    public static Command create(String command, Method method) {
        Command c = new Command(command, method);
        CommandExecutor.add(c);
        return c;
    }

    /**
     * Creates and returns a Command object.
     *
     * @param command the name of the command
     * @param method  the method of the command
     * @param args    the optional args
     * @return the newly created command
     */
    public static Command create(String command, Method method, Object... args) {
        Command c = new Command(command, method, args);
        CommandExecutor.add(c);
        return c;
    }

    /**
     * Returns an instance of CommandFactory
     *
     * @return an instance of the CommandFactory
     */
    public static synchronized CommandFactory getInstance() {
        return classInstance;
    }

    /**
     * Blocks the cloning of the CommandFactory
     *
     * @return nothing
     * @throws CloneNotSupportedException cloning not supported
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException("Clone not supported");
    }
}
