package bsu.mmf.kaminski.user_data;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivityBase extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, R.string.cancel_item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 1){
            Intent returnIntent = new Intent();
            UserActivityBase.this.setResult(Activity.RESULT_CANCELED, returnIntent);
            UserActivityBase.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
