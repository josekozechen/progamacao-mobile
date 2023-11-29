package com.example.disney;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DisneyCharacterAdapter extends RecyclerView.Adapter<DisneyCharacterAdapter.ViewHolder> {

    private List<CharacterResponse.Character> characterList;

    public DisneyCharacterAdapter(List<CharacterResponse.Character> characterList) {
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CharacterResponse.Character character = characterList.get(position);

        holder.tvName.setText(character.getName());
        // Use Picasso or any other image loading library to load the image
        Picasso.get().load(character.getImageUrl()).into(holder.ivCharacterImage);
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView ivCharacterImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            ivCharacterImage = itemView.findViewById(R.id.ivCharacterImage);
        }
    }
}