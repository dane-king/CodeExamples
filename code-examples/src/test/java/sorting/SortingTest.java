package sorting;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SortingTest {
    private final int[] intArray = {3, 1, 5, 6, 2};
    private final Integer[] intObjectArray = {3, 1, 5, 6, 2};

    @Test
    void shouldSortArray() {
        Arrays.sort(intArray);
        assertArrayEquals(new int[]{1, 2, 3, 5, 6}, intArray);
    }

    @Test
    void shouldSortArrayReverseSort() {
        //to use comparator must be an object array
        Arrays.sort(intObjectArray, Comparator.reverseOrder());
        assertArrayEquals(new Integer[]{6, 5, 3, 2, 1}, intObjectArray);
    }

    @Test
    void shouldSortArrayEvensFirst() {
        //to use comparator must be an object array
        Arrays.sort(intObjectArray, Comparator.comparing((Integer c)->c%2==1).thenComparing(Integer::intValue));
        assertArrayEquals(new Integer[]{2, 6, 1, 3, 5}, intObjectArray);
    }
    @Test
    void shouldSortListEvensFirst() {
        //to use comparator must be an object array
        List<Integer> values=Arrays.asList(intObjectArray);
        values.sort(Comparator.comparing((Integer c) -> c % 2 == 1).thenComparing(Integer::intValue));
        assertThat(values, contains(2,6,1,3,5));
    }
    @Test
    void shouldSortArrayStreams() {
        //using streams need to convert to stream and back again
        int[] sortedArray = Arrays.stream(intArray).sorted().toArray();

        assertArrayEquals(new int[]{1, 2, 3, 5, 6}, sortedArray);
    }

    @Test
    void shouldSortObjectsByFirstName() {
        SortObject object1= new SortObject("Joe", "King","");
        SortObject object2= new SortObject("Zena", "Smith","");
        SortObject object3= new SortObject("Anna", "Zephyr","");
        SortObject[] objects={object1,object2, object3};
        Arrays.sort(objects, Comparator.comparing(SortObject::getFirstName));
        assertArrayEquals(new SortObject[]{object3, object1, object2}, objects);
    }
    @Test
    void shouldSortObjectsByLastNameThenFirst() {
        SortObject object1= new SortObject("Joe", "King","");
        SortObject object2= new SortObject("Zena", "Smith","");
        SortObject object3= new SortObject("Anna", "Smith","");
        SortObject object4= new SortObject("Anna", "Zephyr","");

        SortObject[] objects={object1,object2, object3, object4};
        Arrays.sort(objects, Comparator.comparing(SortObject::getLastName).thenComparing(SortObject::getFirstName));
        assertArrayEquals(new SortObject[]{object1, object3, object2, object4}, objects, "Object is " + objects);
    }

    @Data
    @Builder
    private static class SortObject {
        private final String firstName;
        private final String lastName;
        private final String company;

    }
}
