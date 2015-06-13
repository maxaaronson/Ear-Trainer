package com.amset.eartrainer;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



import android.app.Activity;
import android.app.Fragment;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class IntervalGame extends Game {

	public String interval;

	public IntervalGame(){
		total = 0;
		score = 0;
		correctAnswer = "";
		guess = "";
		chooseInterval();
		
	}
	

	public void chooseInterval() {
		
		randomInt = random.nextInt(11);		

		switch(randomInt) {
		case 0: interval= "m2";
				
				break;
		case 1: interval= "maj2";
				
				break;
		case 2: interval= "m3";
				
				break;
		case 3: interval= "maj3";
			
				break;
		case 4: interval= "p4";
				
				break;
		case 5: interval= "dim5";
				
				break;
		case 6: interval= "p5";
				break;
		case 7: interval= "m6";
				break;
		case 8: interval= "maj6";
				break;
		case 9: interval= "m7";
				break;
		case 10: interval= "maj7";
				break;
		case 11: interval= "octave";
				break;
				
			}
		correctAnswer = interval;
	}
		

	public void IntervalRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
    
		// Check which radio button was clicked
		switch(view.getId()) {
			case R.id.radio0:
				if (checked)
					guess = "m2";
					break;
			case R.id.radio1:
				if (checked)
					guess = "maj2";
					break;
			case R.id.radio2:
				if (checked)
					guess = "m3";
					break;
			case R.id.radio3:
				if (checked)
					guess = "maj3";
					break;
			case R.id.radio4:
				if (checked)
					guess = "p4";
					break;
			case R.id.radio5:
				if (checked)
					guess = "dim5";
					break;
			case R.id.radio6:
				if (checked)
					guess = "p5";
					break;
			case R.id.radio7:
				if (checked)
					guess = "m6";
					break;
			case R.id.radio8:
				if (checked)
					guess = "maj6";
					break;
			case R.id.radio9:
				if (checked)
					guess = "m7";
					break;
			case R.id.radio10:
				if (checked)
					guess = "maj7";
					break;
			case R.id.radio11:
				if (checked)
					guess = "octave";
					break;
		}
	
	}
	
	

	/*public static String get_score(boolean correct) {
		if (correct == true) {
			//Toast toast = Toast.makeText(getBaseContext(), "correct", Toast.LENGTH_SHORT);
			//toast.show();
			score +=1;
			total+=1;
			str_score = Integer.toString(score)+ "/" + Integer.toString(total);
		
		}
		else	{
			//Toast toast2 = Toast.makeText(getBaseContext(), "incorrect" , Toast.LENGTH_SHORT);
			//toast2.show();
			total+=1;
			str_score = Integer.toString(score)+ "/" + Integer.toString(total);
		}
		
		return str_score;
			

		} 
	
	*/
		
	

	
	
}
