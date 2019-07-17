package uk.co.senab.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

@TargetApi(5)
public class b extends a
{
  private static final int f = -1;
  private int g = -1;
  private int h = 0;

  public b(Context paramContext)
  {
    super(paramContext);
  }

  float a(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getX(this.h);
      return f1;
    }
    catch (Exception localException)
    {
    }
    return paramMotionEvent.getX();
  }

  float b(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = paramMotionEvent.getY(this.h);
      return f1;
    }
    catch (Exception localException)
    {
    }
    return paramMotionEvent.getY();
  }

  public boolean c(MotionEvent paramMotionEvent)
  {
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 2:
    case 4:
    case 5:
    default:
    case 0:
    case 1:
    case 3:
    case 6:
    }
    int i;
    do
    {
      while (true)
      {
        int k = this.g;
        int m = 0;
        if (k != -1)
          m = this.g;
        this.h = paramMotionEvent.findPointerIndex(m);
        return super.c(paramMotionEvent);
        this.g = paramMotionEvent.getPointerId(0);
        continue;
        this.g = -1;
      }
      i = uk.co.senab.photoview.a.a(paramMotionEvent.getAction());
    }
    while (paramMotionEvent.getPointerId(i) != this.g);
    if (i == 0);
    for (int j = 1; ; j = 0)
    {
      this.g = paramMotionEvent.getPointerId(j);
      this.b = paramMotionEvent.getX(j);
      this.c = paramMotionEvent.getY(j);
      break;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.senab.photoview.a.b
 * JD-Core Version:    0.6.0
 */