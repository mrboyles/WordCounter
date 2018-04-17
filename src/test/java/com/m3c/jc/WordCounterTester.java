package com.m3c.jc;

import com.m3c.jc.Model.WordCounter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCounterTester {

    public WordCounter wordCounter;

    @Before
    public void setup() {
        wordCounter = new WordCounter();
    }

    @Test
    public void testGetTopThree() throws Exception {
        wordCounter.readerSetup("resources/test");
        wordCounter.processLines();
        String[] solution = {"and", "the", "that"};
        String[] attempt = wordCounter.getTopThree();
        Assert.assertArrayEquals(solution, attempt);
    }

    @After
    public void teardown(){

    }
}
