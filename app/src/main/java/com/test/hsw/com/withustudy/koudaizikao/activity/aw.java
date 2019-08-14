package com.withustudy.koudaizikao.activity;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.PopupWindow;

class aw
  implements View.OnKeyListener
{
  aw(QuestionDetailActivity paramQuestionDetailActivity)
  {
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      QuestionDetailActivity.E(this.a).dismiss();
      QuestionDetailActivity.a(this.a, null);
      this.a.a(1.0F);
      return true;
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.aw
 * JD-Core Version:    0.6.0
 */