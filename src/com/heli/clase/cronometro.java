package com.heli.clase;

import java.util.Date;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class cronometro extends Activity {

	public TextView tv;
	String tiempo;
	long milisC, runi;
	Date d1, d2;

	Button bcomenzar;
	public Boolean empezado, parado, ceros, tt;
	Thread timer;
	Handler hand;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cronometro);
		tv = new TextView(this);
		tv = (TextView) findViewById(R.id.tvCronoTiempo);
		tiempo = "00:00:00";
		milisC = 0;
		bcomenzar = (Button) findViewById(R.id.bCronoComenzar);
		empezado = false;
		parado = false;
		ceros = true;
		tt = true;

		bcomenzar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				empezarCronometro();

			}
		});

		timer = new Thread() {

			@Override
			public void run() {
				long min, seg, mil;
				while (true) {
					while (!parado) {
						runi = System.currentTimeMillis() - milisC;
						min = runi / 60000;
						seg = (runi % 60000) / 1000;
						mil = runi % 1000;
						tiempo = min + ":" + seg + ":" + mil;
						// System.out.println(tiempo);
						runOnUiThread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								tv.setText(tiempo);
							}
						});

						try {
							sleep(15);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						sleep(15);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

	}

	public void empezarCronometro() {

		if (!empezado) {
			if (ceros) {

				milisC = System.currentTimeMillis();

				parado = false;

				if (tt) {
					tt = false;
					timer.start();
				}

				empezado = true;
				ceros = false;
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						bcomenzar.setText("Parar");

					}
				});
			}
		} else {
			parado = true;
			empezado = false;
			ceros = true;
			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					bcomenzar.setText("Comenzar");
				}
			});

		}

	}

}
