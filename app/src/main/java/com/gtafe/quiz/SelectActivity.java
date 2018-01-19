package com.gtafe.quiz;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gtafe.quiz.widget.RoundAngleImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ZhouJF on 2018/1/17.
 */

public class SelectActivity extends BaseActivity {
    @BindView(R.id.iv_icon)
    RoundAngleImageView mIvIcon;
    @BindView(R.id.select_name)
    TextView mSelectName;
    @BindView(R.id.bt_start)
    Button mBtStart;
    @BindView(R.id.exerciseDetail)
    RelativeLayout mExerciseDetail;
    @BindView(R.id.select_quiz)
    TextView mSelectQuiz;
    @BindView(R.id.select_order)
    TextView mSelectOrder;
    @BindView(R.id.select_res)
    TextView mSelectRes;
    public List<String> mTexts;


    @Override
    protected void init() {
        initState();
        mSelectName.setText("你好！" + QuizAppcation.userName);
        getTexts();

    }

    private void getTexts() {
        mTexts = new ArrayList<>();
        try {
            InputStream inputStream = getAssets().open("text.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String string = null;
            while ((string = bufferedReader.readLine())!=null){
                int index = string.indexOf("、");
                if (index>0) {
                        String text = string.substring(index+1, string.length());
                        mTexts.add(text);
                    }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int setView() {
        return R.layout.activity_select;
    }

    @Override
    protected void activityEnd() {

    }

    @OnClick({R.id.bt_start, R.id.select_quiz, R.id.select_order, R.id.select_res})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_start:
                Random random = new Random();
                int i = random.nextInt(mTexts.size());
                showToast(mTexts.get(i));
                break;
            case R.id.select_quiz:
                Intent intent = new Intent(mContext, QuizActivity.class);
                startActivity(intent);
                break;
            case R.id.select_order:
                showToast("实训室预约");
                break;
            case R.id.select_res:
                showToast("课程资源");
                break;
        }
    }

}
