package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.g.h;

class ay
  implements View.OnClickListener
{
  ay(QuestionDetailActivity.a parama, int paramInt)
  {
  }

  public void onClick(View paramView)
  {
    try
    {
      switch (QuestionDetailActivity.a.a(this.a).r)
      {
      default:
        QuestionDetailActivity.x(QuestionDetailActivity.a.a(this.a));
        int j = this.b + this.a.a;
        h.a("curr----" + j);
        QuestionDetailActivity.i(QuestionDetailActivity.a.a(this.a)).setCurrentItem(this.b + this.a.a);
        QuestionDetailActivity.b(QuestionDetailActivity.a.a(this.a)).sendEmptyMessageDelayed(21, 10L);
        return;
      case 100:
      case 101:
      }
      int i = this.b + this.a.a;
      QuestionDetailActivity.c(QuestionDetailActivity.a.a(this.a), i);
      QuestionDetailActivity.x(QuestionDetailActivity.a.a(this.a));
      QuestionDetailActivity.i(QuestionDetailActivity.a.a(this.a)).setCurrentItem(this.b + this.a.a);
      QuestionDetailActivity.b(QuestionDetailActivity.a.a(this.a)).sendEmptyMessageDelayed(21, 10L);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ay
 * JD-Core Version:    0.6.0
 */