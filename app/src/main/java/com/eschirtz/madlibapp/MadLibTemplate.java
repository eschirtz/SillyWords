package com.eschirtz.madlibapp;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import static android.R.attr.name;

/**
 * This class is the template for a madlib story, responsible for
 * parsing a story template into "Story elements" and "Parts of Speech".
 * Using "MadLib" mark-up language.
 * Parts of speech are preceded and followed by ";", end
 * of story marked with ";END".
 * @author Eschirtz
 *
 */
public class MadLibTemplate extends MadLib {
    /**
     * Constructor for Mad Lib template class
     * @param template
     * The string of the story in "MadLib" mark-up language, to be parsed.
     * @param title
     * Title of the template
     */
    public MadLibTemplate(String title, String template){
        String[] splitTemplate;
        splitTemplate = template.split(";");
        // Adds story elements and parts of speech to their respective
        // array lists.
        storyElements = new ArrayList<String>();
        partsOfSpeech = new ArrayList<String>();
        this.title = title;
        // Parses story
        for(int i=0; i<splitTemplate.length; i = i +2){
            storyElements.add( splitTemplate[i]);
            if(splitTemplate[i].equals( "END" ) ||
                    splitTemplate[i+1].equals( "END" )){
                partsOfSpeech.add("END");
                return;
            }
            else{
                partsOfSpeech.add( splitTemplate[i+1]);
            }
        }
    }
    // No param constructor, generates test Mad Lib story
    public MadLibTemplate() {
        storyElements = new ArrayList<String>();
        partsOfSpeech = new ArrayList<String>();

        storyElements.add( "Story element one " );
        partsOfSpeech.add( "Noun" );
        storyElements.add( " Story element two " );
        partsOfSpeech.add( "Verb" );
        storyElements.add( " Story element three " );
        partsOfSpeech.add( "Adjective" );
        storyElements.add( " Story element four (end). " );
        partsOfSpeech.add("END");
        this.setTitle( "Test MadLib" );
    }
}