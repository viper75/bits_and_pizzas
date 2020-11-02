package org.viper75.bits_and_pizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import org.viper75.bits_and_pizzas.databinding.CreateOrderBinding;

import java.util.Objects;

public class CreateOrder extends AppCompatActivity {

    private CreateOrderBinding mCreateOrderBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCreateOrderBinding = CreateOrderBinding.inflate(getLayoutInflater());
        setContentView(mCreateOrderBinding.getRoot());

        setSupportActionBar(mCreateOrderBinding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Create Order");

        mCreateOrderBinding.saveOrder.setOnClickListener(v -> saveOrder());
    }

    private void saveOrder() {
        Snackbar snackbar = Snackbar.make(mCreateOrderBinding.getRoot(),
                "You order has been successfully saved!", BaseTransientBottomBar.LENGTH_LONG);
        snackbar.setAction("Undo", v -> {
            Toast.makeText(this, "Undone!!", Toast.LENGTH_SHORT).show();
        });
        snackbar.show();
    }
}