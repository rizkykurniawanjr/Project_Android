/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package id.ac.poliban.mi.jordy.simpleasynctask_071;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;


public class SimpleAsyncTask extends AsyncTask<Void,Void, String> {

    private final WeakReference<TextView> mTextView;

    SimpleAsyncTask(TextView tv) {
            mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {

        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
