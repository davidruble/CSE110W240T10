package sdgkteam10.rent_it;

import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class ProfileActivity extends AppCompatActivity {

    //UI elements
    private TextView userName;
    private TextView userEmail;
    private TextView userPhone;
    private TextView userAddress1;
    private TextView userAddress2;
    private TextView userCity;
    private TextView userState;
    private TextView userZip;
    //Edit profile button
    private Button editProfile;
    boolean edit;

    private User user;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public ProfileActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //initialize all the UI elements
        userName = (TextView) findViewById(R.id.profile_name);
        userEmail = (TextView) findViewById(R.id.profile_email);
        userPhone = (TextView) findViewById(R.id.profile_phone);
        userAddress1 = (TextView) findViewById(R.id.profile_address1);
        userAddress2 = (TextView) findViewById(R.id.profile_address2);
        userCity = (TextView) findViewById(R.id.profile_city);
        userState = (TextView) findViewById(R.id.profile_state);
        userZip = (TextView) findViewById(R.id.profile_zip);
        //editProfile button
        editProfile = (Button) findViewById(R.id.edit_button);

        //make the text view listeners, but make them uneditable (for now)
        final KeyListener userEmailKeyListener = userEmail.getKeyListener();
        final KeyListener userPhoneKeyListener = userPhone.getKeyListener();
        final KeyListener userAddress1KeyListener = userAddress1.getKeyListener();
        final KeyListener userAddress2KeyListener = userAddress2.getKeyListener();
        final KeyListener userCityKeyListener = userCity.getKeyListener();
        final KeyListener userStateKeyListener = userState.getKeyListener();
        final KeyListener userZipKeyListener = userZip.getKeyListener();
        userEmail.setKeyListener(null);
        userPhone.setKeyListener(null);
        userAddress1.setKeyListener(null);
        userAddress2.setKeyListener(null);
        userCity.setKeyListener(null);
        userState.setKeyListener(null);
        userZip.setKeyListener(null);

        //Set boolean value for when button has been clicked
        edit = false;
        //Add listener for button
        editProfile.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {
               if (!edit) {
                   edit = true;
                   editProfile.setText("Update");
                   //make the text views editable
                   userEmail.setKeyListener(userEmailKeyListener);
                   userPhone.setKeyListener(userPhoneKeyListener);
                   userAddress1.setKeyListener(userAddress1KeyListener);
                   userAddress2.setKeyListener(userAddress2KeyListener);
                   userCity.setKeyListener(userCityKeyListener);
                   userState.setKeyListener(userStateKeyListener);
                   userZip.setKeyListener(userZipKeyListener);
               }
               else {
                   edit = false;
                   editProfile.setText("Edit Profile");
                   //make the text views uneditable
                   userEmail.setKeyListener(null);
                   userPhone.setKeyListener(null);
                   userAddress1.setKeyListener(null);
                   userAddress2.setKeyListener(null);
                   userCity.setKeyListener(null);
                   userState.setKeyListener(null);
                   userZip.setKeyListener(null);
               }
           }
        });

        Database.setContext(this);
        Database db = Database.getInstance();

        user = new User();
        user.requestDatabaseData();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        //populate the fields when the user data is all loaded
        db.getRef().child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                populateProfileFields();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void populateProfileFields() {
        userName.setText(user.getName());
        userEmail.setText(user.getEmail());
        userPhone.setText(user.getPhone());
        userAddress1.setText(user.getAddress());
        userAddress2.setText(user.getAddress2());
        userCity.setText(user.getCity());
        userState.setText(user.getState());
        userZip.setText(user.getZip());
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Profile Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://sdgkteam10.rent_it/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Profile Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://sdgkteam10.rent_it/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}