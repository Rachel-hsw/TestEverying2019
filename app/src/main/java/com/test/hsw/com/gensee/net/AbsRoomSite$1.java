package com.gensee.net;

import android.content.Context;
import com.gensee.entity.AccessResEntity;
import com.gensee.entity.LoginResEntity;
import com.gensee.report.ReportInfo;
import com.gensee.utils.GenseeLog;
import org.json.JSONObject;

class AbsRoomSite$1 extends AbsRtHandler
{
  protected AccessResEntity onAccessInfoRes(String paramString)
  {
    int i = 1;
    JSONObject localJSONObject = AbsHandler.converToJson(paramString);
    int j;
    AccessResEntity localAccessResEntity;
    if (localJSONObject != null)
    {
      j = AbsHandler.getJsonInt(localJSONObject, "result");
      if (i == j)
      {
        if ((!this.isBox) && (localJSONObject.has("ipad")))
          i = "true".equalsIgnoreCase(AbsHandler.getJsonString(localJSONObject, "ipad"));
        if (i == 0)
        {
          this.this$0.onErr(18);
          return null;
        }
        localAccessResEntity = new AccessResEntity();
        String str1 = AbsHandler.getJsonString(localJSONObject, "webcastId");
        String str2 = AbsHandler.getJsonString(localJSONObject, "login");
        String str3 = AbsHandler.getJsonString(localJSONObject, "watchword");
        String str4 = AbsHandler.getJsonString(localJSONObject, "subject");
        String str5 = "false";
        if (localJSONObject.has("webonly"))
          str5 = AbsHandler.getJsonString(localJSONObject, "webonly");
        long l = AbsHandler.getJsonLong(localJSONObject, "startTime");
        boolean bool1 = localJSONObject.has("liveEnable");
        boolean bool2 = false;
        if (bool1)
          bool2 = "true".equalsIgnoreCase(AbsHandler.getJsonString(localJSONObject, "liveEnable"));
        localAccessResEntity.setWebcastId(str1);
        localAccessResEntity.setLoginTag(str2);
        localAccessResEntity.setWatchword(str3);
        localAccessResEntity.setSubject(str4);
        localAccessResEntity.setResult(j);
        localAccessResEntity.setWebOnly(str5);
        localAccessResEntity.setStartTime(l);
        localAccessResEntity.setLiveEnable(bool2);
        if ("1".equals(str5))
          this.this$0.onErr(7);
      }
    }
    while (true)
    {
      return null;
      return localAccessResEntity;
      if (j == 0)
      {
        this.this$0.onErr(0);
        continue;
      }
      if (3 == j)
      {
        this.this$0.onErr(8);
        continue;
      }
      this.this$0.onErr(j);
      continue;
      this.this$0.onErr(-1);
    }
  }

  protected AccessResEntity onAccessUrlInfoRes(String paramString)
  {
    return null;
  }

  protected void onError(int paramInt, String paramString)
  {
    this.this$0.onErr(paramInt);
  }

  protected void onLoginFinish(Object paramObject)
  {
    LoginResEntity localLoginResEntity = (LoginResEntity)paramObject;
    if ((GenseeLog.isInited()) && (GenseeLog.reportInfo != null))
      GenseeLog.reportInfo.setLoginEntityInfo(localLoginResEntity);
    localLoginResEntity.setUserData(AbsRoomSite.access$0(this.this$0));
    this.this$0.onLoginEnd(localLoginResEntity);
  }

  protected LoginResEntity onLoginInfoRes(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject = AbsHandler.converToJson(paramString);
    if (localJSONObject != null)
    {
      int i = AbsHandler.getJsonInt(localJSONObject, "result");
      if (1 == i)
      {
        LoginResEntity localLoginResEntity = new LoginResEntity();
        localLoginResEntity.setResult(i);
        localLoginResEntity.setSiteId(AbsHandler.getJsonLong(localJSONObject, "siteId"));
        localLoginResEntity.setUserId(AbsHandler.getJsonLong(localJSONObject, "userId"));
        localLoginResEntity.setWebcastId(AbsHandler.getJsonString(localJSONObject, "webcastId"));
        localLoginResEntity.setWebcastSubject(AbsHandler.getJsonString(localJSONObject, "webcastSubject"));
        localLoginResEntity.setServicetype(AbsHandler.getJsonString(localJSONObject, "servicetype"));
        localLoginResEntity.setIpowner(AbsHandler.getJsonString(localJSONObject, "ipowner"));
        localLoginResEntity.setConfpassword(AbsHandler.getJsonString(localJSONObject, "confpassword"));
        localLoginResEntity.setResponsetype(AbsHandler.getJsonString(localJSONObject, "responsetype"));
        localLoginResEntity.setJoinType(AbsHandler.getJsonString(localJSONObject, "joinType"));
        localLoginResEntity.setNickName(AbsHandler.getJsonString(localJSONObject, "nickName"));
        localLoginResEntity.setMainIdcCode(AbsHandler.getJsonString(localJSONObject, "mainIdcCode"));
        localLoginResEntity.setAlbServer(AbsHandler.getJsonString(localJSONObject, "ablServer"));
        localLoginResEntity.setWebUrl(AbsHandler.getJsonString(localJSONObject, "webUrl"));
        localLoginResEntity.setIsNeedVisitALB(AbsHandler.getJsonString(localJSONObject, "isNeedVisitALB"));
        localLoginResEntity.setChoosePriorNetwork(AbsHandler.getJsonString(localJSONObject, "choosePriorNetwork"));
        localLoginResEntity.setIpLibEnabled(AbsHandler.getJsonString(localJSONObject, "ipLibEnabled"));
        localLoginResEntity.setGcDomain(AbsHandler.getJsonString(localJSONObject, "gcDomain"));
        localLoginResEntity.setGcPort(AbsHandler.getJsonString(localJSONObject, "gcPort"));
        localLoginResEntity.setPingArray(AbsHandler.getPingArray(AbsHandler.getArray(localJSONObject, "array")));
        localLoginResEntity.setSiteId(AbsHandler.getJsonLong(localJSONObject, "siteId"));
        localLoginResEntity.setUserId(AbsHandler.getJsonLong(localJSONObject, "userId"));
        localLoginResEntity.setWebcastId(AbsHandler.getJsonString(localJSONObject, "webcastId"));
        localLoginResEntity.setWebcastSubject(AbsHandler.getJsonString(localJSONObject, "webcastSubject"));
        localLoginResEntity.setServicetype(AbsHandler.getJsonString(localJSONObject, "servicetype"));
        localLoginResEntity.setIpowner(AbsHandler.getJsonString(localJSONObject, "ipowner"));
        localLoginResEntity.setConfpassword(AbsHandler.getJsonString(localJSONObject, "confpassword"));
        localLoginResEntity.setResponsetype(AbsHandler.getJsonString(localJSONObject, "responsetype"));
        localLoginResEntity.setJoinType(AbsHandler.getJsonString(localJSONObject, "joinType"));
        localLoginResEntity.setNickName(AbsHandler.getJsonString(localJSONObject, "nickName"));
        localLoginResEntity.setMainIdcCode(AbsHandler.getJsonString(localJSONObject, "mainIdcCode"));
        localLoginResEntity.setAlbServer(AbsHandler.getJsonString(localJSONObject, "ablServer"));
        localLoginResEntity.setWebUrl(AbsHandler.getJsonString(localJSONObject, "webUrl"));
        localLoginResEntity.setIsNeedVisitALB(AbsHandler.getJsonString(localJSONObject, "isNeedVisitALB"));
        localLoginResEntity.setIpLibEnabled(AbsHandler.getJsonString(localJSONObject, "ipLibEnabled"));
        localLoginResEntity.setGcDomain(AbsHandler.getJsonString(localJSONObject, "gcDomain"));
        localLoginResEntity.setGcPort(AbsHandler.getJsonString(localJSONObject, "gcPort"));
        localLoginResEntity.setPingArray(AbsHandler.getPingArray(AbsHandler.getArray(localJSONObject, "array")));
        AbsHandler.parseMainIDC(localLoginResEntity, AbsHandler.getJSONObj(localJSONObject, "mainIDC"));
        return localLoginResEntity;
      }
      if (paramBoolean)
        this.this$0.onErr(i);
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.AbsRoomSite.1
 * JD-Core Version:    0.6.0
 */