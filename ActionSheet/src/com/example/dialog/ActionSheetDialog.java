package com.example.dialog;

import com.example.actionsheet.R;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

/**
 * �Զ���Dialog����ActionSheet
 * 
 * @author ���Ӹ�
 *
 */

public class ActionSheetDialog extends DialogFragment {

	/**
	 * Ĭ�϶���ʱ��
	 */
	public static final int DEFAULT_DURING = 300;

	/**
	 * ��ActionSheet����
	 */
	TranslateAnimation mOpenAnimation;

	/**
	 * �ر�ActionSheet����
	 */
	TranslateAnimation mCloseAnimation;

	/**
	 * �ر�ActionSheet��ť
	 */
	private Button mCancelBtn;

	private View mActionSheetView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d("TAG", "onCreate");
		initAnimation();

	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//

		return super.onCreateDialog(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.d("TAG", "getView");

		//setCancelable(false);

		// ����ʾ����
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		getDialog().getWindow().setGravity(Gravity.BOTTOM);
		// ����dialog͸��
		Drawable drawable = new ColorDrawable();
		drawable.setAlpha(0);
		getDialog().getWindow().setBackgroundDrawable(drawable);
		// ������ͼ����
		View actionSheet = inflater.inflate(R.layout.actionsheet_layout,
				container);

		mCancelBtn = (Button) actionSheet.findViewById(R.id.cancel_btn);
		mCancelBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();
			}
		});

		mActionSheetView = actionSheet;
		actionSheet.startAnimation(mOpenAnimation);
		return actionSheet;
	}

	/**
	 * ��ʼ����ض���
	 */
	public void initAnimation() {
		int type = TranslateAnimation.RELATIVE_TO_SELF;
		if (mOpenAnimation == null) {
			mOpenAnimation = new TranslateAnimation(type, 0, type, 0, type, 1,
					type, 0);
			mOpenAnimation.setDuration(DEFAULT_DURING);
			mOpenAnimation.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
				}

				@Override
				public void onAnimationRepeat(Animation animation) {

				}

				@Override
				public void onAnimationEnd(Animation animation) {

				}
			});
		}
		if (mCloseAnimation == null) {
			mCloseAnimation = new TranslateAnimation(type, 0, type, 0, type, 0,
					type, 1);
			mCloseAnimation.setDuration(DEFAULT_DURING);
			mCloseAnimation.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {

				}

				@Override
				public void onAnimationRepeat(Animation animation) {

				}

				@Override
				public void onAnimationEnd(Animation animation) {

					// ����������رղ˵�
					closeActionSheet();
				}
			});
		}

	}

	/**
	 * ���ö���ʱ��
	 * 
	 * @param durationMillis
	 */
	public void setDuration(long durationMillis) {
		if (mOpenAnimation != null) {
			mOpenAnimation.setDuration(durationMillis);
		}
	}

	@Override
	public void dismiss() {
		if (mActionSheetView != null) {
			mActionSheetView.startAnimation(mCloseAnimation);
		}
	}

	public void closeActionSheet() {
		super.dismiss();
	}

	class ButtonClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {

		}

	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		mActionSheetView.startAnimation(mCloseAnimation);
		super.onDismiss(dialog);
	}
	
	

	@Override
	public void onCancel(DialogInterface dialog) {

		Log.d("TAG", "onCancel");
		super.onCancel(dialog);
	}
	
	@Override
	public void onDestroyView() {
		
		Log.d("TAG", "onDestroyView");
		super.onDestroyView();
	}

}
