package org.viper75.bits_and_pizzas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.viper75.bits_and_pizzas.databinding.CaptionedImageLayoutBinding;

public class CaptionedImageAdapter extends RecyclerView.Adapter<CaptionedImageAdapter.CaptionedImageViewHolder> {

    public interface OnItemClickListener {
        void onClick(int position);
    }

    static class CaptionedImageViewHolder extends RecyclerView.ViewHolder {

        private CardView root;
        private ImageView image;
        private TextView caption;

        public CaptionedImageViewHolder(@NonNull CaptionedImageLayoutBinding binding) {
            super(binding.getRoot());

            root = binding.getRoot();
            image = binding.image;
            caption = binding.caption;
        }
    }

    private LayoutInflater mLayoutInflater;
    private OnItemClickListener mOnItemClickListener;
    private Pizza[] mPizzas;

    public CaptionedImageAdapter (Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mPizzas = Pizza.PIZZAS;
    }

    @NonNull
    @Override
    public CaptionedImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CaptionedImageViewHolder(CaptionedImageLayoutBinding.inflate(mLayoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CaptionedImageViewHolder holder, int position) {
        Pizza pizza = mPizzas[position];

        holder.caption.setText(pizza.getCaption());
        holder.image.setImageResource(pizza.getImageResource());
        holder.root.setOnClickListener(v -> {

            if (mOnItemClickListener == null)
                throw new ClassCastException("No item click listener provided.");

            mOnItemClickListener.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return mPizzas.length;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
}
