package com.example.ejerciciopizza;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvMasa, tvIngredientes, tvTamano;
    Spinner spMasa;
    CheckBox cbJamon, cbBacon, cbPollo, cbTernera, cbQueso, cbPimiento;
    RadioGroup rgTamano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMasa = (TextView) findViewById(R.id.tvMasa);
        tvIngredientes = (TextView) findViewById(R.id.tvIngredientes);
        tvTamano = (TextView) findViewById(R.id.tvTamano);

        spMasa = (Spinner) findViewById(R.id.spMasa);
        String[] masas = {"Selecciona", "Fina", "Normal", "Borde queso", "Calzone"};
        ArrayAdapter<String> adaptadorMasas = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, masas);
        spMasa.setAdapter(adaptadorMasas);

        cbJamon = (CheckBox) findViewById(R.id.cbJamon);
        cbBacon = (CheckBox) findViewById(R.id.cbBacon);
        cbPollo = (CheckBox) findViewById(R.id.cbPollo);
        cbTernera = (CheckBox) findViewById(R.id.cbTernera);
        cbQueso = (CheckBox) findViewById(R.id.cbQueso);
        cbPimiento = (CheckBox) findViewById(R.id.cbPimiento);

        rgTamano = (RadioGroup)findViewById(R.id.rgTamano);

    }//FIN ON CREATE

    public void clickMasa(View view) {
        //Recoger la masa que esté seleccionada en el spinner y mostrarlo en el TextView
        //Validaremos que esté seleccionada alguna masa

        String masaSeleccionada = spMasa.getSelectedItem().toString();
        if (masaSeleccionada.equals("Selecciona")) {
            Toast.makeText(getApplicationContext(), "Debes de seleccionar una masa", Toast.LENGTH_SHORT).show();
            spMasa.setBackgroundColor(Color.RED);//Poner el spinner rojo si no está seleccionada una masa
        } else {
            tvMasa.setText("Masa " + masaSeleccionada);
            spMasa.setBackgroundColor(Color.TRANSPARENT);//Volver al color de fondo
        }

    }

    public void clickIngredientes(View view) {

        boolean estaCheckeado = false;
        int numIngredientes=0;
        String Ingredientes = "";
        if (cbJamon.isChecked()) {
            Ingredientes += cbJamon.getText().toString() + " ";
            estaCheckeado = true;
            numIngredientes++;
        }
        if (cbBacon.isChecked()) {
            Ingredientes += cbBacon.getText().toString() + " ";
            estaCheckeado = true;
            numIngredientes++;
        }
        if (cbPollo.isChecked()) {
            Ingredientes += cbPollo.getText().toString() + " ";
            estaCheckeado = true;
            numIngredientes++;
        }
        if (cbTernera.isChecked()) {
            Ingredientes += cbTernera.getText().toString() + " ";
            estaCheckeado = true;
            numIngredientes++;
        }
        if (cbQueso.isChecked()) {
            Ingredientes += cbQueso.getText().toString() + " ";
            estaCheckeado = true;
            numIngredientes++;
        }
        if (cbPimiento.isChecked()) {
            Ingredientes += cbPimiento.getText().toString() + " ";
            estaCheckeado = true;
            numIngredientes++;
        }


        if (estaCheckeado) {
            if (numIngredientes>3){
                Toast.makeText(getApplicationContext(), "Sólo puede seleccionar 3 ingredientes", Toast.LENGTH_SHORT).show();
            }else{
                tvIngredientes.setText(Ingredientes);
            }

        } else {
            Toast.makeText(getApplicationContext(), "Debes de seleccionar al menos un ingrediente", Toast.LENGTH_SHORT).show();
        }

    }

    public void clickTamano(View view){
        int id =rgTamano.getCheckedRadioButtonId();

        if(id!=-1){
            RadioButton copiaRadioSeleccionado = (RadioButton)findViewById(id);
            String tamano=copiaRadioSeleccionado.getText().toString();

            tvTamano.setText("Tamaño "+tamano);
        }else{
            Toast.makeText(getApplicationContext(), "Debes de seleccionar un tamanño", Toast.LENGTH_SHORT).show();
        }
    }
}//FIN MAIN
