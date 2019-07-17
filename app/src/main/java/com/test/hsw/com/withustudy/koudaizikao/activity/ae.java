package com.withustudy.koudaizikao.activity;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.PopupWindow;

class ae
  implements View.OnKeyListener
{
  ae(KnowledgeExplainActivity paramKnowledgeExplainActivity)
  {
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      KnowledgeExplainActivity.m(this.a).dismiss();
      KnowledgeExplainActivity.a(this.a, null);
      this.a.a(1.0F);
      return true;
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ae
 * JD-Core Version:    0.6.0
 */