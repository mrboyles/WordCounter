package com.m3c.jc.Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.logging.Logger;

import static com.m3c.jc.View.DisplayManager.displayReading;

public class WordCounter {

    //Sets up a buffered reader
    private BufferedReader bufferedReader;
    public HashMap<String, Integer> wordCount = new HashMap<>();

    //Gives a file reader the file for testing
    public void readerSetup(String fileName) throws FileNotFoundException {
        displayReading(fileName);
        bufferedReader = new BufferedReader(new FileReader(fileName));
    }

    //Processes the text line by line, separating into words, and adding to hash map wordCount
    public void processLines() throws Exception{
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            updateWordCount(words);
        }
    }

    public void wordCountEntry(String word) {
        if (wordCount.containsKey(word)) {
            wordCount.put(word, wordCount.get(word) + 1);
        } else {
            wordCount.put(word, 1);
        }
    }

    public void updateWordCount(String[] words) throws Exception {
        for (String word : words) {
            if (word != null && !word.isEmpty()) {
                wordCountEntry(word);
            }
        }
    }

        public int getWordCount(String word) {
        if (wordCount.containsKey(word)) {
            return wordCount.get(word);
        } else {
            return 0;
        }
    }

    //Pulls out top three occurring words from wordCount
    public String[] getTopThree() {
        String[] topThree = new String[3];
        for (String key : wordCount.keySet()) {
            if (topThree[0] == null || wordCount.get(key) > wordCount.get(topThree[0])) {
                topThree[2] = topThree[1];
                topThree[1] = topThree[0];
                topThree[0] = key;
            } else if (topThree[1] == null || wordCount.get(key) > wordCount.get(topThree[1])) {
                topThree[2] = topThree[1];
                topThree[1] = key;
            } else if (topThree[2] == null || wordCount.get(key) > wordCount.get(topThree[2])) {
                topThree[2] = key;
            }
        }
        return topThree;
    }
}

