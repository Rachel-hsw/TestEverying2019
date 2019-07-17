package com.umeng.socialize.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.a;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.b.b.e;
import com.umeng.socialize.b.b.g.a;
import com.umeng.socialize.bean.UMLocation;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.as;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.common.a;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.m;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class p extends b
{
  public static boolean f = false;
  private static final String j = "/share/multi_add/";
  private static final int k = 17;
  private ay l;
  private ar[] m;
  private UMShareMsg n;

  public p(Context paramContext, ay paramay, ar[] paramArrayOfar, UMShareMsg paramUMShareMsg)
  {
    super(paramContext, "", q.class, paramay, 17, b.b.b);
    this.d = paramContext;
    this.l = paramay;
    this.n = paramUMShareMsg;
    this.m = paramArrayOfar;
  }

  protected String a()
  {
    return "/share/multi_add/" + m.a(this.d) + "/" + this.l.a + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if ((this.m != null) && (this.m.length > 0));
    label289: for (int i = 0; ; i++)
    {
      ar localar;
      if (i < this.m.length)
      {
        localar = this.m[i];
        if (TextUtils.isEmpty(localar.a))
          continue;
      }
      try
      {
        String str2 = localar.a;
        String str3;
        if (TextUtils.isEmpty(localar.b))
          str3 = "";
        while (true)
        {
          localJSONObject1.put(str2, str3);
          break label289;
          str3 = localar.b;
          continue;
          JSONObject localJSONObject2 = new JSONObject();
          try
          {
            localJSONObject2.put("sns", localJSONObject1.toString());
            if (!TextUtils.isEmpty(this.n.a))
              localJSONObject2.put(e.s, this.n.a);
            localJSONObject2.put("ak", m.a(this.d));
            if (this.n.b != null)
              localJSONObject2.put(e.t, this.n.b.toString());
            localJSONObject2.put("type", this.l.j());
            String str1 = this.l.t();
            if (!TextUtils.isEmpty(str1))
              localJSONObject2.put(this.l.u(), str1);
            this.l.a(as.b);
            label244: JSONObject localJSONObject3 = a(localJSONObject2, paramMap);
            Map localMap = a(a, localJSONObject3.toString());
            a(this.n.a(), localMap);
            return localMap;
          }
          catch (Exception localException)
          {
            break label244;
          }
        }
      }
      catch (JSONException localJSONException)
      {
      }
    }
  }

  public void a(UMediaObject paramUMediaObject, Map<String, Object> paramMap)
  {
    if (this.m != null)
      if (this.m.length != 1);
    label69: label335: for (com.umeng.socialize.bean.p localp = com.umeng.socialize.bean.p.a(this.m[0].a); ; localp = null)
    {
      String str1 = ay.b(localp);
      String str3;
      String str2;
      if (paramUMediaObject != null)
        if (paramUMediaObject.b())
        {
          Map localMap = paramUMediaObject.c_();
          if (localMap != null)
            paramMap.putAll(localMap);
          if (!(paramUMediaObject instanceof BaseMediaObject))
            break label324;
          BaseMediaObject localBaseMediaObject = (BaseMediaObject)paramUMediaObject;
          str3 = localBaseMediaObject.c();
          str2 = localBaseMediaObject.d();
        }
      while (true)
      {
        String str4;
        if ((TextUtils.isEmpty(ay.f)) && (this.d != null))
        {
          CharSequence localCharSequence = this.d.getApplicationInfo().loadLabel(this.d.getPackageManager());
          if (TextUtils.isEmpty(localCharSequence))
            break label317;
          str4 = localCharSequence.toString();
          ay.f = str4;
        }
        while (true)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            if (TextUtils.isEmpty(str4))
              continue;
            localJSONObject.put("app_name", str4);
            if ((TextUtils.isEmpty(str3)) || (str3.equals("未知")))
              continue;
            localJSONObject.put(e.A, str3);
            if (TextUtils.isEmpty(str2))
              continue;
            localJSONObject.put(e.B, str2);
            if (TextUtils.isEmpty(str1))
              continue;
            localJSONObject.put("app_website", str1);
            paramMap.put("ext", localJSONObject);
            return;
            if (this.m.length <= 1)
              break label335;
            localp = com.umeng.socialize.bean.p.b;
            break;
            byte[] arrayOfByte = paramUMediaObject.d_();
            if (arrayOfByte == null)
              break label69;
            a(arrayOfByte, b.a.a, null);
            break label69;
            str4 = ay.f;
            continue;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            return;
          }
          str4 = "";
        }
        str2 = "";
        str3 = "";
      }
    }
  }

  public Map<String, g.a> c()
  {
    if ((this.n == null) || (this.n.a() == null) || (this.n.a().b()))
      return super.c();
    Map localMap = super.c();
    if ((this.n.a() instanceof UMImage))
    {
      byte[] arrayOfByte = a(((UMImage)this.n.a()).k());
      String str1 = a.a(arrayOfByte);
      if (TextUtils.isEmpty(str1))
        str1 = "png";
      String str2 = System.currentTimeMillis() + "";
      g.a locala = new g.a(str2 + "." + str1, arrayOfByte);
      localMap.put(e.v, locala);
    }
    return localMap;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.p
 * JD-Core Version:    0.6.0
 */