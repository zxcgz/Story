package com.story;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.story.view.WriteView;

public class MainActivity extends AppCompatActivity {

    private WriteView mWriteArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    private void initData() {
        mWriteArea.setText("某君昆仲，今隱其名，皆余昔日在中學校時良友；" +
                "分隔多年，消息漸闕。日前偶聞其一大病；適歸故鄉，迂道往訪，則僅晤一人，言病者其弟也。" +
                "勞君遠道來視，然已早愈，赴某地候補矣。因大笑，出示日記二冊，謂可見當日病狀，" +
                "不妨獻諸舊友。持歸閱一過，知所患蓋「迫害狂」之類。語頗錯雜無倫次，又多荒唐之言；" +
                "亦不著月日，惟墨色字體不一，知非一時所書。間亦有略具聯絡者，今撮錄一篇，以供醫家研究。" +
                "記中語誤，一字不易；惟人名雖皆村人，不爲世間所知，無關大體，然亦悉易去。至於書名，" +
                "則本人愈後所題，不復改也。七年四月二日識。");
        mWriteArea.setMaxNumber(4);
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mWriteArea = (WriteView) findViewById(R.id.write);
    }
}
