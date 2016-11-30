/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.commandLine;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Singleton factory class regulating the use of commands of the Command class.
 */
public final class CommandFactory {
    private static CommandFactory classInstance = new CommandFactory();

    //Set intended to contain all commands
    private static Set<Command> commandSet;

    /**
     * Private constructor - publicly unavailable
     */
    private CommandFactory() {
        //Constructor not publicly available
        commandSet = Collections.newSetFromMap(new WeakHashMap<>());
    }

    /**
     * Creates and returns a Command object.
     * @param command the name of the command
     * @param method the method of the command
     * @return the newly created command
     */
    public static Command create(String command, Method method) {
        Command c = new Command(command, method);
        commandSet.add(c);
        return c;
    }

    /**
     * Searches for a command from the commandSet and returns it if a command was found.
     * @param command the name of the command to search for
     * @return the matching command, if any
     * @throws IllegalArgumentException command was not found
     */
    public static Command find(String command) throws IllegalArgumentException {
        for (Command c : commandSet) {
            if (c.getCommand().equals(command)) return c;
        }
        throw new IllegalArgumentException("Command not found.");
    }

    /**
     * Fires the method linked to the command.
     * @param command the command to execute
     * @return the result of the invoked method
     */
    private static Object execute(Command command) {
        return command.execute();
    }

    /**
     * Fires the method linked to the command.
     * @param command the command to execute
     * @param args argument(s) to be passed to the method
     * @return the result of the invoked method
     */
    private static Object execute(Command command, Object[] args) {
        command.setArgs(args);
        return command.execute();
    }

    /**
     * Fires the method linked to the command.
     * @param command the name of the command to execute
     * @return the result of the invoked method
     * @throws IllegalArgumentException command was not found
     */
    public static Object execute(String command) throws IllegalArgumentException {
        Command c = find(command);
        return execute(c);
    }

    /**
     * Fires the method linked to the command.
     * @param command the name of the command to execute
     * @param args argument(s) to be passed to the method
     * @return the result of the invoked method
     * @throws IllegalArgumentException command was not found
     */
    public static Object execute(String command, Object[] args) throws IllegalArgumentException {
        Command c = find(command);
        return execute(c, args);
    }

    /**
     * Returns an instance of CommandFactory
     * @return an instance of the CommandFactory
     */
    public static synchronized CommandFactory getInstance() {
        return classInstance;
    }

    /**
     * Blocks the cloning of the CommandFactory
     * @return nothing
     * @throws CloneNotSupportedException cloning not supported
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException("Clone not supported");
    }
}
