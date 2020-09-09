package com.someapp.android.mpgconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ActivityFragment extends Fragment {

    private String mString;
    private int mToConvert;
    private int mFinalResult;

    private EditText mMpg;
    private Button mConvert;
    private TextView mResult;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_activity, container, false);

        mMpg = (EditText) v.findViewById(R.id.enter_mpg);
        mMpg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mString = charSequence.toString();
                try {
                    mToConvert = Integer.parseInt(mString);
                } catch (NumberFormatException e){
                    System.out.println("not a number");
                }

                /*  mString = charSequence.toString();
                 *  mToConvert = Integer.parseInt(mString); */
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mConvert = (Button) v.findViewById(R.id.convert);
        mResult = (TextView) v.findViewById(R.id.result);
        mConvert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mToConvert != 0) {
                    mFinalResult = (int) 235.21 / mToConvert;
                    mResult.setText(String.valueOf(mFinalResult) + " litres per 100km");
                }
            }
        });

        return v;
    }
}
