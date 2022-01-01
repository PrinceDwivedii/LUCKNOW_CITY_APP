package com.r.pqr.HelperClasses.homeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.r.pqr.R;

import java.util.ArrayList;

public class CatogeryAdapter extends RecyclerView.Adapter<CatogeryAdapter.CategoryViewHolder> {

    ArrayList<CategoryHelperClass> categoryLocation;

    public CatogeryAdapter(ArrayList<CategoryHelperClass> categoryLocation) {
        this.categoryLocation = categoryLocation;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryHelperClass categoryHelperClass = categoryLocation.get(position);
        holder.image.setImageResource(categoryHelperClass.getImage());
        holder.title.setText(categoryHelperClass.getTitle());
    }

    @Override
    public int getItemCount() {
        return categoryLocation.size() ;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.ct_image);
            title = itemView.findViewById(R.id.ct_textView);
        }
    }
}
