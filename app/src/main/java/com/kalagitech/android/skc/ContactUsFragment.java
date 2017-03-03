package com.kalagitech.android.skc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by dell on 22-02-2017.
 */

public class ContactUsFragment extends Fragment implements View.OnClickListener{
    TextView mTxtEmail;
    TextView mTxtmobile;
    TextView mTxtphone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contactus, container, false);
        bindById(rootView);
        onClickListener();
        return rootView;
    }

    private void onClickListener() {
        mTxtEmail.setOnClickListener(this);
        mTxtmobile.setOnClickListener(this);
        mTxtphone.setOnClickListener(this);
    }

    private void bindById(View rootView) {
        mTxtEmail = (TextView) rootView.findViewById(R.id.txt_email_id);
        mTxtmobile = (TextView) rootView.findViewById(R.id.txt_mobilenumber_id);
        mTxtphone = (TextView) rootView.findViewById(R.id.txt_landlinenumber_id);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        getActivity().setTitle("Home");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_email_id:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",mTxtEmail.getText().toString().trim(), null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Requesting...");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Sir,");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
                Toast.makeText(getContext(),"email",Toast.LENGTH_SHORT).show();
                break;

            case R.id.txt_mobilenumber_id:
                break;

            case R.id.txt_landlinenumber_id:
                break;

            default:
        }
    }
}
