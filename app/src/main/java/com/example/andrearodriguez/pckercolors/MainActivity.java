package com.example.andrearodriguez.pckercolors;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.android.colorpicker.ColorPickerDialog;
import com.android.colorpicker.ColorPickerSwatch;

public class MainActivity extends AppCompatActivity {

    ImageButton imgColorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgColorPicker= (ImageButton) findViewById(R.id.imgPicker);
    }

    public void onClickColorPicker(View view){
        TypedArray typedArrayColors = getResources().obtainTypedArray(R.array.colors);
        int colors[] = new int[typedArrayColors.length()];

        for (int i=0; i<typedArrayColors.length();i++){
            int idColor = typedArrayColors.getResourceId(i, -1);
            colors[i] = ContextCompat.getColor(this, idColor);
        }
        ColorPickerDialog colorPicker = new ColorPickerDialog();
        colorPicker.initialize(R.string.tituloColorPicker,colors, 0, 4, ColorPickerDialog.SIZE_SMALL);
        colorPicker.setOnColorSelectedListener(new ColorPickerSwatch.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int color) {
                imgColorPicker.setColorFilter(color);

            }
        });
        colorPicker.show(getFragmentManager(), "MainActivity");
        typedArrayColors.recycle();
    }
}
