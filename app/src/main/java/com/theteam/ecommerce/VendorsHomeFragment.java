package com.theteam.ecommerce;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.theteam.ecommerce.adapters.SimilarProductsAdapter;
import com.theteam.ecommerce.listeners.GetProductsInterface;
import com.theteam.ecommerce.models.SimilarProductsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VendorsHomeFragment extends Fragment {
    TextView businessOwner, businessName, noRecentSalesYet, noPopularProductsYet, noSimilarProductsYet;
    RecyclerView recentSales, popularAdverts, similarAdverts;
    SimilarProductsAdapter similarProductsAdapter;
    ArrayList<SimilarProductsModel> similarProductsModels;
    LinearLayoutManager linearLayoutManager;
    Retrofit retrofit;
    GetProductsInterface getProductsInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vendors_home_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        businessOwner = view.findViewById(R.id.businessOwner);
        businessName = view.findViewById(R.id.businessName);
        noRecentSalesYet = view.findViewById(R.id.noRecentSalesYet);
        noPopularProductsYet = view.findViewById(R.id.noPopularProductsYet);
        noSimilarProductsYet = view.findViewById(R.id.noSimilarProductsYet);
        recentSales = view.findViewById(R.id.recentSales);
        popularAdverts = view.findViewById(R.id.popularAdverts);
        similarAdverts = view.findViewById(R.id.similarAdverts);

        similarProductsModels = new ArrayList<>();

        callApiAllProducts();
    }

    public void callApiAllProducts(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://farm2door-6h-4h-onrender")
                .build();

        getProductsInterface = retrofit.create(GetProductsInterface.class);
        Call<ArrayList<SimilarProductsModel>> call = getProductsInterface.getAllProducts();
        call.enqueue(new Callback<ArrayList<SimilarProductsModel>>() {
            @Override
            public void onResponse(Call<ArrayList<SimilarProductsModel>> call, Response<ArrayList<SimilarProductsModel>> response) {
                if (response.isSuccessful()){
                    ArrayList<SimilarProductsModel> data = response.body();
                    similarProductsModels = data;
                    if (similarProductsModels.isEmpty()){
                        noRecentSalesYet.setVisibility(View.VISIBLE);
                        noPopularProductsYet.setVisibility(View.VISIBLE);
                        noSimilarProductsYet.setVisibility(View.VISIBLE);
                    }else {
                        noRecentSalesYet.setVisibility(View.GONE);
                        noPopularProductsYet.setVisibility(View.GONE);
                        noSimilarProductsYet.setVisibility(View.GONE);
                        getAllProducts();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<SimilarProductsModel>> call, Throwable t) {
                noRecentSalesYet.setVisibility(View.VISIBLE);
                noPopularProductsYet.setVisibility(View.VISIBLE);
                noSimilarProductsYet.setVisibility(View.VISIBLE);
            }
        });
    }

    public void getAllProducts(){
        similarProductsAdapter = new SimilarProductsAdapter(similarProductsModels);
        similarProductsAdapter = new SimilarProductsAdapter(similarProductsModels);
        linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        similarAdverts.setAdapter(similarProductsAdapter);
        similarAdverts.setLayoutManager(linearLayoutManager);
        popularAdverts.setAdapter(similarProductsAdapter);
        popularAdverts.setLayoutManager(linearLayoutManager);
        recentSales.setAdapter(similarProductsAdapter);
        recentSales.setLayoutManager(linearLayoutManager);
    }
}