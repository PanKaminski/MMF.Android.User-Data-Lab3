package bsu.mmf.kaminski.user_data;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CommentActivity extends UserActivityBase {

    private Button save;
    private Button discard;
    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        initActivityItems();

        this.save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("COMMENT_TEXT", CommentActivity.this.comment.getText().toString());
                CommentActivity.this.setResult(Activity.RESULT_OK, returnIntent);
                CommentActivity.this.finish();
            }
        });

        this.discard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                CommentActivity.this.setResult(Activity.RESULT_CANCELED, returnIntent);
                CommentActivity.this.finish();
            }
        });
    }

    private void initActivityItems(){
        this.comment = (EditText) this.findViewById(R.id.comment);
        this.save = (Button) this.findViewById(R.id.buttonSave);
        this.discard = (Button) this.findViewById(R.id.buttonDiscard);

        Bundle extras = this.getIntent().getExtras();

        String currentComment = extras.getString("COMMENT_TEXT");

        if (currentComment != null && !currentComment.isEmpty()
                && !currentComment.equals(getString(R.string.user_comments))){
            this.comment.setText(currentComment);
        }
    }
}