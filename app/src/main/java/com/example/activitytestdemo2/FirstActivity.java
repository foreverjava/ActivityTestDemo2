package com.example.activitytestdemo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//活动有四种状态：运行状态、暂停状态、停止状态、销毁状态
public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";
    private Button button_one;
    private Button button_third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这个方法会在活动第一次被创建的时候调用，我们可以在这个方法中完成活动的初始化操作，比如加载布局、绑定事件等。
        setContentView(R.layout.first_layout);//这是我们加的代码
        Log.d(TAG, "onCreate: 这个方法会在活动第一次被创建的时候调用");
        button_one = findViewById(R.id.button_1);
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent一般可被用来启动活动、启动服务以及发送广播等场景，我们来看启动活动。
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        button_third = findViewById(R.id.button_3);
        button_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent一般可被用来启动活动、启动服务以及发送广播等场景，我们来看启动活动。
                Intent intent = new Intent(FirstActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You Clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You Clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}