package com.himamis.retex.renderer.android.e;

import android.content.res.AssetManager;
import com.himamis.retex.renderer.a.e.o;
import java.io.IOException;
import java.io.InputStream;

public class a
  implements com.himamis.retex.renderer.a.g.e.a
{
  private AssetManager a;

  public a(AssetManager paramAssetManager)
  {
    this.a = paramAssetManager;
  }

  public InputStream a(Object paramObject, String paramString)
    throws o
  {
    try
    {
      InputStream localInputStream = this.a.open(com.himamis.retex.renderer.android.a.a(paramObject, paramString));
      return localInputStream;
    }
    catch (IOException localIOException)
    {
    }
    throw new o("Could not load resource.", localIOException);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.e.a
 * JD-Core Version:    0.6.0
 */