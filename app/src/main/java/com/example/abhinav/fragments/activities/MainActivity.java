package com.example.abhinav.fragments.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.abhinav.fragments.R;
import com.example.abhinav.fragments.fragments.BaseFragment;
import com.example.abhinav.fragments.fragments.FirstFragment;
import com.example.abhinav.fragments.fragments.SecondFragment;

/**
 * Created by abhinav on 1/12/15.
 */
public class MainActivity extends Activity implements BaseFragment.ColorSelectionListener {
    private TextView mInfoBox;
    private int parity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_activity);
        mInfoBox = (TextView) findViewById(R.id.selection_info);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, new FirstFragment()).commit();
        parity = 1;
    }

    @Override
    public void onColorSelected(int pos) {
        mInfoBox.setText("Item " + pos + " checked");
    }

    @Override
    public void onColorDeselected(int pos) {
        mInfoBox.setText("Item " + pos + " unchecked");
    }

    public void buttonClicked(View view) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (parity % 2 == 1) {
            replaceFragment(transaction, R.id.fragment_container, new SecondFragment());
        } else {
            replaceFragment(transaction, R.id.fragment_container, new FirstFragment());
        }

        parity++;
    }

    private void replaceFragment(FragmentTransaction transaction, int resId, Fragment fragment) {
        transaction.replace(resId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
