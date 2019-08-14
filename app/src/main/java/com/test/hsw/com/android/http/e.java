package com.android.http;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.widget.ImageView;
import com.a.a.b.c.a;
import com.a.a.b.c.b;

public class e
{
  private static e a;

  public static e a(Context paramContext)
  {
    if (a == null)
      monitorenter;
    try
    {
      if (a == null)
        a = new e();
      return a;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private String a(String paramString)
  {
    if (paramString.contains("http://"))
      return paramString;
    return "http://" + paramString;
  }

  private final void a()
  {
    new c.a().b(true).d(true).a(null).b(null).c(null).e(true).e(true).a(com.a.a.b.a.d.c).a(Bitmap.Config.RGB_565).e(0).a(null).a(null).a(true).a(new com.a.a.b.c.c(0)).a(new b(100)).d();
  }

  public void a(String paramString, ImageView paramImageView)
  {
    String str = a(paramString);
    com.a.a.b.c localc = new c.a().b(true).d(true).a(Bitmap.Config.RGB_565).d();
    com.a.a.b.d.a().a(str, localc, new f(this, paramImageView));
  }

  public void a(String paramString, ImageView paramImageView, int paramInt)
  {
    String str = a(paramString);
    com.a.a.b.c localc = new c.a().b(true).d(true).a(Bitmap.Config.RGB_565).a(new com.a.a.b.c.c(paramInt)).d();
    com.a.a.b.d.a().a(str, paramImageView, localc);
  }

  public void a(String paramString, ImageView paramImageView, Context paramContext)
  {
    String str = a(paramString);
    com.a.a.b.c localc = new c.a().b(true).d(true).a(Bitmap.Config.RGB_565).d();
    com.a.a.b.d.a().a(str, localc, new i(this, paramContext, paramImageView));
  }

  public void b(String paramString, ImageView paramImageView)
  {
    com.a.a.b.c localc = new c.a().b(true).d(true).a(Bitmap.Config.RGB_565).d();
    com.a.a.b.d.a().a(paramString, localc, new g(this, paramImageView));
  }

  public void b(String paramString, ImageView paramImageView, int paramInt)
  {
    com.a.a.b.c localc = new c.a().b(true).d(true).a(Bitmap.Config.RGB_565).d();
    com.a.a.b.d.a().a(paramString, localc, new h(this, paramImageView, paramInt));
  }

  public void c(String paramString, ImageView paramImageView, int paramInt)
  {
    String str = a(paramString);
    com.a.a.b.c localc = new c.a().b(true).d(true).a(Bitmap.Config.RGB_565).d();
    com.a.a.b.d.a().a(str, localc, new j(this, paramImageView, paramInt));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.e
 * JD-Core Version:    0.6.0
 */