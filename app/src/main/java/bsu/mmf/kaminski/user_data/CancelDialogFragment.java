package bsu.mmf.kaminski.user_data;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class CancelDialogFragment extends DialogFragment {

    private UserActivityBase currentActivity;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        currentActivity = (UserActivityBase) context;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String activityType = currentActivity.getClass().getSimpleName();
        String message = activityType.equals(MainActivity.class.getSimpleName()) ?
                getString(R.string.exit_confirmation) : getString(R.string.cancel_confirmation);
        return builder
                .setTitle(message)
                .setView(R.layout.fragment_cancel_dialog)
                .setPositiveButton(getString(R.string.select_decision_positive), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent returnIntent = new Intent();
                        currentActivity.setResult(Activity.RESULT_CANCELED, returnIntent);
                        currentActivity.finish();
                    }
                })
                .setNegativeButton(getString(R.string.select_decision_negative), null)
                .create();
    }
}