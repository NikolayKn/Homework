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
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
      //  import superp.techpark.ru.lesson3.R;


/**
 * Fragment, демонстрирующий передачу параметра аргументом
 */
public class second_fragment extends Fragment {
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
        TextView v = (TextView)view.findViewById(R.id.text);
        v.setText(text);
        v.setTextColor(color);
    }

    public static second_fragment newInstance(String param, int color) {
        second_fragment fragment = new second_fragment();
        Bundle bundle = new Bundle();
        bundle.putString(TEXT, param);
        bundle.putInt(COLOR, color);
        fragment.setArguments(bundle);
        return fragment;
    }
}
