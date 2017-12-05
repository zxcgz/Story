package com.story.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.story.R;

/**
 * Created by lenovo on 2017/12/5.
 */

public class WriteFinishAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private String mStory;
    private int mCount = 1;
    private char[] mStoryChar ;
    private StringBuffer mStoryBak ;
    private TextPaint mPaint;
    private int mWindowWidth;
    private ViewGroup mParent ;

    public WriteFinishAdapter(Context context, String story,ViewGroup parent) {
        mContext = context;
        mStory = story;
        mParent = parent ;
        //测量字符串长度
        measureLength();
    }

    private void measureLength() {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.listview_textview, mParent, false);
        TextView text = (TextView) layout.findViewById(R.id.list_writeFinish);
        mPaint = text.getPaint();
        int v = (int) mPaint.measureText(mStory);
        //获取屏幕的宽度
        WindowManager wm1 = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        mWindowWidth = wm1.getDefaultDisplay().getWidth();
        //获取需要分成几行
        mCount = v/mWindowWidth ;
        mStoryChar = mStory.toCharArray() ;
        mStoryBak = new StringBuffer(mStory) ;
        Log.e("行数",mCount+"...."+mWindowWidth+"...."+mStory);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.listview_textview, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //设置每一行的数据
        MyHolder myHolder = (MyHolder) holder;
        StringBuffer storyInLine = new StringBuffer() ;
        int i ;
        for(i = 0;i<mStoryBak.length();i++){
            storyInLine.append(mStoryBak.substring(i,i+1)) ;
            int v = (int) mPaint.measureText(storyInLine.toString());
            if (v>mWindowWidth){
                //将当前StringBuffer中的数据减一，输出
                storyInLine.delete(storyInLine.length()-1,storyInLine.length()) ;
                break;
            }
        }
        myHolder.write.setText(storyInLine.toString());
        Log.e("输出信息",storyInLine.toString()) ;
        //将mStoryBak中和storyInLine中相同的数据清空
        mStoryBak.delete(0,i) ;
    }

    @Override
    public int getItemCount() {
        //计算出
        return mCount;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        LinearLayout itemView;
        TextView write;

        public MyHolder(View itemView) {
            super(itemView);
            this.itemView = (LinearLayout) itemView;
            write = (TextView) itemView.findViewById(R.id.list_writeFinish);
        }
    }
    //获取到剩余的字符串
    public String getSurplus(){
        return mStoryBak.toString() ;
    }
}
