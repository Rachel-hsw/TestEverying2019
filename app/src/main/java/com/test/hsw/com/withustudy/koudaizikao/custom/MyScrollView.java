package com.withustudy.koudaizikao.custom;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView
{
  private a a;
  private int b;
  private Handler c = new m(this);

  public MyScrollView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MyScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MyScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null)
    {
      a locala = this.a;
      int i = getScrollY();
      this.b = i;
      locala.a(i);
    }
    switch (paramMotionEvent.getAction())
    {
    default:
    case 1:
    }
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.c.sendMessageDelayed(this.c.obtainMessage(), 5L);
    }
  }

  public void setOnScrollListener(a parama)
  {
    this.a = parama;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.MyScrollView
 * JD-Core Version:    0.6.0
 */