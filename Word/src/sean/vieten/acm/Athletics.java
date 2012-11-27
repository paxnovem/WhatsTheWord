package sean.vieten.acm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class Athletics extends Activity {

	public String athletics[] = { "Lebron James", "Dallas Cowboys",
			"Barry Bonds", "Boston Celtics", "Steve Nash" };// string array that
															// holds the strings

	ArrayList numbersList = new ArrayList();
	public int length = 4;
	public int startNumber = 0;
	public Timer timer;
	public int counter = 0;
	Random rand = new Random();
	int num= rand.nextInt(30);
	public int time = num + 60;

	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play_screen);
		
		
		// get the button id
		final Button nextButton = (Button) findViewById(R.id.buttonNext);
		// get the text view id
		final TextView textPlay = (TextView) findViewById(R.id.playText);

		RandomNumberGenerator(length);

		// set the text view to that random number
		textPlay.setText("" + "Hit next to Start");
		// put the value into the holder array

		// button listener class to check if the next button is pressed

		nextButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				do{
				
					 Reminder(time);
					counter++;
				}while(counter ==0);
				
				 if (startNumber < 5) {
					textPlay.setText(""
							+ athletics[generateNewRandom(startNumber)]);
					startNumber++;
				} else {
					// textPlay.setText("Out of bounds");
					Intent intent1 = new Intent(getApplicationContext(),
							WordActivity.class);
					startActivity(intent1);
				}
				
			}

		});

	}

	public void RandomNumberGenerator(int length) {
		for (int x = 0; x <= length; x++)
			numbersList.add(x);
		Collections.shuffle(numbersList);
	}

	public int generateNewRandom(int n) {
		return (Integer) numbersList.get(n);
	}

	public void Reminder(int seconds) {
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds * 1000);
	}
	

	class RemindTask extends TimerTask {
		public void run() {
			timer.cancel();
			Intent intent2 = new Intent(getApplicationContext(),
					EndScreen.class);
			startActivity(intent2);
			 // Terminate the timer thread
			
		}
	}
}
