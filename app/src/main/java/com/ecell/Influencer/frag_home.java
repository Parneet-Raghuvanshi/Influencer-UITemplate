package com.ecell.Influencer;

import android.app.Application;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class frag_home extends Fragment {

    RecyclerView recyclerView;
    Influencer_Adapter adapter;
    SearchView searchView;
    ArrayList<Influencerdata> list;
    ImageView dropdown_btn;
    boolean drop = false;
    RelativeLayout dropdown_body;
    ImageView cross_btn;
    TextView card_text;
    CardView card_choose,card_platform;
    String custom_filter= "NULL";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_home, container, false);

        searchView = view.findViewById(R.id.search_view);
        dropdown_btn = view.findViewById(R.id.dropdown_btn);
        dropdown_body = view.findViewById(R.id.dropdown_body);
        cross_btn = view.findViewById(R.id.cross_btn_card);
        card_text = view.findViewById(R.id.text_in);
        card_choose = view.findViewById(R.id.card_choosed);
        card_platform = view.findViewById(R.id.card_platform);

        list = new ArrayList<Influencerdata>();
        list.add(new Influencerdata("Parneet Raghuvanshi","AlphaGaming","Youtube","Gaming","male","CSGO#GTA5","Ghaziabad","1.2 M"));
        list.add(new Influencerdata("Nishant Jawla","ReviewerNishant","Youtube","Movies","male","Horror","Ghaziabad","450 K"));
        list.add(new Influencerdata("Ananya Shukla","ananya@official","Instagram","Fashion","female","Gucci","New Delhi","648 K"));
        list.add(new Influencerdata("Utkarsh Jain","food_ninja","Twitch","Food","male","Fast Food","Mumbai","351 K"));
        list.add(new Influencerdata("Atrij Dixit","education_everyone","Youtube","Education","male","JAVA","Banglore","450 K"));
        list.add(new Influencerdata("Pranav Shukla","techforlife","Blogger","Tech","male","Reviews","Lucknow","3.6 M"));
        list.add(new Influencerdata("Harshit Saxena","motivation4life","Instagram","motivation","male","speech","Haryana","2.6 M"));
        list.add(new Influencerdata("Iqra","ArtLife","Twitch","artist","female","nailart","Modinagar","751 K"));

        recyclerView = view.findViewById(R.id.recyclerview_home);
        adapter = new Influencer_Adapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        cross_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card_choose.setVisibility(View.GONE);
                custom_filter = "NULL";
            }
        });

        card_platform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card_choose.setVisibility(View.VISIBLE);
                dropdown_body.setVisibility(View.GONE);
                custom_filter = "PLT";
                drop = false;
            }
        });

        dropdown_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drop){
                    dropdown_body.setVisibility(View.GONE);
                    drop = false;
                }
                else {
                    dropdown_body.setVisibility(View.VISIBLE);
                    drop = true;
                }
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.setFilter_cs(custom_filter);
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }
}