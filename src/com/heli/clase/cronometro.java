package com.heli.clase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextView;

public class cronometro extends Activity {

	Timer tim;
	TextView tv;
	String tiempo;
	long milis;
	Date d1, d2;
	SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
	Button bcomenzar;
	Boolean empezado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cronometro);
		tv = (TextView) findViewById(R.id.tvCronoTiempo);
		tiempo = "00:00:00";
		milis = 0;
		bcomenzar = (Button) findViewById(R.id.bCronoComenzar);
		empezado = false;
		bcomenzar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!empezado) {
					empezarCronometro();
				}else{
					
				}

			}
		});

	}

	public void empezarCronometro() {
		
		d1.setTime(System.currentTimeMillis());

		TimerTask a = new TimerTask() {

			@Override
			public void run() {
				d2.setTime(System.currentTimeMillis() - d1.getTime());

				tv.setText(sdf.format(d2));

			}
		};
		tim.schedule(a, 1);

	}

}
