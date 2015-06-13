package com.amset.eartrainer;

import java.util.Random;

import android.view.View;
import android.widget.RadioButton;

public class CadenceGame extends Game{

	public String Cadence;
	public String chord;
	
	public CadenceGame(){
		
		total = 0;
		score = 0;
		correctAnswer = "";
		guess = "";
		chooseCadence();
	}
	
	
	public void chooseCadence() {

			randomInt = random.nextInt(7);
			String chord = "";
	
			switch(randomInt) {
	
			case 0: chord= "chord_2";
					
					break;
			case 1: chord= "chord_3";
					
					break;
			case 2: chord= "chord_4";
				
					break;
			case 3: chord= "chord_5";
					
					break;
			case 4: chord= "chord_6";
					
					break;
			case 5: chord= "chord_7";
			
					break;
			case 6: chord= "octave_chord";
			
			break;
				}
			correctAnswer = chord;
			
		}
		
	public void CadenceRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
	
		// Check which radio button was clicked
		switch(view.getId()) {
			
			case R.id.c1:
				if (checked)
					guess = "chord_2";
					break;
			case R.id.c2:
				if (checked)
					guess = "chord_3";
					break;
			case R.id.c3:
				if (checked)
					guess = "chord_4";
					break;
			case R.id.c4:
				if (checked)
					guess = "chord_5";
					break;
			case R.id.c5:
				if (checked)
					guess = "chord_6";
					break;
			case R.id.c6:
				if (checked)
					guess = "chord_7";
					break;		
			case R.id.c7:
				if (checked)
					guess = "octave_chord";
					break;
		}	
	}

}
