package testing.mocking;

import java.time.Clock;
import java.time.LocalDate;

class ClockClassToTest {
    private LocalDate localDate;

    //original constructor method called now
    //need to create a default constructor that can tak a mock
    //original constructor sets defaults

    ClockClassToTest(Clock clock){
        localDate=clock==null?LocalDate.now():LocalDate.now(clock);
    }
    public ClockClassToTest(){
        this(Clock.systemDefaultZone());
    }

    LocalDate today() {
        return LocalDate.now();
    }

    public LocalDate getLocalDate() {
        return today();
    }
    public LocalDate getLocalDateFromConstructor() {
        return this.localDate;
    }
}
