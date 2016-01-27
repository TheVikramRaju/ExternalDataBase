package vikram.sample.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import vikram.sample.Classes.User;
import vikram.sample.DatabaseUtils.UserHelper;

/**
 * Created by bosco on 8/31/2015.
 */
public class AddContactsActivity extends Activity implements View.OnClickListener {
//    ImageView userImage;
    EditText mfirstname, mlastname, mphone, mbday, mgender, memail, maddress;
    Button msave;
    private User user;
    Context mContext;
    UserHelper appUserHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact_activity);
        mContext = this;
        appUserHelper = new UserHelper(mContext);
        mfirstname = (EditText) findViewById(R.id.cname);
        mlastname = (EditText) findViewById(R.id.txtlastname);
        mphone = (EditText) findViewById(R.id.cphone);
        mbday = (EditText) findViewById(R.id.txtbday);
        mgender = (EditText) findViewById(R.id.txtgender);
        memail = (EditText) findViewById(R.id.txtemail);
        maddress = (EditText) findViewById(R.id.txtaddress);

        msave = (Button) findViewById(R.id.save);
        msave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                String firstname = mfirstname.getText().toString().trim();
                String lastname = mlastname.getText().toString().trim();
                String phone = mphone.getText().toString().trim();
                String bday = mbday.getText().toString().trim();
                String gender = mgender.getText().toString().trim();
                String email = memail.getText().toString().trim();
                String address = maddress.getText().toString().trim();

                Bitmap userImage = drawableToBitmap(getResources().getDrawable(R.drawable.ic_contact));
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                userImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                user = new User( "","", "", byteArray, firstname, lastname, gender,  phone, email, address, bday);
//                new LoadLogin(mActivity, user).execute();
                int result = (int) appUserHelper.addUserDetails(user);
                if(result != -1){
                    Toast.makeText(mContext,"Added Successfully...!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(mContext,"Error..!",Toast.LENGTH_SHORT).show();
                }

        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        final int width = !drawable.getBounds().isEmpty() ? drawable.getBounds().width() : drawable.getIntrinsicWidth();
        final int height = !drawable.getBounds().isEmpty() ? drawable.getBounds().height() : drawable.getIntrinsicHeight();
        final Bitmap bitmap = Bitmap.createBitmap(width <= 0 ? 1 : width, height <= 0 ? 1 : height, Bitmap.Config.ARGB_8888);
        Log.v("Bitmap width - Height :", width + " : " + height);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}
