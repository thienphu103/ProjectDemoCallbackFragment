package com.example.projectdemosomething.firstview;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectdemosomething.OnCallBackData;
import com.example.projectdemosomething.R;
import com.example.projectdemosomething.entity.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

@SuppressWarnings("All")
public class FirstFragment extends Fragment {

    private EditText mEdtTextRequest;
    private Button mBtnRequest;
    private User user;
    private OnCallBackData onCallBackData;

    public static FirstFragment newInstance() {
        FirstFragment firstFragment = new FirstFragment();
        return firstFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCallBackData) onCallBackData = (OnCallBackData) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initMappingViewId(view);
        initEvent();
        super.onViewCreated(view, savedInstanceState);
    }

    private void initEvent() {
        mBtnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User(mEdtTextRequest.getText().toString());
//                SecordFragment secordFragment = SecordFragment.newInstance();
//                secordFragment.sendData(user);
//                ActivityUtils.replaceFragment(getActivity().getSupportFragmentManager(),
//                        secordFragment, R.id.container);
                onCallBackData.sendData(user);
            }
        });
    }

    private void initMappingViewId(View view) {
        mEdtTextRequest = view.findViewById(R.id.edt_text_request);
        mBtnRequest = view.findViewById(R.id.btn_request);
    }

}
