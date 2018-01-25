package net.nikonorov.recyclerpageradaptersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import net.nikonorov.recyclerpageradaptersample.R;

/**
 * Created by Vitaly Nikonorov on 22.01.2018.
 * email@nikonorov.net
 */

public class MainActivity extends AppCompatActivity {

    private final boolean infiniteAdapter = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ViewPager pager = findViewById(R.id.pager);
        String[] titles = getResources().getStringArray(R.array.page_titles);
        MainPagerAdapter pagerAdapter = new MainPagerAdapter(titles, getResources().getIntArray(R.array.page_colors));
        pagerAdapter.setInfiniteAdapter(infiniteAdapter);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(infiniteAdapter ? Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2) % titles.length : 0);
    }

}
