package com.m3c.jc.Control;

import com.m3c.jc.Model.WordCounter;

import static com.m3c.jc.View.DisplayManager.displayResults;

public class WordCounterManager {

    public void findTopThree() throws Exception{
        WordCounter wordCounter = new WordCounter();
        wordCounter.readerSetup("resources/test");
        wordCounter.processLines();
        for (String word : wordCounter.getTopThree()) {
            displayResults(word, wordCounter.getWordCount(word));
        }

    }
}
