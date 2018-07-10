package com.example.roguex.nyumbaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class listActivity2 extends AppCompatActivity {

    //For Apartments in Kampala Central Division only

    int[] IMAGES = {R.drawable.olive_apartments, R.drawable.selina_apartment, R.drawable.comboni, R.drawable.lake_victoria, R.drawable.eka_guest
            , R.drawable.sapphire, R.drawable.buziga, R.drawable.pearl_apartments, R.drawable.lj};
    String[] NAMES = {"Olive Apartments", "Selina Apartments", "Comboni Apartments", "Lake Victoria Masionettes", "Eka Guest Apartments", "Supphire Apartments UG"
            , "Buziga Apartments", "Pearl Apartments", "L.J Apartments"};
    String[] PHONES = {"+256774435110", "+256782 467777", "No contact", "+256782271033", "+256788594721", "No contact", "No contacts", "+256750917598", "+256773456681"};
    String[] DESCRIPTION = {"Muyenga, Kampala", "2745 Tank Hill Rd", "Plot 3513, Black gate kironde", "Common Wealth Road, Munyonyo", "Munyonyo", "Buziga, kampala", "Buziga, kampala", "Wavamunno Road", "Muyenga, Victoria shores"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

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
            textView_contact.setText(PHONES[i]);
            textView_description.setText(DESCRIPTION[i]);

            return view;
        }
    }
}