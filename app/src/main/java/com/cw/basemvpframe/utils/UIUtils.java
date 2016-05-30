package com.cw.basemvpframe.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class UIUtils {

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 绘制一个圆角矩形
	 */
	public static Drawable drawDrawable(int rgb, int radius) {
		GradientDrawable gradientDrawable=new GradientDrawable();
		//绘制矩形
		gradientDrawable.setGradientType(GradientDrawable.RECTANGLE);
		//设置颜色
		gradientDrawable.setColor(rgb);
		//设置内切圆的半径
		gradientDrawable.setCornerRadius(radius);
		return gradientDrawable;
	}

	/**
	 * 绘制一个选择器
	 */
	public static Drawable getStateListDrawable(Drawable drawDrawable,
												Drawable pressDrawable) {
		StateListDrawable stateListDrawable=new StateListDrawable();
		stateListDrawable.addState(new int[]{android.R.attr.state_pressed,android.R.attr.state_enabled}, pressDrawable);
		stateListDrawable.addState(new int[]{}, drawDrawable);
		return stateListDrawable;
	}
}









