package com.example.abhinav.fragments.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.abhinav.fragments.R;

/**
 * Created by abhinav on 1/12/15.
 */
public class BaseFragment extends Fragment {
    protected int pos;
    protected ColorSelectionListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        throw new IllegalArgumentException("call onCreate(inflater,container,bundle,resId");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, int resId) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(resId, container, false);
        View colorView = rootView.findViewById(R.id.color_view);
        final ImageView tick = (ImageView) rootView.findViewById(R.id.tick);
        colorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tick.getVisibility() == View.VISIBLE) {
                    tick.setVisibility(View.GONE);
                    mListener.onColorDeselected(pos);
                } else {
                    tick.setVisibility(View.VISIBLE);
                    mListener.onColorSelected(pos);
                }
            }
        });
        return rootView;
    }

    public interface ColorSelectionListener {
        public void onColorSelected(int pos);

        public void onColorDeselected(int pos);
    }
}
