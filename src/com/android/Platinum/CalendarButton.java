package com.android.Platinum;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;

public class CalendarButton extends Button{
	private final String NAMESPACE = "com.android.Platinum";
	private final int MARGIN = 8;
	private int resourceId = 0;
	private Bitmap bitmap;

	public CalendarButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setClickable(true);
		// Ĭ��ʹ��R.drawable.calendar_date����ͼƬ
		resourceId = attrs.getAttributeResourceValue(NAMESPACE, "ic_calendar_date",
				R.drawable.ic_calendar_date);
		bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// ͼƬ�Ҳ������ʾ
		int x = (this.getMeasuredWidth() - bitmap.getWidth()) - MARGIN;
		int y = (this.getMeasuredHeight() - bitmap.getHeight() - MARGIN ) / 2;
		canvas.drawBitmap(bitmap, x, y, null);
		// ������Ҫת������ΪĬ�������Button�е����־�����ʾ
		// ������Ҫ�������������ʾ
		canvas.translate(-bitmap.getWidth(),
				0);

		super.onDraw(canvas);
	}

	public void setIcon(Bitmap bitmap) {
		this.bitmap = bitmap;
		invalidate();
	}

	public void setIcon(int resourceId) {
		this.bitmap = BitmapFactory.decodeResource(getResources(), resourceId);
		invalidate();
	}
}
