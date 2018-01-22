package net.nikonorov.library;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaly Nikonorov on 22.01.2018.
 * email@nikonorov.net
 */

public abstract class RecyclerPagerAdapter<VH extends RecyclerPagerAdapter.ViewHolder> extends PagerAdapter {
    private static final String TAG = RecyclerPagerAdapter.class.getSimpleName();

    private static final int DEFAULT_VIEW_POOL_SIZE = 5;
    private final List<View> viewPool = new ArrayList<>(DEFAULT_VIEW_POOL_SIZE);
    private boolean infiniteAdapter = false;
    private int viewPoolSize = DEFAULT_VIEW_POOL_SIZE;

    public abstract int getDataListSize();

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    protected abstract void onBindViewHolder(@NonNull VH holder, int position);

    protected abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    protected int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return infiniteAdapter ? Integer.MAX_VALUE : getDataListSize();
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        Log.d(TAG, String.format("Instantiate item start, position = %d", position));
        VH holder;
        View itemView;
        if (!viewPool.isEmpty()) {
            itemView = viewPool.get(viewPool.size() - 1);
            viewPool.remove(itemView);
            holder = (VH) itemView.getTag();
            Log.d(TAG, "Item got from view pool");
        } else {
            holder = onCreateViewHolder(collection, getItemViewType(position));
            holder.itemView.setTag(holder);
            Log.d(TAG, "Item instantiated as a new view");
        }
        onBindViewHolder(holder, position);
        collection.addView(holder.itemView);
        return holder.itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.d(TAG, String.format("Destroy item on position = %d", position));
        View itemView = (View) object;
        container.removeView(itemView);
        if (viewPool.size() < viewPoolSize) {
            viewPool.add(itemView);
        }
        Log.d(TAG, String.format("Item destroyed, position = %d", position));
    }

    public void setInfiniteAdapter(boolean infiniteAdapter) {
        this.infiniteAdapter = infiniteAdapter;
    }

    public boolean isInfiniteAdapter() {
        return infiniteAdapter;
    }

    public void setViewPoolSize(int viewPoolSize) {
        if (viewPoolSize < 0) throw new IllegalArgumentException("Size of view pool can not be negative number");
        this.viewPoolSize = viewPoolSize;
    }

    public abstract static class ViewHolder {
        public final View itemView;
        public ViewHolder(View itemView) {
            this.itemView = itemView;
        }
    }
}
