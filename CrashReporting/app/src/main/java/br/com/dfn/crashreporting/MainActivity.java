package br.com.dfn.crashreporting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.firebase.crash.FirebaseCrash;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseCrash.log("Activity created");
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseCrash.log("Activity resumed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseCrash.log("Activity started");
    }

    public void onForceError(View v){
        throw new RuntimeExecutionException(null);
    }

    public void onSendReport(View v){
        FirebaseCrash.report(new Exception("My first Android non-fatal error 2"));
    }

    public void onNullPointerException(View v){
        throw new NullPointerException("Fake null pointer exception");
    }
}
