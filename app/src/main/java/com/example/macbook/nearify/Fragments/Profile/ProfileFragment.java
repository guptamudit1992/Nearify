package com.example.macbook.nearify.Fragments.Profile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.macbook.nearify.Interfaces.FragmentInteractionListener;
import com.example.macbook.nearify.R;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    // Floating action button
    private FloatingActionButton fabEdit, fabSave;

    // Edittext fields
    private EditText nameEdittext, emailEdittext, phoneEdittext;

    // Keyboard toggle variable
    private InputMethodManager imm;

    private FragmentInteractionListener mListener;


    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initializing keyboard
        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        // Toggle fab
        nameEdittext = (EditText) view.findViewById(R.id.name_edittext);
        emailEdittext = (EditText) view.findViewById(R.id.email_edittext);
        phoneEdittext = (EditText) view.findViewById(R.id.phone_edittext);
        fabEdit = (FloatingActionButton) view.findViewById(R.id.fab_edit);
        fabSave = (FloatingActionButton) view.findViewById(R.id.fab_save);

        // Set on click listener
        fabEdit.setOnClickListener(this);
        fabSave.setOnClickListener(this);

        // Disable fields initially
        disableInput(nameEdittext);
        disableInput(emailEdittext);
        disableInput(phoneEdittext);

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInteractionListener) {
            mListener = (FragmentInteractionListener) context;
        } else {

            // TODO: Handle error
            /*throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");*/
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.fab_edit:

                fabEdit.hide();
                fabSave.show();
                enableInput(nameEdittext);
                enableInput(emailEdittext);
                enableInput(phoneEdittext);
                break;

            case R.id.fab_save:

                fabEdit.show();
                fabSave.hide();
                disableInput(nameEdittext);
                disableInput(emailEdittext);
                disableInput(phoneEdittext);
                break;

            default:
                break;
        }
    }

    /**
     * Function to enable input
     *
     * @param editText
     */
    public void enableInput(EditText editText) {

        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        editText.setCursorVisible(true);
    }


    /**
     * Function to disable input
     *
     * @param editText
     */
    public void disableInput(EditText editText) {

        editText.setCursorVisible(false);
        editText.setInputType(InputType.TYPE_NULL);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
