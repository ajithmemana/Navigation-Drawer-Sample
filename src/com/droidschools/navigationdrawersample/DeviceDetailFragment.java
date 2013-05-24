package com.droidschools.navigationdrawersample;

import java.util.Locale;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DeviceDetailFragment extends Fragment{


    public static final String ARG_PHONE_INDEX = "phone_index";
    String phoneImageName ;
    public DeviceDetailFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.device_detail_fragment_layout, container, false);
        int i = getArguments().getInt(ARG_PHONE_INDEX);
        //Get the corresponding name from string array
         phoneImageName = getResources().getStringArray(R.array.phone_array)[i];
        
// Get the resource Id usign name  -  filename.drawable.packagename
        int imageId = getResources().getIdentifier(phoneImageName.toLowerCase(Locale.getDefault()),
                        "drawable", getActivity().getPackageName());
        ((ImageView) rootView.findViewById(R.id.deviceimageView)).setImageResource(imageId);
        ((TextView) rootView.findViewById(R.id.phoneNametextView)).setText(phoneImageName);
        getActivity().setTitle(imageId);

        return rootView;
    }

}
