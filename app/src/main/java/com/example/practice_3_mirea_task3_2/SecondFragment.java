package com.example.practice_3_mirea_task3_2;

import static com.example.practice_3_mirea_task3_2.FirstFragment.isIntNumeric;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    TextView text_view_s_fragment_count_value;
    Button button_save_value;
    Button button_add;

    public SecondFragment() {
        super(R.layout.fragment_second);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button_save_value = (Button) getActivity().findViewById(R.id.button_save_value);
        button_add = (Button) getActivity().findViewById(R.id.button_add);

        text_view_s_fragment_count_value = (TextView) getActivity().findViewById(R.id.text_view_s_fragment_count_value);

        text_view_s_fragment_count_value.setText("0");

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isIntNumeric((String) text_view_s_fragment_count_value.getText())) {
                    int n = Integer.parseInt((String) text_view_s_fragment_count_value.getText()) + 1;
                    text_view_s_fragment_count_value.setText(Integer.toString(n));
                } else {
                    Toast.makeText(getActivity(), "TextView error occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_save_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isIntNumeric((String) text_view_s_fragment_count_value.getText())) {
                    Bundle result = new Bundle();
                    result.putString("bundleKey1", (String) text_view_s_fragment_count_value.getText());
                    text_view_s_fragment_count_value.setText("0");
                    getParentFragmentManager().setFragmentResult(
                            "requestKey1", result);
                } else {
                    Toast.makeText(getActivity(), "TextView error occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
