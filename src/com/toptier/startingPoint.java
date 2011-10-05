package com.toptier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class startingPoint extends Activity implements OnClickListener {
	private Button bMail;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bMail = (Button) findViewById(R.id.bMail);
        
        bMail.setOnClickListener(this);
        
       
    }
	@Override
	public void onClick(View v) {
		 Intent i = new Intent(Intent.ACTION_SEND);
	        i.setType("text/plain");
	        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
	        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
	        i.putExtra(Intent.EXTRA_TEXT   , "body of email");
	        try {
	            startActivity(Intent.createChooser(i, "Send mail..."));
	        } catch (android.content.ActivityNotFoundException ex) {
	            Toast.makeText(startingPoint.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
	        }
		
	}
}