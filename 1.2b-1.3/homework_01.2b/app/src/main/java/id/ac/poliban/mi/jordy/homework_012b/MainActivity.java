package id.ac.poliban.mi.jordy.homework_012b;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }
    public void showToast(View view) {
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));

        Toast toast = Toast.makeText(this, "Hello Toast",
                Toast.LENGTH_SHORT);
        toast.show();
        Button button = findViewById(R.id.button_zero);
        if (mCount== 0) {
            button.setBackgroundColor(Color.GRAY);
        }
        if (mCount == 0) {
            button = this.findViewById(R.id.button_count);
            button.setBackgroundColor(Color.MAGENTA);
        }
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));

        Button button = findViewById(R.id.button_zero );
        if (mCount>= 0) {
            button.setBackgroundColor(Color.GREEN);
        }
        if (mCount >= 0) {
            button = this.findViewById(R.id.button_count);
            button.setBackgroundColor(Color.RED);
        }
    }

    public void zero(View view) {
        mCount=0;
        Toast zero = Toast.makeText(this, "0", Toast.LENGTH_SHORT);
        zero.show();
        if (mShowCount!=null) {
            mShowCount.setText(Integer.toString(mCount));
            Button button = findViewById(R.id.button_zero);
            if (mCount== 0) {
                button.setBackgroundColor(Color.GRAY);
            }
            if (mCount == 0) {
                button = this.findViewById(R.id.button_count);
                button.setBackgroundColor(Color.MAGENTA);
            }
        }
    }
}