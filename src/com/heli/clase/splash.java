package com.heli.clase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;


public class splash extends Activity {
	
	Thread timer;
	ProgressBar pb;
	int cont;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        pb=(ProgressBar)findViewById(R.id.pbSplashCarga);
        cont=0;
        timer=new Thread() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while(cont<100){
						sleep(30);
						cont++;
						pb.setProgress(cont);
					}
					abrirMenu();
					this.stop();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
        timer.start();
    }
    
    public void abrirMenu(){
    	
    	Intent menu=new Intent(this,Menu.class);
    	startActivity(menu);
    	finish();
    	
    	
    }
}