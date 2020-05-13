package com.example.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.renderscript.Sampler;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    private Activity mContext;
    public MyAsyncTask(Activity mContext) {
        this.setmContext(mContext);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(mContext, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i <= 100; i++) {
            SystemClock.sleep(100);
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        ProgressBar progressBar = mContext.findViewById(R.id.prbDemo);
        int number = values[0];
        progressBar.setProgress(number);
        TextView textView = mContext.findViewById(R.id.btnStart);
        textView.setText(number + "%");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(mContext, "Ok, Finished", Toast.LENGTH_SHORT).show();
    }

    public Activity getmContext() {
        return mContext;
    }

    public void setmContext(Activity mContext) {
        this.mContext = mContext;
    }
}
