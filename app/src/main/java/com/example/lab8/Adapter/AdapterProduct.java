package com.example.lab8.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lab8.MainActivity;
import com.example.lab8.Modal.Product;
import com.example.lab8.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductViewHolder> {
    private ArrayList<Product> list;
    private Context context;

    public AdapterProduct(ArrayList<Product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product dt = list.get(position);

        String productID = dt.getProductId();

        holder.tv_evaluate.setText(String.valueOf(dt.getRate()));
        holder.tv_nameProduct.setText(dt.getProductName());

        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat vietnamFormat = NumberFormat.getCurrencyInstance(vietnamLocale);
        String priceFormatted = vietnamFormat.format(dt.getPrice());
        holder.tv_priceProduct.setText(priceFormatted);

        Glide.with(context)
                .load(dt.getImage())
                .into(holder.img_productItem);

        holder.tv_name_productType.setText(dt.getProductTypeId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView tv_evaluate, tv_nameProduct, tv_priceProduct, tv_name_productType;
        CardView addToCart;
        ImageView img_productItem;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_evaluate = itemView.findViewById(R.id.tv_evaluate);
            tv_nameProduct = itemView.findViewById(R.id.tv_nameProduct);
            addToCart = itemView.findViewById(R.id.addToCart);
            tv_priceProduct = itemView.findViewById(R.id.tv_priceProduct);
            img_productItem = itemView.findViewById(R.id.img_productItem);
            tv_name_productType = itemView.findViewById(R.id.tv_name_productType);
        }
    }
}
