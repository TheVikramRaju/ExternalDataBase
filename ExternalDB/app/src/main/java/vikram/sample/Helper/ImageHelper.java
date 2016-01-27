/**
 *
 */
package vikram.sample.Helper;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

/**
 * @author Jona
 */
public class ImageHelper {

//	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
//		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
//				bitmap.getHeight(), Config.ARGB_8888);
//		Canvas canvas = new Canvas(output);
//
//		final int color = 0xff424242;
//		final Paint paint = new Paint();
//		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
//		final RectF rectF = new RectF(rect);
//		final float roundPx = pixels;
//
//		paint.setAntiAlias(true);
//		canvas.drawARGB(0, 0, 0, 0);
//		paint.setColor(color);
//		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
//
//		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
//		canvas.drawBitmap(bitmap, rect, rect, paint);
//
//		return output;
//	}

//	public static Bitmap getCroppedBitmap(Bitmap bmp, int radius) {
//		Bitmap sbmp;
//        if(bmp.getWidth() != radius || bmp.getHeight() != radius)
//            sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
//        else
//            sbmp = bmp;
//
//        Bitmap output = Bitmap.createBitmap(sbmp.getWidth(), sbmp.getHeight(), Config.ARGB_8888);
//        final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());
//
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setFilterBitmap(true);
//        paint.setDither(true);
//        paint.setColor(Color.parseColor("#BAB399"));
//
//        Canvas c = new Canvas(output);
//        c.drawARGB(0, 0, 0, 0);
//        c.drawCircle(sbmp.getWidth() / 2+0.7f, sbmp.getHeight() / 2+0.7f, sbmp.getWidth() / 2+0.1f, paint);
//        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
//        c.drawBitmap(sbmp, rect, rect, paint);
//
//		return output;
//	}

    public static Bitmap getRoundedCornerBitmap(Bitmap bmp, int radius) {
        Bitmap sbmp;
//  Log.v("rnd", "GETTING CROP:" + mStrokeColor);
        if (bmp.getWidth() != radius || bmp.getHeight() != radius) {
            float smallest = Math.min(bmp.getWidth(), bmp.getHeight());
            float factor = smallest / radius;
            sbmp = Bitmap.createScaledBitmap(bmp, (int) (bmp.getWidth() / factor), (int) (bmp.getHeight() / factor), false);
        } else {
            sbmp = bmp;
        }

        Bitmap output = Bitmap.createBitmap(radius, radius,
                Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xffa19774;
        final Paint paint = new Paint();
        final Paint stroke = new Paint();

        final Rect rect = new Rect(0, 0, radius, radius);

        paint.setAntiAlias(true);
        stroke.setAntiAlias(true);

        paint.setFilterBitmap(true);
        stroke.setFilterBitmap(true);

        paint.setDither(true);
        stroke.setDither(true);

        canvas.drawARGB(0, 0, 0, 0);
//  paint.setColor(Color.parseColor("#BAB399"));
        stroke.setColor(Color.parseColor("#2a809c"));
        stroke.setStyle(Paint.Style.STROKE);
        stroke.setStrokeWidth(12f);
        canvas.drawCircle(radius / 2 + 0.7f,
                radius / 2 + 0.7f, radius / 2 + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);

        canvas.drawCircle(radius / 2 + 0.7f,
                radius / 2 + 0.7f, radius / 2 - stroke.getStrokeWidth() / 2 + 0.1f, stroke);

        return output;
    }


    public static Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
// create a matrix for the manipulation
        Matrix matrix = new Matrix();
// resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
// recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }
}
