package bsu.mmf.kaminski.user_data;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivityBase extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String activityType =  this.getClass().getSimpleName();

        String name = activityType.equals(MainActivity.class.getSimpleName()) ?
                getString(R.string.exit_item) : getString(R.string.cancel_item);

        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, name);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 1){
            CancelDialogFragment dialog = new CancelDialogFragment();
            dialog.show(getSupportFragmentManager(), "edit");
        }
        return super.onOptionsItemSelected(item);
    }
}
