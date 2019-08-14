package com.withustudy.koudaizikao.activity;

import android.os.Handler;

class ad
  implements Runnable
{
  ad(KnowledgeExplainActivity paramKnowledgeExplainActivity)
  {
  }

  public void run()
  {
    if (KnowledgeExplainActivity.k(this.a))
    {
      KnowledgeExplainActivity.e(this.a);
      KnowledgeExplainActivity.l(this.a).removeCallbacks(this);
      return;
    }
    KnowledgeExplainActivity.l(this.a).postDelayed(this, 30L);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ad
 * JD-Core Version:    0.6.0
 */