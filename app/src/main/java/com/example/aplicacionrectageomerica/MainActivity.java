package com.example.aplicacionrectageomerica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText EditX1;
    private EditText Editx2;
    private EditText Edity1;
    private EditText Edity2;
    private EditText Editpen;
    private EditText Editdosliena;
    private Button btncalcular;

    public void crear()
    {  EditX1=(EditText)findViewById(R.id.editX1);
       Editx2=(EditText)findViewById(R.id.editX2);
       Edity1=(EditText)findViewById(R.id.editY1);
       Edity2=(EditText)findViewById(R.id.editY2);
       Editpen=(EditText)findViewById(R.id.editPendiente);
       Editdosliena=(EditText)findViewById(R.id.editdoslineas);

        btncalcular=(Button)findViewById(R.id.btnCalcular);
    }

    public void  app()
    {
      crear();


            btncalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   try {
                       calculo();
                       mostramensaje();
                   }
                   catch (Exception e)
                   {
                       Toast.makeText(getApplicationContext(),"ingrese un numero",Toast.LENGTH_SHORT).show();
                   }
                }
            });
        }





    public void calculo()
    {   recta re1= new recta();




        re1.setY1(Double.parseDouble(Edity1.getText().toString()));
        re1.setY2(Double.parseDouble(Edity2.getText().toString()));
        re1.setX1(Double.parseDouble(EditX1.getText().toString()));
        re1.setX2(Double.parseDouble(Editx2.getText().toString()));




        String pen;
        pen=String.valueOf(re1.pendiente());
        Editpen.setText(pen);


        re1.distanciaentredoslineas();
        String linea;
        linea=String.valueOf(re1.distanciaentredoslineas());
        Editdosliena.setText(linea);

    }
    public void mostramensaje()
    {
        new AlertDialog.Builder(this)
           .setTitle("exit")
                .setMessage("¿Desea useted salir?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       Log.d("Mensaje","se cancelo la accion ");
                    }
                })
                .show();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         app();

    }



}
