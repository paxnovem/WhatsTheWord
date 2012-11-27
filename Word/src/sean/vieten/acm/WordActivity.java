package sean.vieten.acm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;



public class WordActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Button athleticsButton = (Button) findViewById(R.id.buttonAthletics);
		final Button celebritiesButton = (Button) findViewById(R.id.buttonCelebrities);
		final Button computerButton = (Button) findViewById(R.id.buttonComputer);

		// OnClickLIstener for when athletics button is pressed.
		athleticsButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent in2 = new Intent(getApplicationContext(), Athletics.class);
		    	startActivity(in2);
		    	
			}
		});

	}

}

