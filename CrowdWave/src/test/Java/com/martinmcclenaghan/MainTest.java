package Java.com.martinmcclenaghan;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class MainTest {

    private String start;
    private String[] result;

    public MainTest(String start, String[] result) {
        this.start = start;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions() {
        return Arrays.asList(new Object[][]{

                {"abc def", new String[]{"Abc def", "aBc def", "abC def", "abc Def", "abc dEf", "abc deF"}},
                {"a b c", new String[]{"A b c", "a B c", "a b C"}},
                {"  ab cd", new String[]{"  Ab cd", "  aB cd", "  ab Cd", "  ab cD"}},
                {"abcd", new String[]{"Abcd", "aBcd", "abCd", "abcD"}},
                {" ", new String[0]},


        });
    }

    @Test
    public void crowdWaveTest() {
        assertArrayEquals(result, Main.wave(start));
    }
}
