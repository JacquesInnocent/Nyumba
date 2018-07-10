package com.example.roguex.nyumbaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class listActivity5 extends AppCompatActivity {

    //For Apartments in Makindye Division alone
    int[] IMAGES = {R.drawable.apartment, R.drawable.apartment, R.drawable.apartment, R.drawable.apartment, R.drawable.apartment
            , R.drawable.apartment, R.drawable.apartment, R.drawable.apartment, R.drawable.apartment, R.drawable.apartment};
    String[] NAMES = {"apartment", "apartment", "apartment", "apartment", "apartment", "apartment"
            , "apartment", "apartment", "apartment", "apartment"};
    String[] DESCRIPTION = {"apartment1", "apartment2", "apartment3", "apartment4", "apartment5", "apartment6", "apartment7"
            , "apartment8", "apartment9", "apartment10"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list5);

        ListView listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount(){
            return IMAGES.length;
        }
        @Override
        public Object getItem(int i){
            return null;
        }

        @Override
        public long getItemId(int i){
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup){

            view = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView imageView= view.findViewById(R.id.imageView);
            TextView textView_name = view.findViewById(R.id.textView_name);
            TextView textView_description = view.findViewById(R.id.textView_description);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTION[i]);

            return view;
        }
    }
}

