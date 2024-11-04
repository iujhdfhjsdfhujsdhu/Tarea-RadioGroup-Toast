package com.example.tarearadiogrouptoast;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Obtener el RadioButton seleccionado
                RadioButton radioButtonSeleccionado = findViewById(checkedId);
                String colorSeleccionado = radioButtonSeleccionado.getText().toString();


                // Crear un TextView para mostrar el texto en el Toast
                TextView textoDelToast = new TextView(MainActivity.this);
                textoDelToast.setText(colorSeleccionado);
                textoDelToast.setTextSize(28);
                textoDelToast.setPadding(30, 20, 30, 20); // Añadir padding para que se vea mejor en el Toast



                switch (colorSeleccionado) {
                    case "Rojo":
                        textoDelToast.setTextColor(Color.RED);
                        break;
                    case "Verde":
                        textoDelToast.setTextColor(Color.parseColor("#4CAF50"));
                        break;
                    case "Azul":
                        textoDelToast.setTextColor(Color.BLUE);
                        break;
                    default:
                        textoDelToast.setTextColor(Color.BLACK);
                }


                // Crear y configurar el Toast
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(textoDelToast);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }
}
