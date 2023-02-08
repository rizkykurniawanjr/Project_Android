package id.ac.poliban.mi.jordy.codingchallenge2_052;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SecondActivity extends BaseClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView redBlock = findViewById(R.id.redBlock);
        ImageView blueBlock = findViewById(R.id.blueBlock);
        ImageView yellowBlock = findViewById(R.id.yellowBlock);
        ImageView androidBlock = findViewById(R.id.androidBlock);
        
        explodeTransition(this, redBlock);
        fadeTransition(this, blueBlock);
        rotateView(yellowBlock);
        switchAnimation(androidBlock,blueBlock,new Intent(
                this,MainActivity.class),this);
    }
}