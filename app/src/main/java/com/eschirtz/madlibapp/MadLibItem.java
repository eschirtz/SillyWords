package com.eschirtz.madlibapp;

/**
 * These objects will hopefully be able to be created with file io, creating
 * the Strings for both title and story template, as well as the image reference. All
 * with the intent to be displayed in the list, and to be passsed into the template constructor.
 * Created by Eschirtz on 1/10/17.
 */

public class MadLibItem {
    // Title for the story
    private String title = "Broken";
    // Story in mark-up language to be parsed by story template
    private String template;
    // Subtitle or description
    private String subtitle = "Broken";
    // Image to be used as a background for list item
    private int imageResorceID;

    /**
     *
     * @param title
     * @param template
     * @param imageResourceID
     */
    public MadLibItem(String title, String subtitle, String template, int imageResourceID){
        this.title = title;
        this.template = template;
        this.imageResorceID = imageResourceID;
        this.subtitle = subtitle;
    }

    public int getImageResourceID() {
        return imageResorceID;
    }

    public String getTemplate() {
        return template;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
