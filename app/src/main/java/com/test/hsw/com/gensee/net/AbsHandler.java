package com.gensee.net;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.gensee.common.GenseeConfig;
import com.gensee.entity.LoginResEntity;
import com.gensee.entity.MainIdc;
import com.gensee.entity.PingEntity;
import com.gensee.utils.GenseeLog;
import com.gensee.utils.StringUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsHandler
  implements IHttpHandler
{
  protected Context context;
  private OnErrListener errListener;
  protected boolean isBox = false;

  public AbsHandler(Context paramContext)
  {
    this.context = paramContext;
  }

  public static JSONObject converToJson(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString.toString());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      GenseeLog.e(localJSONException);
    }
    return null;
  }

  public static JSONArray getArray(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray(paramString);
      return localJSONArray;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }

  private int getInt(String paramString)
  {
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception localException)
    {
      GenseeLog.w("value = " + paramString);
    }
    return -1;
  }

  public static JSONObject getJSONObj(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray != null)
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(paramInt);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    return null;
  }

  public static JSONObject getJSONObj(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
      try
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        GenseeLog.e("getJSONObj " + localJSONException.toString());
      }
    return null;
  }

  public static JSONArray getJsonArray(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      return localJSONArray;
    }
    catch (JSONException localJSONException)
    {
      GenseeLog.e(localJSONException);
    }
    return null;
  }

  public static int getJsonInt(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      int i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (JSONException localJSONException)
    {
      GenseeLog.e(localJSONException);
    }
    return -1;
  }

  public static long getJsonLong(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      long l = paramJSONObject.getLong(paramString);
      return l;
    }
    catch (JSONException localJSONException)
    {
      GenseeLog.e(localJSONException);
    }
    return 0L;
  }

  public static JSONObject getJsonObj(JSONArray paramJSONArray, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = (JSONObject)paramJSONArray.get(paramInt);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      GenseeLog.d("getJsonObj", localJSONException.toString());
    }
    return null;
  }

  public static String getJsonString(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = "";
    try
    {
      String str = paramJSONObject.getString(paramString);
      localObject = str;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      while ("data".equals(paramString));
      GenseeLog.i("getJsonString name = " + paramString);
      GenseeLog.e(localJSONException);
    }
    return (String)localObject;
  }

  protected static List<PingEntity> getPingArray(JSONArray paramJSONArray)
  {
    ArrayList localArrayList;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
      localArrayList = null;
    while (true)
    {
      return localArrayList;
      int i = paramJSONArray.length();
      localArrayList = new ArrayList();
      for (int j = 0; j < i; j++)
      {
        JSONObject localJSONObject = getJSONObj(paramJSONArray, j);
        if (localJSONObject == null)
          continue;
        PingEntity localPingEntity = new PingEntity();
        localPingEntity.setCode(getJsonString(localJSONObject, "code"));
        localPingEntity.setDescription(getJsonString(localJSONObject, "description"));
        localPingEntity.setId(getJsonString(localJSONObject, "id"));
        localPingEntity.setName(getJsonString(localJSONObject, "name"));
        localPingEntity.setPingUrl(getJsonString(localJSONObject, "pingUrl"));
        localPingEntity.setSupported(getJsonString(localJSONObject, "supported"));
        localArrayList.add(localPingEntity);
      }
    }
  }

  public static boolean is3GOrWifi(Context paramContext)
  {
    return (is4G(paramContext)) || (isWifi(paramContext));
  }

  public static boolean is4G(Context paramContext)
  {
    return isNetConnected(paramContext, 0);
  }

  private static boolean isNetConnected(Context paramContext, int paramInt)
  {
    if (paramContext == null)
      return false;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(paramInt);
    return (localNetworkInfo != null) && (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED);
  }

  public static boolean isWifi(Context paramContext)
  {
    return isNetConnected(paramContext, 1);
  }

  protected static void parseMainIDC(LoginResEntity paramLoginResEntity, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      MainIdc localMainIdc = new MainIdc();
      localMainIdc.setCode(getJsonString(paramJSONObject, "code"));
      paramLoginResEntity.setAblPort(getJsonString(paramJSONObject, "albPort"));
      localMainIdc.setAlbProxyPort(getJsonString(paramJSONObject, "albProxyPort"));
      localMainIdc.setChoosePriorNetwork(getJsonString(paramJSONObject, "choosePriorNetwork"));
      localMainIdc.setDiagnoseUploadUrl(getJsonString(paramJSONObject, "diagnoseUploadUrl"));
      localMainIdc.setPingRequired(getJsonString(paramJSONObject, "pingRequired"));
      localMainIdc.setPingThreshold(getJsonString(paramJSONObject, "pingThreshold"));
      localMainIdc.setPingUrl(getJsonString(paramJSONObject, "pingUrl"));
      localMainIdc.setId(getJsonString(paramJSONObject, "id"));
      paramLoginResEntity.setMainIdc(localMainIdc);
    }
  }

  public boolean is3GOrWifi()
  {
    return is3GOrWifi(this.context);
  }

  public void onConnectError(int paramInt, String paramString)
  {
    sendError("errorconnected", paramInt);
  }

  public void sendBroadCast(String paramString, Serializable paramSerializable)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      Intent localIntent = new Intent(paramString);
      if (paramSerializable != null)
        localIntent.putExtra("responsedata", paramSerializable);
      GenseeLog.d("sendBroadCast", paramString);
      localIntent.putExtra("appname", GenseeConfig.getAppName());
      this.context.sendBroadcast(localIntent);
    }
  }

  public void sendError(String paramString)
  {
    if (this.errListener != null)
    {
      this.errListener.onErr(getInt(paramString));
      return;
    }
    Intent localIntent = new Intent("errorres");
    localIntent.putExtra("responsedata", paramString);
    localIntent.putExtra("appname", GenseeConfig.getAppName());
    GenseeLog.d("sendBroadCast", "errorres " + paramString);
    this.context.sendBroadcast(localIntent);
  }

  public void sendError(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramString);
    localIntent.putExtra("responsedata", paramInt);
    GenseeLog.d("sendBroadCast", paramString);
    localIntent.putExtra("appname", GenseeConfig.getAppName());
    this.context.sendBroadcast(localIntent);
  }

  public void setBox(boolean paramBoolean)
  {
    this.isBox = paramBoolean;
  }

  public void setErrListener(OnErrListener paramOnErrListener)
  {
    this.errListener = paramOnErrListener;
  }

  public static abstract interface OnErrListener
  {
    public abstract void onErr(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.AbsHandler
 * JD-Core Version:    0.6.0
 */