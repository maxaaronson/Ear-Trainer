package com.amset.eartrainer;


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

	String difficulty = "Easy";
	int id;
	int id2;
	int counter;
	String choice1;
	String choice2;
	String choice3;
	String choice4;
	static MediaPlayer mediaPlayer = new MediaPlayer();

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

	public static void play_media() {

		mediaPlayer.setVolume(1f, 1f);

		try {  
			mediaPlayer.start();		        
		} catch(Exception f) {
			f.printStackTrace();
		}
	}


	/////////////////////////////Chord Game//////////////////////////////////////////////////////

	public void chord_game(View view) {
		setContentView(R.layout.chord_game);
		TextView mytxt=(TextView )findViewById(R.id.textView1);
		mytxt.setText("Score:  " + "0");
		choose_chord();
		counter = 0;
		Game_Contents.reset_score();
	}

	public void choose_chord() {
		//TextView e = (TextView)findViewById(R.id.show_diff);
		//e.setText(difficulty);

		choice1 = Game_Contents.choose_chord(difficulty);
		choice2 = Game_Contents.choose_chord(difficulty);
		choice3 = Game_Contents.choose_chord(difficulty);
		choice4 = Game_Contents.choose_chord(difficulty);

		while (choice1 == choice2 || choice1 == choice3 || choice1 == choice4 || 
				choice2 == choice3 || choice2 == choice4 || choice3 == choice4) {
			choice2 = Game_Contents.choose_chord(difficulty);
			choice3 = Game_Contents.choose_chord(difficulty);
			choice4 = Game_Contents.choose_chord(difficulty);
		}


		RadioButton a = (RadioButton)findViewById(R.id.choice1);
		a.setText(choice1);
		RadioButton b = (RadioButton)findViewById(R.id.choice2);
		b.setText(choice2);
		RadioButton c = (RadioButton)findViewById(R.id.choice3);
		c.setText(choice3);
		RadioButton d = (RadioButton)findViewById(R.id.choice4);
		d.setText(choice4);

		String correct_choice = Game_Contents.correct_choice(choice1, choice2, choice3,
				choice4);

		id = this.getResources().getIdentifier(correct_choice, "raw", this.getPackageName());

	}


	public void hear_again(View view) {
		TextView mytxt=(TextView )findViewById(R.id.button2);
		mytxt.setText("Hear Again");
		if (counter == 1) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		mediaPlayer = MediaPlayer.create(getBaseContext(), id);
		counter = 1;
		play_media();
	}

	public void onChordButtonClicked(View view) {
		boolean correct  = Game_Contents.onChordButtonClicked(view, choice1, choice2, choice3, choice4);
		if (correct == true) {
			Toast toast = Toast.makeText(getBaseContext(), "correct", Toast.LENGTH_SHORT);
			toast.show(); }
		else if (correct == false) {
			Toast toast2 = Toast.makeText(getBaseContext(), "incorrect" , Toast.LENGTH_SHORT);
			toast2.show(); 
		}
		String str_score = Game_Contents.get_score(correct);
		TextView mytxt=(TextView ) findViewById(R.id.textView1);
		mytxt.setText("Score:  " + str_score);
	}

	public void see_chord_answer(View view) {
		String answer = Game_Contents.see_answer();
		Toast.makeText(view.getContext(), answer, 1000).show();
	}

	public void new_chord(View view) {
		if (counter == 1) {
			mediaPlayer.stop();
		}
		choose_chord();
		hear_again(view);
	}


	//////////////////////////////Interval Game////////////////////////////////////
	public void interval_game(View view) {
		setContentView(R.layout.interval_guessing);


		TextView mytxt=(TextView )findViewById(R.id.textView1);
		mytxt.setText("Score:  " + "0");
		choose_interval(view);
		counter = 0;
		Game_Contents.reset_score();
	}

	public void choose_interval(View view) {	
		String interval = Game_Contents.choose_interval();
		id = this.getResources().getIdentifier(interval, "raw", this.getPackageName());

	}

	public void onHearAgain(View view) {
		TextView mytxt=(TextView )findViewById(R.id.button1);
		mytxt.setText("Hear Again");

		if (counter == 1) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		mediaPlayer = MediaPlayer.create(getBaseContext(), id);
		counter = 1;
		play_media();
	}

	public void IntervalRadioButtonClicked(View view) {
		boolean correct  = Game_Contents.IntervalRadioButtonClicked(view);
		if (correct == true) {
			Toast toast = Toast.makeText(getBaseContext(), "correct", Toast.LENGTH_SHORT);
			toast.show(); }
		else if (correct == false) {
			Toast toast2 = Toast.makeText(getBaseContext(), "incorrect" , Toast.LENGTH_SHORT);
			toast2.show(); }
		String str_score = Game_Contents.get_score(correct);
		TextView mytxt=(TextView ) findViewById(R.id.textView1);
		mytxt.setText("Score:  " + str_score);
	}

	public void see_interval_answer(View view){
		String answer = Game_Contents.see_answer();
		Toast toast = Toast.makeText(getBaseContext(), "Answer is " 
				+ answer, Toast.LENGTH_SHORT);
		toast.show(); 

	}

	public void newInterval(View view) {
		if (counter == 1){
			mediaPlayer.stop();
		}
		choose_interval(view);
		onHearAgain(view);
	}

	////////////////////////////Instrument Game///////////////////////////////////

	public void instrument_game(View view){
		setContentView(R.layout.game_screen);
		//Game_Contents.instrument_game(difficulty);
	}

	////////////////////////////Cadence Game//////////////////////////////////////

	public void cadence_game(View view){
		setContentView(R.layout.cadence_screen);

		TextView mytxt=(TextView )findViewById(R.id.textView1);
		mytxt.setText("Score:  " + "0");
		choose_cadence(view);
		counter = 0;
		Game_Contents.reset_score();
	}

	public void choose_cadence(View view){	
		String cadence = Game_Contents.choose_cadence();
		id = this.getResources().getIdentifier("chord_1", "raw", this.getPackageName());
		id2 = this.getResources().getIdentifier(cadence, "raw", this.getPackageName());

	}

	public void onHearCadenceAgain(View view) {
		TextView mytxt=(TextView )findViewById(R.id.button1);
		mytxt.setText("Hear Again");

		if (counter == 1){
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		mediaPlayer = MediaPlayer.create(getBaseContext(), id);

		play_media();

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		mediaPlayer.stop();
		mediaPlayer = MediaPlayer.create(getBaseContext(), id2);

		play_media();

		counter = 1;
	}

	public void CadenceRadioButtonClicked(View view) {
		boolean correct  = Game_Contents.CadenceRadioButtonClicked(view);
		if (correct == true) {
			Toast toast = Toast.makeText(getBaseContext(), "correct", Toast.LENGTH_SHORT);
			toast.show(); }
		else if (correct == false) {
			Toast toast2 = Toast.makeText(getBaseContext(), "incorrect" , Toast.LENGTH_SHORT);
			toast2.show(); }
		String str_score = Game_Contents.get_score(correct);
		TextView mytxt=(TextView ) findViewById(R.id.textView1);
		mytxt.setText("Score:  " + str_score);
	}

	public void see_cadence_answer(View view){
		String answer = Game_Contents.see_answer();
		Toast toast = Toast.makeText(getBaseContext(), "Answer is " 
				+ answer, Toast.LENGTH_SHORT);
		toast.show(); 

	}

	public void newCadence(View view) {
		if (counter == 1){
			mediaPlayer.stop();
		}
		choose_cadence(view);
		onHearCadenceAgain(view);

	}

	////////////////////////////Scale Game////////////////////////////////////////

	public void scale_game(View view){
		setContentView(R.layout.scale_guessing);
		TextView mytxt=(TextView )findViewById(R.id.textView1);
		mytxt.setText("Score:  " + "0");
		choose_scale();
		counter = 0;
		Game_Contents.reset_score();
	}
	public void choose_scale(){
		String scale = Game_Contents.choose_scale();
		id = this.getResources().getIdentifier(scale, "raw", this.getPackageName());

	}




	public void ScaleRadioButtonClicked(View view){
		boolean correct = Game_Contents.ScaleRadioButtonClicked(view);
		if (correct == true) {
			TextView mytxt=(TextView )findViewById(R.id.textView3);
			mytxt.setText("Correct!");
		}

		else if (correct == false) {
			TextView mytxt=(TextView )findViewById(R.id.textView3);
			mytxt.setText("Sorry, try again.");
		}
		String str_score = Game_Contents.get_score(correct);
		TextView mytxt=(TextView ) findViewById(R.id.textView1);
		mytxt.setText("Score:  " + str_score);


	}
	public void see_scale_answer(View view){
		TextView mytxt=(TextView )findViewById(R.id.textView3);
		String answer = Game_Contents.see_answer();
		mytxt.setText("Answer is " + answer);
	}

	public void onPlayAgain(View view)  {
		TextView mytxt=(TextView )findViewById(R.id.button3);
		mytxt.setText("Hear Again");

		TextView mytxt2=(TextView )findViewById(R.id.textView3);
		mytxt2.setText("Which Scale was that?");
		if (counter == 1){
			mediaPlayer.stop();
			mediaPlayer.release();
		}
		mediaPlayer = MediaPlayer.create(getBaseContext(), id);
		counter = 1;
		play_media();

	}


	public void onTryAgain(View view) {
		if (counter == 1){
			mediaPlayer.stop();
		}
		choose_scale();
		onPlayAgain(view);

	}


	////////////////////////////////Settings/////////////////////////////////////////


	public void settings(View view){
		// view settings
		setContentView(R.layout.settings);
	}

/*
 	public void set_difficulty1(View view){
		difficulty = "Easy";


	}

	public void set_difficulty2(View view){
		difficulty = "Medium";


	}

	public void set_difficulty3(View view){
		difficulty = "Hard";

	}
*/
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
		mediaPlayer.release();
		setContentView(R.layout.fragment_main);
	}



}