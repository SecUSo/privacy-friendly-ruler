package org.secuso.privacyfriendlyruler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by roberts on 02.06.16.
 */
public class RulerView extends View {

    public RulerView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(150);
        canvas.drawRect(50, 50, 100, 100, paint);
    }
}
