/**
 * 
 */
package vikram.sample.Classes;

import android.graphics.Bitmap;

/**
 * @author bosco
 * 
 */
public class Contacts {
	private Bitmap cImage;
	private String cName = "";
	private String cNo = "";

	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contacts(Bitmap cImage, String cName, String cNo) {
		this.cImage = cImage;
		this.cName = cName;
		this.cNo = cNo;
	}

	public Bitmap getcImage() {
		return cImage;
	}

	public void setcImage(Bitmap cImage) {
		this.cImage = cImage;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
}
