package Bhaskara;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BhaskaraTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final InputStream originalIn = System.in;
	
	@Before
	public void setStream() {
		System.setOut(new PrintStream(out));
	}
	
	@After
	public void resetStream() {
		System.setOut(originalOut);
		System.setIn(originalIn);
	}
	
	@Test
	public void testDividedByZero() {
		Boolean shouldBeFalse = BhaskaraApp.ableToCalculateBhaskara(0, 20, 5);
		assertEquals(shouldBeFalse, false);
	}
	
	@Test
	public void testDividedByPositive() {
		Boolean shouldBeFalse = BhaskaraApp.ableToCalculateBhaskara(10, 20, 5);
		assertEquals(shouldBeFalse, true);
	}

	@Test
	public void testDividedByNegative() {
		Boolean shouldBeFalse = BhaskaraApp.ableToCalculateBhaskara(-40, 20, 5);
		assertEquals(shouldBeFalse, true);
	}
	
	@Test
	public void testSqrRootOfNegativeNumber() {
		Boolean shouldBeFalse = BhaskaraApp.ableToCalculateBhaskara(10, 1, 10);
		assertEquals(shouldBeFalse, false);
	}
	
	@Test
	public void testSqrRootOfPositiveNumber() {
		Boolean shouldBeFalse = BhaskaraApp.ableToCalculateBhaskara(1, 10, 1);
		assertEquals(shouldBeFalse, true);
	}
	
	@Test
	public void testSqrRootOfZero() {
		Boolean shouldBeFalse = BhaskaraApp.ableToCalculateBhaskara(0, 0, 0);
		assertEquals(shouldBeFalse, false);
	}
	
	@Test
	public void testeAccurateResult1() {
		BhaskaraResult result = BhaskaraApp.bhaskara(10, 20.1, 5.1);
		double firstResult = -0.29788;
		assertEquals(firstResult, result.getFirstResult(), 0);
	}
	
	@Test
	public void testeAccurateResult2() {
		BhaskaraResult result = BhaskaraApp.bhaskara(10.3, 203.0, 5.0);
		double secondResult = -19.68408;
		assertEquals(secondResult, result.getSecondResult(), 0);
	}
	
	@Test
	public void testImpossivelCalcular() {
		System.setIn(new ByteArrayInputStream("1\n1\n1".getBytes()));
		BhaskaraApp.main(null);
		assertEquals("Impossivel calcular\n", out.toString());
	}
	
	@Test
	public void testMainClass() {
		System.setIn(new ByteArrayInputStream("10\n20.1\n5.1".getBytes()));
		BhaskaraApp.main(null);
		assertEquals("First Result = -0.297880\nSecond Result = -1.712120\n", out.toString());
	}
}
