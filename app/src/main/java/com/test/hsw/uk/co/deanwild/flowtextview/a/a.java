package uk.co.deanwild.flowtextview.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.Iterator;
import java.util.List;
import uk.co.deanwild.flowtextview.c.b;

public class a
  implements View.OnTouchListener
{
  private final d a;
  private uk.co.deanwild.flowtextview.b.a b;
  private double c = 0.0D;
  private float d;
  private float e;
  private float f;
  private float g = 0.0F;

  public a(d paramd)
  {
    this.a = paramd;
  }

  private static double a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt(Math.pow(paramFloat1 - paramFloat3, 2.0D) + Math.pow(paramFloat2 - paramFloat4, 2.0D));
  }

  private void a(String paramString)
  {
    if (this.b != null)
      this.b.a(paramString);
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    Iterator localIterator = this.a.b().iterator();
    b localb;
    float f1;
    float f2;
    float f3;
    float f4;
    do
    {
      if (!localIterator.hasNext())
        return false;
      localb = (b)localIterator.next();
      f1 = localb.h;
      f2 = localb.c;
      f3 = localb.h + localb.a;
      f4 = localb.c + localb.b;
    }
    while ((paramFloat1 <= f1) || (paramFloat1 >= f3) || (paramFloat2 <= f2) || (paramFloat2 >= f4));
    a(localb.d);
    return true;
  }

  public uk.co.deanwild.flowtextview.b.a a()
  {
    return this.b;
  }

  public void a(uk.co.deanwild.flowtextview.b.a parama)
  {
    this.b = parama;
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 1;
    int j = paramMotionEvent.getAction();
    if (j == 0)
    {
      this.c = 0.0D;
      this.d = paramMotionEvent.getX();
      this.e = paramMotionEvent.getY();
    }
    if (j == 2)
    {
      this.f = paramMotionEvent.getX();
      this.g = paramMotionEvent.getY();
      this.c = a(this.d, this.e, this.f, this.g);
    }
    if (this.c < 10.0D)
    {
      if (j == i)
        i = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      return i;
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.deanwild.flowtextview.a.a
 * JD-Core Version:    0.6.0
 */