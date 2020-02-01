package enums.color;

import org.junit.Before;
import org.junit.Test;

public class ColorWriterTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void ColorWriterShouldWriteColorWhenColorIsPassedIn() {
		ColorWriter writer = new ColorWriter();
		writer.setColor(Color.RED);
	}

}
