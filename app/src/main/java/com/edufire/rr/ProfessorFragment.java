package com.edufire.rr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.edufire.rr.models.Professor;
import com.edufire.rr.models.User;

public class ProfessorFragment extends Fragment {


    private Button registerProfessor;
    private EditText username;
    private EditText completeName;
    private EditText universityName;
    private EditText password;
    private TextView textView;
    private Button back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_professor, container, false);

        registerProfessor = view.findViewById(R.id.registerBtnProfesssor);
        username = view.findViewById(R.id.usernameProfessor);
        completeName = view.findViewById(R.id.completeNameProfessor);
        universityName = view.findViewById(R.id.universityNameProfessor);
        password = view.findViewById(R.id.passwordProfessor);
        textView = view.findViewById(R.id.textViewProfessor);
        back = view.findViewById(R.id.backBtnProfessor);

        registerProfessor.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                ///read from shared
//                SharedPreferences sharedPrefGet = getActivity().getPreferences(Context.MODE_PRIVATE);
//                int defaultValue = getResources().getInteger(0);
//                int highScore = sharedPrefGet.getInt("Users", defaultValue);
                ///
                if (!username.getText().toString().equals("") && !password.getText().toString().equals("") && !completeName.getText().toString().equals("") && !universityName.getText().toString().equals("")) {
                    if (!User.doesTheUserExist(username.getText().toString())) {
                        ////
                        //first get and
//                        HashMap<String, User> outputMap = new HashMap<>();
//                        SharedPreferences sharedPrefGet = getActivity().getPreferences(Context.MODE_PRIVATE);
//                        try {
//                            if (sharedPrefGet != null) {
//
//                                String jsonString = sharedPrefGet.getString("Users", (new JSONObject()).toString());
//                                System.out.println(jsonString+"   nnnnnnnnnnnnnnnnnnnnnnnnn");
//                                if (jsonString != null) {
//                                    JSONObject jsonObject = new JSONObject(jsonString);
//                                    Iterator<String> keysItr = jsonObject.keys();
//                                    while (keysItr.hasNext()) {
//                                        String key = keysItr.next();
//                                        outputMap.put(key, (User) jsonObject.get(key));
//                                    }
//                                }
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        User.setUsers(outputMap);
///////////////////////////////////////////////////
                        new Professor(username.getText().toString(), password.getText().toString(), completeName.getText().toString(), universityName.getText().toString());
//                        //now save
//                        SharedPreferences sharedPrefPut = getActivity().getPreferences(Context.MODE_PRIVATE);
//                        if (sharedPrefPut != null) {
//                            GsonBuilder gsonMapBuilder = new GsonBuilder();
//                            Gson gsonObject = gsonMapBuilder.create();
//                            String JSONObject = gsonObject.toJson(User.getUsers());
//                            String jsonString = JSONObject.toString();
//
//                            SharedPreferences.Editor editor = sharedPrefPut.edit();
//                            editor.remove("Users").apply();
//                            editor.putString("Users", jsonString);
//                            editor.apply();
//                        }
//                        /////////////////////
                        Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                        startActivity(myIntent);
                    } else {
                        textView.setText("User with this username already exists");
                    }
                } else {
                    textView.setText("Fill all the fields");

                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });
        return view;

    }

    //    private void saveMap(Map<String, Object> inputMap) {
//        SharedPreferences pSharedPref = getApplicationContext().getSharedPreferences("MyVariables",
//                Context.MODE_PRIVATE);
//        if (pSharedPref != null) {
//            JSONObject jsonObject = new JSONObject(inputMap);
//            String jsonString = jsonObject.toString();
//            SharedPreferences.Editor editor = pSharedPref.edit();
//            editor.remove(mapKey).apply();
//            editor.putString(mapKey, jsonString);
//            editor.commit();
//        }
//    }


}