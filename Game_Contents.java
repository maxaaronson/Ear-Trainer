package com.amset.eartrainer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import android.view.View;
import android.widget.RadioButton;



public class Game_Contents {
	
	static String scale;
	String diff = "";
	static String answer = "";
	static String selection = "";
	static int var;
	static String interval;
	static int score = 0;
	static int total = 0;
	static String str_score = Integer.toString(score)+ "/" + Integer.toString(total);
	
	
	
	
	
	
	
	
	public static void reset_score(){
		score = 0;
		total = 0;
	}
	
	public static String get_score(boolean correct) {
		if (correct == true) {
			score +=1;
			total+=1;
			str_score = Integer.toString(score)+ "/" + Integer.toString(total);
		
		}
		else	{
			total+=1;
			str_score = Integer.toString(score)+ "/" + Integer.toString(total);
		}
		
		return str_score;
			

		}
	
	
	public static String see_answer() {
		return answer;
  }
	
	
	/////////////////////////Chord Game//////////////////////////
	
	public static String choose_chord(String diff) {
		List<String> chords = new LinkedList<String>();
	    if (diff == "Easy"){
			chords.add("amaj");
		    chords.add("a7");
		    chords.add("am7");
		    chords.add("amaj7");
		    chords.add("a9");
		    chords.add("am");
	    }
	    
	    if (diff == "Medium") {
	    	chords.add("a");
	    	chords.add("am");
		    chords.add("a7");
		    chords.add("am7");
		    chords.add("amaj7");
		    chords.add("a6");
	 	    chords.add("am6");
		    chords.add("a9");
		    chords.add("am9");
		    chords.add("a11");
		    chords.add("am11");
	    	chords.add("a_dim");
	 	    chords.add("a_aug");	 	    
	 	    chords.add("a_sus");
	    }
	    
	    else if (diff == "Hard"){
	    	chords.add("a9");
		    chords.add("am9");
		    chords.add("a11");
		    chords.add("am11");
	    	chords.add("a_dim");
	 	    chords.add("a_aug");	 	    
	 	    chords.add("a_sus");
	 	 	chords.add("amin_maj7");
	 	    chords.add("a13");
	 	    chords.add("am13");
	 	    chords.add("a7sus4");
	 	    chords.add("a7b5");
	 	    chords.add("a13b9");
	 	    chords.add("amaj9");
	    }
	
    
    Random rand = new Random();
    while (true) {
        int choice = rand.nextInt(chords.size());
    return chords.get(choice);
    	}
    }
	

	public static String correct_choice(String a, String b, String c, String d){
		List<String> choices = new LinkedList<String>();
	    choices.add(a);
	    choices.add(b);
	    choices.add(c);
	    choices.add(d);
	    Random rand = new Random();
	    while (true) {
	        int choice = rand.nextInt(choices.size());
	    answer = choices.get(choice);
	    return answer;
	    }
	}
	
	public static boolean onChordButtonClicked(View view, String a, String b, String c, String d) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
	
    
		// Check which radio button was clicked
		switch(view.getId()) {
			case R.id.choice1:
				if (checked)
					selection = a;
					break;
			case R.id.choice2:
				if (checked)
					selection = b;
					break;
			case R.id.choice3:
				if (checked)
					selection = c;
					break;
			case R.id.choice4:
				if (checked)
					selection = d;
					break;
			
		}
		boolean correct = false;
		if (answer == selection) {
			 correct = true;
		}
		else if (answer != selection){ 
			correct = false;
		}
		
		return correct;
	}
	

	//////////////////////////////Interval Game///////////////////////////
	
public static String choose_interval() {

		
		Random generator = new Random();
		var = generator.nextInt(11);

		switch(var) {
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
		answer = interval;
		return interval;
	}
		

	public static boolean IntervalRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
	
    
		// Check which radio button was clicked
		switch(view.getId()) {
			case R.id.radio0:
				if (checked)
					selection = "m2";
					break;
			case R.id.radio1:
				if (checked)
					selection = "maj2";
					break;
			case R.id.radio2:
				if (checked)
					selection = "m3";
					break;
			case R.id.radio3:
				if (checked)
					selection = "maj3";
					break;
			case R.id.radio4:
				if (checked)
					selection = "p4";
					break;
			case R.id.radio5:
				if (checked)
					selection = "dim5";
					break;
			case R.id.radio6:
				if (checked)
					selection = "p5";
					break;
			case R.id.radio7:
				if (checked)
					selection = "m6";
					break;
			case R.id.radio8:
				if (checked)
					selection = "maj6";
					break;
			case R.id.radio9:
				if (checked)
					selection = "m7";
					break;
			case R.id.radio10:
				if (checked)
					selection = "maj7";
					break;
			case R.id.radio11:
				if (checked)
					selection = "octave";
					break;
		}
		boolean correct = false;
		if (answer == selection) {
			 correct = true;
		}
		else if (answer != selection){ 
			correct = false;
		}
		
		return correct;
	}
	


	

		
	//////////////////////////////////Scale Game////////////////////////////////////
	
	public static String choose_scale(){
		Random generator = new Random();
		var = generator.nextInt(7);

		if (var == 0) {
			scale = "ionian";
			
			}
		else if (var == 1) {
			scale = "dorian";
			
			}
		else if (var == 2) {
			scale = "phrygian";
			
			}
		else if (var == 3) {
			scale = "lydian";
		
			}
		else if (var == 4) {	
			scale = "mixolydian";
		
			}
		else if (var == 5) {
			scale = "aeolian";
		
			}
		else {
			scale = "locrian";
		
			}
		answer = scale;
		return scale;
		}
		
	
	
	
	
	
	public static boolean ScaleRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
    
		// Check which radio button was clicked
		switch(view.getId()) {
			case R.id.radio0:
				if (checked)
					selection = "ionian";
					break;
			case R.id.radio1:
				if (checked)
					selection = "dorian";
					break;
			case R.id.radio2:
				if (checked)
					selection = "phrygian";
					break;
			case R.id.radio3:
				if (checked)
					selection = "lydian";
					break;
			case R.id.radio4:
				if (checked)
					selection = "mixolydian";
					break;
			case R.id.radio5:
				if (checked)
					selection = "aeolian";
					break;
			case R.id.radio6:
				if (checked)
					selection = "locrian";
					break;			
		}
		boolean correct = false;
		if (answer == selection) {
			 correct = true;
		}
		else if (answer != selection) {
			 correct = false;
		}
		return correct;
		

	}
	
	//////////////////////////////Cadence Game///////////////////////////////
	
public static String choose_cadence() {

		
		Random generator = new Random();
		var = generator.nextInt(7);
		String chord = "";

		switch(var) {

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
		answer = chord;
		return chord;
	}
	
public static boolean CadenceRadioButtonClicked(View view) {
	// Is the button now checked?
	boolean checked = ((RadioButton) view).isChecked();

	// Check which radio button was clicked
	switch(view.getId()) {
		
		case R.id.c1:
			if (checked)
				selection = "chord_2";
				break;
		case R.id.c2:
			if (checked)
				selection = "chord_3";
				break;
		case R.id.c3:
			if (checked)
				selection = "chord_4";
				break;
		case R.id.c4:
			if (checked)
				selection = "chord_5";
				break;
		case R.id.c5:
			if (checked)
				selection = "chord_6";
				break;
		case R.id.c6:
			if (checked)
				selection = "chord_7";
				break;		
		case R.id.c7:
			if (checked)
				selection = "octave_chord";
				break;
	}
	boolean correct = false;
	if (answer == selection) {
		 correct = true;
	}
	else if (answer != selection) {
		 correct = false;
	}
	return correct;
	

}

}
