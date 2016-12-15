/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package util.commandLine;

import be.thibaulthelsmoortel.helsmoortelUtil.util.commandLine.Command;
import be.thibaulthelsmoortel.helsmoortelUtil.util.commandLine.CommandExecutor;
import be.thibaulthelsmoortel.helsmoortelUtil.util.commandLine.CommandFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test case for Command.
 *
 * @author Thibault Helsmoortel
 */
public class CommandTests {

    private static final Logger LOGGER = Logger.getLogger(CommandTests.class);

    /**
     * Tests whether commands are properly executed.
     *
     * @throws NoSuchMethodException when the used method is not found.
     */
    @Test
    public void shouldExecuteCommand() throws NoSuchMethodException {
        Method methodToUse = Math.class.getMethod("random");
        Command c = CommandFactory.create("testRand", methodToUse);
        LOGGER.debug(CommandExecutor.execute("testRand"));
        assertTrue(c.isExecuted());

        Method methodToUse2 = Math.class.getMethod("floor", double.class);
        Command c2 = CommandFactory.create("testFloor", methodToUse2);
        LOGGER.debug(CommandExecutor.execute("testFloor", new Object[]{2.53}));
        assertTrue(c2.isExecuted());
        assertEquals(2.0, CommandExecutor.execute("testFloor"));

        Method methodToUse3 = Math.class.getMethod("subtractExact", int.class, int.class);
        Command c3 = CommandFactory.create("testSubtractExact", methodToUse3);
        LOGGER.debug(CommandExecutor.execute("testSubtractExact", new Object[]{10, 5}));
        assertTrue(c3.isExecuted());
        assertEquals(5, CommandExecutor.execute("testSubtractExact"));
    }
}
