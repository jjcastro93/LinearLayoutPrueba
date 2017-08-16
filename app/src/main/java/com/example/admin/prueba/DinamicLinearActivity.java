package com.example.admin.prueba;

import android.app.DatePickerDialog;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class DinamicLinearActivity extends AppCompatActivity {

    ViewGroup llLinearDinamico;
    int count = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamic_linear);

        ArrayList<String> datos = new ArrayList<>();
        datos.add("hola");
        datos.add("hola mundo mundiaaaaal");
        datos.add(":3");

        final Spinner spnPrueba = (Spinner) findViewById(R.id.spnPrueba);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datos);
        spnPrueba.setAdapter(adapter);

        spnPrueba.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String text = adapterView.getItemAtPosition(position).toString();
                Rect bounds = new Rect();
                Paint textPaint = new Paint();
                textPaint.measureText(text);
                textPaint.setTextSize(45);
                textPaint.getTextBounds(text, 0, text.length(), bounds);
                int width = bounds.width();
                ViewGroup.LayoutParams params = spnPrueba.getLayoutParams();
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                params.width = width;
                spnPrueba.setLayoutParams(params);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        llLinearDinamico = (ViewGroup) findViewById(R.id.llLinearDinamico);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 1){
                    llLinearDinamico.removeViews(1,count);
                    count = 1;
                }
            }
        });

        final TextView textView1 = (TextView) findViewById(R.id.textView);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View viewNuevo = LayoutInflater.from(DinamicLinearActivity.this).inflate(R.layout.item_linearlayout, llLinearDinamico, false);
                TextView add = (TextView) viewNuevo.findViewById(R.id.textView);
                add.setText("Nuevoooooooooooooooo");
                llLinearDinamico.addView(viewNuevo);

                count ++;
            }
        });


        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                textView1.setText( datePicker.getYear() + "");
            }
        },
                1993, 1, 15).show();

    }

    /*public int pxToDp(int px) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }*/
}
