/**
 * Dictionary entity class.
 *
 * @author Jesús Ramírez Guerrero
 * @date 10/Dic/2013
 */
package es.jesramgue.ghost.ghostwebgame.business.entities;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.logging.Logger;

public class Dictionary {

    private static final int MIN_WORD_LENGTH = 4;
    private final Logger logger_ = Logger.getLogger(Dictionary.class.getName());
    private ArrayList<String> ialDictionary = new ArrayList<String>();

    /**
     * The file constructor for the Dictionary class.
     *
     * @param fileName The name of the dictionary file. This file is assumed to
     * be sorted in alphabetical order.
     */
    public Dictionary(String fileName) {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream(fileName.toLowerCase());

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String lsAllWords = "";
            String word = null;
            while ((word = reader.readLine()) != null) {
                if (word.length() > 3) {
                    ialDictionary.add(word);
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {
            logger_.severe("File " + fileName + " not found.");
        } catch (IOException ioException) {
            logger_.severe("Error reading file:  " + ioException.toString());
        }
    }

    public Dictionary(ArrayList<String> aalCopy) {
        ialDictionary.addAll(aalCopy);

    }

    /**
     * Construct the actual dictionary.
     *
     * @param adDict base dictionary
     * @param asActualWord the actual word in play.
     */
    public Dictionary subSetDictionary(Dictionary adDict, String asActualWord) {
        ArrayList<String> newDictionary = new ArrayList<String>();
        for (int i = 0; i < adDict.size(); i++) {
            if (adDict.getIalDictionary().get(i).startsWith(asActualWord)) {
                newDictionary.add(adDict.getIalDictionary().get(i));
            }
        }

        return new Dictionary(newDictionary);
    }

    /**
     * Return an iterator to the underlying collection of words.
     */
    public ListIterator<String> listIterator() {
        return getIalDictionary().listIterator(0);
    }

    /**
     * Return the number of words in the dictionary.
     */
    public long size() {
        return getIalDictionary().size();
    }

    /**
     * Return the first word in the dictionary.
     */
    public String firstWord() {
        String firstWord = null;

        try {
            firstWord = getIalDictionary().get(0);
        } catch (NoSuchElementException e) {
            logger_.info("Dictionary without words.");
        }

        return firstWord;
    }

    /**
     * @return the ialDictionary
     */
    public ArrayList<String> getIalDictionary() {
        return ialDictionary;
    }

    /**
     * @param ialDictionary the ialDictionary to set
     */
    public void setIalDictionary(ArrayList<String> ialDictionary) {
        this.ialDictionary = ialDictionary;
    }
}  // end Dictionary

