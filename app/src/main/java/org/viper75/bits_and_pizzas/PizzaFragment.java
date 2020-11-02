package org.viper75.bits_and_pizzas;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.viper75.bits_and_pizzas.databinding.PizzaFragmentBinding;

public class PizzaFragment extends Fragment {

    private CaptionedImageAdapter.OnItemClickListener onItemClickedCallback = position -> {
        Intent intent = new Intent(getActivity(), PizzaDetail.class);
        intent.putExtra(PizzaDetail.EXTRA_PIZZA_ID, position);
        startActivity(intent);
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PizzaFragmentBinding pizzaFragmentBinding = PizzaFragmentBinding
                .inflate(inflater, container, false);

        CaptionedImageAdapter adapter = new CaptionedImageAdapter(getActivity());
        adapter.setOnItemClickListener(onItemClickedCallback);
        pizzaFragmentBinding.pizzasRv.setAdapter(adapter);
        pizzaFragmentBinding.pizzasRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return pizzaFragmentBinding.getRoot();
    }
}