package com.example.zahiduck.aniversario;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class InfiniteAdapter extends PagerAdapter {
    private Context activity;
    private int [] image;
    private int pos = 0;

    public InfiniteAdapter(Context activity,int [] image){
        this.activity = activity;
        this.image = image;
    }

    public int getCount(){
        return Integer.MAX_VALUE;
    }

    public Object instantiateItem(ViewGroup container, int position){
        ImageView img = new ImageView(activity);
        ((ViewPager)container).addView(img);
        img.setImageResource(image[pos]);

        if(pos >= image.length -1 )
            pos = 0;
        else
            ++pos;

        Log.i("Posittion", pos+"");
        return  img;
    }

    public boolean isViewFromObject(View view, Object object) {return view == ((View)object);}

    public void destroyItem(ViewGroup container, int position, Object object){
        ((ViewPager)container).removeView((View)object);
    }
}
