package com.himamis.retex.editor.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.himamis.retex.editor.a.d.d;
import com.himamis.retex.renderer.a.dr;
import com.himamis.retex.renderer.a.dr.b;
import com.himamis.retex.renderer.a.du;
import com.withustudy.koudaizikao.R.styleable;

public class FormulaEditor extends View
  implements com.himamis.retex.editor.a.c.a
{
  protected static com.himamis.retex.editor.a.e.h a;
  protected com.himamis.retex.editor.a.c.b b;
  private du c;
  private com.himamis.retex.renderer.android.c.c d;
  private float e = 20.0F;
  private int f = 0;
  private com.himamis.retex.renderer.android.c.b g = new com.himamis.retex.renderer.android.c.b(-16777216);
  private int h = 0;
  private String i;
  private float j;
  private float k;
  private com.himamis.retex.editor.a.a.b l;

  public FormulaEditor(Context paramContext)
  {
    super(paramContext);
    d();
  }

  public FormulaEditor(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
    d();
  }

  public FormulaEditor(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    d();
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.FormulaEditor, paramInt, 0);
    try
    {
      this.e = localTypedArray.getFloat(0, 20.0F);
      this.f = localTypedArray.getColor(2, 0);
      this.g = new com.himamis.retex.renderer.android.c.b(localTypedArray.getColor(1, -16777216));
      this.i = localTypedArray.getString(3);
      this.h = localTypedArray.getInteger(4, 0);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
    throw localObject;
  }

  private void d()
  {
    e();
    f();
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.j = getResources().getDisplayMetrics().scaledDensity;
    this.b = new com.himamis.retex.editor.a.c.b();
    this.b.a(this.e * this.j);
    this.b.a(this.h);
    this.b.a(this);
    if (!isInEditMode())
      this.b.a(com.himamis.retex.editor.a.f.f.a(a));
  }

  private void e()
  {
    if (com.himamis.retex.renderer.a.g.a.a == null)
      com.himamis.retex.renderer.a.g.a.a = new com.himamis.retex.renderer.android.b(getContext().getAssets());
  }

  private void f()
  {
    if ((!isInEditMode()) && (a == null))
      a = new com.himamis.retex.editor.a.e.h(new com.himamis.retex.renderer.a.g.f().a("Octave.xml"));
  }

  private void g()
  {
    this.b.a(com.himamis.retex.editor.a.f.f.a(a, this.l, this.i));
  }

  private float getMinHeigth()
  {
    if (this.k == 0.0F)
    {
      dr localdr = new dr("|");
      localdr.getClass();
      du localdu = new dr.b(localdr).a(this.e * this.j).a(0).a();
      localdu.a(h());
      this.k = localdu.b();
    }
    return this.k;
  }

  private com.himamis.retex.renderer.a.g.c.h h()
  {
    return new com.himamis.retex.renderer.a.g.c.h(getPaddingTop(), getPaddingLeft(), getPaddingBottom(), getPaddingRight());
  }

  public void a()
  {
    invalidate();
  }

  public void a(com.himamis.retex.editor.a.a.b paramb, String paramString)
  {
    this.l = paramb;
    this.i = paramString;
    g();
    requestLayout();
  }

  public boolean b()
  {
    return getParent() != null;
  }

  public void c()
  {
    requestFocus();
  }

  public boolean onCheckIsTextEditor()
  {
    return true;
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    float f1 = paramConfiguration.fontScale;
    if (Math.abs(this.j - f1) > 0.001D)
    {
      this.j = paramConfiguration.fontScale;
      this.k = 0.0F;
      this.b.a(false);
    }
  }

  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    BaseInputConnection localBaseInputConnection = new BaseInputConnection(this, false);
    paramEditorInfo.actionLabel = null;
    paramEditorInfo.inputType = 0;
    paramEditorInfo.imeOptions = 5;
    return localBaseInputConnection;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.c == null)
      return;
    if (this.d == null)
      this.d = new com.himamis.retex.renderer.android.c.c();
    paramCanvas.drawColor(this.f);
    int m = Math.round((getMeasuredHeight() - this.c.b()) / 2.0F);
    this.d.a(paramCanvas);
    this.c.a(this.g);
    this.c.a(null, this.d, 0, m);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = this.c.d();
    int n = (int)(0.5D + Math.max(getMinHeigth(), this.c.b()));
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == 1073741824)
      if (i3 != 1073741824)
        break label105;
    while (true)
    {
      setMeasuredDimension(i2, i4);
      return;
      if (i1 == -2147483648)
      {
        i2 = Math.min(m, i2);
        break;
      }
      i2 = m;
      break;
      label105: if (i3 == -2147483648)
      {
        i4 = Math.min(n, i4);
        continue;
      }
      i4 = n;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (onCheckIsTextEditor())
    {
      super.onTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getAction() == 1)
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 2);
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setBackgroundColor(int paramInt)
  {
    this.f = paramInt;
    invalidate();
  }

  public void setClickListener(com.himamis.retex.editor.a.d.a parama)
  {
    setOnClickListener(new com.himamis.retex.editor.android.a.a(parama));
  }

  public void setFocusListener(com.himamis.retex.editor.a.d.b paramb)
  {
    setOnFocusChangeListener(new com.himamis.retex.editor.android.a.b(paramb));
  }

  public void setForegroundColor(int paramInt)
  {
    this.g = new com.himamis.retex.renderer.android.c.b(paramInt);
    invalidate();
  }

  public void setKeyListener(d paramd)
  {
    setOnKeyListener(new com.himamis.retex.editor.android.a.c(paramd));
  }

  public void setTeXIcon(du paramdu)
  {
    this.c = paramdu;
    this.c.a(h());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.android.FormulaEditor
 * JD-Core Version:    0.6.0
 */