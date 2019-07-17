package com.withustudy.koudaizikao.custom;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class AotuViewPager extends ViewPager
{
  protected static final int a = 1;
  protected static final int b = 2;
  private long c;
  private int d = 0;
  private a e;
  private Context f;

  public AotuViewPager(Context paramContext)
  {
    super(paramContext);
    this.f = paramContext;
    c();
  }

  public AotuViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = paramContext;
    c();
  }

  private void c()
  {
    this.e = new a();
    this.c = 3000L;
    this.d = 0;
  }

  public void a()
  {
    this.e.sendEmptyMessageDelayed(1, this.c);
  }

  public void b()
  {
    this.e.sendEmptyMessage(2);
  }

  public void setApartTime(long paramLong)
  {
    this.c = paramLong;
  }

  class a extends Handler
  {
    a()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (AotuViewPager.a(AotuViewPager.this) == null)
        return;
      if (hasMessages(1))
        removeMessages(1);
      switch (paramMessage.what)
      {
      case 2:
      default:
        return;
      case 1:
      }
      AotuViewPager.a(AotuViewPager.this, AotuViewPager.this.getCurrentItem());
      AotuViewPager localAotuViewPager = AotuViewPager.this;
      AotuViewPager.a(localAotuViewPager, 1 + AotuViewPager.b(localAotuViewPager));
      AotuViewPager.this.setCurrentItem(AotuViewPager.b(AotuViewPager.this));
      sendEmptyMessageDelayed(1, AotuViewPager.c(AotuViewPager.this));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.AotuViewPager
 * JD-Core Version:    0.6.0
 */