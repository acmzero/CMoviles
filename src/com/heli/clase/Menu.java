package com.heli.clase;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Menu extends ListActivity  {
	String opciones[]={"Cronometro.","Temporizador.","Vueltas."};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setListAdapter(new ArrayAdapter<String>(getBaseContext(), R.menu.opciones, opciones));
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opciones));
		
		
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		switch(position){
		case 0:
			Intent crono=new Intent(this,cronometro.class);
			startActivity(crono);
			break;
		}
	}
	
	
	
}
