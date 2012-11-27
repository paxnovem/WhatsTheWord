package sean.vieten.acm;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import sean.vieten.acm.Athletics.RemindTask;

public class EndScreen extends Activity {
	public Timer timer;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.end_screen);
		Reminder(10);
		
		final Button okButton = (Button) findViewById(R.id.button1);
		
		okButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
			}
		});
	}
	public void Reminder(int seconds) {
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds * 1000);
	}
	

	class RemindTask extends TimerTask {
		public void run() {
			timer.cancel(); // Terminate the timer thread
			Intent intent = new Intent(getApplicationContext(),
					WordActivity.class);
			startActivity(intent);
			
		}
	}

}