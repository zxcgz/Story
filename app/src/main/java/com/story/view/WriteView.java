package com.story.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.story.R;

/**
 * Created by lenovo on 2017/12/5.
 */

public class WriteView extends LinearLayout {

    private Context mContext ;
    private RecyclerView mWriteFinish;
    private KeyListener tkl;
    private Editable et;
    private InputMethodManager imm;
    private int mMaxNumber = 3;
    private EditText mWriting;
    private EditText mWritingLine;
    private TextView mWritingLineFinish;
    private StringBuffer mStory  =new StringBuffer() ;

    public WriteView(Context context) {
        //super(context);
        this(context, null);
    }

    public WriteView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WriteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context ;
        initView();
        initData();
    }

    private void initData() {
        //将已经存在的数据写入到mWriteFinish中
        mWriteFinish.setLayoutManager(new LinearLayoutManager(mContext));
        //mWriteFinish.setAdapter(new WriteFinishAdapter(mContext,mStory.toString()));
    }

    private void initView() {
        View.inflate(mContext, R.layout.view_write, this);
        mWriteFinish = (RecyclerView) this.findViewById(R.id.writeFinish);
        mWriting = (EditText) this.findViewById(R.id.writing);
        mWritingLine = (EditText) this.findViewById(R.id.writingLine);
        mWritingLineFinish = (TextView) this.findViewById(R.id.writingLineFinish);
    }

    public void setMaxNumber(int maxNumber) {
        this.mMaxNumber = maxNumber;
    }
    //追加信息
    public void addText(String text){
        mStory.append(text) ;
    }
    //添加信息
    public void setText(String text){
        mStory.setLength(0);
        mStory.append(text) ;
        mWriteFinish.setAdapter(new WriteFinishAdapter(mContext,mStory.toString(),this));
    }

}
