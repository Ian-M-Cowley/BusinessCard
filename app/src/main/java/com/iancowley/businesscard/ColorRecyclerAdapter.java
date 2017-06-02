package com.iancowley.businesscard;

import android.databinding.DataBindingUtil;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iancowley.businesscard.databinding.ItemColorBinding;

/**
 * Created by iancowley on 6/2/17.
 */

public class ColorRecyclerAdapter extends RecyclerView.Adapter<ColorRecyclerAdapter.ViewHolder> {

    private @ColorInt int[] colors;
    private @ColorInt int[] textColors;
    private String[] colorNames;
    private ColorRecyclerAdapterListener listener;

    public ColorRecyclerAdapter(@NonNull @ColorInt int[] colors, @NonNull @ColorInt int[] textColors,
                                @NonNull String[] colorNames, @NonNull ColorRecyclerAdapterListener listener) {
        this.colors = colors;
        this.textColors = textColors;
        this.colorNames = colorNames;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemColorBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_color, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        @ColorInt int color = colors[position];
        @ColorInt int textColor = textColors[position];
        String colorName = colorNames[position];
        viewHolder.bind(color, textColor, colorName);
        viewHolder.itemView.setTag(color);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedColor = (int) view.getTag();
                listener.onColorSelected(selectedColor);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (colors == null) return 0;
        return colors.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemColorBinding binding;

        public ViewHolder(ItemColorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(@ColorInt int color, @ColorInt int textColor, String colorName) {
            binding.setColor(color);
            binding.setTextColor(textColor);
            binding.setColorName(colorName);
        }
    }

    public interface ColorRecyclerAdapterListener {
        void onColorSelected(@ColorInt int color);
    }
}
