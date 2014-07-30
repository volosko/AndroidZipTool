package com.avolosko.androidziptool;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;


public class StartActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        new CompressOperation().execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private class CompressOperation extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            File file = new File(Environment.getExternalStorageDirectory()+"/filename");
            ZipTool.compress(file);


            File folder = new File(Environment.getExternalStorageDirectory()+"/folder name");
            ZipTool.compress(folder);


            File media = new File(Environment.getExternalStorageDirectory()+"/filename");
            ZipTool.compress(media);
            return null;
        }
    }

}
