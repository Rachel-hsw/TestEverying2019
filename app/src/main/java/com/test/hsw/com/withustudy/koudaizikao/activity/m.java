package com.withustudy.koudaizikao.activity;

import android.os.Handler;

class m
  implements Runnable
{
  m(ChapterSectionListActivity paramChapterSectionListActivity, int paramInt)
  {
  }

  public void run()
  {
    this.a.findViewById(2131296437);
    if (ChapterSectionListActivity.j(this.a))
    {
      ChapterSectionListActivity.b(this.a, this.b);
      ChapterSectionListActivity.k(this.a).removeCallbacks(this);
      return;
    }
    ChapterSectionListActivity.k(this.a).postDelayed(this, 30L);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.m
 * JD-Core Version:    0.6.0
 */