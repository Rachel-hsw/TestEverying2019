package com.gensee.net;

import android.content.Context;
import com.gensee.entity.AccVodResEntity;
import com.gensee.entity.AccessResEntity;
import com.gensee.entity.LoginResEntity;
import com.gensee.entity.VodObject;
import com.gensee.entity.VodParam;
import java.io.Serializable;
import org.json.JSONObject;

public class VodHttpHandler extends AbsHandler
{
  public VodHttpHandler(Context paramContext)
  {
    super(paramContext);
  }

  public AccessResEntity onAccessInfoRes(String paramString)
  {
    return null;
  }

  public AccessResEntity onAccessUrlInfoRes(String paramString)
  {
    JSONObject localJSONObject = converToJson(paramString);
    if (localJSONObject != null)
    {
      String str1 = getJsonString(localJSONObject, "result");
      if ("1".equals(str1))
      {
        AccessResEntity localAccessResEntity = new AccessResEntity();
        String str2 = getJsonString(localJSONObject, "webcastId");
        String str3 = getJsonString(localJSONObject, "login");
        String str4 = getJsonString(localJSONObject, "watchword");
        String str5 = getJsonString(localJSONObject, "subject");
        String str6 = getJsonString(localJSONObject, "reason");
        String str7 = getJsonString(localJSONObject, "code");
        long l = getJsonLong(localJSONObject, "startTime");
        localAccessResEntity.setWebcastId(str2);
        localAccessResEntity.setLoginTag(str3);
        localAccessResEntity.setWatchword(str4);
        localAccessResEntity.setSubject(str5);
        localAccessResEntity.setResult(str1);
        localAccessResEntity.setReason(str6);
        localAccessResEntity.setCode(str7);
        localAccessResEntity.setStartTime(l);
        sendBroadCast("accessurlinfores", localAccessResEntity);
        return localAccessResEntity;
      }
      sendError(str1);
    }
    return null;
  }

  public AccVodResEntity onAccessVod(String paramString)
  {
    int i = 1;
    JSONObject localJSONObject = converToJson(paramString);
    String str1;
    if (localJSONObject != null)
    {
      str1 = getJsonString(localJSONObject, "result");
      if (!"1".equals(str1))
        break label143;
      if ((!this.isBox) && (localJSONObject.has("ipad")))
      {
        String str2 = getJsonString(localJSONObject, "ipad");
        if ((!"true".equals(str2)) && (!"TRUE".equals(str2)))
          i = 0;
      }
      if (i != 0)
      {
        AccVodResEntity localAccVodResEntity = new AccVodResEntity();
        localAccVodResEntity.setLoginRequired(getJsonString(localJSONObject, "loginRequired"));
        localAccVodResEntity.setPwdRequired(getJsonString(localJSONObject, "pwdRequired"));
        localAccVodResEntity.setSubject(getJsonString(localJSONObject, "subject"));
        localAccVodResEntity.setVodId(getJsonString(localJSONObject, "vodId"));
        return localAccVodResEntity;
      }
      sendError("18");
    }
    while (true)
    {
      return null;
      label143: if ("2".equals(str1))
      {
        sendError("15");
        continue;
      }
      sendError("14");
    }
  }

  public Object onAlbRes(String paramString)
  {
    return null;
  }

  public void onErr(int paramInt)
  {
  }

  public Object onJoinRes(String paramString)
  {
    return null;
  }

  public Object onKeepLive(String paramString)
  {
    return null;
  }

  public void onLoginFinish(Serializable paramSerializable)
  {
  }

  public LoginResEntity onLoginInfoRes(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject = converToJson(paramString);
    if (localJSONObject != null)
    {
      String str = getJsonString(localJSONObject, "result");
      if ("".equals(str))
        str = "1";
      if ("1".equals(str))
      {
        LoginResEntity localLoginResEntity = new LoginResEntity();
        localLoginResEntity.setResult(str);
        localLoginResEntity.setSiteId(getJsonLong(localJSONObject, "siteId"));
        localLoginResEntity.setUserId(getJsonLong(localJSONObject, "userId"));
        localLoginResEntity.setWebcastId(getJsonString(localJSONObject, "webcastId"));
        localLoginResEntity.setWebcastSubject(getJsonString(localJSONObject, "webcastSubject"));
        localLoginResEntity.setServicetype(getJsonString(localJSONObject, "servicetype"));
        localLoginResEntity.setIpowner(getJsonString(localJSONObject, "ipowner"));
        localLoginResEntity.setConfpassword(getJsonString(localJSONObject, "confpassword"));
        localLoginResEntity.setResponsetype(getJsonString(localJSONObject, "responsetype"));
        localLoginResEntity.setJoinType(getJsonString(localJSONObject, "joinType"));
        localLoginResEntity.setNickName(getJsonString(localJSONObject, "nickName"));
        localLoginResEntity.setMainIdcCode(getJsonString(localJSONObject, "mainIdcCode"));
        localLoginResEntity.setAlbServer(getJsonString(localJSONObject, "ablServer"));
        localLoginResEntity.setWebUrl(getJsonString(localJSONObject, "webUrl"));
        return localLoginResEntity;
      }
      sendError(str);
    }
    return null;
  }

  public VodParam onLoginVod(String paramString)
  {
    JSONObject localJSONObject = converToJson(paramString);
    String str;
    if (localJSONObject != null)
    {
      str = getJsonString(localJSONObject, "result");
      if ("".equals(str))
        str = "1";
      if ("1".equals(str))
      {
        VodObject localVodObject = new VodObject();
        localVodObject.setResult(str);
        localVodObject.setAlbPort(getJsonString(localJSONObject, "albPort"));
        localVodObject.setConnectSvr(getJsonString(localJSONObject, "connectSvr"));
        localVodObject.setNickName(getJsonString(localJSONObject, "nickName"));
        localVodObject.setSiteId(getJsonString(localJSONObject, "siteId"));
        localVodObject.setTid(getJsonString(localJSONObject, "tid"));
        localVodObject.setUserId(getJsonString(localJSONObject, "userId"));
        localVodObject.setVodId(getJsonString(localJSONObject, "vodId"));
        localVodObject.setVodSubject(getJsonString(localJSONObject, "vodSubject"));
        localVodObject.setXmlUrl(getJsonString(localJSONObject, "xmlUrl"));
        localVodObject.setSc(getJsonInt(localJSONObject, "sc"));
        return localVodObject;
      }
      if ("4".equals(str))
        sendError("16");
    }
    while (true)
    {
      return null;
      if ("7".equals(str))
      {
        sendError("17");
        continue;
      }
      sendError("14");
      continue;
      sendError("14");
    }
  }

  public void onVodInitEnd(Serializable paramSerializable)
  {
    sendBroadCast("gsvodinitres", paramSerializable);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.VodHttpHandler
 * JD-Core Version:    0.6.0
 */