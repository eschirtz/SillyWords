package com.eschirtz.madlibapp;
import java.util.ArrayList;
/**
 * This class is the parents class for both the final MadLib stories, as
 * well as the MadLib templates. Contains basic fields that can be interfaced
 * with by the MadLib engine, and the Android app
 * @author Eschirtz
 *
 */
public abstract class MadLib {
    // Title of MadLib
    protected String title;
    // Subtitle or description of story
    protected String subTitle;
    // The surrounding text, or "Story elements" of the Mad Lib story
    protected ArrayList<String> storyElements;
    // All parts of speech, in chronological order
    protected ArrayList<String> partsOfSpeech;
    // Image reference
    protected int image;

    // Accessor methods
    // Title
    public String getTitle(){ return title;}
    public void setTitle(String title){ this.title = title;}
    // Story Elements
    public ArrayList<String> getStoryElements(){ return storyElements;}
    // Parts of Speech
    public ArrayList<String> getPartsOfSpeech(){ return partsOfSpeech;}
}
