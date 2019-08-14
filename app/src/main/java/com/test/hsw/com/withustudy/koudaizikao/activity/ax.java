package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.PopupWindow;

class ax
  implements View.OnKeyListener
{
  ax(QuestionDetailActivity paramQuestionDetailActivity)
  {
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      QuestionDetailActivity.F(this.a).dismiss();
      QuestionDetailActivity.b(this.a, null);
      QuestionDetailActivity.b(this.a).sendEmptyMessageDelayed(2, 100L);
      return true;
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ax
 * JD-Core Version:    0.6.0
 */