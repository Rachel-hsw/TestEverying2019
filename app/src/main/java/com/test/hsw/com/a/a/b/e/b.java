package com.a.a.b.e;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.a.a.b.a.h;
import java.lang.ref.Reference;
import java.lang.reflect.Field;

public class b extends d
{
  public b(ImageView paramImageView)
  {
    super(paramImageView);
  }

  public b(ImageView paramImageView, boolean paramBoolean)
  {
    super(paramImageView, paramBoolean);
  }

  private static int a(Object paramObject, String paramString)
  {
    try
    {
      Field localField = ImageView.class.getDeclaredField(paramString);
      localField.setAccessible(true);
      int i = ((Integer)localField.get(paramObject)).intValue();
      if ((i > 0) && (i < 2147483647))
        return i;
    }
    catch (Exception localException)
    {
      com.a.a.c.d.a(localException);
    }
    return 0;
  }

  public int a()
  {
    int i = super.a();
    if (i <= 0)
    {
      ImageView localImageView = (ImageView)this.c.get();
      if (localImageView != null)
        return a(localImageView, "mMaxWidth");
    }
    return i;
  }

  protected void a(Bitmap paramBitmap, View paramView)
  {
    ((ImageView)paramView).setImageBitmap(paramBitmap);
  }

  protected void a(Drawable paramDrawable, View paramView)
  {
    ((ImageView)paramView).setImageDrawable(paramDrawable);
    if ((paramDrawable instanceof AnimationDrawable))
      ((AnimationDrawable)paramDrawable).start();
  }

  public int b()
  {
    int i = super.b();
    if (i <= 0)
    {
      ImageView localImageView = (ImageView)this.c.get();
      if (localImageView != null)
        return a(localImageView, "mMaxHeight");
    }
    return i;
  }

  public h c()
  {
    ImageView localImageView = (ImageView)this.c.get();
    if (localImageView != null)
      return h.a(localImageView);
    return super.c();
  }

  public ImageView g()
  {
    return (ImageView)super.d();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.e.b
 * JD-Core Version:    0.6.0
 */