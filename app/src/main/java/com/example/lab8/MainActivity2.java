package com.example.lab8;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab8.Adapter.AdapterProduct;
import com.example.lab8.Modal.Product;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView rcv;

    ArrayList<Product> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        rcv = findViewById(R.id.rcv_Product);
        list.add(new Product("1", "fruit", "Apple", "Fresh and juicy apple", 4.5, 2.99, R.drawable.apple));
        list.add(new Product("2", "fruit", "Banana", "Ripe banana", 4.2, 1.99, R.drawable.apple));
        list.add(new Product("3", "fruit", "Orange", "Sweet and tangy orange", 4.0, 3.49, R.drawable.apple));
        list.add(new Product("4", "fruit", "Grape", "Delicious grapes", 4.3, 4.99, R.drawable.apple));

        AdapterProduct adapterProduct = new AdapterProduct(list,MainActivity2.this);
        rcv.setLayoutManager(new GridLayoutManager(this, 2));
        rcv.setAdapter(adapterProduct);
    }
}