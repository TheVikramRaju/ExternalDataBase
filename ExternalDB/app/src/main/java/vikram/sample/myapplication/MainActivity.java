package vikram.sample.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import vikram.sample.Adapter.CustomAdapter;
import vikram.sample.Classes.User;
import vikram.sample.DatabaseUtils.UserHelper;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ListView lv_user;
    Context mContext;
    private ImageView addContact;
    private TextView message;
    private UserHelper appUserHelper;
    CustomAdapter adapter = null;
    private ArrayList<User> usersList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_user = (ListView) findViewById(R.id.listview);
        message = (TextView) findViewById(R.id.message);
        mContext = this;
        addContact = (ImageView) findViewById(R.id.addContact);
        appUserHelper = new UserHelper(mContext);

        LoadUserData();
        if (usersList != null && usersList.size() > 0) {
            adapter = new CustomAdapter(this, R.layout.contact_items, usersList);
            lv_user.setVisibility(View.VISIBLE);
            message.setVisibility(View.GONE);
            lv_user.setAdapter(adapter);
            lv_user.setClickable(true);
            lv_user.setOnItemClickListener(this);
        } else {
            lv_user.setVisibility(View.GONE);
            message.setVisibility(View.VISIBLE);
        }

        addContact.setOnClickListener(this);
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


    private void LoadUserData() {
        usersList = appUserHelper.getAllUsersDetail();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, AddContactsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
