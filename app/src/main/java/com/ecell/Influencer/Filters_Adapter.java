package com.ecell.Influencer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Filters_Adapter extends RecyclerView.Adapter<Filters_Adapter.Filters_Viewholder> {

    private ArrayList<FilterModel> filters;

    public Filters_Adapter(ArrayList<FilterModel> filters) {
        this.filters = filters;
    }

    @NonNull
    @Override
    public Filters_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listitem = layoutInflater.inflate(R.layout.templatefilter,parent,false);
        Filters_Adapter.Filters_Viewholder viewholder = new Filters_Adapter.Filters_Viewholder(listitem);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Filters_Viewholder holder, int position) {
        final FilterModel filterModel = filters.get(position);
        holder.item_text.setText(filterModel.getName());
        holder.item_image.setImageResource(filterModel.getImageid());
    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    public static class Filters_Viewholder extends RecyclerView.ViewHolder {

        public ImageView item_image;
        public TextView item_text;

        public Filters_Viewholder(@NonNull View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.image_item);
            item_text = itemView.findViewById(R.id.item_text);
        }
    }

}
