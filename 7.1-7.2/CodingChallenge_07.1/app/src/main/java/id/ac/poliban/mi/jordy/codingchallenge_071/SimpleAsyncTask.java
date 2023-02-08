package id.ac.poliban.mi.jordy.codingchallenge_071;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {

    private final WeakReference<TextView> mTextView;
    private final WeakReference<TextView> mResultTextView;
    SimpleAsyncTask (TextView tv, TextView result){
        mTextView = new WeakReference<>(tv);
        mResultTextView = new WeakReference<>(result);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random random = new Random();
        int number = random.nextInt(11);
        int milli = number * 200;
        publishProgress(milli);
        try {
            Thread.sleep(milli);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Awake after sleeping for " + milli + " milliseconds";
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onProgressUpdate(Integer... values) {
        mResultTextView.get().setText("Current sleep time: " + values[0] + " ms");
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
