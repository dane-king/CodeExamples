package patterns.java8patterns.behavior.templatemethod;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalTime;

public class TemplateMethodRunner {

    private TemplateMethodRunner(){

    }

    static void runWithTiming(Runnable action){
        LocalTime before= now(Clock.systemDefaultZone());
        action.run();
        LocalTime after= now(Clock.systemDefaultZone());
        System.out.println(String.format("Execution took:%d ms%n", Duration.between(before,after).toMillis()));


    }

    private static LocalTime now(Clock clock) {
        return LocalTime.now(clock);
    }
}
