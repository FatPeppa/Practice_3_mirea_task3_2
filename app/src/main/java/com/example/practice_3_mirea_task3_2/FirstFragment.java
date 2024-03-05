package com.example.practice_3_mirea_task3_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import org.w3c.dom.Text;

public class FirstFragment extends Fragment {

    TextView text_view_saved_result;

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view2,
                            SecondFragment.class, null, "secondFragment")
                    .commit();
        }

        getChildFragmentManager().setFragmentResultListener("requestKey1",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey,
                                                 @NonNull Bundle bundle) {
                        String result = bundle.getString("bundleKey1");

                        if (isIntNumeric(result)) {
                            String first_part = getActivity().getResources().getString(R.string.text_view_saved_result_first_part);
                            text_view_saved_result = (TextView) getActivity().findViewById(R.id.text_view_saved_result);
                            String new_text = first_part + result;
                            text_view_saved_result.setText(new_text);
                        } else {
                            Toast.makeText(getActivity(), "bundle error occurred!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public static boolean isIntNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
