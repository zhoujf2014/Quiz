package com.gtafe.quiz;

import android.content.DialogInterface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class QuizActivity extends BaseActivity {
    private static final String TAG = "MainActivity";


    public QuestBean mQuestBean;
    public ItemAdapter mItemAdapter;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.confir)
    TextView mConfir;
    @BindView(R.id.pager)
    TextView mPager;
    private int mItemCount = 0;
    private int mCurrentPosition = 0;


    @Override
    protected void init() {

        loadDataFromServer(null, "ExperimentalExercise/getAnswer", null, 88);
        initState();
        mItemAdapter = new ItemAdapter();
        mVp.setAdapter(mItemAdapter);

        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPager.setVisibility(View.VISIBLE);
                mPager.setText(position + 1 + "/" + mItemCount);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    protected int setView() {
        return R.layout.activity_main;
    }

    @Override
    protected void activityEnd() {

    }

    private List<String> mStuAnswer = null;


    @OnClick(R.id.confir)
    public void onViewClicked() {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        if (mStuAnswer==null) {
            return;
        }
        for (int i = 0; i < mStuAnswer.size(); i++) {

            stringBuffer.append(mQuestBean.getData().getList().get(i).getID()+ ":");
            String s = mStuAnswer.get(i);
            if (s.length() < 1) {
                Toast.makeText(mContext, "未完成所有题目，不能提交", Toast.LENGTH_SHORT).show();
                return;
            }
            stringBuffer.append("\'");
            if (s.length() < 2) {
                stringBuffer.append(s);
            } else {
                char[] chars = bubbleSort(s.toCharArray());

                for (int j = 0; j < chars.length; j++) {
                    if (j != chars.length - 1) {

                        stringBuffer.append(chars[j]).append(",");
                    } else {
                        stringBuffer.append(chars[j]);

                    }
                }
            }
            stringBuffer.append("\'");
            if (i != mStuAnswer.size() - 1) {
                stringBuffer.append(",");

            }
        }
        stringBuffer.append("}");
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setMessage("是否现在提交答案？")
                .setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                }).setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RequestBody body = new FormBody.Builder().add("eid", mQuestBean.getData().getEid() + "").add("stuNO", QuizAppcation.userCode).add("strAnswer", stringBuffer.toString()).build();
                        Log.e(TAG, "onViewClicked:getEid =" + mQuestBean.getData().getEid() + " stringBuffer.toString()=" + stringBuffer.toString());
                        // RequestBody body =null;
                        loadDataFromServer(null, "ExperimentalExercise/stusaveAnswer", body, 99);


                    }
                });
        builder.show();
    }


    class ItemAdapter extends PagerAdapter {


        @Override
        public int getCount() {

            return mItemCount;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            // TODO Auto-generated method stub
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LinearLayout.inflate(mContext, R.layout.item_option_item, null);
            ItemViewHolder itemViewHolder = new ItemViewHolder(view);
            itemViewHolder.setItemData(position);
            container.addView(view);
            return view;
        }

        class ItemViewHolder {
            @BindView(R.id.item_position)
            TextView mItemPosition;
            @BindView(R.id.item_type)
            TextView mItemType;
            @BindView(R.id.item_stem)
            TextView mItemStem;
            @BindView(R.id.lv_answer)
            ListView mLvAnswer;
            private int mPosition;
            public int mQuestionType;


            ItemViewHolder(View view) {
                ButterKnife.bind(this, view);
            }

            public void setItemData(int position) {
                mPosition = position;
                QuestBean.DataBean.ListBean listBean = mQuestBean.getData().getList().get(position);
                mItemPosition.setText(position + 1 + ".");
                mItemStem.setText(listBean.getStem());
                AnswerAdapter answerAdapter = new AnswerAdapter(listBean, position);
                mLvAnswer.setAdapter(answerAdapter);
                mLvAnswer.setDividerHeight(0);
                mQuestionType = listBean.getQuestionType();
                switch (mQuestionType) {
                    case 1:
                        mItemType.setText("【" + "单选题" + "】");

                        break;
                    case 2:
                        mItemType.setText("【" + "多选题" + "】");

                        break;
                    case 3:
                        mItemType.setText("【" + "判断题" + "】");

                        break;
                }
            }

            class AnswerAdapter extends BaseAdapter {
                private QuestBean.DataBean.ListBean answerlistBean;
                private int mPosition;

                public AnswerAdapter(QuestBean.DataBean.ListBean listBean, int position) {
                    answerlistBean = listBean;
                    mPosition = position;
                }

                @Override
                public int getCount() {
                    if (answerlistBean.getQuestionOptions().size() == 0) {
                        return 2;
                    }
                    return answerlistBean.getQuestionOptions().size();
                }

                @Override
                public Object getItem(int position) {
                    if (answerlistBean.getQuestionOptions().size() == 0) {
                        return null;
                    }
                    return answerlistBean.getQuestionOptions().get(position);
                }

                @Override
                public long getItemId(int position) {

                    return position;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    convertView = View.inflate(mContext, R.layout.item_option_answer, null);
                    AnswerHolder answerHolder = new AnswerHolder(convertView);
                    answerHolder.setData(position);
                    return convertView;
                }

                class AnswerHolder {
                    @BindView(R.id.tv_oId)
                    TextView mTvOId;
                    @BindView(R.id.tv_oName)
                    TextView mTvOName;
                    @BindView(R.id.ll_option)
                    LinearLayout mLlOption;
                    private String mStringAnswer;

                    AnswerHolder(View view) {
                        ButterKnife.bind(this, view);
                    }

                    public void setData(final int position) {
                        mStringAnswer = mStuAnswer.get(mPosition);

                        mLlOption.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String answerString = null;
                                Log.e(TAG, "onClick: mQuestionType=" + mQuestionType + " position=" + position);
                                switch (mQuestionType) {
                                    //单选
                                    case 1:
                                        answerString = getStringByPosition(position);
                                        Log.e(TAG, "onClick:mStringAnswer= " + mStringAnswer);
                                        mStringAnswer = answerString;
                                        //多选
                                        break;
                                    case 2:
                                        answerString = getStringByPosition(position);

                                        if (mStringAnswer.contains(answerString)) {
                                            mStringAnswer = mStringAnswer.replace(answerString, "");
                                        } else {
                                            mStringAnswer = answerString + mStringAnswer;
                                        }
                                        break;
                                    //判断
                                    case 3:
                                        mStringAnswer = (position == 0) ? "Y" : "N";
                                        break;
                                }
                                Log.e(TAG, "onClick:mStringAnswer= " + mStringAnswer);
                                mStuAnswer.set(mPosition, mStringAnswer);
                                String s = mStuAnswer.get(mPosition);
                                Log.e(TAG, "onClick:mStringAnswer= "+position+"   " + s);
                                notifyDataSetChanged();

                            }
                        });


                        if (mQuestionType == 3) {
                            if (position == 0) {
                                if (mStringAnswer.contains("Y")) {
                                    mTvOId.setBackgroundResource(R.drawable.btn_green);
                                } else {
                                    mTvOId.setBackgroundResource(R.drawable.btn_option);
                                }
                                mTvOId.setText("A");
                                mTvOName.setText("对");

                            } else {
                                if (mStringAnswer.contains("N")) {
                                    mTvOId.setBackgroundResource(R.drawable.btn_green);
                                } else {
                                    mTvOId.setBackgroundResource(R.drawable.btn_option);
                                }
                                mTvOId.setText("B");
                                mTvOName.setText("错");
                            }
                        } else {
                            String stringByPosition = getStringByPosition(position);
                            if (mStringAnswer.contains(stringByPosition)) {

                                mTvOId.setBackgroundResource(R.drawable.btn_green);
                            } else {
                                mTvOId.setBackgroundResource(R.drawable.btn_option);
                            }
                            mTvOId.setText(answerlistBean.getQuestionOptions().
                                    get(position).
                                    getOptionName());
                            mTvOName.setText(answerlistBean.getQuestionOptions().
                                    get(position).
                                    getOptionContent());
                        }
                    }
                }
            }
        }
    }

    private String getStringByPosition(int position) {
        String string = null;
        switch (position) {
            case 0:
                string = "A";
                break;
            case 1:
                string = "B";
                break;
            case 2:
                string = "C";
                break;
            case 3:
                string = "D";
                break;
            case 4:
                string = "E";
                break;
            case 5:
                string = "F";
                break;
            case 6:
                string = "G";
                break;
            case 7:
                string = "H";
                break;
        }
        return string;
    }

    private int getPositionByString(String string) {
        int position = -1;
        switch (string) {
            case "A":
                position = 0;
                break;
            case "B":
                position = 1;
                break;
            case "C":
                position = 2;
                break;
            case "D":
                position = 3;
                break;
            case "E":
                position = 4;
                break;
            case "F":
                position = 5;
                break;
            case "G":
                position = 6;
                break;
            case "H":
                position = 7;
                break;
        }
        return position;
    }


    @Override
    protected void loadDataFromServerSuccessful(String string, int tag) {
        super.loadDataFromServerSuccessful(string, tag);
        Gson gson = new Gson();

        if (tag == 88) {
            Log.e(TAG, "loadDataFromServerSuccessful: "+string );

            QuestBean questBean = gson.fromJson(string, QuestBean.class);
            if (questBean != null) {
                mQuestBean = questBean;
                mStuAnswer = new ArrayList<>();
                mItemCount = mQuestBean.getData().getList().size();
                for (int i = 0; i < mItemCount; i++) {
                    mStuAnswer.add("");
                }
                mPager.setVisibility(View.VISIBLE);
                mPager.setText(mCurrentPosition + 1 + "/" + mItemCount);
                mItemAdapter.notifyDataSetChanged();
            }

        } else if (tag == 99) {
            Log.e(TAG, "loadDataFromServerSuccessful: " + string);
            StuAnswer stuAnswer = gson.fromJson(string, StuAnswer.class);
            Toast.makeText(mContext, "提交" + stuAnswer.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }


    public char[] bubbleSort(char[] args) {//冒泡排序算法
        for (int i = 0; i < args.length - 1; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i] > args[j]) {
                    char temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }
        return args;
    }
}
