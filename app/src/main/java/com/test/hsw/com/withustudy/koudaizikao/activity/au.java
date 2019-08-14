package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.widget.Toast;

class au
  implements Runnable
{
  au(QuestionDetailActivity paramQuestionDetailActivity)
  {
  }

  public void run()
  {
    if (QuestionDetailActivity.s(this.a))
    {
      QuestionDetailActivity localQuestionDetailActivity = this.a;
      QuestionDetailActivity.b(localQuestionDetailActivity, -1 + QuestionDetailActivity.t(localQuestionDetailActivity));
      if (QuestionDetailActivity.t(this.a) != -1)
        break label53;
      Toast.makeText(this.a.getApplicationContext(), "时间到", 0).show();
    }
    label53: 
    do
      return;
    while (QuestionDetailActivity.t(this.a) < 0);
    QuestionDetailActivity.u(this.a);
    this.a.c();
    this.a.v.postDelayed(this, 1000L);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.au
 * JD-Core Version:    0.6.0
 */