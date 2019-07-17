package com.a.a.b.b;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.a.a.b.a.d;
import com.a.a.b.a.e;
import com.a.a.b.a.h;
import com.a.a.b.d.b;

public class c
{
  private final String a;
  private final String b;
  private final String c;
  private final e d;
  private final d e;
  private final h f;
  private final b g;
  private final Object h;
  private final boolean i;
  private final BitmapFactory.Options j;

  public c(String paramString1, String paramString2, String paramString3, e parame, h paramh, b paramb, com.a.a.b.c paramc)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = parame;
    this.e = paramc.j();
    this.f = paramh;
    this.g = paramb;
    this.h = paramc.n();
    this.i = paramc.m();
    this.j = new BitmapFactory.Options();
    a(paramc.k(), this.j);
  }

  private void a(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inDensity = paramOptions1.inDensity;
    paramOptions2.inDither = paramOptions1.inDither;
    paramOptions2.inInputShareable = paramOptions1.inInputShareable;
    paramOptions2.inJustDecodeBounds = paramOptions1.inJustDecodeBounds;
    paramOptions2.inPreferredConfig = paramOptions1.inPreferredConfig;
    paramOptions2.inPurgeable = paramOptions1.inPurgeable;
    paramOptions2.inSampleSize = paramOptions1.inSampleSize;
    paramOptions2.inScaled = paramOptions1.inScaled;
    paramOptions2.inScreenDensity = paramOptions1.inScreenDensity;
    paramOptions2.inTargetDensity = paramOptions1.inTargetDensity;
    paramOptions2.inTempStorage = paramOptions1.inTempStorage;
    if (Build.VERSION.SDK_INT >= 10)
      b(paramOptions1, paramOptions2);
    if (Build.VERSION.SDK_INT >= 11)
      c(paramOptions1, paramOptions2);
  }

  @TargetApi(10)
  private void b(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inPreferQualityOverSpeed = paramOptions1.inPreferQualityOverSpeed;
  }

  @TargetApi(11)
  private void c(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inBitmap = paramOptions1.inBitmap;
    paramOptions2.inMutable = paramOptions1.inMutable;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public e d()
  {
    return this.d;
  }

  public d e()
  {
    return this.e;
  }

  public h f()
  {
    return this.f;
  }

  public b g()
  {
    return this.g;
  }

  public Object h()
  {
    return this.h;
  }

  public boolean i()
  {
    return this.i;
  }

  public BitmapFactory.Options j()
  {
    return this.j;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.b.c
 * JD-Core Version:    0.6.0
 */