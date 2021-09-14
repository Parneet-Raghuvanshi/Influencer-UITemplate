package com.ecell.Influencer;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Influencer_Adapter extends RecyclerView.Adapter<Influencer_Adapter.Influencer_Viewholder> implements Filterable {

    private ArrayList<Influencerdata> influencerdata;
    private ArrayList<Influencerdata> influencerdatafull;
    private String filter_cs;

    public Influencer_Adapter(ArrayList<Influencerdata> influencerdata) {
        this.influencerdata = influencerdata;
        influencerdatafull = new ArrayList<>(influencerdata);
    }

    @NonNull
    @Override
    public Influencer_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listitem = layoutInflater.inflate(R.layout.profile_temp,parent,false);
        Influencer_Viewholder viewholder = new Influencer_Viewholder(listitem);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Influencer_Viewholder holder, int position) {
        final Influencerdata influencerdatatemp = influencerdata.get(position);
        holder.user_name.setText(influencerdatatemp.getName());
        holder.user_genre.setText(influencerdatatemp.getGenre());
        holder.user_followers.setText(influencerdatatemp.getFollowers());
        holder.user_desig.setText(influencerdatatemp.getCategory());
        if (influencerdatatemp.getGender()=="male"){
            holder.user_image.setImageResource(R.drawable.profile);
        }
        else {
            holder.user_image.setImageResource(R.drawable.woman);
        }
        if (influencerdatatemp.getPlatform()=="Youtube"){
            holder.user_genre_icon.setImageResource(R.drawable.youtube);
        }
        else if (influencerdatatemp.getPlatform()=="Instagram"){
            holder.user_genre_icon.setImageResource(R.drawable.instagram);
        }
        else if (influencerdatatemp.getPlatform()=="Twitch"){
            holder.user_genre_icon.setImageResource(R.drawable.twitch);
        }
        else if (influencerdatatemp.getPlatform()=="Blogger"){
            holder.user_genre_icon.setImageResource(R.drawable.blogger);
        }
    }

    @Override
    public int getItemCount() {
        return influencerdata.size();
    }

    public void setFilter_cs(String filter_temp){
        filter_cs = filter_temp;
    }

    @Override
    public Filter getFilter() {
        return newFilter;
    }

    private Filter newFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<Influencerdata> filteredlist = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0){
                filteredlist.addAll(influencerdatafull);
            }
            else {
                String filterpattern = charSequence.toString().toLowerCase().trim();

                for (Influencerdata item : influencerdatafull){
                    if (filter_cs == "PLT"){
                        if (item.getPlatform().toLowerCase().contains(filterpattern)){
                            filteredlist.add(item);
                        }
                    }
                    else {
                        if (item.getName().toLowerCase().contains(filterpattern)){
                            filteredlist.add(item);
                        }
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredlist;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            influencerdata.clear();
            influencerdata.addAll((ArrayList) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public static class Influencer_Viewholder extends RecyclerView.ViewHolder {

        public ImageView user_image;
        public ImageView user_genre_icon;
        public TextView user_name;
        public TextView user_desig;
        public TextView user_genre;
        public TextView user_followers;

        public Influencer_Viewholder(@NonNull View itemView) {
            super(itemView);
            this.user_image = itemView.findViewById(R.id.user_image);
            this.user_genre_icon = itemView.findViewById(R.id.user_genre_icon);
            this.user_name = itemView.findViewById(R.id.user_name);
            this.user_desig = itemView.findViewById(R.id.user_desig);
            this.user_genre = itemView.findViewById(R.id.user_genre);
            this.user_followers = itemView.findViewById(R.id.user_followers);
        }
    }
}
