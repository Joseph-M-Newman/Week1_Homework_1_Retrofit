package com.example.week1_homework_1_newman;

import com.example.week1_homework_1_newman.Utils.Utils;

import org.jetbrains.annotations.TestOnly;
import org.junit.Test;

import java.util.Random;

import okhttp3.internal.Util;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void mutliplications_IsCorrect(){
        Random r = new Random();
        int x = r.nextInt();
        int y = r.nextInt();
        assertEquals(x*y, Utils.multi(x,y));
        assertNotEquals(x*y+1,Utils.multi(x,y));
    }

    @Test
    public void Username_IsCorrect() {
        assertEquals("Anakin", MainActivity.fillUsers(1));
    }

    @Test
    public void password_IsCorrect(){
        assertEquals("API", MainActivity.testPass(9));
    }

}