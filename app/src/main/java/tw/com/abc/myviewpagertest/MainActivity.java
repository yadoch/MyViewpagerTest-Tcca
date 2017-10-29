package tw.com.abc.myviewpagertest;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinkedList<View> views;
    private ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager) findViewById(R.id.viewpager);


        initViewPager();
    }

    private void initViewPager() {
        LayoutInflater inflater = LayoutInflater.from(this);

        View Page1 =inflater.inflate(R.layout.page1,null);
        View Page2 =inflater.inflate(R.layout.page2,null);
        View Page3 =inflater.inflate(R.layout.page3,null);
        views.add(Page1);
        views.add(Page2);
        views.add(Page3);

        flipper = (ViewFlipper)Page2.findViewById(R.id.flipper);

        View f0 = flipper.getChildAt(0);
        View f1 = flipper.getChildAt(1);
        View f2 = flipper.getChildAt(2);

        viewPager.setAdapter(new MyPagerAdapter());

        f0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
    }

    private class MyPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            viewPager.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = views.get(position);
            viewPager.removeView(view);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
