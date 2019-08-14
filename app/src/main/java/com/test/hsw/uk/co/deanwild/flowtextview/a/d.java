package uk.co.deanwild.flowtextview.a;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import uk.co.deanwild.flowtextview.FlowTextView;
import uk.co.deanwild.flowtextview.c.b;

public class d
{
  private final c a;
  private final FlowTextView b;
  private final List<b> c = new ArrayList();
  private int d = 0;
  private Spannable e;
  private final HashMap<Integer, uk.co.deanwild.flowtextview.c.c> f = new HashMap();

  public d(FlowTextView paramFlowTextView, c paramc)
  {
    this.b = paramFlowTextView;
    this.a = paramc;
  }

  private String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 > -1 + this.d)
      paramInt2 = -1 + this.d;
    return this.e.subSequence(paramInt1, paramInt2).toString();
  }

  private b a(URLSpan paramURLSpan, String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    b localb = new b(paramString, paramInt1, paramInt2, paramFloat, this.b.getLinkPaint(), paramURLSpan.getURL());
    this.c.add(localb);
    return localb;
  }

  private uk.co.deanwild.flowtextview.c.c a(StyleSpan paramStyleSpan, String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    TextPaint localTextPaint = this.a.a();
    localTextPaint.setTypeface(Typeface.defaultFromStyle(paramStyleSpan.getStyle()));
    localTextPaint.setTextSize(this.b.getTextsize());
    localTextPaint.setColor(this.b.getColor());
    paramStyleSpan.updateDrawState(localTextPaint);
    paramStyleSpan.updateMeasureState(localTextPaint);
    uk.co.deanwild.flowtextview.c.c localc = new uk.co.deanwild.flowtextview.c.c(paramString, paramInt1, paramInt2, paramFloat, localTextPaint);
    localc.j = true;
    return localc;
  }

  private uk.co.deanwild.flowtextview.c.c a(Object paramObject, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramObject instanceof URLSpan))
      return a((URLSpan)paramObject, paramString, paramInt1, paramInt2, 0.0F);
    if ((paramObject instanceof StyleSpan))
      return a((StyleSpan)paramObject, paramString, paramInt1, paramInt2, 0.0F);
    return a(paramString, paramInt1, paramInt2, 0.0F);
  }

  private uk.co.deanwild.flowtextview.c.c a(String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    return new uk.co.deanwild.flowtextview.c.c(paramString, paramInt1, paramInt2, paramFloat, this.b.getTextPaint());
  }

  private static boolean a(boolean[] paramArrayOfBoolean)
  {
    for (int i = 0; ; i++)
    {
      int k;
      if (i >= paramArrayOfBoolean.length)
        k = 1;
      int j;
      do
      {
        return k;
        j = paramArrayOfBoolean[i];
        k = 0;
      }
      while (j == 0);
    }
  }

  public float a(List<uk.co.deanwild.flowtextview.c.c> paramList, Object[] paramArrayOfObject, int paramInt1, int paramInt2, float paramFloat)
  {
    this.f.clear();
    int i = paramInt2 - paramInt1;
    boolean[] arrayOfBoolean = new boolean[i];
    int j = paramArrayOfObject.length;
    int k = 0;
    int i2;
    Object[] arrayOfObject;
    float f1;
    if (k >= j)
    {
      i2 = 0;
      if (!a(arrayOfBoolean))
        break label213;
      arrayOfObject = this.f.keySet().toArray();
      Arrays.sort(arrayOfObject);
      f1 = paramFloat;
    }
    for (int i6 = 0; ; i6++)
    {
      if (i6 >= arrayOfObject.length)
      {
        return f1 - paramFloat;
        Object localObject = paramArrayOfObject[k];
        int m = this.e.getSpanStart(localObject);
        int n = this.e.getSpanEnd(localObject);
        if (m < paramInt1)
          m = paramInt1;
        if (n > paramInt2)
          n = paramInt2;
        for (int i1 = m; ; i1++)
        {
          if (i1 >= n)
          {
            String str1 = a(m, n);
            this.f.put(Integer.valueOf(m), a(localObject, str1, m, n));
            k++;
            break;
          }
          arrayOfBoolean[(i1 - paramInt1)] = true;
        }
        label268: label319: 
        while (true)
        {
          if (arrayOfBoolean[i2] != 0)
            i2++;
          while (true)
          {
            label213: if (i2 < i)
              break label319;
            break;
            for (int i3 = i2; ; i3++)
            {
              if (i3 > i)
              {
                i2 = i3;
                break;
              }
              if ((i3 >= i) || (arrayOfBoolean[i3] != 0))
                break label268;
              arrayOfBoolean[i3] = true;
            }
            int i4 = i2 + paramInt1;
            int i5 = paramInt1 + i3;
            String str2 = a(i4, i5);
            this.f.put(Integer.valueOf(i4), a(null, str2, i4, i5));
            i2 = i3;
          }
        }
      }
      uk.co.deanwild.flowtextview.c.c localc = (uk.co.deanwild.flowtextview.c.c)this.f.get(arrayOfObject[i6]);
      localc.h = f1;
      f1 += localc.i.measureText(localc.e);
      paramList.add(localc);
    }
  }

  public void a()
  {
    this.c.clear();
  }

  public void a(Spannable paramSpannable)
  {
    this.e = paramSpannable;
    this.d = paramSpannable.length();
  }

  public void a(b paramb, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramb.c = (paramFloat1 - 20.0F);
    paramb.a = paramFloat2;
    paramb.b = (paramFloat3 + 20.0F);
    this.c.add(paramb);
  }

  public List<b> b()
  {
    return this.c;
  }

  public Spannable c()
  {
    return this.e;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.deanwild.flowtextview.a.d
 * JD-Core Version:    0.6.0
 */