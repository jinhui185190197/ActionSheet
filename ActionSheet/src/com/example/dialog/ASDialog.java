package com.example.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.Window;

public class ASDialog extends Dialog{


	public ASDialog(Context context) {
		//����Ϊȫ��
		super(context,android.R.style.Theme_Light_NoTitleBar);
		//���ò��ַ���
		getWindow().setGravity(Gravity.BOTTOM);
		//���ñ���ɫ
		Drawable drawable = new ColorDrawable();
		drawable.setAlpha(0);//͸��
	}
	
	

}
