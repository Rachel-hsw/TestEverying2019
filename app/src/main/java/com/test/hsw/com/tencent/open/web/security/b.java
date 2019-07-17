package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.open.a;
import com.tencent.open.a.a;
import com.tencent.open.a.b;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class b extends a
{
  private static final String b = f.d + ".SecureJs";

  public void a(String paramString1, String paramString2, List<String> paramList, a.a parama)
  {
    f.c(b, "-->getResult, objectName: " + paramString1 + " | methodName: " + paramString2);
    int i = paramList.size();
    int j = 0;
    while (true)
      if (j < i)
        try
        {
          paramList.set(j, URLDecoder.decode((String)paramList.get(j), "UTF-8"));
          j++;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          while (true)
            localUnsupportedEncodingException.printStackTrace();
        }
    a.b localb = (a.b)this.a.get(paramString1);
    if (localb != null)
    {
      f.b(b, "-->handler != null");
      localb.call(paramString2, paramList, parama);
    }
    do
    {
      return;
      f.b(b, "-->handler == null");
    }
    while (parama == null);
    parama.a();
  }

  public boolean a(WebView paramWebView, String paramString)
  {
    f.b(b, "-->canHandleUrl---url = " + paramString);
    if (paramString == null)
      return false;
    if (!Uri.parse(paramString).getScheme().equals("jsbridge"))
      return false;
    ArrayList localArrayList = new ArrayList(Arrays.asList((paramString + "/#").split("/")));
    if (localArrayList.size() < 7)
      return false;
    String str1 = (String)localArrayList.get(2);
    String str2 = (String)localArrayList.get(3);
    String str3 = (String)localArrayList.get(4);
    String str4 = (String)localArrayList.get(5);
    f.c(b, "-->canHandleUrl, objectName: " + str1 + " | methodName: " + str2 + " | snStr: " + str3);
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
      return false;
    try
    {
      long l = Long.parseLong(str3);
      c localc = new c(paramWebView, l, paramString, str4);
      a(str1, str2, localArrayList.subList(6, -1 + localArrayList.size()), localc);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.web.security.b
 * JD-Core Version:    0.6.0
 */