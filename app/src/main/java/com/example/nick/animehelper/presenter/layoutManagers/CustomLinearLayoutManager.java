package com.example.nick.animehelper.presenter.layoutManagers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

public class CustomLinearLayoutManager extends LinearLayoutManager {

    private Context context;

    public CustomLinearLayoutManager(Context context) {
        super(context);
        this.context = context;
    }

    public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        this.context = context;
    }

    public CustomLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }


    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        super.smoothScrollToPosition(recyclerView, state, position);
        LinearSmoothScroller smoothScroller = new LinearSmoothScroller(this.context){
            private static final float SPEED = 25f;// Change this value (default=25f)

            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                //return SPEED/displayMetrics.densityDpi;
                return 1;
            }
        };
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);


    }
}
