package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.graphics.Color;


public class SecondFragment extends Fragment {
    private static final String TEXT = "some_text";
    private static final String COLOR = "color";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String text = "no value supplied";
        int color = Color.RED;
        Bundle arguments = getArguments();
        if (arguments != null) {
            text = arguments.getString(TEXT);
            color = arguments.getInt(COLOR);

        }
        TextView v = (TextView) view.findViewById(R.id.text);
        v.setText(text);
        v.setTextColor(color);
    }

    public static SecondFragment newInstance(String param, int color) {
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TEXT, param);
        bundle.putInt(COLOR, color);
        fragment.setArguments(bundle);
        return fragment;
    }
}
