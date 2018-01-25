package net.nikonorov.recyclerpageradaptersample;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.nikonorov.recyclerpageradapter.RecyclerPagerAdapter;

/**
 * Created by Vitaly Nikonorov on 22.01.2018.
 * email@nikonorov.net
 */

class MainPagerAdapter extends RecyclerPagerAdapter<MainPagerAdapter.ViewHolder> {

    private final String[] titles;
    @ColorRes
    private final int[] colors;

    MainPagerAdapter(String[] titles, int[] colors) {
        if (colors.length != titles.length) throw new IllegalArgumentException("Titles and colors should be the same number!");

        this.titles = titles;
        this.colors = colors;
    }

    @Override
    public int getDataListSize() {
        return titles.length;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int endlessPosition = isInfiniteAdapter() ? position % titles.length : position;
        holder.itemView.setBackgroundColor(colors[endlessPosition]);
        holder.captionView.setText(titles[endlessPosition]);
    }

    @Override
    protected ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pager_item, parent, false);
        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerPagerAdapter.ViewHolder {
        final TextView captionView;

        ViewHolder(View itemView) {
            super(itemView);
            captionView = itemView.findViewById(R.id.item_number_view);
        }
    }

}
