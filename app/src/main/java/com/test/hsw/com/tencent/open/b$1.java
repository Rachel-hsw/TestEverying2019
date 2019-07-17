package com.tencent.open;

import android.os.Build.VERSION;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.a.f;

class b$1 extends WebChromeClient
{
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    f.c("WebConsole", paramString1 + " -- From 222 line " + paramInt + " of " + paramString2);
    if (Build.VERSION.SDK_INT == 7)
      this.a.onConsoleMessage(paramString1);
  }

  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage == null)
      return false;
    f.c("WebConsole", paramConsoleMessage.message() + " -- From  111 line " + paramConsoleMessage.lineNumber() + " of " + paramConsoleMessage.sourceId());
    b localb;
    if (Build.VERSION.SDK_INT > 7)
    {
      localb = this.a;
      if (paramConsoleMessage != null)
        break label79;
    }
    label79: for (String str = ""; ; str = paramConsoleMessage.message())
    {
      localb.onConsoleMessage(str);
      return true;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b.1
 * JD-Core Version:    0.6.0
 */