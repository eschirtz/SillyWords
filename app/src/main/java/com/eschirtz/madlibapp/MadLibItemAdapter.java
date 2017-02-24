package com.eschirtz.madlibapp;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Eschirtz on 1/10/17.
 */

public class MadLibItemAdapter extends ArrayAdapter {
    // Constructor, to take in context and each MadLibItem object
    public MadLibItemAdapter(Context context, ArrayList<MadLibItem> stories){
        super(context, 0, stories);
    }

    /**
     * Customized code to populate each list item view
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        MadLibItem currentMadLibItem = (MadLibItem) getItem(position);

        // Set views for each field
        TextView titleTextView = (TextView)listItemView.findViewById(R.id.list_item_title);
        titleTextView.setText(currentMadLibItem.getTitle());

        TextView subtitleTextView = (TextView)listItemView.findViewById(R.id.list_item_subtitle);
        subtitleTextView.setText(currentMadLibItem.getSubtitle());

        ImageView imageView = (ImageView)listItemView.findViewById(R.id.list_item_image);
        imageView.setImageResource(currentMadLibItem.getImageResourceID());

        return listItemView;
    }
}

