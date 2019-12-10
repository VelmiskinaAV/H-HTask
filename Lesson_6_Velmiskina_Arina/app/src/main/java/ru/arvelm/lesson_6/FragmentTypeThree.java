package ru.arvelm.lesson_6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class FragmentTypeThree extends Fragment {

    Button buttonShow, buttonHide;
    ViewPager viewPager;

    FragmentTypeThree(){
    }

    public int[] mImages = new int[] {
            R.drawable.image_one,
            R.drawable.image_two,
            R.drawable.image_three
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){

            View v = inflater.inflate(R.layout.fragment_type_three, container, false);
            buttonShow = v.findViewById(R.id.buttonShow);
            buttonHide = v.findViewById(R.id.buttonHide);
            buttonHide.setVisibility(View.GONE);

            buttonShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonShow.setVisibility(View.GONE);
                    buttonHide.setVisibility(View.VISIBLE);

                    ImagePagerAdapter adapterImage = new ImagePagerAdapter(mImages);
                    viewPager.setAdapter(adapterImage);
                    viewPager.setVisibility(View.VISIBLE);
                }
            });

            viewPager = v.findViewById(R.id.view_pager);

            buttonHide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonShow.setVisibility(View.VISIBLE);
                    buttonHide.setVisibility(View.GONE);
                    viewPager.setVisibility(View.GONE);
                }
            });

            return v;
    }

    private class ImagePagerAdapter extends PagerAdapter {
        private int[] mImages;

        ImagePagerAdapter(int mImages[]){
            this.mImages = mImages;
        }
        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            final Context context = container.getContext();
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(mImages[position]);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, String.format("Image "), Toast.LENGTH_SHORT).show();
                }
            });

            container.addView(imageView, 0);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            (container).removeView((ImageView) object);
        }
    }
}

