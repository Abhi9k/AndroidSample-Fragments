package com.example.abhinav.fragments.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abhinav.fragments.R;

/**
 * Created by abhinav on 1/12/15.
 */
public class SecondFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) super.onCreateView(inflater, container, savedInstanceState, R.layout.second_fragment);
        pos = 2;
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (ColorSelectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("should implement ColorSelection Interface");
        }
    }
}
