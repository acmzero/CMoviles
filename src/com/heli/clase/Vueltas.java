package com.heli.clase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class Vueltas extends Activity {
	Button bComenzar;
	TextView tiempo;
	Thread tiempoCorriendo;
	long t0;
	int nClick;
	boolean terminado;
	String ctiempo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vueltas);
		tiempo = (TextView) findViewById(R.id.tvTiempoVueltas);
		bComenzar = (Button) findViewById(R.id.bVueltasComenzar);
		oclComenzar();
		nClick = 0;
		terminado = true;

	}

	public void oclComenzar() {

		bComenzar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				switch (nClick) {
				case 0:
					empezarTiempo();
					break;
				}

			}
		});
		nClick++;
	}

	public void empezarTiempo() {
		// Se ejecuta al pulsar comenzar por primera vez.
		t0 = System.currentTimeMillis();

		tiempoCorriendo = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long min = 0, seg = 0, mil = 0, runi = 0;
				while (!terminado) {
					runi = System.currentTimeMillis() - t0;
					min = runi / 60000;
					seg = (runi % 60000) / 1000;
					mil = runi % 1000;
					ctiempo = min + ":" + seg + ":" + mil;
					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							tiempo.setText(ctiempo);
						}
					});

				}
			}
		});

		tiempoCorriendo = new Thread() {
			public void run() {
				// TODO Auto-generated method stub
				long min = 0, seg = 0, mil = 0, runi = 0;
				while (!terminado) {
					runi = System.currentTimeMillis() - t0;
					min = runi / 60000;
					seg = (runi % 60000) / 1000;
					mil = runi % 1000;
					ctiempo = min + ":" + seg + ":" + mil;
					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							tiempo.setText(ctiempo);
						}
			};
		};
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				bComenzar.setText("Vuelta.");
			}
		});
		terminado = false;
		tiempoCorriendo.start();
	}

	public void asignarTiempo(long min, long seg, long mil) {
		switch (nClick) {

		}
	}
}
