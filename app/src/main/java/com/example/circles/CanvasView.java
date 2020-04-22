package com.example.circles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class CanvasView extends View {
    private static int width;
    private static int height;
    private GameManager gameManager;


    public CanvasView(Context context, AttributeSet attrs) {
        super(context,attrs);
        initWidhtAndHeight(context);
        gameManager = new GameManager(this, width,height);

    }

    private void initWidhtAndHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE); // узнаем размер экрана
        Display display = windowManager.getDefaultDisplay();
        Point point =  new Point();
        display.getSize(point);
        width = point.x;
        height = point.y;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        gameManager.onDraw(canvas);

    }
}
