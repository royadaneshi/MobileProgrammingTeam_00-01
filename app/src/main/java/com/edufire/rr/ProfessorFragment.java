package com.edufire.rr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.edufire.rr.databinding.FragmentFirstBinding;

public class ProfessorFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Button registerProfessor;
    private EditText username;
    private EditText completeName;
    private EditText universityName;
    private EditText password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_professor, container, false);

        registerProfessor = view.findViewById(R.id.registerBtnProfesssor);
        username = view.findViewById(R.id.usernameProfessor);
        completeName = view.findViewById(R.id.completeNameProfessor);
        universityName = view.findViewById(R.id.universityNameProfessor);
        password = view.findViewById(R.id.passwordProfessor);

        registerProfessor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Professor(username.getText().toString(), password.getText().toString(), completeName.getText().toString(), universityName.getText().toString());
                NavHostFragment.findNavController(ProfessorFragment.this)
                        .navigate(R.id.action_mainActivity2_to_FirstFragment);
            }
        });
        return view;

    }


    public ProfessorFragment() {
        // Required empty public constructor
    }


    public static ProfessorFragment newInstance(String param1, String param2) {
        ProfessorFragment fragment = new ProfessorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


}