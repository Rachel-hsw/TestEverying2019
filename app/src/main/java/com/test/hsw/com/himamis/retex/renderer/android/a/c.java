package com.himamis.retex.renderer.android.a;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.himamis.retex.renderer.a.e.o;

public class c
  implements com.himamis.retex.renderer.a.g.a.c
{
  private AssetManager b;

  public c(AssetManager paramAssetManager)
  {
    this.b = paramAssetManager;
  }

  public com.himamis.retex.renderer.a.g.a.a a(Object paramObject, String paramString)
    throws o
  {
    return new a(paramString, Typeface.createFromAsset(this.b, com.himamis.retex.renderer.android.a.a(paramObject, paramString)), Math.round(1.0F));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.a.c
 * JD-Core Version:    0.6.0
 */