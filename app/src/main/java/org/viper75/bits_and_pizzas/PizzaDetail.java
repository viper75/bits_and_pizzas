package org.viper75.bits_and_pizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.viper75.bits_and_pizzas.databinding.PizzaDetailBinding;

import java.util.Objects;

public class PizzaDetail extends AppCompatActivity {

    public static final String EXTRA_PIZZA_ID = "pizzaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PizzaDetailBinding pizzaDetailBinding = PizzaDetailBinding.inflate(getLayoutInflater());
        setContentView(pizzaDetailBinding.getRoot());

        setSupportActionBar(pizzaDetailBinding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        int pizzaId = getIntent().getIntExtra(EXTRA_PIZZA_ID, 0);
        Pizza pizza = Pizza.PIZZAS[pizzaId];

        pizzaDetailBinding.title.setText(pizza.getCaption());
        pizzaDetailBinding.image.setImageResource(pizza.getImageResource());
    }
}