/**
 * Created by farriem on 2/10/18.
 */
package com.hackathon.jungg2.honeycrisppls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class FountainsWindow extends AppCompatActivity {

    TextView showValueBLUP;
    TextView showValueBLDOWN;

    TextView showValueF1UP;
    TextView showValueF1DOWN;

    TextView showValueF2UP;
    TextView showValueF2DOWN;

    TextView showValueF3UP;
    TextView showValueF3DOWN;

    TextView showValueF4UP;
    TextView showValueF4DOWN;

    int counterBLUP = 0;
    int counterBLDOWN = 0;

    int counterF1UP = 0;
    int counterF1DOWN = 0;

    int counterF2UP = 0;
    int counterF2DOWN = 0;

    int counterF3UP = 0;
    int counterF3DOWN = 0;

    int counterF4UP = 0;
    int counterF4DOWN = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fountains_window);

        showValueBLUP = (TextView) findViewById(R.id.BLUPcounterValue);
        showValueBLDOWN = (TextView) findViewById(R.id.BLDOWNcounterValue);

        showValueF1UP = (TextView) findViewById(R.id.F1UPcounterValue);
        showValueF1DOWN = (TextView) findViewById(R.id.F1DOWNcounterValue);

        showValueF2UP = (TextView) findViewById(R.id.F2UPcounterValue);
        showValueF2DOWN = (TextView) findViewById(R.id.F2DOWNcounterValue);

        showValueF3UP = (TextView) findViewById(R.id.F3UPcounterValue);
        showValueF3DOWN = (TextView) findViewById(R.id.F3DOWNcounterValue);

        showValueF4UP = (TextView) findViewById(R.id.F4UPcounterValue);
        showValueF4DOWN = (TextView) findViewById(R.id.F4DOWNcounterValue);
    }

    public void countBLUP(View view) {
        counterBLUP++;
        showValueBLUP.setText(Integer.toString(counterBLUP));
    }

    public void countBLDOWN(View view) {
        counterBLDOWN++;
        showValueBLDOWN.setText(Integer.toString(counterBLDOWN));
    }

    public void countF1UP(View view) {
        counterF1UP++;
        showValueF1UP.setText(Integer.toString(counterF1UP));
    }

    public void countF1DOWN(View view) {
        counterF1DOWN++;
        showValueF1DOWN.setText(Integer.toString(counterF1DOWN));
    }

    public void countF2UP(View view) {
        counterF2UP++;
        showValueF2UP.setText(Integer.toString(counterF2UP));
    }

    public void countF2DOWN(View view) {
        counterF2DOWN++;
        showValueF2DOWN.setText(Integer.toString(counterF2DOWN));
    }

    public void countF3UP(View view) {
        counterF3UP++;
        showValueF3UP.setText(Integer.toString(counterF3UP));
    }

    public void countF3DOWN(View view) {
        counterF3DOWN++;
        showValueF3DOWN.setText(Integer.toString(counterF3DOWN));
    }

    public void countF4UP(View view) {
        counterF4UP++;
        showValueF4UP.setText(Integer.toString(counterF4UP));
    }

    public void countF4DOWN(View view) {
        counterF4DOWN++;
        showValueF4DOWN.setText(Integer.toString(counterF4DOWN));
    }
}
