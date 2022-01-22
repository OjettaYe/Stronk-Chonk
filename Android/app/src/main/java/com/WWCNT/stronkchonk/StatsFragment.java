package com.WWCNT.stronkchonk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class StatsFragment extends Fragment {
    private View statsView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Stats");
        statsView = inflater.inflate(R.layout.fragment_stats, container, false);
        //Test Squirrel
        Squirrel s1 = new Squirrel(1,20,5,"MR. CHONKY BOI");
        TextView tvName = (TextView) statsView.findViewById(R.id.squirrelName);
        TextView tvSize = (TextView) statsView.findViewById(R.id.squirrelSize);
        TextView tvChonkLevel = (TextView) statsView.findViewById(R.id.squirrelChonkLevel);


        tvName.setText(s1.getName());
        tvSize.setText(Integer.toString(s1.getSize()));
        tvChonkLevel.setText(Integer.toString(s1.getChonklevel()));
        return statsView;
    }
}
