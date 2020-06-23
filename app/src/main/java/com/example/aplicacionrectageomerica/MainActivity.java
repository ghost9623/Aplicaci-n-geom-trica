package com.example.aplicacionrectageomerica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText EditX1;
    private EditText Editx2;
    private EditText Edity1;
    private EditText Edity2;
    private EditText Editpen;
    private EditText Editdosliena;
    private Button btnclacular;




    public void  app()
    {
        EditX1=(EditText)findViewById(R.id.editX1);
        Editx2=(EditText)findViewById(R.id.editX2);
        Edity1=(EditText)findViewById(R.id.editY1);
        Edity2=(EditText)findViewById(R.id.editY2);
        Editpen=(EditText)findViewById(R.id.editPendiente);
        Editdosliena=(EditText)findViewById(R.id.editdoslineas);

        btnclacular=(Button)findViewById(R.id.btnCalcular);

        btnclacular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculo();
            }
        });


    }

    public void calculo()
    {
        double pendiente,disdoslien,x1,x2,y1,y2;
        y1=Double.parseDouble(Edity1.getText().toString());
        y2=Double.parseDouble(Edity2.getText().toString());

        x1=Double.parseDouble(EditX1.getText().toString());
        x2=Double.parseDouble(Editx2.getText().toString());

        pendiente=(y2-y1)/(x2-x1);

        String pen;
        pen=String.valueOf(pendiente);
        Editpen.setText(pen);


        disdoslien=Math.sqrt(Math.pow((x1-x2),2)+Math.pow(y1-y2,2));
        String linea;
        linea=String.valueOf(disdoslien);
        Editdosliena.setText(linea);




    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app();
    }
}
