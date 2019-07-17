package com.gensee.entity;

import android.content.Context;
import org.w3c.dom.Node;

public class EmsMsg extends BaseMsg
{
  public static final String ATTR_GROUP = "group";
  public static final String ATTR_SENDER = "sender";
  public static final String ATTR_TIME = "time";
  public static final String ATTR_TYPE = "type";
  public static final String NODE_EMS = "ems";
  private static final long serialVersionUID = -4007680915797488402L;
  private String sender;
  private long senderId;
  private String senderid;

  public EmsMsg()
  {
    setModule("ems");
  }

  public EmsMsg(String paramString)
  {
    setModule("ems");
    setType(paramString);
  }

  public String getSender()
  {
    return this.sender;
  }

  public long getSenderId()
  {
    return this.senderId;
  }

  public String getSenderid()
  {
    return this.senderid;
  }

  protected BaseMsg onXmlNode(Context paramContext, Node paramNode)
  {
    String str = getType();
    if (("pause".equals(str)) || ("resume".equals(str)) || ("close".equals(str)))
    {
      sendBroadCast(paramContext, "gs.action.res.msg.cast.status");
      return this;
    }
    if ("useClient".equals(str))
    {
      this.sender = getNodeAttrString(paramNode, "sender");
      this.senderid = getNodeAttrString(paramNode, "senderid");
      sendBroadCast(paramContext, "gs.action.res.msg.useclient");
      return this;
    }
    return null;
  }

  public void setSender(String paramString)
  {
    this.sender = paramString;
  }

  public void setSenderId(long paramLong)
  {
    this.senderId = paramLong;
  }

  public void setSenderid(String paramString)
  {
    this.senderid = paramString;
  }

  public String toString()
  {
    return "EmsMsg [sender=" + this.sender + ", senderId=" + this.senderId + ", senderid=" + this.senderid + ", " + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.EmsMsg
 * JD-Core Version:    0.6.0
 */