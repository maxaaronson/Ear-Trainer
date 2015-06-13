package com.amset.eartrainer;


import java.util.Arrays;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	public String difficulty = "Easy";
	public int id;
	public int id2;
	public int counter;
	public String [] choices = new String[4];

	static MediaPlayer mediaPlayer = new MediaPlayer();
	IntervalGame i;
	ScaleGame s;
	ChordGame ch;
	CadenceGame ca;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id3 = item.getItemId();
		if (id3 == R.id.action_settings) {
			setContentView(R.layout.settings);
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}


	/////////////////////////////////Mediaplayer//////////////////////////////////////

	public void play_media(String filename) {

		mediaPlayer.setVolume(1f, 1f);
		
		if (counter == 1) {
			mediaPlayer.stop();
			mediaPlayer.release();
			counter = 0;
		}
		
		id = this.getResources().getIdentifier(filename, "raw", this.getPackageName());
		mediaPlayer = MediaPlayer.create(getBaseContext(), id);

		try {  
			mediaPlayer.start();
			counter = 1;
			
		} catch(Exception f) {
			f.printStackTrace();
			Toast toast = Toast.makeText(getBaseContext(), "Can't play media", Toast.LENGTH_SHORT);
			toast.show();
		}
	}


	/////////////////////////////Chord Game//////////////////////////////////////////////////////

	public void playChordGame(View view) {
		setContentView(R.layout.chord_game);
		TextView mytxt=(TextView )findViewById(R.id.textView1);
		ch = new ChordGame(difficulty);
		mytxt.setText("Score:  " + "0");
		
		setChordText();
		play_media(ch.correctAnswer);
	}

	public void setChordText() {
		choices[0] = ch.chord;
		choices[1] = ch.wrongAnswer1;
		choices[2] = ch.wrongAnswer2;
		choices[3] = ch.wrongAnswer3;
		Arrays.sort(choices);
		
		RadioButton a = (RadioButton)findViewById(R.id.choice1);
		a.setText(choices[0]);
		RadioButton b = (RadioButton)findViewById(R.id.choice2);
		b.setText(choices[1]);
		RadioButton c = (RadioButton)findViewById(R.id.choice3);
		c.setText(choices[2]);
		RadioButton d = (RadioButton)findViewById(R.id.choice4);
		d.setText(choices[3]);
	}
	

	public void new_chord(View view) {
		ch.chooseChord(ch.difficulty);
		setChordText();
		hear_again(view);
	}


	public void hear_again(View view) {
		play_media(ch.correctAnswer);
	}

	public void onChordButtonClicked(View view) {
		ch.onChordButtonClicked(view, choices[0], choices[1], choices[2], choices[3]);
		if (ch.isCorrect()) {
			Toast toast = Toast.makeText(getBaseContext(), "correct", Toast.LENGTH_SHORT);
			toast.show(); }
		else {
			Toast toast2 = Toast.makeText(getBaseContext(), "incorrect" , Toast.LENGTH_SHORT);
			toast2.show(); 
		}
		ch.updateScore(ch.isCorrect());
		TextView mytxt=(TextView ) findViewById(R.id.textView1);
		mytxt.setText("Score:  " + ch.displayScore());
	}

	public void see_chord_answer(View view) {
		String answer = ch.correctAnswer;
		Toast.makeText(view.getContext(), answer, 1000).show();
	}

	//////////////////////////////Interval Game////////////////////////////////////
	public void playIntervalGame(View view) {
		setContentView(R.layout.interval_guessing);

		TextView mytxt=(TextView )findViewById(R.id.textView1);
		mytxt.setText("Score:  " + "0");

		i = new IntervalGame();
		play_media(i.correctAnswer);
		
	}

	public void newInterval(View view) {
		i.chooseInterval();
		hearAgain(view);
	}

	public void hearAgain(View view) {
		play_media(i.correctAnswer);
	}

	public void IntervalRadioButtonClicked(View view) {
		i.IntervalRadioButtonClicked(view);
		if (i.isCorrect()) {
			Toast toast = Toast.makeText(getBaseContext(), "correct", Toast.LENGTH_SHORT);
			toast.show(); }
		else {
			Toast toast2 = Toast.makeText(getBaseContext(), "incorrect" , Toast.LENGTH_SHORT);
			toast2.show(); }

		i.updateScore(i.isCorrect());
		TextView mytxt=(TextView ) findViewById(R.id.textView1);
		mytxt.setText("Score:  " + i.displayScore());
	}

	public void seeAnswer(View view){
		String answer = i.correctAnswer;
		Toast toast = Toast.makeText(getBaseContext(), "Answer is " 
				+ answer, Toast.LENGTH_SHORT);
		toast.show(); 
	}

	

	////////////////////////////Instrument Game///////////////////////////////////

	public void instrument_game(View view){
		setContentView(R.layout.game_screen);
		//Game_Contents.instrument_game(difficulty);
	}

	////////////////////////////Cadence Game//////////////////////////////////////

	public void playCadenceGame(View view){
		setContentView(R.layout.cadence_screen);
		ca = new CadenceGame();

		TextView mytxt=(TextView )findViewById(R.id.textView1);
		mytxt.setText("Score:  " + "0");

		playCadence();
	}
	
	public void playCadence() {

		play_media("chord_1");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		play_media(ca.correctAnswer);

	}
	
	public void newCadence(View view) {
		ca.chooseCadence();
		playCadence();
	}

	public void hearCadenceAgain(View view){
		try {
			playCadence();
		}
		catch (Exception e){
			Toast toast = Toast.makeText(getBaseContext(), "error", Toast.LENGTH_SHORT);
			toast.show(); 
		}
	}
	
	public void CadenceRadioButtonClicked(View view) {
		ca.CadenceRadioButtonClicked(view);
		if (ca.isCorrect()) {
			Toast toast = Toast.makeText(getBaseContext(), "correct", Toast.LENGTH_SHORT);
			toast.show(); }
		else {
			Toast toast2 = Toast.makeText(getBaseContext(), "incorrect" , Toast.LENGTH_SHORT);
			toast2.show(); }
		ca.updateScore(ca.isCorrect());

		TextView mytxt=(TextView ) findViewById(R.id.textView1);
		mytxt.setText("Score:  " + ca.displayScore());
	}

	public void see_cadence_answer(View view){
		Toast toast = Toast.makeText(getBaseContext(), "Answer is " 
				+ ca.correctAnswer, Toast.LENGTH_SHORT);
		toast.show(); 

	}

	////////////////////////////Scale Game////////////////////////////////////////

	public void playScaleGame(View view){
		setContentView(R.layout.scale_guessing);
		s = new ScaleGame();
		TextView mytxt=(TextView )findViewById(R.id.textView1);
		mytxt.setText("Score:  " + "0");
		play_media(s.correctAnswer);
	}
	public void newScale(){
		s.chooseScale();
		play_media(s.correctAnswer);
	}

	public void hearScaleAgain(View view)  {
		play_media(s.correctAnswer);
	}
	
	public void newScale(View view) {
		s.chooseScale();
		TextView mytxt2=(TextView )findViewById(R.id.textView3);
		mytxt2.setText("Which Scale was that?");
		play_media(s.correctAnswer);
	}
	
	public void ScaleRadioButtonClicked(View view){
		s.ScaleRadioButtonClicked(view);
		if (s.isCorrect()) {
			TextView mytxt=(TextView )findViewById(R.id.textView3);
			mytxt.setText("Correct!");
		}

		else {
			TextView mytxt=(TextView )findViewById(R.id.textView3);
			mytxt.setText("Sorry, try again.");
		}
		s.updateScore(s.isCorrect());
		String str_score = s.displayScore();
		TextView mytxt=(TextView ) findViewById(R.id.textView1);
		mytxt.setText("Score:  " + str_score);
	}
	
	public void see_scale_answer(View view){
		TextView mytxt=(TextView )findViewById(R.id.textView3);
		mytxt.setText("Answer is " + s.correctAnswer);
	}



	////////////////////////////////Settings/////////////////////////////////////////


	public void settings(View view){
		// view settings
		setContentView(R.layout.settings);
	}

	public void change_diff(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		// Check which radio button was clicked
		switch(view.getId()) {
		case R.id.radio0:
			if (checked)
				difficulty = "Easy";
			break;
		case R.id.radio1:
			if (checked)
				difficulty = "Medium";
			break;
		case R.id.radio2:
			if (checked)
				difficulty = "Hard";
			break;
		}
	}

	////////////////////////////Return to Main////////////////////////////////

	public void return_to_main(View view) {
		if (counter == 1){
			mediaPlayer.stop();
		}
		setContentView(R.layout.fragment_main);
	}



}