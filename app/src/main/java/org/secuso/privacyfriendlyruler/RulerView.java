package org.secuso.privacyfriendlyruler;

import android.content.Context;
import android.graphics.Canvas;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.View;

import static org.secuso.privacyfriendlyruler.R.color.darkblue;

/**
 * Created by roberts on 02.06.16.
 */
public class RulerView extends View {

    double ydpi;
    double ydpmm;
    double heightPx;
    double heightmm;
    double widthPx;
    int textSize = 50;
    int db;

    public RulerView(Context context, Activity activity) {
        super(context);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

//        heightPx = this.getMeasuredHeight();
//        widthPx = this.getMeasuredWidth();
        ydpi = displayMetrics.ydpi;
        ydpmm = ydpi / 25.4;
        heightPx = displayMetrics.heightPixels;
        heightmm = heightPx/ydpmm;
        widthPx = displayMetrics.widthPixels;
        db = ContextCompat.getColor(context, R.color.darkblue);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(db);
        paint.setAlpha(255);
        paint.setTextSize(textSize);
        for (int i = 0; i < heightmm; i++){
            if (i%10 == 0) {
                //draw 8mm line every cm
                //left side
                canvas.drawLine(0, (float)ydpmm*i, (float)ydpmm*8, (float)ydpmm*i, paint);
                canvas.drawText(""+i/10, (float)ydpmm*8+(textSize/5), (float)(ydpmm*i+textSize), paint);
                //right side
                canvas.drawLine((float)(widthPx-ydpmm*8), (float)(heightPx-ydpmm*i), (float)widthPx, (float)(heightPx-ydpmm*i), paint);
                canvas.drawText(""+i/10, (float)(widthPx-ydpmm*8-textSize/5), (float)(heightPx-ydpmm*i+textSize), paint);
            } else if (i%5 == 0) {
                //draw 5mm line every 5mm
                //left side
                canvas.drawLine(0, (float)ydpmm*i, (float)ydpmm*5, (float)ydpmm*i, paint);
                //right side
                canvas.drawLine((float)(widthPx-ydpmm*5), (float)(heightPx-ydpmm*i), (float)widthPx, (float)(heightPx-ydpmm*i), paint);
            } else {
                //draw 3mm line every mm
                //left side
                canvas.drawLine(0, (float)ydpmm*i, (float)ydpmm*3, (float)ydpmm*i, paint);
                //right side
                canvas.drawLine((float)(widthPx-ydpmm*3), (float)(heightPx-ydpmm*i), (float)widthPx, (float)(heightPx-ydpmm*i), paint);
            }
        }
    }
}
