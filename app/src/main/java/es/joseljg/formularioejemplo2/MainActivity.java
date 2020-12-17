package es.joseljg.formularioejemplo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_texto;
    TextView txt_dia;
    TextView txt_hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_texto = (TextView) findViewById(R.id.txt_texto);
        txt_dia = (TextView) findViewById(R.id.txt_dia);
        txt_hora = (TextView) findViewById(R.id.txt_hora);
    }

    public void mostrarAlerta(View view) {
        AlertDialog.Builder miAlerta = new AlertDialog.Builder(this);
        miAlerta.setTitle("Alerta1");
        miAlerta.setMessage("Clic ok para continuar o cancel para cancelar");
        miAlerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"has presionado OK", Toast.LENGTH_SHORT).show();
                txt_texto.setText("has dado a ok");
            }
        });
        miAlerta.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"has presionado cancel", Toast.LENGTH_SHORT).show();
                txt_texto.setText("has dado a cancel");

            }
        });
        miAlerta.show();
    }


    public void mostrarCalendario(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void procesarCalendario(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string + "/" + month_string + "/" + year_string);
        txt_dia.setText(dateMessage);
    }

    public void procesarHora(int hora, int minutos) {
        // Convert time elements into strings.
        String hour_string = Integer.toString(hora);
        String minute_string = Integer.toString(minutos);
        String textohora = hour_string + "/" + minute_string;
        txt_hora.setText(textohora);
    }

    public void mostrarHora(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
}