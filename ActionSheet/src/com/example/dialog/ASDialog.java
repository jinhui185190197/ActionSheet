package com.example.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.Window;

public class ASDialog extends Dialog{


	public ASDialog(Context context) {
		//设置为全屏
		super(context,android.R.style.Theme_Light_NoTitleBar);
		//设置布局方向
		getWindow().setGravity(Gravity.BOTTOM);
		//设置背景色
		Drawable drawable = new ColorDrawable();
		drawable.setAlpha(0);//透明
	}
	
	

}
