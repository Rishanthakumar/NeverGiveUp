package com.example.rishanthakumarrasarathinam.nevergiveup;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rishanthakumarrasarathinam on 4/6/16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PostViewHolder> {
    List<Posts> posts;


    RVAdapter(List<Posts> posts){
        this.posts = posts;
    }

    @Override
    public RVAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detailed_posts, parent, false);

        PostViewHolder pvh = new PostViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(RVAdapter.PostViewHolder holder, int position) {

        holder.personName.setText(posts.get(position).name);
        holder.personAge.setText(posts.get(position).age);
        holder.personPhoto.setImageResource(posts.get(position).photoId);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PostViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }
}
