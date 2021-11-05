package bsu.mmf.kaminski.user_data;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView name;
    private TextView address;
    private TextView comment;
    private Button editNameButton;
    private Button editAddressButton;
    private Button editCommentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = (TextView) this.findViewById(R.id.nameView);
        this.address = (TextView) this.findViewById(R.id.addressView);
        this.comment = (TextView) this.findViewById(R.id.commentView);

        this.editNameButton = (Button) this.findViewById(R.id.editNameButton);
        this.editAddressButton = (Button) this.findViewById(R.id.editAddressButton);
        this.editCommentButton = (Button) this.findViewById(R.id.editCommentButton);

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();

                            String nameString = data.getStringExtra("NAME_TEXT");
                            String addressString = data.getStringExtra("ADDRESS_TEXT");
                            String commentString = data.getStringExtra("COMMENT_TEXT");

                            if (nameString != null && !nameString.isEmpty()) {
                                name.setText(nameString);
                            }

                            if (addressString != null && !addressString.isEmpty()) {
                                address.setText(addressString);
                            }

                            if (commentString != null && !commentString.isEmpty()) {
                                comment.setText(commentString);
                            }
                        }
                    }
                });

        this.editNameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserNameActivity.class);
                intent.putExtra("NAME_TEXT", name.getText());
                someActivityResultLauncher.launch(intent);
            }
        });

        this.editAddressButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddressActivity.class);
                intent.putExtra("ADDRESS_TEXT", address.getText());
                someActivityResultLauncher.launch(intent);
            }
        });

        this.editCommentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CommentActivity.class);
                intent.putExtra("COMMENT_TEXT", comment.getText());
                someActivityResultLauncher.launch(intent);
            }
        });
    }
}