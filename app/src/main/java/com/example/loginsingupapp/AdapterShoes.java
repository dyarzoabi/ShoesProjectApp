package com.example.loginsingupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterShoes extends RecyclerView.Adapter<AdapterShoes.ViewHolder> {

    private List<Sneakers> mData;
    private LayoutInflater mInflater;
    private AdapterShoes.ItemClickListener mClickListener;

    // data is passed into the constructor
    AdapterShoes(Context context, List<Sneakers> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }
    // inflates the row layout from xml when needed
    @Override
    public AdapterShoes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row, parent, false);
        return new AdapterShoes.ViewHolder(view);
    }
    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(AdapterShoes.ViewHolder holder, int position) {
        Sneakers rest = mData.get(position);
        holder.tvName.setText(rest.getName());
        //holder.ivPhoto.setImageDrawable(rest.getPhoto());
    }
    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        ImageView ivPhoto;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.NameRow);
            ivPhoto = itemView.findViewById(R.id.PhotoRow);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Sneakers getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(AdapterShoes.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
