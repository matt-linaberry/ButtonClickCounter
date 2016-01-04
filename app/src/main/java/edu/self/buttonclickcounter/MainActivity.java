package edu.self.buttonclickcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button ourButton;
    private TextView ourMessage;
    private int numTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // this loads the actual view.
        // link the UI to our properties allocated.
        // this is like the control-drag action for xcode stuff.
        ourButton = (Button)findViewById(R.id.button);
        ourMessage = (TextView)findViewById(R.id.textView);

        // create button listeners.
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numTimesClicked++;
                String result = "The button got tapped " + numTimesClicked + " time";
                if (numTimesClicked != 1) {
                    result += "s...";
                }
                ourMessage.setText(result);
            }
        };

        // add button listeners.
        ourButton.setOnClickListener(ourOnClickListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu); // add something to the menu.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toastMessage = Toast.makeText(this, "Text value is now: " + ourMessage.getText(), Toast.LENGTH_LONG);
            toastMessage.show();
            numTimesClicked = 0;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
