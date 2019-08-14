package uk.co.deanwild.flowtextview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uk.co.deanwild.flowtextview.c.e;

public class FlowTextView extends RelativeLayout
{
  List<uk.co.deanwild.flowtextview.c.c> a = new ArrayList();
  uk.co.deanwild.flowtextview.c.c b = new uk.co.deanwild.flowtextview.c.c("", 0, 0, 0.0F, null);
  private final uk.co.deanwild.flowtextview.a.c c = new uk.co.deanwild.flowtextview.a.c();
  private final uk.co.deanwild.flowtextview.a.d d = new uk.co.deanwild.flowtextview.a.d(this, this.c);
  private final uk.co.deanwild.flowtextview.a.a e = new uk.co.deanwild.flowtextview.a.a(this.d);
  private int f = -16777216;
  private int g = 0;
  private TextPaint h;
  private TextPaint i;
  private float j = 20.0F * getResources().getDisplayMetrics().scaledDensity;
  private int k = -16777216;
  private Typeface l;
  private int m = 100;
  private boolean n = true;
  private final ArrayList<e> o = new ArrayList();
  private CharSequence p = "";
  private boolean q = false;
  private float r;
  private float s;

  public FlowTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public FlowTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public FlowTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private int a()
  {
    int i1 = getChildCount();
    int i2 = 0;
    int i3 = 0;
    if (i2 >= i1)
      return i3;
    View localView = getChildAt(i2);
    e locale;
    if (localView.getVisibility() != 8)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      locale = new e();
      locale.a = (localView.getLeft() - localLayoutParams.leftMargin);
      localView.getTop();
      locale.b = localView.getTop();
      locale.c = (locale.a + localLayoutParams.leftMargin + localView.getWidth() + localLayoutParams.rightMargin);
      locale.d = (locale.b + localView.getHeight() + localLayoutParams.bottomMargin);
      this.o.add(locale);
      if (locale.d <= i3);
    }
    for (int i4 = locale.d; ; i4 = i3)
    {
      i2++;
      i3 = i4;
      break;
    }
  }

  private int a(String paramString, float paramFloat)
  {
    int i1 = this.h.breakText(paramString, true, paramFloat, null);
    if ((i1 <= 0) || (i1 >= paramString.length()) || (paramString.charAt(i1 - 1) == ' '))
      return i1;
    if ((paramString.length() > i1) && (paramString.charAt(i1) == ' '))
      return i1 + 1;
    int i2 = i1 - 1;
    do
    {
      if (paramString.charAt(i2) == ' ')
        return i2 + 1;
      i2--;
    }
    while (i2 > 0);
    return i1;
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
      b(paramContext, paramAttributeSet);
    this.h = new TextPaint(1);
    this.h.density = getResources().getDisplayMetrics().density;
    this.h.setTextSize(this.j);
    this.h.setColor(this.k);
    this.i = new TextPaint(1);
    this.i.density = getResources().getDisplayMetrics().density;
    this.i.setTextSize(this.j);
    this.i.setColor(-16776961);
    this.i.setUnderlineText(true);
    setBackgroundColor(0);
  }

  private void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, paramPaint);
  }

  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843287, 16843288, 16842901, 16842904 });
    this.s = localTypedArray.getDimensionPixelSize(0, 0);
    this.r = localTypedArray.getFloat(1, 1.0F);
    this.j = localTypedArray.getDimension(2, this.j);
    this.k = localTypedArray.getColor(3, -16777216);
    localTypedArray.recycle();
  }

  public int getColor()
  {
    return this.f;
  }

  public int getLineHeight()
  {
    return Math.round(this.h.getFontMetricsInt(null) * this.r + this.s);
  }

  public TextPaint getLinkPaint()
  {
    return this.i;
  }

  public uk.co.deanwild.flowtextview.b.a getOnLinkClickListener()
  {
    return this.e.a();
  }

  public CharSequence getText()
  {
    return this.p;
  }

  public int getTextColor()
  {
    return this.k;
  }

  public TextPaint getTextPaint()
  {
    return this.h;
  }

  public float getTextsize()
  {
    return this.j;
  }

  public Typeface getTypeFace()
  {
    return this.l;
  }

  public void invalidate()
  {
    this.n = true;
    super.invalidate();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = getWidth();
    this.o.clear();
    int i1 = a();
    String[] arrayOfString = this.p.toString().split("\n");
    int i2 = getLineHeight();
    getPaddingTop();
    this.a.clear();
    this.d.a();
    int i3 = 0;
    float f2 = 0.0F;
    int i4 = 0;
    int i5 = 0;
    View localView;
    String str1;
    int i10;
    int i8;
    int i9;
    float f3;
    for (int i6 = 0; ; i6 = i9)
    {
      if (i3 > -1 + arrayOfString.length)
      {
        float f10 = f2 + i2 / 2;
        localView = getChildAt(-1 + getChildCount());
        if ((localView != null) && (localView.getTag() != null) && (localView.getTag().toString().equalsIgnoreCase("hideable")))
        {
          if (f10 <= this.g)
            break label775;
          if (f10 >= ((e)this.o.get(-1 + this.o.size())).b - getLineHeight())
            break;
          localView.setVisibility(8);
        }
        this.m = Math.max(i1, (int)f10);
        if (this.n)
        {
          this.n = false;
          requestLayout();
        }
        return;
      }
      str1 = arrayOfString[i3];
      if (str1.length() > 0)
        break label806;
      int i15 = i4 + 1;
      i10 = i5 + 2;
      i8 = i15;
      i9 = i10;
      f3 = f2;
      label263: i3++;
      f2 = f3;
      i4 = i8;
      i5 = i10;
    }
    label388: label649: label656: label663: label792: label799: label806: label815: 
    while (true)
    {
      int i11 = i4 + 1;
      float f4 = getPaddingTop() + i11 * i2 - (getLineHeight() + this.h.getFontMetrics().ascent);
      uk.co.deanwild.flowtextview.c.d locald = uk.co.deanwild.flowtextview.a.b.a(f4, i2, f1, this.o);
      float f5 = locald.a;
      float f6 = locald.b - locald.a;
      label355: Object localObject1;
      int i12 = a((String)localObject1, f6);
      int i7;
      int i13 = i7 + i12;
      String str2;
      float f7;
      label452: float f8;
      label468: Iterator localIterator;
      label565: Object localObject2;
      if (i12 > 1)
      {
        str2 = ((String)localObject1).substring(0, i12);
        this.a.clear();
        if (!this.q)
          break label656;
        Object[] arrayOfObject = ((Spanned)this.p).getSpans(i6, i13, Object.class);
        if (arrayOfObject.length <= 0)
          break label649;
        f7 = this.d.a(this.a, arrayOfObject, i6, i13, f5);
        if (f7 <= f6)
          break label799;
        f8 = f6 - 5.0F;
        if (f7 > f8)
          break label792;
        int i14 = i7 + i12;
        if (this.a.size() <= 0)
        {
          this.b.e = str2;
          this.b.f = 0;
          this.b.g = 0;
          this.b.h = f5;
          this.b.i = this.h;
          this.a.add(this.b);
        }
        localIterator = this.a.iterator();
        if (localIterator.hasNext())
          break label663;
        if (i12 < 1)
          break label785;
        localObject2 = ((String)localObject1).substring(i12, ((String)localObject1).length());
        label595: localObject1 = localObject2;
        i4 = i11;
        i7 = i14;
        i6 = i14;
        f2 = f4;
      }
      while (true)
      {
        if (((String)localObject1).length() > 0)
          break label815;
        i8 = i4;
        i9 = i6;
        i10 = i7;
        f3 = f2;
        break label263;
        str2 = "";
        break label388;
        f7 = f6;
        break label452;
        f7 = f6;
        break label452;
        uk.co.deanwild.flowtextview.c.c localc = (uk.co.deanwild.flowtextview.c.c)localIterator.next();
        if ((localc instanceof uk.co.deanwild.flowtextview.c.b))
        {
          uk.co.deanwild.flowtextview.c.b localb = (uk.co.deanwild.flowtextview.c.b)localc;
          float f9 = localb.i.measureText(localc.e);
          this.d.a(localb, f4, f9, i2);
        }
        a(paramCanvas, localc.e, localc.h, f4, localc.i);
        if (!localc.j)
          break label565;
        this.c.a(localc.i);
        break label565;
        localView.setVisibility(0);
        break;
        localView.setVisibility(8);
        break;
        localObject2 = localObject1;
        break label595;
        f6 = f8;
        break label355;
        f8 = f6;
        break label468;
        localObject1 = str1;
        i7 = i5;
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == 1073741824)
      if (i2 != 1073741824)
        break label67;
    while (true)
    {
      setMeasuredDimension(i3, i4 + getLineHeight());
      return;
      i3 = getWidth();
      break;
      label67: i4 = this.m;
    }
  }

  public void setColor(int paramInt)
  {
    this.f = paramInt;
    if (this.h != null)
      this.h.setColor(this.f);
    this.c.a(this.f);
    invalidate();
  }

  public void setLinkPaint(TextPaint paramTextPaint)
  {
    this.i = paramTextPaint;
    invalidate();
  }

  public void setOnLinkClickListener(uk.co.deanwild.flowtextview.b.a parama)
  {
    this.e.a(parama);
  }

  public void setPageHeight(int paramInt)
  {
    this.g = paramInt;
    invalidate();
  }

  public void setText(CharSequence paramCharSequence)
  {
    this.p = paramCharSequence;
    if ((paramCharSequence instanceof Spannable))
    {
      this.q = true;
      this.d.a((Spannable)paramCharSequence);
    }
    while (true)
    {
      invalidate();
      return;
      this.q = false;
    }
  }

  public void setTextColor(int paramInt)
  {
    this.k = paramInt;
    this.h.setColor(this.k);
    invalidate();
  }

  public void setTextPaint(TextPaint paramTextPaint)
  {
    this.h = paramTextPaint;
    invalidate();
  }

  public void setTextSize(float paramFloat)
  {
    this.j = paramFloat;
    this.h.setTextSize(this.j);
    this.i.setTextSize(this.j);
    invalidate();
  }

  public void setTypeface(Typeface paramTypeface)
  {
    this.l = paramTypeface;
    this.h.setTypeface(this.l);
    this.i.setTypeface(this.l);
    invalidate();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.deanwild.flowtextview.FlowTextView
 * JD-Core Version:    0.6.0
 */