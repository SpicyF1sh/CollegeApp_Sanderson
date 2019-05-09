package com.hsandies.collegeapp_sanderson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;


public class SiblingFragment extends Fragment {

    //Variable Instantiation for elements on layout file fragment_sibling.xml
    private TextView mFirstNameTextView, mLastNameTextView, mOccupationTextView;
    private EditText mFirstNameEditText, mLastNameEditText, mOccupationEditText;
    private Button mSubmitButton;
    private Sibling mSibling;
    private final String TAG = "SIBLING_FRAGMENT";

    //onCreateView inflates layout with fragment_sibling.xml, links layout elements in code, logic for onClickListeners, saves to backendless, returns rootview
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sibling, container, false);
        mSibling = new Sibling("FirstName", "LastName");
        mFirstNameTextView = (TextView) rootView.findViewById(R.id.sibling_first_name);
        mLastNameTextView = (TextView) rootView.findViewById(R.id.sibling_last_name);
        mFirstNameEditText = (EditText) rootView.findViewById(R.id.sibling_first_name_edit);
        mLastNameEditText = (EditText) rootView.findViewById(R.id.sibling_last_name_edit);
        mSubmitButton = (Button) rootView.findViewById(R.id.sibling_submit_button);
        mFirstNameTextView.setText(mSibling.getFirstName());
        mLastNameTextView.setText(mSibling.getLastName());

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFirstNameEditText.getText().length() > 0){
                    String firstName = mFirstNameEditText.getText().toString();
                    mSibling.setFirstName(firstName);
                    mFirstNameTextView.setText(firstName);
                    mFirstNameEditText.setText("");
                }

                if(mLastNameEditText.getText().length() > 0){
                    String lastName = mLastNameEditText.getText().toString();
                    mSibling.setLastName(lastName);
                    mLastNameTextView.setText(lastName);
                    mLastNameEditText.setText("");
                }
                Backendless.Persistence.save(mSibling, new AsyncCallback<Sibling>() {
                    @Override
                    public void handleResponse(Sibling sibling) {
                        Log.i(TAG, "Saved" + sibling.toString());
                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {
                        Log.i(TAG, backendlessFault.toString());
                    }
                });
            }
        });
        return rootView;
    }

    //Retrieves intent and sets elements on layout file to properties of sibling
    @Override
    public void onStart(){
        int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX, -1);
        if (index != -1){
            mSibling = (Sibling)Family.getFamily().getFamilyList().get(index);
            mFirstNameTextView.setText(mSibling.getFirstName());
            mLastNameTextView.setText(mSibling.getLastName());
        }
        super.onStart();
    }
}