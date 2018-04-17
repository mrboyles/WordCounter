package com.m3c.jc.Control;

import com.m3c.jc.Model.WordCounter;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

import static com.m3c.jc.View.DisplayManager.displayResults;

public class WordCounterManager {

    static Logger log = Logger.getLogger(WordCounterManager.class.getName());

    private static final String FILE_NOT_FOUND = "Sorry but that file does not exist";
    private static final String LINE_PROCESSING = "Sorry there was a problem processing lines";

    //Implements WordCounter class and displays results
    public void findTopThree() throws WordCounterManagerException {
        WordCounter wordCounter = new WordCounter();
        try {
            wordCounter.readerSetup("resources/test0");
            log.info("Reading text from resources file");
            wordCounter.processLines();
            log.info("Processing lines");
            for (String word : wordCounter.getTopThree()) {
                displayResults(word, wordCounter.getWordCount(word));
            }
            log.info("Top three occurrences found successfully");
        } catch (FileNotFoundException fnfe) {
            log.debug("Exception thrown: " + FILE_NOT_FOUND);
            //Error message for missing file
            throw new WordCounterManagerException(FILE_NOT_FOUND);
        } catch (Exception e) {
            log.debug("Exception thrown: " + LINE_PROCESSING);
            //Error message for problems processing lines
            throw new WordCounterManagerException(LINE_PROCESSING);
        }
    }
}
