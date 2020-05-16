package com.mustafa.juvo.bodyFragments;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mustafa.juvo.Model.Vaka;
import com.mustafa.juvo.R;
import com.mustafa.juvo.SelectDateFragment;
import com.mustafa.juvo.databinding.VakaAramaFragmentBinding;
import com.mustafa.juvo.viewmodels.VakaAramaViewModel;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class VakaAramaFragment extends Fragment {

    VakaAramaViewModel mViewModel;
    VakaAramaFragmentBinding binding;
    DatePickerDialog datePickerDialog;
    SearchableSpinner durumSpinner,hizmetSpinner;
    TextView etTarih;
    EditText vakaNo,vakaExplanation;
    String vakano,hizmet,durum,explanation,date;
    Button button;
    public static VakaAramaFragment newInstance() {
        return new VakaAramaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

       View view= inflater.inflate(R.layout.vaka_arama_fragment, container, false);
       etTarih=view.findViewById(R.id.vakaTarih);
       button=view.findViewById(R.id.vakaSearchButton);
       hizmetSpinner=view.findViewById(R.id.hizmetSpinner);
       durumSpinner=view.findViewById(R.id.durumSpinner);
       vakaExplanation=view.findViewById(R.id.vakaExplanation);
       vakaNo=view.findViewById(R.id.vakaNo);







/*        binding= DataBindingUtil.inflate(inflater,R.layout.vaka_arama_fragment,container,false);

        binding.setVakaAramaViewModel(new VakaAramaViewModel());
        binding.setLifecycleOwner(getActivity());

        searchableSpinner=binding.getRoot().findViewById(R.id.durumSpinner);*/




        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VakaAramaViewModel.class);

        etTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment= new SelectDateFragment(etTarih);
                newFragment.show(getFragmentManager(),"DatePicker");
                date=etTarih.getText().toString();
            }
        });

        hizmetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (view.toString() != null) {
                    hizmet=view.toString();
                }
                else{
                    hizmet=null;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        durumSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                durum=view.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // TODO: Use the ViewModel


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vakano=vakaNo.getText().toString();
                explanation=vakaExplanation.getText().toString();
                Vaka vaka= new Vaka(vakano,durum,hizmet,date,explanation);

                MutableLiveData<Vaka> data= new MutableLiveData<>();
                data.setValue(vaka);

                mViewModel.setVakaMutableLiveData(data);
            }
        });

    }







}
