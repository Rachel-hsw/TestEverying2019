package com.gensee.entity;

import android.content.Context;
import android.content.Intent;
import com.gensee.utils.GenseeLog;
import java.io.Serializable;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class BaseMsg
  implements Serializable
{
  public static final String GS_ACTION_REC_MSG_BROAD = "gs.action.rec.msg.broad";
  public static final String GS_ACTION_REC_MSG_CHAT = "gs.action.rec.msg.chat";
  public static final String GS_ACTION_REC_MSG_QA = "gs.action.rec.msg.qa";
  public static final String GS_ACTION_REC_MSG_QAHISTROY = "gs.action.rec.msg.qahistroy";
  public static final String GS_ACTION_REC_MSG_VOTE = "gs.action.rec.msg.vote";
  public static final String GS_ACTION_REC_MSG_VOTE_SUBMIT = "gs.action.rec.msg.vote.submit";
  public static final String GS_ACTION_RES_MSG_CAHT_ENABLE = "gs.action.res.msg.chatenable";
  public static final String GS_ACTION_RES_MSG_CAST_STATUS = "gs.action.res.msg.cast.status";
  public static final String GS_ACTION_RES_MSG_DOCPAGE = "gs.action.res.msg.docpage";
  public static final String GS_ACTION_RES_MSG_EJECTED = "gs.action.res.msg.ejected";
  public static final String GS_ACTION_RES_MSG_FETCHPAGE = "gs.action.res.msg.fetchpage";
  public static final String GS_ACTION_RES_MSG_LOTTERY = "gs.action.res.msg.lottery";
  public static final String GS_ACTION_RES_MSG_MUTECHAT = "gs.action.res.msg.mutechat";
  public static final String GS_ACTION_RES_MSG_QA_ENABLE = "gs.action.res.msg.qaenable";
  public static final String GS_ACTION_RES_MSG_RESOURCE = "gs.action.res.msg.resource";
  public static final String GS_ACTION_RES_MSG_ROLLCALL = "gs.action.res.msg.rollcall";
  public static final String GS_ACTION_RES_MSG_THIRD_VOTE = "gs.action.res.msg.third.vote";
  public static final String GS_ACTION_RES_MSG_TXTCAST = "gs.action.res.msg.txtcast";
  public static final String GS_ACTION_RES_MSG_URNUM = "gs.action.res.msg.usernum";
  public static final String GS_ACTION_RES_MSG_USECLIENT = "gs.action.res.msg.useclient";
  public static final String GS_ACTION_RES_MSG_USERNOTIFY = "gs.action.res.msg.usernotify";
  public static final String GS_ACTION_RES_MSG_VIDEOPARAM = "gs.action.res.msg.videoparam";
  public static final String GS_ACTION_VOD_MSG_CHAT = "gs.action.vod.msg.chat";
  public static final String GS_ACTION_VOD_MSG_QAHISTROY = "gs.action.vod.msg.qahistroy";
  public static final String GS_MSG_DATA = "data";
  public static final String MSG_DOC_PAGE = "page";
  public static final String MSG_EMS_CHAT = "chat";
  public static final String MSG_EMS_CHAT_ENABLE = "chatenable";
  public static final String MSG_EMS_CLOSE = "close";
  public static final String MSG_EMS_EJECT = "ejectUser";
  public static final String MSG_EMS_FETCHPAGE = "fetchPage";
  public static final String MSG_EMS_MUTECHAT = "muteChat";
  public static final String MSG_EMS_PAUSE = "pause";
  public static final String MSG_EMS_PUBLICMSG = "publicMsg";
  public static final String MSG_EMS_QA = "qa";
  public static final String MSG_EMS_QAHISTROY = "qahistroy";
  public static final String MSG_EMS_QA_ENABLE = "qaenable";
  public static final String MSG_EMS_RESUME = "resume";
  public static final String MSG_EMS_ROLLCALL = "rollCall";
  public static final String MSG_EMS_USECLIENT = "useClient";
  public static final String MSG_LIVETEXT = "livetext";
  public static final String MSG_LOTTERY = "lottery";
  public static final String MSG_ONROSTERINFOLIST = "onRosterInfolist";
  public static final String MSG_ROSTERINFOHISTROY = "RosterInfoHistroy";
  public static final String MSG_THIRD_VOTE = "thirdsurvey";
  public static final String MSG_USER_NUM = "usernum";
  public static final String MSG_VIDEOPARAM = "videoparam";
  public static final String MSG_VOTE = "vote";
  private static final String TAG = "BaseMsg";
  private static final long serialVersionUID = 413249565778161975L;
  private String module;
  private String type;

  public static boolean getNodeAttrBool(Node paramNode, String paramString)
  {
    String str = getNodeAttrString(paramNode, paramString);
    try
    {
      if (!"true".equalsIgnoreCase(str))
      {
        boolean bool = "1".equals(str);
        if (!bool)
          return false;
      }
      return true;
    }
    catch (Exception localException)
    {
      GenseeLog.e("BaseMsg", localException);
    }
    return false;
  }

  public static int getNodeAttrInt(Node paramNode, String paramString)
  {
    String str = getNodeAttrString(paramNode, paramString);
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException)
    {
      GenseeLog.e("BaseMsg", localException);
    }
    return 0;
  }

  public static long getNodeAttrLong(Node paramNode, String paramString)
  {
    String str = getNodeAttrString(paramNode, paramString);
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException)
    {
      GenseeLog.e("BaseMsg", localException);
    }
    return 0L;
  }

  public static String getNodeAttrString(Node paramNode, String paramString)
  {
    if ((paramNode == null) || (paramString == null))
      return "";
    NamedNodeMap localNamedNodeMap = paramNode.getAttributes();
    if (localNamedNodeMap != null)
    {
      Node localNode = localNamedNodeMap.getNamedItem(paramString);
      if (localNode != null)
        return localNode.getNodeValue();
    }
    return "";
  }

  public String getModule()
  {
    return this.module;
  }

  public String getType()
  {
    return this.type;
  }

  protected String getXml()
  {
    return "";
  }

  protected BaseMsg onXmlNode(Context paramContext, Node paramNode)
  {
    if (paramNode == null)
      this = null;
    return this;
  }

  protected void sendBroadCast(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent(paramString);
      localIntent.putExtra("data", this);
      paramContext.sendBroadcast(localIntent);
    }
  }

  public void setModule(String paramString)
  {
    this.module = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public String toString()
  {
    return "BaseMsg [module=" + this.module + ", type=" + this.type + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.BaseMsg
 * JD-Core Version:    0.6.0
 */