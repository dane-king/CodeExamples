package lambdas;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ComposeTest {


    private Compose compose;

    @Before
    public void setUp() {
        compose = new Compose();
    }

    @Test
    public void shouldBeAbleToAndThenFunctions() {
        //multiple by 2 then add 2, then add 4 + 4
        assertThat(compose.multiplyAndThenAdd(2), equalTo(8));
    }
    @Test
    public void shouldBeAbleToComposeFunctions() {
        //multiple by 2 then add 2, then add 4 + 4
        assertThat(compose.multipleAddCompose(2), equalTo(8));
    }

    @Test
    public void shouldConvertToCurrencyAndThen() {
        assertThat(compose.convertToCurrencyAndThen("5.00"), equalTo("$5.00"));

    }
    @Test
    public void shouldConvertToCurrencyCompose() {
        assertThat(compose.convertToCurrencyCompose("5.00"), equalTo("$5.00"));

    }

    @Test
    public void shouldAdd2Mulitply2Add3() {
        assertThat(compose.add2ThenMultiply2ThenAdd3(5), equalTo(17));
    }
}
