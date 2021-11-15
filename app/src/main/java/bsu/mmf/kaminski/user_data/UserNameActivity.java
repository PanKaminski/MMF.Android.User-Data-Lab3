package bsu.mmf.kaminski.user_data;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserNameActivity extends UserActivityBase {

    private Button save;
    private Button discard;
    private EditText firstName;
    private EditText lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);

        initActivityItems();

        this.save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                String firstName = UserNameActivity.this.firstName.getText().toString();
                String lastName = UserNameActivity.this.lastName.getText().toString();

                returnIntent.putExtra("NAME_TEXT", firstName + " " + lastName);
                UserNameActivity.this.setResult(Activity.RESULT_OK, returnIntent);
                UserNameActivity.this.finish();
            }
        });

        this.discard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                UserNameActivity.this.setResult(Activity.RESULT_CANCELED, returnIntent);
                UserNameActivity.this.finish();
            }
        });
    }

    private void initActivityItems(){
        this.firstName = (EditText) this.findViewById(R.id.firstName);
        this.lastName = (EditText) this.findViewById(R.id.lastName);
        this.save = (Button) this.findViewById(R.id.buttonSave);
        this.discard = (Button) this.findViewById(R.id.buttonDiscard);

        Bundle extras = this.getIntent().getExtras();

        String currentName = extras.getString("NAME_TEXT");

        if (currentName != null && !currentName.isEmpty()
                && !currentName.equals(getString(R.string.user_name))){
            String[] nameInfo = currentName.split(" ");
            if (nameInfo.length > 1) {
                this.lastName.setText(nameInfo[1]);
            }

            this.firstName.setText(nameInfo[0]);
        }
    }
}