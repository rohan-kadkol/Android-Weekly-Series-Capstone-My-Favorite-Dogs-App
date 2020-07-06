package com.rohankadkol.favoritedogsappfinal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohankadkol.favoritedogsappfinal.R;
import com.rohankadkol.favoritedogsappfinal.pojos.Dog;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.DogViewHolder> {
    private Context mContext;
    private List<Dog> mDogs;

    public DogsAdapter(Context context, List<Dog> dogs) {
        mContext = context;
        mDogs = dogs;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_dog, parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mDogs != null ? mDogs.size() : 0;
    }

    class DogViewHolder extends RecyclerView.ViewHolder {
        ImageView ivDog;
        TextView tvBreed;
        TextView tvName;

        DogViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDog = itemView.findViewById(R.id.iv_dog);
            tvBreed = itemView.findViewById(R.id.tv_breed);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        void bind(int position) {
            Dog dog = mDogs.get(position);
            Picasso.get().load(dog.getImageUrl()).into(ivDog);
            tvBreed.setText(dog.getBreed());
            tvName.setText(dog.getName());
        }
    }
}
