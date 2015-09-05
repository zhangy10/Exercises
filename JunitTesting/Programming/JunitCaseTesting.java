package Programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitCaseTesting {

	@Test
	public void test() {
		
		JunitCase junitCase = new JunitCase();
		assertEquals(0, junitCase.calculateArea(23));
		
	}

}
