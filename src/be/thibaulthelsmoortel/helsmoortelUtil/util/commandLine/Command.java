/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.util.commandLine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class to create simple String commands that are able to fire a specific method.
 *
 * @author Thibault Helsmoortel
 */
public class Command {

    //The actual name of the command
    private String command;
    //The method to be executed
    private Method method;
    //Argument(s) to pass to the method
    private String[] args;

    /**
     * Package local constructor specifying command and method.
     *
     * @param command the actual name of the command
     * @param method  the method to be executed
     */
    protected Command(String command, Method method) {
        this.command = command;
        this.method = method;
    }

    /**
     * Package local constructor specifying command, method and optional args.
     *
     * @param command the actual name of the command
     * @param method  the method to be executed
     * @param args    the optional args
     */
    protected Command(String command, Method method, String... args) {
        this.command = command;
        this.method = method;
        this.args = args;
    }

    /**
     * Returns the actual name of the command.
     *
     * @return the name of the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Set the argument(s) to be passed to the executed method.
     *
     * @param args argument(s) to be passed to the executed method
     */
    public void setArgs(String[] args) {
        this.args = args;
    }

    /**
     * Fires the method linked to the command along with the previously set argument(s), if any.
     *
     * @return the result of the invoked event
     */
    public Object execute() {
        Object result = null;
        try {
            if (args != null) result = method.invoke(null, args);
            else result = method.invoke(null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
    //Example implementation (static methods)
    public static void main(String[] args) {
        try {
            Method methodToUse = Math.class.getMethod("random");
            CommandFactory.create("testRand", methodToUse);
            System.out.println(CommandFactory.execute("testRand"));

            Method methodToUse2 = Math.class.getMethod("floor", double.class);
            CommandFactory.create("testFloor", methodToUse2);
            System.out.println(CommandFactory.execute("testFloor", new Object[]{2.53}));

            Method methodToUse3 = Math.class.getMethod("subtractExact", int.class, int.class);
            CommandFactory.create("testSubtractExact", methodToUse3);
            System.out.println(CommandFactory.execute("testSubtractExact", new Object[]{10, 5}));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
    */
}
