/*
 * Course Agile Software Development
 */ 
package invoker;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CmdExitIntegrationTest extends IntegrationTestBase {

	@Test
	public void noErrorOutput() {
		commandInvoker.executeCommand("exit", testOutput);

		assertTrue(testOutput.toString().toLowerCase().contains("is not recognized as an internal or external command") == false);
	}
}
