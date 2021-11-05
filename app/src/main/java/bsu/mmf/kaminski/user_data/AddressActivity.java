package bsu.mmf.kaminski.user_data;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {

    private Button save;
    private Button discard;
    private EditText country;
    private EditText town;
    private EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        Bundle extras = this.getIntent().getExtras();

        initActivityItems();

        this.save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                String country = AddressActivity.this.country.getText().toString();
                String town = AddressActivity.this.town.getText().toString();
                String address = AddressActivity.this.address.getText().toString();
                returnIntent.putExtra("ADDRESS_TEXT", country + ", " + town + ", " + address);
                AddressActivity.this.setResult(Activity.RESULT_OK, returnIntent);
                AddressActivity.this.finish();
            }
        });

        this.discard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                AddressActivity.this.setResult(Activity.RESULT_CANCELED, returnIntent);
                AddressActivity.this.finish();
            }
        });
    }

    private void initActivityItems(){
        this.country = (EditText) this.findViewById(R.id.country);
        this.town = (EditText) this.findViewById(R.id.town);
        this.address = (EditText) this.findViewById(R.id.address);
        this.save = (Button) this.findViewById(R.id.buttonSave);
        this.discard = (Button) this.findViewById(R.id.buttonDiscard);

        Bundle extras = this.getIntent().getExtras();

        String currentAddress = extras.getString("ADDRESS_TEXT");

        if (currentAddress != null && !currentAddress.isEmpty() && !currentAddress.equals("Address")){
            String[] addressInfo = currentAddress.split(", ", 3);

            switch (addressInfo.length){
                case 1:
                    this.country.setText(addressInfo[0]);
                    break;
                case 2:
                    this.country.setText(addressInfo[0]);
                    this.town.setText(addressInfo[1]);
                    break;
                case 3:
                    this.country.setText(addressInfo[0]);
                    this.town.setText(addressInfo[1]);
                    this.address.setText(addressInfo[2]);
                    break;
            }
        }
    }
}