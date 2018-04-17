package com.m3c.jc;

import com.m3c.jc.Model.WordCounter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class WordCounterTester {

    public WordCounter wordCounter;

    @Before
    public void setup() {
        wordCounter = new WordCounter();
    }

    @Test
    public void testGetTopThree() throws Exception {
        wordCounter.readerSetup("resources/test0");
        wordCounter.processLines();
        String[] solution = {"and", "the", "that"};
        String[] attempt = wordCounter.getTopThree();
        Assert.assertArrayEquals(solution, attempt);
    }

    @Test
    public void testEmptyText() throws Exception {
        wordCounter.readerSetup("resources/test1");
        wordCounter.processLines();
        String[] solution = {null, null, null};
        String[] attempt = wordCounter.getTopThree();
        Assert.assertArrayEquals(solution, attempt);
    }

    @Test
    public void testExcessivePunctuation() throws Exception {
        wordCounter.readerSetup("resources/test2");
        wordCounter.processLines();
        String[] solution = {"and", "the", "that"};
        String[] attempt = wordCounter.getTopThree();
        Assert.assertArrayEquals(solution, attempt);
    }

    @Test
    public void testCaseSensitivity() throws Exception {
        wordCounter.readerSetup("resources/test3");
        wordCounter.processLines();
        String[] solution = {"and", "the", "that"};
        String[] attempt = wordCounter.getTopThree();
        Assert.assertArrayEquals(solution, attempt);
    }

    @Test
    public void testAddWords() throws Exception {
        wordCounter.readerSetup("resources/test0");
        wordCounter.processLines();
        wordCounter.wordCountEntry("the");
        String[] solution = {"the", "and", "that"};
        String[] attempt = wordCounter.getTopThree();
        Assert.assertArrayEquals(solution, attempt);
    }

    @After
    public void teardown(){

    }
}
