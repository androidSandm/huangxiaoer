package com.example.boylucky.myfirst.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by BoyLucky on 2018/7/12.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    int mSpace;
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;


    }

    public SpaceItemDecoration(int space) {
        this.mSpace = space;
    }
}
