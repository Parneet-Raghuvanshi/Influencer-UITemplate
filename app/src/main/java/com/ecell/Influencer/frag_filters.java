package com.ecell.Influencer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class frag_filters extends Fragment {

    RecyclerView r_game,r_sports,r_locations,r_programming,r_entertainment;
    Filters_Adapter adaptergame,adaptersport,adapterlocation,adapterprogramming,adapterentertainment;
    ArrayList<FilterModel> gamelist,sportlist,locationlist,programminglist,entertainmentlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_filters, container, false);

        gamelist = new ArrayList<FilterModel>();
        gamelist.add(new FilterModel("CSGO",R.drawable.csgo_game));
        gamelist.add(new FilterModel("Fortnite",R.drawable.fortnite_game));
        gamelist.add(new FilterModel("GTA 5",R.drawable.gta5_game));
        gamelist.add(new FilterModel("Warzone",R.drawable.warzone_game));

        sportlist = new ArrayList<FilterModel>();
        sportlist.add(new FilterModel("Cricket",R.drawable.cricket_sports));
        sportlist.add(new FilterModel("Football",R.drawable.football_sport));
        sportlist.add(new FilterModel("BodyBuilding",R.drawable.body_sports));
        sportlist.add(new FilterModel("Badminton",R.drawable.badminton_sports));

        locationlist = new ArrayList<FilterModel>();
        locationlist.add(new FilterModel("Ghaziabad",R.drawable.ghaziabad_location));
        locationlist.add(new FilterModel("Mathura",R.drawable.mathura_location));
        locationlist.add(new FilterModel("Delhi",R.drawable.delhi_location));
        locationlist.add(new FilterModel("Mumbai",R.drawable.mumbai_location));

        programminglist = new ArrayList<FilterModel>();
        programminglist.add(new FilterModel("Database",R.drawable.java_programming));
        programminglist.add(new FilterModel("Python",R.drawable.python_programming));
        programminglist.add(new FilterModel("Android",R.drawable.android_programming));
        programminglist.add(new FilterModel("Java",R.drawable.java_programming));

        entertainmentlist = new ArrayList<FilterModel>();
        entertainmentlist.add(new FilterModel("Movies",R.drawable.movies_enter));
        entertainmentlist.add(new FilterModel("Standup Comedy",R.drawable.standup_enter));
        entertainmentlist.add(new FilterModel("Memes",R.drawable.memes_enter));
        entertainmentlist.add(new FilterModel("Books",R.drawable.book_enter));

        r_game = view.findViewById(R.id.recyclerview_game);
        adaptergame = new Filters_Adapter(gamelist);
        r_game.setHasFixedSize(true);
        r_game.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        r_game.setAdapter(adaptergame);

        r_sports = view.findViewById(R.id.recyclerview_sports);
        adaptersport = new Filters_Adapter(sportlist);
        r_sports.setHasFixedSize(true);
        r_sports.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        r_sports.setAdapter(adaptersport);

        r_locations = view.findViewById(R.id.recyclerview_nearbylocations);
        adapterlocation = new Filters_Adapter(locationlist);
        r_locations.setHasFixedSize(true);
        r_locations.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        r_locations.setAdapter(adapterlocation);

        r_programming = view.findViewById(R.id.recyclerview_programming);
        adapterprogramming = new Filters_Adapter(programminglist);
        r_programming.setHasFixedSize(true);
        r_programming.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        r_programming.setAdapter(adapterprogramming);

        r_entertainment = view.findViewById(R.id.recyclerview_entertainment);
        adapterentertainment = new Filters_Adapter(entertainmentlist);
        r_entertainment.setHasFixedSize(true);
        r_entertainment.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        r_entertainment.setAdapter(adapterentertainment);

        return view;
    }
}