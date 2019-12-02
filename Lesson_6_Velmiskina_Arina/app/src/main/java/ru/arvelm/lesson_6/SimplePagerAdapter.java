package ru.arvelm.lesson_6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

public class SimplePagerAdapter extends PagerAdapter {

    private Context mContext;

    public SimplePagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position) {
        ResourcesModel resources = ResourcesModel.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(resources.getLayoutResourceId(), viewGroup, false);
        viewGroup.addView(layout);

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup viewGroup, int position, Object view) {
        viewGroup.removeView((View) view);
    }

    @Override
    public int getCount() {
        return ResourcesModel.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ResourcesModel customPagerEnum = ResourcesModel.values()[position];

        return mContext.getString(customPagerEnum.getTitleResourceId());
    }
}