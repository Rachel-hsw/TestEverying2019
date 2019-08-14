package com.umeng.message.c;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.b.a.b;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack;
import com.umeng.message.UmengRegistrar;
import com.umeng.message.b.ep;
import com.umeng.message.b.fb;
import com.umeng.message.protobuffer.PushResponse;
import com.umeng.message.protobuffer.PushResponse.Info;
import com.umeng.message.protobuffer.PushResponse.responseCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = a.class.getName();
  private static final String b = "ok";
  private static final String c = "fail";
  private static a d;
  private Context e;

  private a(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
  }

  public static a a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (d == null)
        d = new a(paramContext.getApplicationContext());
      a locala = d;
      return locala;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static String a(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(-1 + localStringBuilder.length()) == ','))
          localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
        return localStringBuilder.toString();
      }
      localStringBuilder.append((String)localIterator.next()).append(",");
    }
  }

  private static JSONObject a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    String str = ep.c(paramString).H().r("application/json").i(paramJSONObject.toString()).b("UTF-8");
    com.umeng.b.a.a.c(a, "postJson() url=" + paramString + "\n request = " + paramJSONObject + "\n response = " + str);
    return new JSONObject(str);
  }

  private JSONObject c()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("header", UTrack.getInstance(this.e).getHeader());
    localJSONObject.put("utdid", b.z(this.e));
    localJSONObject.put("device_token", UmengRegistrar.getRegistrationId(this.e));
    localJSONObject.put("ts", System.currentTimeMillis());
    return localJSONObject;
  }

  private static String d(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfString.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(-1 + localStringBuilder.length()) == ','))
          localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
        return localStringBuilder.toString();
      }
      localStringBuilder.append(paramArrayOfString[j]).append(",");
    }
  }

  private boolean d()
  {
    if (TextUtils.isEmpty(b.z(this.e)))
    {
      com.umeng.b.a.a.b(a, "UTDID is empty");
      return false;
    }
    if (TextUtils.isEmpty(UmengRegistrar.getRegistrationId(this.e)))
    {
      com.umeng.b.a.a.b(a, "RegistrationId is empty");
      return false;
    }
    return true;
  }

  private boolean e()
  {
    int i = 1;
    if (MessageSharedPrefs.getInstance(this.e).getTagSendPolicy() == i);
    while (true)
    {
      if (i != 0)
        com.umeng.b.a.a.c(a, "tag is disabled by the server");
      return i;
      i = 0;
    }
  }

  private a f()
  {
    a locala = new a(new JSONObject());
    locala.b = MessageSharedPrefs.getInstance(this.e).getTagRemain();
    locala.a = "ok";
    locala.d = ("status:" + locala.a + "," + " remain:" + locala.b + "," + "description:" + locala.a);
    return locala;
  }

  public a a()
    throws Exception
  {
    if (e())
      throw new Exception("Tag API is disabled by the server.");
    if (!d())
      throw new Exception("No utdid or device_token");
    JSONObject localJSONObject = c();
    fb localfb = new fb(this.e);
    PushResponse localPushResponse = localfb.a(localfb.a(localJSONObject), MsgConstant.TAG_ENDPOINT + "/reset");
    a locala = new a(localPushResponse);
    if (localPushResponse != null)
      com.umeng.b.a.a.c(a, "clearTags: " + localPushResponse.code + ", " + localPushResponse.description);
    if ((localPushResponse != null) && (localPushResponse.code.equals(PushResponse.responseCode.SUCCESS)))
      MessageSharedPrefs.getInstance(this.e).resetTags();
    return locala;
  }

  public a a(String[] paramArrayOfString)
    throws Exception
  {
    if (e())
      throw new Exception("Tag API is disabled by the server.");
    if (!d())
      throw new Exception("No utdid or device_token");
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      throw new Exception("No tags");
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfString.length;
    int j = 0;
    a locala;
    if (j >= i)
    {
      if (localArrayList.size() != 0)
        break label133;
      locala = f();
    }
    label133: PushResponse localPushResponse;
    do
    {
      return locala;
      String str = paramArrayOfString[j];
      if ((!MessageSharedPrefs.getInstance(this.e).isTagSet(str)) && (!localArrayList.contains(str)))
        localArrayList.add(str);
      j++;
      break;
      JSONObject localJSONObject = c();
      localJSONObject.put("tags", a(localArrayList));
      fb localfb = new fb(this.e);
      localPushResponse = localfb.a(localfb.a(localJSONObject), MsgConstant.TAG_ENDPOINT + "/add");
      locala = new a(localPushResponse);
      if (localPushResponse == null)
        continue;
      com.umeng.b.a.a.c(a, "addTags: " + localPushResponse.code + ", " + localPushResponse.description);
    }
    while ((localPushResponse == null) || (!localPushResponse.code.equals(PushResponse.responseCode.SUCCESS)));
    MessageSharedPrefs.getInstance(this.e).addTags(paramArrayOfString);
    MessageSharedPrefs.getInstance(this.e).setTagRemain(locala.b);
    return locala;
  }

  public a b(String[] paramArrayOfString)
    throws Exception
  {
    if (e())
      throw new Exception("Tag API is disabled by the server.");
    if (!d())
      throw new Exception("No utdid or device_token");
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      throw new Exception("No tags");
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfString.length;
    int j = 0;
    a locala;
    if (j >= i)
    {
      if (localArrayList.size() != 0)
        break label105;
      locala = f();
    }
    label105: PushResponse localPushResponse;
    do
    {
      return locala;
      localArrayList.add(paramArrayOfString[j]);
      j++;
      break;
      JSONObject localJSONObject = c();
      localJSONObject.put("tags", a(localArrayList));
      fb localfb = new fb(this.e);
      localPushResponse = localfb.a(localfb.a(localJSONObject), MsgConstant.TAG_ENDPOINT + "/update");
      locala = new a(localPushResponse);
      if (localPushResponse == null)
        continue;
      com.umeng.b.a.a.c(a, "addTags: " + localPushResponse.code + ", " + localPushResponse.description);
    }
    while ((localPushResponse == null) || (!localPushResponse.code.equals(PushResponse.responseCode.SUCCESS)));
    MessageSharedPrefs.getInstance(this.e).resetTags();
    MessageSharedPrefs.getInstance(this.e).addTags(paramArrayOfString);
    MessageSharedPrefs.getInstance(this.e).setTagRemain(locala.b);
    return locala;
  }

  public List<String> b()
    throws Exception
  {
    if (e())
      throw new Exception("Tag API is disabled by the server.");
    if (!d())
      throw new Exception("No utdid or device_token");
    JSONObject localJSONObject = c();
    fb localfb = new fb(this.e);
    PushResponse localPushResponse = localfb.a(localfb.a(localJSONObject), MsgConstant.TAG_ENDPOINT + "/get");
    if (localPushResponse != null)
      com.umeng.b.a.a.c(a, "listTags: " + localPushResponse.code + ", " + localPushResponse.description);
    if ((localPushResponse != null) && (localPushResponse.code.equals(PushResponse.responseCode.SUCCESS)) && (localPushResponse.info != null) && (localPushResponse.info.tags != null))
    {
      com.umeng.b.a.a.c(a, localPushResponse.info.tags);
      return Arrays.asList(localPushResponse.info.tags.split(","));
    }
    return null;
  }

  public a c(String[] paramArrayOfString)
    throws Exception
  {
    if (e())
      throw new Exception("Tag API is disabled by the server.");
    if (!d())
      throw new Exception("No utdid or device_token");
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      throw new Exception("No tags");
    JSONObject localJSONObject = c();
    localJSONObject.put("tags", d(paramArrayOfString));
    fb localfb = new fb(this.e);
    PushResponse localPushResponse = localfb.a(localfb.a(localJSONObject), MsgConstant.TAG_ENDPOINT + "/delete");
    a locala = new a(localPushResponse);
    com.umeng.b.a.a.c(a, "removeTags: " + localPushResponse.code + ", " + localPushResponse.description);
    if ((localPushResponse != null) && (localPushResponse.code.equals(PushResponse.responseCode.SUCCESS)))
    {
      MessageSharedPrefs.getInstance(this.e).removeTags(paramArrayOfString);
      MessageSharedPrefs.getInstance(this.e).setTagRemain(locala.b);
    }
    return locala;
  }

  public static class a
  {
    public String a;
    public int b;
    public String c;
    public String d;

    public a(PushResponse paramPushResponse)
    {
      if (paramPushResponse.code.equals(PushResponse.responseCode.SUCCESS))
        this.a = "success";
      while (true)
      {
        if (paramPushResponse.info != null)
          this.b = paramPushResponse.info.tagRemainCount.intValue();
        this.c = paramPushResponse.description;
        this.d = ("status:" + this.a + "," + " remain:" + this.b + "," + "description:" + this.c);
        return;
        if (paramPushResponse.code.equals(PushResponse.responseCode.INVALID_REQUEST))
        {
          this.a = "invalid_request";
          continue;
        }
        if (!paramPushResponse.code.equals(PushResponse.responseCode.SERVER_EXCEPTION))
          continue;
        this.a = "server_exception";
      }
    }

    public a(JSONObject paramJSONObject)
    {
      this.a = paramJSONObject.optString("success", "fail");
      this.b = paramJSONObject.optInt("remain", 0);
      this.c = paramJSONObject.optString("errors");
      this.d = paramJSONObject.toString();
    }

    public String toString()
    {
      return this.d;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.c.a
 * JD-Core Version:    0.6.0
 */