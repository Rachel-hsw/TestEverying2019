package com.withustudy.koudaizikao.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class b
{
  private final SparseArray<View> a;
  private int b;
  private View c;

  private b(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    this.b = paramInt2;
    this.a = new SparseArray();
    this.c = LayoutInflater.from(paramContext).inflate(paramInt1, paramViewGroup, false);
    this.c.setTag(this);
  }

  public static b a(Context paramContext, View paramView, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (paramView == null)
      return new b(paramContext, paramViewGroup, paramInt1, paramInt2);
    return (b)paramView.getTag();
  }

  public View a()
  {
    return this.c;
  }

  public <T extends View> T a(int paramInt)
  {
    View localView = (View)this.a.get(paramInt);
    if (localView == null)
    {
      localView = this.c.findViewById(paramInt);
      this.a.put(paramInt, localView);
    }
    return localView;
  }

  public b a(int paramInt1, int paramInt2)
  {
    ((ImageView)a(paramInt1)).setImageResource(paramInt2);
    return this;
  }

  public b a(int paramInt, Bitmap paramBitmap)
  {
    ((ImageView)a(paramInt)).setImageBitmap(paramBitmap);
    return this;
  }

  public b a(int paramInt, String paramString)
  {
    ((TextView)a(paramInt)).setText(paramString);
    return this;
  }

  public int b()
  {
    return this.b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.c.b
 * JD-Core Version:    0.6.0
 */