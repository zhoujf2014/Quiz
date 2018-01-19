package com.gtafe.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.gson.Gson;
import com.gtafe.quiz.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;


public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";

    @BindView(R.id.user)
    ClearEditText mUser;
    @BindView(R.id.pwd)
    ClearEditText mPwd;
    @BindView(R.id.remenber)
    AppCompatCheckBox mRemenber;
    @BindView(R.id.login)
    Button mLogin;
    public SharedPreferences mSp;
    @BindView(R.id.ip_port)
    TextView mIpPort;
    public String mIp_port_LOGIN;
    public String mIp_port_ANSWER;


    @Override
    protected int setView() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        initState();
        mSp = getSharedPreferences(Constant.PACKGE, MODE_PRIVATE);
        mIp_port_LOGIN = mSp.getString(Constant.IP_PORT_L, "210.75.17.218:20000");
        mIp_port_ANSWER = mSp.getString(Constant.IP_PORT_A, "210.75.17.218:20004");
        String passWord = mSp.getString(Constant.PASSWORD, null);
        String userName = mSp.getString(Constant.USERNAME, null);
        if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(passWord)) {
            return;
        }
        mRemenber.setChecked(true);
        mPwd.setText(passWord);
        mUser.setText(userName);
     /*   //    RequestBody body = new FormBody.Builder().add("userName", userName).add("userPwd", passWord).build();
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse(
                "application/json; charset=utf-8"), "{\"userName\":\"" + userName + "\",\"userPwd\":\"" + passWord + "\"}");
        loadDataFromServer("http://10.1.136.166:5080/", "dataapi/user/checkUserLogin", body, 1);*/

    }

    @Override
    protected void activityEnd() {

    }
    @Override
    protected void loadDataFromServerSuccessful(String string, int tag) {
        super.loadDataFromServerSuccessful(string, tag);
        Gson gson = new Gson();
        Log.e(TAG, "loadDataFromServerSuccessful: " + string);
        if (tag == 66) {

            LoginBean loginBean = gson.fromJson(string, LoginBean.class);
            if (loginBean.getErrcode() == 0) {
                LoginBean.UserInfoBean user_info = loginBean.getUser_info();
                QuizAppcation.userCode = user_info.getUserCode();
                QuizAppcation.userName = user_info.getUserName();
                Intent intent = new Intent(mContext, SelectActivity.class);
                startActivity(intent);
                finish();
            } else {
                showToast("用户名或者密码错误");
            }
        }
    }

    @Override
    protected void loadDataFromServerFail(String s, int tag) {
        if (tag == 1) {
            showToast("服务器异常，请检查服务器");
        }
    }

    @OnClick({R.id.login, R.id.ip_port})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ip_port:
                View dialog_ip_port = View.inflate(mContext, R.layout.dialog_ipport_edit, null);
                final ClearEditText edit_ip_login = (ClearEditText) dialog_ip_port.findViewById(R.id.dialog_edit_login);
                final ClearEditText edit_ip_answer = (ClearEditText) dialog_ip_port.findViewById(R.id.dialog_edit_answer);
                edit_ip_login.setText(mIp_port_LOGIN);
                edit_ip_answer.setText(mIp_port_ANSWER);
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
                        .setTitle("请输入服务器IP和端口号")
                        .setCancelable(false)
                        .setView(dialog_ip_port)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String ip_port_LOGIN = edit_ip_login.getText().toString().trim();
                                String ip_port_ANSWER = edit_ip_answer.getText().toString().trim();
                                mIp_port_LOGIN = ip_port_LOGIN;
                                mIp_port_ANSWER = ip_port_ANSWER;
                                dialog.dismiss();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                builder.show();
                break;
            case R.id.login:
                String userName = mUser.getText().toString().trim();
                String password = mPwd.getText().toString().trim();
                if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(password)) {
                    showToast("用户名或者密码不能为空！");
                    return;
                }
                SharedPreferences.Editor edit = mSp.edit();
                edit.putString(Constant.IP_PORT_L, mIp_port_LOGIN);
                edit.putString(Constant.IP_PORT_A, mIp_port_ANSWER);
                edit.putString(Constant.PASSWORD, password);
                edit.putString(Constant.USERNAME, userName);
                edit.commit();
                Constant.IP_PORT_LOGIN = "http://" + mIp_port_LOGIN + "/";
                Constant.IP_PORT_ANSWER = "http://" + mIp_port_ANSWER + "/";
                RequestBody body = RequestBody.create(okhttp3.MediaType.parse(
                        "application/json; charset=utf-8"), "{\"userName\":\"" + userName + "\",\"userPwd\":\"" + password + "\"}");
                Log.e(TAG, "onViewClicked: "+"{\"userName\":\"" + userName + "\",\"userPwd\":\"" + password + "\"}" );
                loadDataFromServer(null,"dataapi/user/checkUserLogin", body, 66);
                break;
        }
    }
}
