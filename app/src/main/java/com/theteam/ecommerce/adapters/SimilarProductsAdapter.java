package com.theteam.ecommerce.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.theteam.ecommerce.R;
import com.theteam.ecommerce.models.SimilarProductsModel;

import java.util.ArrayList;

public class SimilarProductsAdapter extends RecyclerView.Adapter<SimilarProductsAdapter.SimilarProductsViewHolder> {
    ArrayList<SimilarProductsModel> similarProductsModel;
    public SimilarProductsAdapter(ArrayList<SimilarProductsModel> similarProductsModel){
        this.similarProductsModel = similarProductsModel;
    }

    @NonNull
    @Override
    public SimilarProductsAdapter.SimilarProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_similar_products, parent, false);
        return new SimilarProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarProductsAdapter.SimilarProductsViewHolder holder, int position) {
        holder.productName.setText(similarProductsModel.get(position).getProductName());
        Glide.with(holder.itemView)
                .load(similarProductsModel.get(position).getProductImage())
                .into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return similarProductsModel.size();
    }

    public static class SimilarProductsViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;

        public SimilarProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.productName);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}
