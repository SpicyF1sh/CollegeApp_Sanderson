package com.hsandies.collegeapp_sanderson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FamilyMemberFragment extends Fragment {

    //    onCreateView method for FamilyMemberFragment - inflates view with fragment_family_member.xml, returns rootview    //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle bundle){
        super.onCreateView(inflater, view, bundle);
        View rootView = inflater.inflate(R.layout.fragment_family_member, view, false);
        return rootView;
    }
}