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

public class MsAdapter extends RecyclerView.Adapter<MsAdapter.FeaturedViewHolder> {

    ArrayList<MsFeaturedHelperclass> featuredLocation;

    public MsAdapter(ArrayList<MsFeaturedHelperclass> featuredLocation) {
        this.featuredLocation = featuredLocation;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed, parent, false);
        FeaturedAdapter.FeaturedViewHolder featuredViewHolder = new FeaturedAdapter.FeaturedViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        MsFeaturedHelperclass msFeaturedHelperclass = featuredLocation.get(position);

        holder.image.setImageResource(msFeaturedHelperclass.getImage());
        holder.title.setText(msFeaturedHelperclass.getTitle());
        holder.description.setText(msFeaturedHelperclass.getDescription());


    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,description;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.ms_view);
            title = itemView.findViewById(R.id.mv_title);
            description = itemView.findViewById(R.id.ms_desc);
        }
    }
}
