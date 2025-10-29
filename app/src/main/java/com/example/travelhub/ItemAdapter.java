package com.example.travelhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyviewHolder>{

    Context C;
    ArrayList<String> Title = new ArrayList<>();
    ArrayList<Integer> ImageAddress = new ArrayList<>();

    public ItemAdapter(Context c, ArrayList<String> title, ArrayList<Integer> imageAddress) {
        C = c;
        Title = title;
        ImageAddress = imageAddress;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview = LayoutInflater.from(C).inflate(R.layout.recycler_layout,parent,false);
        return new MyviewHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        holder.txtTitle.setText(Title.get(position));
        holder.imgView.setImageResource(ImageAddress.get(position));

    }

    @Override
    public int getItemCount() {
        return Title.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        ImageView imgView;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.TitleRecycle);
            imgView = itemView.findViewById(R.id.imgRecycle);
        }
    }
}
