package com.android.Platinum;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DashedLine extends View { 
    
    public DashedLine(Context context, AttributeSet attrs) {  
        super(context, attrs);                      
    }  
  
    @Override  
    protected void onDraw(Canvas canvas) {  
        super.onDraw(canvas);          
        Paint paint = new Paint();  
        paint.setStyle(Paint.Style.STROKE);  
        paint.setColor(Color.DKGRAY);  
//        Path path = new Path();       
//        path.moveTo(0, 10);  
//        path.lineTo(480,10);        
//        PathEffect effects = new DashPathEffect(new float[]{5,5,5,5},1);  
//        paint.setPathEffect(effects);  
//        canvas.drawPath(path, paint);
        canvas.drawLine(0, 10, 480, 10, paint);
    } 
}
