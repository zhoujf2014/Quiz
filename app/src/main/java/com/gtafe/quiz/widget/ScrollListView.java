package com.gtafe.quiz.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * recycleview包裹listview滑动冲突
 * Created by liulin on 2017/6/9.
 */
public class ScrollListView extends ListView {
    public ScrollListView(Context context) {
        super(context);
    }

    public ScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mExpandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, mExpandSpec);
    }

   /* public void setListHeight(ListView mListView) {
        //获取ListView的adapter
        ListAdapter adapter = mListView.getAdapter();
        if (adapter == null) {
            return;
        }
//子条目的总高度
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
//逐个获取每个Item的
            View itemView = (View) adapter.getItem(i);
            itemView.measure(0, 0);
            totalHeight += itemView.getMeasuredHeight();
        }
//接下来是获取每个ItemVIew在竖直方向的间隔
        ViewGroup.LayoutParams params = mListView.getLayoutParams();
        params.height = totalHeight + (mListView.getDividerHeight()) * (adapter.getCount() - 1);
        mListView.setLayoutParams(params);
    }*/
}
