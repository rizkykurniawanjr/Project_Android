package id.ac.poliban.mi.jordy.powerreceiver_073;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private CustomReceiver mReceiver = new CustomReceiver();
    private static final String EXTRA_RANDOM_NUMBER = "id.ac.poliban.mi.jordy.powerreceiver_073.RANDOM_NUMBER";
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar()!=null)getSupportActionBar().setTitle("PowerReceiver");

        textView = findViewById(R.id.textView);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        this.registerReceiver(mReceiver, intentFilter);
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        int num = randomNum();
        textView.setText(String.format("Number is %s", String.valueOf(num)));
        customBroadcastIntent.putExtra(EXTRA_RANDOM_NUMBER, String.valueOf(num));
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }

    public int randomNum(){
        Random random = new Random();
        return random.nextInt(30) + 1;
    }
}
