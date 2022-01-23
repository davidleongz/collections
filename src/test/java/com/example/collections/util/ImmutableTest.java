package com.example.collections.util;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ImmutableTest {

    @Test
    public void immutableString() {

        String name = "David";
        name.concat("Leon");
        assertEquals("David", name);
        name = name.concat("Leon");
        assertEquals("DavidLeon", name);

        String first = "David";
        String second = "David";
        assertTrue(first == second);

        String third = new String("David");
        String fourth = new String("David");
        assertFalse(third == fourth);

        String constantString = "David Leon";
        String newString = new String("David Leon");

        System.out.println(Integer.toHexString(System.identityHashCode(constantString)));
        System.out.println(Integer.toHexString(System.identityHashCode(newString)));

        // Object comparison
        assertTrue(constantString.equals(newString));

        // Reference comparison
        assertFalse(constantString == newString);

        String internedString = newString.intern();
        assertTrue(constantString == internedString);

    }

    @Test
    public void immutableInteger() {

        Integer a=3;
        String firstHashCode = Integer.toHexString(System.identityHashCode(a));

        Integer b=3;
        a+=b;
        String secondHashCode = Integer.toHexString(System.identityHashCode(a));

        assertFalse(firstHashCode.equals(secondHashCode));

        System.out.println(a);

    }

   @Test
    public void immutableIntegerDemostrationTest() {

        Integer a=3;
        String firstHashCode = Integer.toHexString(System.identityHashCode(a));

        Integer b=a;
        b = b + 5;
        String secondHashCode = Integer.toHexString(System.identityHashCode(a));

        assertTrue(a == 3);
        assertTrue(b == 8);

        // If int could mutate, "a" would print 8 but it does not because it is immutable, thats why it is 3.
        // Your example is just a new assignment.

        System.out.println(a);

    }
}
