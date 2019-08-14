package com.withustudy.koudaizikao.custom;

import android.os.Handler;
import android.os.Message;

class m extends Handler
{
  m(MyScrollView paramMyScrollView)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    int i = this.a.getScrollY();
    if (MyScrollView.a(this.a) != i)
    {
      MyScrollView.a(this.a, i);
      MyScrollView.b(this.a).sendMessageDelayed(MyScrollView.b(this.a).obtainMessage(), 5L);
    }
    if (MyScrollView.c(this.a) != null)
      MyScrollView.c(this.a).a(i);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.m
 * JD-Core Version:    0.6.0
 */