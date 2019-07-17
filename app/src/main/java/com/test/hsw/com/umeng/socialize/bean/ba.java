package com.umeng.socialize.bean;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.umeng.socialize.common.b;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.common.r;
import com.umeng.socialize.utils.i;

public class ba
{
  public static final int a = 200;
  public static final int b = 5027;
  public static final int c = 5028;
  public static final int d = 5014;
  public static final int e = 5037;
  public static final int f = 5029;
  public static final int g = 5016;
  public static final int h = 505;
  public static final int i = 40000;
  public static final int j = 40001;
  public static final int k = 40002;
  public static final int l = 10086;
  public static final int m = -101;
  public static final int n = -102;
  public static final int o = -103;
  public static final int p = -104;
  public static final int q = -105;

  public static int a(Context paramContext, int paramInt, String paramString)
  {
    if (paramInt == 200)
      i.e("com.umeng.socialize", "call show error msg but error_code is " + paramInt);
    do
    {
      return paramInt;
      if (paramInt == 505)
      {
        if (r.t);
        for (String str = " [" + paramInt + "]"; ; str = "")
        {
          Toast.makeText(paramContext, paramContext.getString(b.a(paramContext, b.a.e, "umeng_socialize_tip_blacklist")) + str, 1).show();
          return paramInt;
        }
      }
      if ((paramInt == 5027) || (5028 == paramInt))
      {
        Toast.makeText(paramContext, "授权失效，请重新授权...", 0).show();
        return paramInt;
      }
      if (paramInt == 5016)
      {
        Toast.makeText(paramContext, "分享内容重复...", 0).show();
        return paramInt;
      }
      if (paramInt != 40000)
        continue;
      Toast.makeText(paramContext, "取消分享", 0).show();
      return paramInt;
    }
    while (TextUtils.isEmpty(paramString));
    Toast.makeText(paramContext, paramString + " [" + paramInt + "]", 1).show();
    return paramInt;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.ba
 * JD-Core Version:    0.6.0
 */