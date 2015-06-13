package com.amset.eartrainer;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ChordGame extends Game{
	
	public String chord;
	public String wrongAnswer1;
	public String wrongAnswer2;
	public String wrongAnswer3;
	public String difficulty;
	
	public ChordGame(String difficulty){
		total = 0;
		score = 0;
		correctAnswer = "";
		guess = "";
		this.difficulty = difficulty;
		
		chooseChord(difficulty);
	}
	
	public void chooseChord(String difficulty) {
		List<String> chords = new LinkedList<String>();
	    if (difficulty == "Easy"){
			chords.add("amaj");
		    chords.add("a7");
		    chords.add("am7");
		    chords.add("amaj7");
		    chords.add("a9");
		    chords.add("am");
	    }
	    
	    else if (difficulty == "Medium") {
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
	    
	    else if (difficulty == "Hard"){
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
	
        randomInt = random.nextInt(chords.size());
    	chord = chords.get(randomInt);
    	randomInt = random.nextInt(chords.size());
    	wrongAnswer1 = chords.get(randomInt);
    	while (chord == wrongAnswer1){
    		randomInt = random.nextInt(chords.size());
        	wrongAnswer1 = chords.get(randomInt);  	
    	}
    	randomInt = random.nextInt(chords.size());
    	wrongAnswer2 = chords.get(randomInt);
    	while ((chord == wrongAnswer2) || (wrongAnswer1 == wrongAnswer2)){
    		randomInt = random.nextInt(chords.size());
        	wrongAnswer2 = chords.get(randomInt);  
    	}
    	randomInt = random.nextInt(chords.size());
    	wrongAnswer3 = chords.get(randomInt);
    	while ((chord == wrongAnswer3) || (wrongAnswer1 == wrongAnswer3) || (wrongAnswer2 == wrongAnswer3)){
    		randomInt = random.nextInt(chords.size());
        	wrongAnswer3 = chords.get(randomInt);  
    	}    	
    	
    	correctAnswer = chord;
    }
	
	public void onChordButtonClicked(View view, String a, String b, String c, String d) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
	
    
		// Check which radio button was clicked
		switch(view.getId()) {
			case R.id.choice1:
				if (checked)
					guess = a;
					break;
			case R.id.choice2:
				if (checked)
					guess = b;
					break;
			case R.id.choice3:
				if (checked)
					guess = c;
					break;
			case R.id.choice4:
				if (checked)
					guess = d;
					break;
			
		}
		
	}
	
	

/*	public static String correct_choice(String a, String b, String c, String d){
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
	} */
	
	//public static String get_answer() {
	//	return answer;
  //}
	
}
		
		


	
	


