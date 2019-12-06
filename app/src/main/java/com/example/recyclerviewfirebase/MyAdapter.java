package com.example.recyclerviewfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Profile> profiles;

    public MyAdapter(Context c, ArrayList<Profile> p)
    {
        context = c;
        profiles = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.name.setText(profiles.get(position).getName());
        holder.email.setText(profiles.get(position).getEmail());
        Picasso.get().load(profiles.get(position).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount()
    {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, email;
        ImageView image;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.id_name);
            email = (TextView) itemView.findViewById(R.id.id_email);
            image = (ImageView) itemView.findViewById(R.id.id_image);
        }
    }
}
