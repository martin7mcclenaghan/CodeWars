package com.martinmcclenaghan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)

public class MainTest {

    private String input1;
    private String input2;
    private String expected;

    public MainTest(String input1, String input2, String expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object> testConditions (){
        return Arrays.asList(new Object[][]{

                {"132535365", "123456789", "12356"},
                {"abcdefghijklmnopq", "apcdefghijklmnobq", "acdefghijklmnoq"},
                {"7M7;JAO640>;51HE1<JD", "FL9=;GF7KG4K2@NA8<0R", "7A0"},
                {"P@E=N2N8=>3C287GS5IA", "24R;1P;36;4=RMBFNK6K", "P=N"},
                {"@8SK6;R7R?LNF7I5@C:Q", "N8L8LB6:3?BSBF3I3KLJ", "86?FI"}
                {}



        });
    }

    @Test
    public void lcs() {
        assertEquals(expected, Main.lcs(input1,input2));
    }
}