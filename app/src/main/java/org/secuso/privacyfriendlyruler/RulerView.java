package org.secuso.privacyfriendlyruler;

import android.content.Context;
import android.graphics.Canvas;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
    float lineWidth;
    int textSize;
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
        textSize = (int)(ydpmm *2.5);
        lineWidth = (float)(ydpmm*0.15);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(db);
        paint.setAlpha(255);
        paint.setTextSize(textSize);
        paint.setStrokeWidth(lineWidth);

        drawLeftSide(canvas, paint);
        drawRightSide(canvas, paint);
    }

    private void drawLeftSide(Canvas canvas, Paint paint){
        Path path = new Path();
        double stepLeft = ydpmm;

        for (int i = 0; i < heightmm; i++){
            if (i%10 == 0) {
                //draw 8mm line every cm
                canvas.drawLine(0, (float)stepLeft*i, (float)stepLeft*8, (float)stepLeft*i, paint);
                //draw a number every cm
                canvas.drawText(""+i/10, (float)stepLeft*8+(textSize/5), (float)(stepLeft*i+textSize), paint);
            } else if (i%5 == 0) {
                //draw 5mm line every 5mm
                canvas.drawLine(0, (float)stepLeft*i, (float)stepLeft*5, (float)stepLeft*i, paint);
            } else {
                //draw 3mm line every mm
                canvas.drawLine(0, (float)stepLeft*i, (float)stepLeft*3, (float)stepLeft*i, paint);
            }
        }
    }

    private void drawRightSide(Canvas canvas, Paint paint){
        Path path = new Path();
        double stepRight = ydpmm;

        for (int i = 0; i < heightmm; i++){
            if (i%10 == 0) {
                //draw 8mm line every cm
                canvas.drawLine((float)(widthPx-stepRight*(8+5)), (float)(heightPx-stepRight*(i+18)), (float)(widthPx-stepRight*5), (float)(heightPx-stepRight*(i+18)), paint);
                //draw a number every cm
                path.reset();
                path.moveTo((float)(widthPx-stepRight*(8+5)-textSize/5), (float)(heightPx-stepRight*(i+16)-textSize));
                path.lineTo((float)(widthPx-stepRight*(8+5)-textSize/5), (float)(heightPx-stepRight*(i+16)-2*textSize));
                canvas.drawTextOnPath(""+i/10, path, 0, 0, paint);
            } else if (i%5 == 0) {
                //draw 5mm line every 5mm
                canvas.drawLine((float)(widthPx-stepRight*(5+5)), (float)(heightPx-stepRight*(i+18)), (float)(widthPx-stepRight*5), (float)(heightPx-stepRight*(i+18)), paint);
            } else {
                //draw 3mm line every mm
                canvas.drawLine((float)(widthPx-stepRight*(3+5)), (float)(heightPx-stepRight*(i+18)), (float)(widthPx-stepRight*5), (float)(heightPx-stepRight*(i+18)), paint);
            }
        }
    }
}
