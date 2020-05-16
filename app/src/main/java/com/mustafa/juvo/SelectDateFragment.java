package com.mustafa.juvo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    TextView textView;
    public SelectDateFragment(TextView textView) {
        this.textView=textView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, yy, mm, dd);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("EEEE");
        Date date = new Date(year, month, dayOfMonth);
        String dayOfWeek = simpledateformat.format(date);

        if((month+1)<10){
            textView.setText(dayOfMonth+".0"+(month+1)+"."+year+" / "+dayOfWeek);
        }
        else
        {
            textView.setText(dayOfMonth+"."+(month+1)+"."+year+" / "+dayOfWeek);
        }
    }

}