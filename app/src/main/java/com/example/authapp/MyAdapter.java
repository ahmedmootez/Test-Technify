package com.example.authapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Article> list;

    public MyAdapter(Context context, ArrayList<Article> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
Article article=list.get(position);
holder.articleName.setText(article.name);
holder.articlePrice.setText(article.price);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

TextView articleName,articlePrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            articleName=itemView.findViewById(R.id.articleName);
            articlePrice=itemView.findViewById(R.id.articlePrice);

        }
    }
}
