package com.example.hhuang66.workshop5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.hhuang66.workshop5.MainActivity;
//import com.example.hhuang66.workshop5.R;

/**
 * Created by hhuang66 on 2/14/2017.
 */

public class MyCustomAdapter extends BaseAdapter{
//let's declare some instance variables to hold essential data
    String[] description;
    int [] images;
    Context context;

    //constructor to set up our instance variable
    public MyCustomAdapter(MainActivity context, String[] d, int[] i) {
        context = context;
        description = d;
        images = i;

    }
    @Override
    public int getCount() {
return description.length;
       // return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

  /*
  the android framworkd will call getView every time it needs to draw you ListView
  int position indicates which row the framework is trying to draw
    */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       // return null;
        View row; //a reference to refer to each row
        //LayoutInflater is a class that creates a Java object from the xml layout
        //we get a LayoutInflater from the framwork by calling getSystemService
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //use the LayoutInflater to create a new View of the correct type (custom_list)
        row = inflater.inflate(R.layout.custom_list,null);
        //get the TextView and set its text!
        TextView textView = (TextView) row.findViewById(R.id.textView);
        textView.setText(description[position]);
        //get the ImageView and set its image icon
        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        //we need  to add an onClickListener to respond to user clicks!
        row.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            //for new show a toast.. later you will broadcast an intent to start the Web Browser
                Toast.makeText(context, description[position], Toast.LENGTH_LONG).show();
            }
            });
        //don't forget to return a View!
        return row;

    }
}
