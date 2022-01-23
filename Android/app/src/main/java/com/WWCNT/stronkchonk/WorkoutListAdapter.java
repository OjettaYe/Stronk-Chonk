package com.WWCNT.stronkchonk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class WorkoutListAdapter extends ArrayAdapter<Workout> {
    private static final String TAG = "WorkoutListAdapter";
    private Context aContext;
    int aResource;

    public WorkoutListAdapter(Context context, int resource, ArrayList<Workout> objects) {
        super(context, resource, objects);
        this.aContext = context;
        aResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int id = getItem(position).getId();
        String name = getItem(position).getName();
        Time startTime = getItem(position).getStartTime();
        Time endTime = getItem(position).getEndTime();
        int length = getItem(position).getLength();
        int exp = getItem(position).getExp();

        Workout workout = new Workout(id, name, startTime, endTime, length, exp);

        LayoutInflater inflater = LayoutInflater.from(aContext);
        convertView = inflater.inflate(aResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.textViewWN);
//        TextView tvDate = (TextView) convertView.findViewById(R.id.textView00);
        TextView tvLength = (TextView) convertView.findViewById(R.id.textViewLength);
        TextView tvEXP = (TextView) convertView.findViewById(R.id.textAcornEXP);
//        TextView tvStartTime = (TextView) convertView.findViewById(R.id.textView3);
//        TextView tvEndTime = (TextView) convertView.findViewById(R.id.textView4);

        tvName.setText(name);
        tvLength.setText(Integer.toString(length));
        tvEXP.setText(Integer.toString(exp));
//        tvStartTime.setText(startTime.toString());
//        tvEndTime.setText(endTime.toString());

        return convertView;
    }
}
