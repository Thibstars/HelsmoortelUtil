/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.commandLine;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * Created by Thibault Helsmoortel on 15/12/2016.
 */
public final class CommandExecutor {

    private static CommandExecutor classInstance = new CommandExecutor();

    //Set intended to contain all commands
    private static Set<Command> commandSet;

    /**
     * Private constructor - publicly unavailable
     */
    private CommandExecutor() {
        //Constructor not publicly available
        commandSet = Collections.newSetFromMap(new WeakHashMap<>());
    }

    /**
     * Adds a command to the command set.
     *
     * @param command the command to add
     * @return true if added, false if otherwise
     */
    public static boolean add(Command command) {
        return commandSet.add(command);
    }

    /**
     * Searches for a command from the commandSet and returns it if a command was found.
     *
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
     *
     * @param command the command to execute
     * @return the result of the invoked method
     */
    private static Object execute(Command command) {
        return command.execute();
    }

    /**
     * Fires the method linked to the command.
     *
     * @param command the command to execute
     * @param args    argument(s) to be passed to the method
     * @return the result of the invoked method
     */
    private static Object execute(Command command, Object[] args) {
        command.setArgs(args);
        return command.execute();
    }

    /**
     * Fires the method linked to the command.
     *
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
     *
     * @param command the name of the command to execute
     * @param args    argument(s) to be passed to the method
     * @return the result of the invoked method
     * @throws IllegalArgumentException command was not found
     */
    public static Object execute(String command, Object[] args) throws IllegalArgumentException {
        Command c = find(command);
        return execute(c, args);
    }

    /**
     * Returns an instance of CommandExecutor
     *
     * @return an instance of the CommandExecutor
     */
    public static synchronized CommandExecutor getInstance() {
        return classInstance;
    }

    /**
     * Blocks the cloning of the CommandExecutor
     *
     * @return nothing
     * @throws CloneNotSupportedException cloning not supported
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException("Clone not supported");
    }
}
