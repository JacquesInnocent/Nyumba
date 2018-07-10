package com.example.roguex.nyumbaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class listActivity3 extends AppCompatActivity {

    //For Apartments in Rubaga Division alone

    int[] IMAGES = {R.drawable.speke, R.drawable.summit_view, R.drawable.apartment, R.drawable.tagore, R.drawable.acacia_green};
    String[] NAMES = {"Speke Apartments", "Summit View Kololo", "Tagore Apartments", "Acacia Green Apartments"};
    String[] PHONE = {"+256752711704", "+256312298208", "+256704601264", "+256414533576"};
    String[] DESCRIPTION = {"Plot No 19, 21 Wampewo Ave", "Kololo Hill Drive", "Tagore Cresent", "Plot 6-10, Makindu Lane"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);
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
            TextView textView_contact = view.findViewById(R.id.textView_contact);
            TextView textView_description = view.findViewById(R.id.textView_description);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_contact.setText(PHONE[i]);
            textView_description.setText(DESCRIPTION[i]);

            return view;
        }
    }
}