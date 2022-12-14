package com.example.activitytestdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    @Override
    protected void onStart() {
        //这个方法在活动有不可见变为可见的时候调用。
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        //这个方法在活动有不可见变为可见的时候调用。
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        //这个方法在系统准备去启动或恢复另一个活动的时候调用。此时活动处于暂停状态
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        /*这个在活动完全不可见的时候调用，他和**onPause()**的区别在于，
         如果启动的新活动是一个对话框式的活动，那么onPause()方法会得到执行，
         而onStop()方法不会执行(因为活动并不是完全不可见)，此时活动处于停止状态。*/
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        //这个方法在活动被销毁之前调用，之后的活动将变为销毁状态，此时活动处于销毁状态。
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        //在活动重新启动的情况下被调用
        Log.d(TAG, "onRestart: ");
        super.onRestart();
    }
}