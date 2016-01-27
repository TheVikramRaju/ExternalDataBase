/**
 *
 */
package vikram.sample.Adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import vikram.sample.Classes.Contacts;
import vikram.sample.Classes.User;
import vikram.sample.Helper.ImageHelper;
import vikram.sample.myapplication.R;

/**
 * @author bosco
 */
public class CustomAdapter extends ArrayAdapter<User> {

    Context context;
    int layoutResourceId;
    User data[] = null;
    ArrayList<User> usersList = new ArrayList<User>();

    public CustomAdapter(Context context, int layoutResourceId, User[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public CustomAdapter(Context context, int resource, ArrayList<User> objects) {
        super(context, resource, objects);
        this.usersList = objects;
        this.layoutResourceId = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ViewHolder();
            holder.imgUser = (ImageView) row.findViewById(R.id.contactImage);
            holder.txtName = (TextView) row.findViewById(R.id.contactName);
            holder.txtNo = (TextView) row.findViewById(R.id.contactNo);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

//        User user = data[position];
        User user = usersList.get(position);
        holder.txtName.setText(user.getFirstName());
        holder.txtNo.setText(user.getPhoneNumber());
//		holder.imgUser.set
        Bitmap bitmap = BitmapFactory.decodeByteArray(user.getUserImage(), 0, user.getUserImage().length);
//		Bitmap resized = ImageHelper.getResizedBitmap(bitmap, 150, 150);
//		holder.imgIcon.setImageBitmap(ImageHelper.getRoundedCornerBitmap(resized, resized.getWidth()));
        holder.imgUser.setImageBitmap(bitmap);
        return row;
    }

    static class ViewHolder {
        ImageView imgUser;
        TextView txtName;
        TextView txtNo;
    }
}
/*extends ArrayAdapter<Contacts> {

	private Activity mActivity;
	private List<Contacts> lstChats;
	public Resources res;
	public Drawable d;

	public class ViewHolder {
		private TextView tName;
		private TextView tMsg;
		private TextView tDate;
		private ImageView img;
	}


	public CustomAdapter(Context context, int resource, ArrayList<User> objects) {
		super(context, resource, objects);
		this.usersList = objects;
		this.layoutResourceId = resource;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		convertView = null;
		Bitmap bm = null;
		Contacts chat = lstChats.get(position);
		if (convertView == null) {
			LayoutInflater inflator = mActivity.getLayoutInflater();
			convertView = inflator.inflate(R.layout.contact_items, null);
			viewHolder = new ViewHolder();
			viewHolder.tName = (TextView) convertView
					.findViewById(R.id.contactName);
			viewHolder.tMsg = (TextView) convertView
					.findViewById(R.id.contactNo);
			viewHolder.img = (ImageView) convertView
					.findViewById(R.id.contactImage);

			viewHolder.tName.setText(chat.getcName());
			viewHolder.tMsg.setText(chat.getcNo());
			
			 int sdk = android.os.Build.VERSION.SDK_INT;
			 if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
			 viewHolder.img.setImageBitmap(chat.getcImage());
			 } else {
			viewHolder.img.setImageBitmap(chat.getcImage());
			 }
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}
}*/
