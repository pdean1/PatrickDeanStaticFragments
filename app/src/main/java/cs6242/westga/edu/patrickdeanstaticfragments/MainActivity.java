package cs6242.westga.edu.patrickdeanstaticfragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.DataEntryListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataEntry(double one, double two) {
        DataDisplayFragment ddf =
                (DataDisplayFragment)
                        getSupportFragmentManager().findFragmentById(R.id.dataDisplayFragment);
        ddf.setNum1(one);
        ddf.setNum2(two);
        ddf.multiply();
        ddf.displayProduct();
    }

    @Override
    public void DisplayAdd(double a, double b) {
        DisplayAddFragment daf =
                (DisplayAddFragment)
                        getSupportFragmentManager().findFragmentById(R.id.displayAdd);
        daf.setNum1(a);
        daf.setNum2(b);
        daf.add();
        daf.displaySum();
    }
}
