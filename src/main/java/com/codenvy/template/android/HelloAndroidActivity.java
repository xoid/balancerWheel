package com.codenvy.template.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class HelloAndroidActivity extends Activity {
  		Server server;
    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState
     *         If the activity is being re-initialized after
     *         previously being shut down then this Bundle contains the data it most
     *         recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      	//server = new Server();
         setContentView(new myView(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.codenvy.template.android.R.menu.main, menu);
        return true;
    }

}

