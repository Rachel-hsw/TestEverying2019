package com.a.a.b.e;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.a.a.b.a.h;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class d
  implements a
{
  public static final String a = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";
  public static final String b = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";
  protected Reference<View> c;
  protected boolean d;

  public d(View paramView)
  {
    this(paramView, true);
  }

  public d(View paramView, boolean paramBoolean)
  {
    if (paramView == null)
      throw new IllegalArgumentException("view must not be null");
    this.c = new WeakReference(paramView);
    this.d = paramBoolean;
  }

  public int a()
  {
    View localView = (View)this.c.get();
    ViewGroup.LayoutParams localLayoutParams;
    if (localView != null)
    {
      localLayoutParams = localView.getLayoutParams();
      if ((!this.d) || (localLayoutParams == null) || (localLayoutParams.width == -2))
        break label62;
    }
    label62: for (int i = localView.getWidth(); ; i = 0)
    {
      if ((i <= 0) && (localLayoutParams != null))
        i = localLayoutParams.width;
      return i;
      return 0;
    }
  }

  protected abstract void a(Bitmap paramBitmap, View paramView);

  protected abstract void a(Drawable paramDrawable, View paramView);

  public boolean a(Bitmap paramBitmap)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      View localView = (View)this.c.get();
      if (localView != null)
      {
        a(paramBitmap, localView);
        return true;
      }
    }
    else
    {
      com.a.a.c.d.c("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
    }
    return false;
  }

  public boolean a(Drawable paramDrawable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      View localView = (View)this.c.get();
      if (localView != null)
      {
        a(paramDrawable, localView);
        return true;
      }
    }
    else
    {
      com.a.a.c.d.c("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
    }
    return false;
  }

  public int b()
  {
    View localView = (View)this.c.get();
    ViewGroup.LayoutParams localLayoutParams;
    if (localView != null)
    {
      localLayoutParams = localView.getLayoutParams();
      if ((!this.d) || (localLayoutParams == null) || (localLayoutParams.height == -2))
        break label62;
    }
    label62: for (int i = localView.getHeight(); ; i = 0)
    {
      if ((i <= 0) && (localLayoutParams != null))
        i = localLayoutParams.height;
      return i;
      return 0;
    }
  }

  public h c()
  {
    return h.b;
  }

  public View d()
  {
    return (View)this.c.get();
  }

  public boolean e()
  {
    return this.c.get() == null;
  }

  public int f()
  {
    View localView = (View)this.c.get();
    if (localView == null)
      return super.hashCode();
    return localView.hashCode();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.e.d
 * JD-Core Version:    0.6.0
 */