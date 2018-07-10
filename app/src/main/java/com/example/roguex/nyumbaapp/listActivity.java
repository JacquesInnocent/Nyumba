package com.example.roguex.nyumbaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class listActivity extends AppCompatActivity {

    //For Apartments in Nakawa Division alone

        int[] IMAGES = {R.drawable.brown_flats_apartments, R.drawable.lakewood_estates, R.drawable.marcelo_apartments, R.drawable.naguru_view_point, R.drawable.ntinda_view
                , R.drawable.nvilla_apartments, R.drawable.pinegrove_apartments, R.drawable.ssaima_apartments, R.drawable.sunsiri_apartments, R.drawable.apartment};
        String[] NAMES = {"Brown Flats Apartments", "Lakewood Estates", "Marcelo Apartments", "Naguru View Point", "Ntinda View Apartments", "Nville Apartments"
                , "Pinegrove Apartments", "Ssaima Apartments", "Sunsiri Apartments", "Bukoto Heights Apartments"};
        String[] PHONE = {"+256771855130","+256414255253","+256779771140","+256393517511","+256787492028","+256772406557","+256752779440","+25414695870","+256200940940","+256752711732" };
        String[] DESCRIPTION = {"Old Kira Road", "Bukoto, Kampala", "Plot 31, Binayomba Rd", "Balikuddembe Rd", "Kiwatule, Off Kira Rd", "Kampala", "Plot 3934, Kisaasi"
                , "Kimera Rd", "Plot 3 Naguru Hill Drive", "Plot 481 - 482, Moyo Cl"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter{
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
