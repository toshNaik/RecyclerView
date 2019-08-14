package com.example.naik.recyclervvew;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {
    private List<Pizza> pizzas;
    private LayoutInflater inflater;
    private Context context;

    public PizzaAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        pizzas = new ArrayList<>();
    }

    public void setData(List<Pizza> pizzas) {
        this.pizzas.clear();
        this.pizzas.addAll(pizzas);
        notifyDataSetChanged();
    }
    public void addData(List<Pizza> pizzas) {
        this.pizzas.addAll(pizzas);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.e("PizzaAdapter", "onCreateViewHolder: ");
        View itemView = inflater.inflate(R.layout.card_view,viewGroup,false);
        return new PizzaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder pizzaViewHolder, int i) {
        Log.e("PizzaAdapter", "onBindViewHolder: ");
        pizzaViewHolder.bind();
    }

    @Override
    public int getItemCount() {
        return pizzas.size();
    }

    public class PizzaViewHolder extends RecyclerView.ViewHolder {

        private TextView txtPizzaName;
        private TextView txtPizzaDes;
        private ImageView imgPizza;
        public PizzaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPizzaName = itemView.findViewById(R.id.txt_pizzaName);
            txtPizzaDes = itemView.findViewById(R.id.txt_pizzaDes);
            imgPizza = itemView.findViewById(R.id.imageView);
        }

        public void bind() {
            Pizza pizza = pizzas.get(getAdapterPosition());
            txtPizzaName.setText(pizza.getName());
            txtPizzaDes.setText(pizza.getDescription());
            Picasso.with(context)
                    .load("https://i.imgur.com/DvpvklR.png")
                    .error(R.drawable.ic_pizza)
                    .into(imgPizza);


            //imgPizza.setImageResource(R.drawable.ic_pizza);
        }
    }
}
