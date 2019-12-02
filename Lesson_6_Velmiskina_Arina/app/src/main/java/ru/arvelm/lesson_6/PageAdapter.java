package ru.arvelm.lesson_6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.lang.reflect.Array;

public class PageAdapter extends FragmentPagerAdapter {

    private String[] text;
    private int[] images;

    PageAdapter(FragmentManager fragmentManager, Context context, String[] text, int[] images){
        super(fragmentManager);
        Resources resources = context.getResources();
        this.text = text;
        this.images = images;
    }

    @NonNull
    @Override
    public Fragment getItem(int position){
        Bundle arguments = new Bundle();
        arguments.putString("text", text[position]);
        arguments.putInt("image", images[position]);

        Fragment fragment = new Fragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public int getCount() {
        return text.length;
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position){
        return text[position];
    }
}
