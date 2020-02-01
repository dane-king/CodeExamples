package patterns.java8patterns.behavior.templatemethod;

import org.junit.Test;

public class TemplateMethodRunnerTest {


    @Test
    public void shouldRunTiming() {
        Runnable runnable = () -> findById(42);
        //Runnable spyRunnable=spy(runnable);
        //TemplateMethodRunner.runWithTiming(runnable);
        //verify(spyRunnable).run();
        TemplateMethodRunner.runWithTiming(runnable);
    }

    private void findById(int num) {

    }
}
