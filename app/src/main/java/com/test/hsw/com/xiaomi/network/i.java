package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.xiaomi.a.a.e.c;
import com.xiaomi.a.a.e.d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class i
{
  static int a(int paramInt1, int paramInt2)
  {
    return paramInt2 + (paramInt1 + (1080 + 132 * ((paramInt2 + 243) / 1448)));
  }

  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt3 + (paramInt1 + (paramInt2 + (1011 + 132 * ((paramInt2 + 200) / 1448))));
  }

  private static int a(h paramh, String paramString1, List<c> paramList, String paramString2)
  {
    if (paramh.a() == 1)
      return a(paramString1.length(), a(paramString2));
    if (paramh.a() == 2)
    {
      int i = a(paramList);
      return a(paramString1.length(), i, a(paramString2));
    }
    return -1;
  }

  static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return 0;
    try
    {
      int i = paramString.getBytes("UTF-8").length;
      return i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return 0;
  }

  static int a(List<c> paramList)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    c localc;
    if (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      if (!TextUtils.isEmpty(localc.a()))
        i += localc.a().length();
      if (TextUtils.isEmpty(localc.b()))
        break label87;
    }
    label87: for (int j = i + localc.b().length(); ; j = i)
    {
      i = j;
      break;
      return i * 2;
    }
  }

  public static String a(Context paramContext, String paramString, List<c> paramList)
  {
    return a(paramContext, paramString, paramList, new a(), true);
  }

  public static String a(Context paramContext, String paramString, List<c> paramList, h paramh, boolean paramBoolean)
  {
    if (d.d(paramContext));
    while (true)
    {
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        b localb = null;
        if (!paramBoolean)
          continue;
        localb = f.a().a(paramString);
        if (localb == null)
          continue;
        localArrayList1 = localb.a(paramString);
        if (localArrayList1.contains(paramString))
          continue;
        localArrayList1.add(paramString);
        localObject1 = null;
        Iterator localIterator = localArrayList1.iterator();
        if (!localIterator.hasNext())
          break label275;
        String str = (String)localIterator.next();
        if (paramList == null)
          break label278;
        localArrayList2 = new ArrayList(paramList);
        long l = System.currentTimeMillis();
        try
        {
          if (!paramh.a(paramContext, str, localArrayList2))
            return localObject1;
          localObject1 = paramh.b(paramContext, str, localArrayList2);
          if (TextUtils.isEmpty((CharSequence)localObject1))
            continue;
          if (localb == null)
            break label275;
          localb.a(str, System.currentTimeMillis() - l, a(paramh, str, localArrayList2, (String)localObject1));
          return localObject1;
        }
        catch (IOException localIOException)
        {
          if (localb == null)
            continue;
          localb.a(str, System.currentTimeMillis() - l, a(paramh, str, localArrayList2, (String)localObject1), localIOException);
          localIOException.printStackTrace();
          localObject2 = localObject1;
          localObject1 = localObject2;
        }
        continue;
        if (localb == null)
          continue;
        localb.a(str, System.currentTimeMillis() - l, a(paramh, str, localArrayList2, (String)localObject1), null);
        Object localObject2 = localObject1;
        continue;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
      }
      Object localObject1 = null;
      label275: return localObject1;
      label278: ArrayList localArrayList2 = null;
    }
  }

  public static class a extends h
  {
    public a()
    {
      super();
    }

    public String b(Context paramContext, String paramString, List<c> paramList)
    {
      if (paramList == null)
        return d.a(paramContext, new URL(paramString));
      Uri.Builder localBuilder = Uri.parse(paramString).buildUpon();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        localBuilder.appendQueryParameter(localc.a(), localc.b());
      }
      return d.a(paramContext, new URL(localBuilder.toString()));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.i
 * JD-Core Version:    0.6.0
 */