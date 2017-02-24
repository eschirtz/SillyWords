package com.eschirtz.madlibapp;

import java.util.ArrayList;

/**
 * This class is responsible for building the final story
 * given the final story elements and user words. Creates story
 * on instantiation.
 * @author Eschirtz
 *
 */
public class MadLibStory extends MadLib {
    // The final story, in one string
    private String story = "";
    // User entered words
    private ArrayList<String> userWords;

    // Creates a story with the given story elements and user words
    public MadLibStory(ArrayList<String> storyElements, ArrayList<String> userWords){
        this.userWords = userWords;
        this.storyElements = storyElements;
        for(int i=0; i<storyElements.size(); i++){
            story += storyElements.get( i );
            if(i != userWords.size()){
                story += userWords.get( i );
            }
        }
    }
    // Accessor methods
    public String getStory(){
        return story;
    }
    public ArrayList<String> getUserWords(){
        return userWords;
    }
    // To string
    public String toString(){
        return story;
    }
}
