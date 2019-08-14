package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class NetworkImageView extends ImageView
{
  private String a;
  private int b;
  private int c;
  private l d;
  private l.c e;

  public NetworkImageView(Context paramContext)
  {
    this(paramContext, null);
  }

  public NetworkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public NetworkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    if (this.b != 0)
    {
      setImageResource(this.b);
      return;
    }
    setImageBitmap(null);
  }

  public void a(String paramString, l paraml)
  {
    this.a = paramString;
    this.d = paraml;
    a(false);
  }

  void a(boolean paramBoolean)
  {
    int i = 1;
    int j = getWidth();
    int k = getHeight();
    ImageView.ScaleType localScaleType = getScaleType();
    int i2;
    int i3;
    label56: int n;
    int m;
    if (getLayoutParams() != null)
      if (getLayoutParams().width == -2)
      {
        i2 = i;
        if (getLayoutParams().height != -2)
          break label98;
        i3 = i;
        int i4 = i3;
        n = i2;
        m = i4;
      }
    while (true)
    {
      if ((n != 0) && (m != 0))
        label78: if ((j != 0) || (k != 0) || (i != 0))
          break label109;
      label98: label109: 
      do
      {
        return;
        i2 = 0;
        break;
        i3 = 0;
        break label56;
        i = 0;
        break label78;
        if (TextUtils.isEmpty(this.a))
        {
          if (this.e != null)
          {
            this.e.a();
            this.e = null;
          }
          a();
          return;
        }
        if ((this.e == null) || (this.e.c() == null))
          break label188;
      }
      while (this.e.c().equals(this.a));
      this.e.a();
      a();
      label188: if (n != 0);
      for (int i1 = 0; ; i1 = j)
      {
        if (m != 0)
          k = 0;
        this.e = this.d.a(this.a, new r(this, paramBoolean), i1, k, localScaleType);
        return;
      }
      m = 0;
      n = 0;
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }

  public String getImageURL()
  {
    return this.a;
  }

  protected void onDetachedFromWindow()
  {
    if (this.e != null)
    {
      this.e.a();
      setImageBitmap(null);
      this.e = null;
    }
    super.onDetachedFromWindow();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a(true);
  }

  public void setDefaultImageResId(int paramInt)
  {
    this.b = paramInt;
  }

  public void setErrorImageResId(int paramInt)
  {
    this.c = paramInt;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.NetworkImageView
 * JD-Core Version:    0.6.0
 */