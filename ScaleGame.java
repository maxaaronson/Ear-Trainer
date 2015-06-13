package com.amset.eartrainer;

import java.util.Random;
import java.util.Scanner;



import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ScaleGame extends Game {
	
	public String scale;
		
	public ScaleGame(){
		total = 0;
		score = 0;
		correctAnswer = "";
		guess = "";
		chooseScale();
	}
	
	public void chooseScale(){
		
		randomInt = random.nextInt(7);

		if (randomInt == 0) {
			scale = "ionian";
			}
		else if (randomInt == 1) {
			scale = "dorian";
			}
		else if (randomInt == 2) {
			scale = "phrygian";
			}
		else if (randomInt == 3) {
			scale = "lydian";
			}
		else if (randomInt == 4) {	
			scale = "mixolydian";
			}
		else if (randomInt == 5) {
			scale = "aeolian";
			}
		else {
			scale = "locrian";
			}
		correctAnswer = scale;
		}
		
	public void ScaleRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
    
		// Check which radio button was clicked
		switch(view.getId()) {
			case R.id.radio0:
				if (checked)
					guess = "ionian";
					break;
			case R.id.radio1:
				if (checked)
					guess = "dorian";
					break;
			case R.id.radio2:
				if (checked)
					guess = "phrygian";
					break;
			case R.id.radio3:
				if (checked)
					guess = "lydian";
					break;
			case R.id.radio4:
				if (checked)
					guess = "mixolydian";
					break;
			case R.id.radio5:
				if (checked)
					guess = "aeolian";
					break;
			case R.id.radio6:
				if (checked)
					guess = "locrian";
					break;			
		}
	}
	
}

 

