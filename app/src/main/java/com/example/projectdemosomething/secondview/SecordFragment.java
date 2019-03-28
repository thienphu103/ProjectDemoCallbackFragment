package com.example.projectdemosomething.secondview;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectdemosomething.OnCallBackData;
import com.example.projectdemosomething.R;
import com.example.projectdemosomething.entity.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

@SuppressWarnings("All")
public class SecordFragment extends Fragment implements OnCallBackData {
    User user;
    private TextView mTxtTextResponse;

    public static SecordFragment newInstance(User user) {

        SecordFragment secordFragment = new SecordFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("user_key", user);
        secordFragment.setArguments(bundle);
        return secordFragment;

    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        if (getArguments() != null) {
            user = (User) getArguments().getSerializable("user_key");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_secord, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initMappingViewId(view);
        initEvent();
        initView();
    }

    private void initView() {
        mTxtTextResponse.setText(user.getUserName());
    }

    private void initEvent() {

    }

    private void initMappingViewId(View view) {

        mTxtTextResponse = view.findViewById(R.id.txt_text_response);
    }

    @Override
    public void sendData(User user) {
        if (user != null) {
            this.user = user;
        }
    }
}
