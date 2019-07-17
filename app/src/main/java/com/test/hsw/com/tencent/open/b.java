package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebChromeClient;

public abstract class b extends Dialog
{
  protected a jsBridge;

  @SuppressLint({"NewApi"})
  protected final WebChromeClient mChromeClient = new b.1(this);

  public b(Context paramContext)
  {
    super(paramContext);
  }

  public b(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  protected abstract void onConsoleMessage(String paramString);

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jsBridge = new a();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b
 * JD-Core Version:    0.6.0
 */