package com.WWCNT.stronkchonk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    private View settingsView;
    private TextView tvName;
    private EditText inputText;
    private Button editButton;
    private TextView tvNameTEST;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Settings");
        settingsView = inflater.inflate(R.layout.fragment_settings, container, false);

        inputText = (EditText) settingsView.findViewById(R.id.NameEdit);
        editButton = (Button) settingsView.findViewById(R.id.NameEditButton);
        editButton.setOnClickListener(this);
        tvNameTEST = (TextView) settingsView.findViewById(R.id.testChonks);

        return settingsView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.NameEditButton:
                inputText = (EditText) settingsView.findViewById(R.id.NameEdit);
                String name = inputText.getText().toString();
                editButton.setText(name);
//                tvName = (TextView) settingsView.findViewById(R.id.ChonkyUsername);
//                tvName.setText("TEST");
                tvNameTEST.setText(name);
                break;
        }

    }
}
