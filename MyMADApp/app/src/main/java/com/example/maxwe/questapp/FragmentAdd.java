package com.example.maxwe.questapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FragmentAdd extends Fragment {

    private EditText titleText, descriptionText;

    private Button nextButton;

    MainViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentadd_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new MainViewModel(getActivity().getApplicationContext());

        titleText = getActivity().findViewById(R.id.title_edit);
        descriptionText = getActivity().findViewById(R.id.des_edit);

        nextButton = getActivity().findViewById(R.id.button);

        final Spinner spinner = getActivity().findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.questLength, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleText.getText().toString();
                String descripiton = descriptionText.getText().toString();
                String type = spinner.getSelectedItem().toString();

                Quest newQuest = new Quest(title, descripiton, type);

                viewModel.insert(newQuest);

                titleText.setText(R.string.title);
                descriptionText.setText(R.string.description);
            }
        });

    }
}
