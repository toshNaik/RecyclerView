package com.example.naik.recyclervvew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PizzaAdapter pizzaAdapter;
    private RecyclerView r1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
        getManualData();
    }
    private void initView() {
        r1 = findViewById(R.id.view_recycler);
    }
    private void init() {
        pizzaAdapter = new PizzaAdapter(this);
        r1.setLayoutManager(new LinearLayoutManager(this));
        r1.setAdapter(pizzaAdapter);
    }
    private void getManualData() {
        List<Pizza> pizzas = new ArrayList<>(10);
        for (long i=0;i<20;i++) {
            Pizza pizza = new Pizza();
            pizza.setId(i);
            pizza.setName("Pizza name" + i);
            pizza.setDescription("This is the description for pizza" + i);
            pizzas.add(pizza);
        }
        pizzaAdapter.setData(pizzas);
    }
}