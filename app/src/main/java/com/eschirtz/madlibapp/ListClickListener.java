package com.eschirtz.madlibapp;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Eschirtz on 1/18/17.
 */

public class ListClickListener implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(parent.getContext(), Game.class);
        MadLibItem madLibItem = (MadLibItem) parent.getItemAtPosition(position);
        String title = madLibItem.getTitle();
        String template = madLibItem.getTemplate();
        intent.putExtra("title", title);
        intent.putExtra("template", template);
        view.getContext().startActivity(intent);
    }
}
