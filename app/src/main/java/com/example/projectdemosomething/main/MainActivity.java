package com.example.projectdemosomething.main;

import android.os.Bundle;

import com.example.projectdemosomething.OnCallBackData;
import com.example.projectdemosomething.R;
import com.example.projectdemosomething.entity.User;
import com.example.projectdemosomething.firstview.FirstFragment;
import com.example.projectdemosomething.secondview.SecordFragment;
import com.example.projectdemosomething.utils.ActivityUtils;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("All")
public class MainActivity extends AppCompatActivity implements OnCallBackData {
    private FirstFragment firstFragment;
    private SecordFragment secordFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initView();
    }


    private void initFragment() {
        firstFragment = FirstFragment.newInstance();
    }

    private void initView() {
        ActivityUtils.addFragment(getSupportFragmentManager(), firstFragment, R.id.container);
    }

    @Override
    public void sendData(User user) {
        ActivityUtils.replaceFragment(getSupportFragmentManager(), secordFragment.newInstance(user), R.id.container);
    }
}
