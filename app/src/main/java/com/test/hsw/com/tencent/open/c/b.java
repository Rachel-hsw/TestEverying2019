package com.tencent.open.c;

import android.content.Context;
import android.webkit.WebView;
import java.lang.reflect.Method;

public class b extends WebView
{
  public b(Context paramContext)
  {
    super(paramContext);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Class localClass = getSettings().getClass();
    try
    {
      Method localMethod = localClass.getMethod("removeJavascriptInterface", new Class[] { String.class });
      if (localMethod != null)
        localMethod.invoke(this, new Object[] { "searchBoxJavaBridge_" });
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.c.b
 * JD-Core Version:    0.6.0
 */