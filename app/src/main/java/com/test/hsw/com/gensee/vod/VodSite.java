package com.gensee.vod;

import android.content.Context;
import com.gensee.common.GenseeConstant.CommonErrCode;
import com.gensee.common.PlayerEnv;
import com.gensee.common.PlayerEnv.IProxy;
import com.gensee.entity.ChatMsg;
import com.gensee.entity.InitParam;
import com.gensee.entity.QAMsg;
import com.gensee.entity.VodObject;
import com.gensee.entity.VodParam;
import com.gensee.entity.VoteMsg;
import com.gensee.offline.GSOLComp;
import com.gensee.offline.GSOLComp.OnVodListener;
import com.gensee.taskret.OnTaskRet;
import com.gensee.utils.GenseeLog;
import com.gensee.utils.StringUtil;
import java.util.List;

public class VodSite
  implements GSOLComp.OnVodListener
{
  private GSOLComp mComp;
  private OnVodListener mListener;

  public VodSite(Context paramContext)
  {
    this.mComp = new GSOLComp(paramContext, true);
    this.mComp.setVodListener(this);
  }

  public static boolean init(Context paramContext, OnTaskRet paramOnTaskRet)
  {
    return GSOLComp.initOfflineComp(paramContext, paramOnTaskRet);
  }

  public static void release()
  {
    GSOLComp.destroyOfflineComp();
  }

  public static void setTcpProxy(PlayerEnv.IProxy paramIProxy)
  {
    PlayerEnv.setTcpProxy(paramIProxy);
  }

  public int answerVote(Context paramContext, String paramString, VoteMsg paramVoteMsg)
  {
    VodObject localVodObject = (VodObject)VodMr.getIns().getVodObjById(paramString);
    if (localVodObject == null)
      return -1;
    return this.mComp.answerVote(paramContext, localVodObject, paramVoteMsg);
  }

  public void getChatHistory(String paramString)
  {
    getChatHistory(paramString, 1);
  }

  public void getChatHistory(String paramString, int paramInt)
  {
    VodObject localVodObject = (VodObject)VodMr.getIns().getVodObjById(paramString);
    if (localVodObject != null)
      this.mComp.getChatHistory(localVodObject, paramInt);
    do
      return;
    while (this.mListener == null);
    this.mListener.onVodErr(-201);
  }

  public void getQaHistory(String paramString, int paramInt)
  {
    VodObject localVodObject = (VodObject)VodMr.getIns().getVodObjById(paramString);
    if (localVodObject != null)
      this.mComp.getQaHistory(localVodObject, paramInt);
    do
      return;
    while (this.mListener == null);
    this.mListener.onVodErr(-201);
  }

  public void getVodDetail(String paramString)
  {
    VodObject localVodObject = (VodObject)VodMr.getIns().getVodObjById(paramString);
    if ((localVodObject == null) || (StringUtil.isEmpty(localVodObject.getXmlUrl())))
    {
      if (this.mListener != null)
        this.mListener.onVodErr(-201);
      return;
    }
    GSOLComp.getStream(localVodObject.getXmlUrl(), new VodSite.1(this, localVodObject));
  }

  public void getVodObject(InitParam paramInitParam)
  {
    this.mComp.initVod(paramInitParam);
  }

  public void onChatHistory(String paramString, List<ChatMsg> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.mListener != null)
      this.mListener.onChatHistory(paramString, paramList, paramInt, paramBoolean);
  }

  public void onOlErr(int paramInt)
  {
    if (this.mListener != null)
      this.mListener.onVodErr(paramInt);
  }

  public void onQaHistory(String paramString, List<QAMsg> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.mListener != null)
      this.mListener.onQaHistory(paramString, paramList, paramInt, paramBoolean);
  }

  public void onVodInited(VodParam paramVodParam)
  {
    StringBuilder localStringBuilder = new StringBuilder("vodId = ");
    if (paramVodParam == null);
    for (String str = ""; ; str = paramVodParam.getVodId())
    {
      GenseeLog.d("onVodInited", str);
      if (this.mListener != null)
      {
        VodMr.getIns().putVodObj((VodObject)paramVodParam);
        this.mListener.onVodObject(paramVodParam.getVodId());
      }
      return;
    }
  }

  public void setBox(boolean paramBoolean)
  {
    this.mComp.setBox(paramBoolean);
  }

  public void setVodListener(OnVodListener paramOnVodListener)
  {
    this.mListener = paramOnVodListener;
  }

  public static abstract interface OnVodListener extends GenseeConstant.CommonErrCode
  {
    public static final int ERR_UNSURPORT_MOBILE = 18;
    public static final int ERR_UN_INVOKE_GETOBJECT = -201;
    public static final int ERR_VOD_ACC_PWD_ERR = 17;
    public static final int ERR_VOD_INTI_FAIL = 14;
    public static final int ERR_VOD_NUM_UNEXIST = 15;
    public static final int ERR_VOD_PWD_ERR = 16;

    public abstract void onChatHistory(String paramString, List<ChatMsg> paramList, int paramInt, boolean paramBoolean);

    public abstract void onQaHistory(String paramString, List<QAMsg> paramList, int paramInt, boolean paramBoolean);

    public abstract void onVodDetail(VodObject paramVodObject);

    public abstract void onVodErr(int paramInt);

    public abstract void onVodObject(String paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vod.VodSite
 * JD-Core Version:    0.6.0
 */