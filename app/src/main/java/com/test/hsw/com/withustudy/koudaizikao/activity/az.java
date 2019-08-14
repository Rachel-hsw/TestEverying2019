package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

class az
  implements View.OnClickListener
{
  az(QuestionDetailActivity.b paramb, int paramInt)
  {
  }

  public void onClick(View paramView)
  {
    try
    {
      QuestionDetailActivity.x(QuestionDetailActivity.b.a(this.a));
      QuestionDetailActivity.b(QuestionDetailActivity.b.a(this.a)).sendEmptyMessageDelayed(21, 400L);
      QuestionDetailActivity.i(QuestionDetailActivity.b.a(this.a)).setCurrentItem(this.b);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.az
 * JD-Core Version:    0.6.0
 */