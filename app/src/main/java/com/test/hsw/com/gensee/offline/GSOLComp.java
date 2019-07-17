package com.gensee.offline;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gensee.common.PlayerEnv;
import com.gensee.common.PlayerEnv.IProxy;
import com.gensee.common.ServiceType;
import com.gensee.entity.AccVodResEntity;
import com.gensee.entity.ChatMsg;
import com.gensee.entity.InitParam;
import com.gensee.entity.QAMsg;
import com.gensee.entity.VodParam;
import com.gensee.entity.VodPlayParam;
import com.gensee.entity.VoteMsg;
import com.gensee.media.AVConfig;
import com.gensee.net.AbsHttpAction;
import com.gensee.net.IHttpHandler;
import com.gensee.net.VodHttpHandler;
import com.gensee.taskret.OnTaskRet;
import com.gensee.utils.GenseeLog;
import com.gensee.utils.StringUtil;
import com.gensee.vod.VodMr;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class GSOLComp extends AbsHttpAction
{
  private static final String ACCESSVOD = "http://%s/%s/site/accessVodInfo";
  private static final String CHAT_HISTORY = "<?xml version=\"1.0\" encoding=\"utf-8\"?><chatHistory live=\"false\" confid=\"%s\" userid=\"%s\" siteid=\"%s\" page=\"%d\"/>";
  protected static final String CLIENTAPI = "http://%s/clientapi/apichannel?sc=";
  private static final String LOGINVOD = "http://%s/%s/site/loginVod";
  private static final String QA_HISTORY = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><qaHistory live=\"false\" confid=\"%s\" userid=\"%s\" siteid=\"%s\" page=\"%d\"/>";
  private static final String RESULT_OK = "<result>ok</result>";
  public static final String SP_ALB_ADDRESS = "albAddress";
  public static final String SP_NAME = "gsol";
  public static final String SP_SERVICE_TYPE = "serviceType";
  public static final String SP_SITE_ID = "siteId";
  public static final String SP_USER_ID = "userId";
  public static final String SP_USER_NAME = "userName";
  private static final String TAG = "GSOLComp";
  protected static final String XMLAPI = "http://%s/xmlapi/apichannel";
  private Context context;
  private boolean isFromVodSite = false;
  private OnVodListener mListener;
  private InitParam vodParam;

  public GSOLComp(Context paramContext)
  {
    this(paramContext, false);
  }

  public GSOLComp(Context paramContext, boolean paramBoolean)
  {
    this(new VodHttpHandler(paramContext), paramBoolean);
    this.isFromVodSite = paramBoolean;
    this.context = paramContext;
  }

  private GSOLComp(IHttpHandler paramIHttpHandler, boolean paramBoolean)
  {
    super(paramIHttpHandler);
    if (paramBoolean)
      ((VodHttpHandler)paramIHttpHandler).setErrListener(new GSOLComp.1(this));
  }

  private void accessVod(InitParam paramInitParam)
  {
    if ((paramInitParam != null) && (paramInitParam.isValid()))
    {
      this.vodParam = paramInitParam;
      String str = paramInitParam.getLiveId();
      if (!StringUtil.isEmpty(str))
      {
        loginVod(str);
        return;
      }
      accessVod(paramInitParam.getVodDomain(), paramInitParam.getVodNumber(), paramInitParam.getVodSType());
      return;
    }
    GenseeLog.e("GSOLComp", "vodParam is invalid!");
    this.mHttpHandler.onErr(102);
  }

  private void accessVod(String paramString1, String paramString2, ServiceType paramServiceType)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramServiceType.getValue();
    String str = String.format("http://%s/%s/site/accessVodInfo", arrayOfObject);
    String[] arrayOfString = paramString1.split(":");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
      paramString1 = arrayOfString[0];
    doPostRequest(str, "number=" + paramString2 + "&domain=" + paramString1, new GSOLComp.5(this));
  }

  public static void destroyOfflineComp()
  {
    PlayerEnv.release();
  }

  private void getChatHistory(String paramString, VodParam paramVodParam, int paramInt)
  {
    if (StringUtil.isEmpty(paramString));
    for (String str1 = paramVodParam.getVodId(); ; str1 = paramString)
    {
      String str2 = "http://%s/clientapi/apichannel?sc=" + paramVodParam.getSc();
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramVodParam.getDomain();
      String str3 = String.format(str2, arrayOfObject1);
      Object[] arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = str1;
      arrayOfObject2[1] = paramVodParam.getUserId();
      arrayOfObject2[2] = paramVodParam.getSiteId();
      arrayOfObject2[3] = Integer.valueOf(paramInt);
      doPostRequest(str3, String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?><chatHistory live=\"false\" confid=\"%s\" userid=\"%s\" siteid=\"%s\" page=\"%d\"/>", arrayOfObject2), new GSOLComp.4(this, str1, paramInt, paramString, paramVodParam));
      return;
    }
  }

  private void getQAList(String paramString, VodParam paramVodParam, boolean paramBoolean, int paramInt)
  {
    if (StringUtil.isEmpty(paramString))
      paramString = paramVodParam.getVodId();
    String str1 = paramVodParam.getDomain();
    String str2 = String.format("http://%s/clientapi/apichannel?sc=" + paramVodParam.getSc(), new Object[] { str1 });
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = paramVodParam.getUserId();
    arrayOfObject[2] = paramVodParam.getSiteId();
    arrayOfObject[3] = Integer.valueOf(paramInt);
    doPostRequest(str2, String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><qaHistory live=\"false\" confid=\"%s\" userid=\"%s\" siteid=\"%s\" page=\"%d\"/>", arrayOfObject), new GSOLComp.3(this, paramBoolean, paramString));
  }

  private void getRecord(VodParam paramVodParam)
  {
    String str = paramVodParam.getXmlUrl();
    if (StringUtil.isEmpty(str))
    {
      this.mHttpHandler.onVodInitEnd(paramVodParam);
      return;
    }
    getStream(str, new GSOLComp.7(this, paramVodParam));
  }

  public static boolean initOfflineComp(Context paramContext, OnTaskRet paramOnTaskRet)
  {
    VodMr.getIns().initCachDir(paramContext);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("gsol", 0);
    int i = AVConfig.getSampleRate(paramContext);
    long l = localSharedPreferences.getLong("userId", 0L);
    String str = localSharedPreferences.getString("albAddress", "");
    int j = localSharedPreferences.getInt("serviceType", 0);
    if ((l == 0L) || ("".equals(str)))
      GenseeLog.w("initOfflineComp fail that no source");
    if ((!"".equals(str)) && (!str.contains("http://")))
      new StringBuilder("http://").append(str).toString();
    return PlayerEnv.init(true, j, i, paramOnTaskRet);
  }

  private void loginVod(String paramString)
  {
    loginVod(paramString, this.vodParam.getVodDomain(), this.vodParam.getVodLoginName(), this.vodParam.getVodLoginPwd(), this.vodParam.getVodNickName(), this.vodParam.getVodPwd(), this.vodParam.getVodSType());
  }

  private void loginVod(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ServiceType paramServiceType)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString2;
    arrayOfObject[1] = paramServiceType.getValue();
    String str1 = String.format("http://%s/%s/site/loginVod", arrayOfObject);
    Object localObject2;
    label41: Object localObject1;
    if (paramString3 == null)
    {
      localObject2 = "";
      paramString3 = (String)localObject2;
      if (paramString5 != null)
        break label181;
      localObject1 = "";
    }
    while (true)
    {
      while (true)
      {
        StringBuilder localStringBuilder1 = new StringBuilder("vodId=").append(paramString1).append("&loginPassword=");
        if (paramString4 == null)
          paramString4 = "";
        StringBuilder localStringBuilder2 = localStringBuilder1.append(paramString4).append("&password=");
        if (paramString6 == null)
          paramString6 = "";
        doPostRequest(str1, paramString6 + "&loginName=" + paramString3 + "&nickName=" + (String)localObject1, new GSOLComp.6(this, paramString2));
        return;
        try
        {
          String str3 = URLEncoder.encode(paramString3, "utf-8");
          localObject2 = str3;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          localUnsupportedEncodingException1.printStackTrace();
        }
      }
      break label41;
      try
      {
        label181: String str2 = URLEncoder.encode(paramString5, "utf-8");
        localObject1 = str2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        localUnsupportedEncodingException2.printStackTrace();
        localObject1 = paramString5;
      }
    }
  }

  private void onChatHistory(String paramString, List<ChatMsg> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.mListener != null)
      this.mListener.onChatHistory(paramString, paramList, paramInt, paramBoolean);
  }

  private void saveSource(VodParam paramVodParam)
  {
    SharedPreferences.Editor localEditor = this.context.getSharedPreferences("gsol", 0).edit();
    try
    {
      String str = paramVodParam.getConnectSvr();
      if ((str != null) && (!"".equals(str)) && (!str.contains("http://")))
        str = "http://" + str;
      localEditor.putLong("siteId", Long.valueOf(paramVodParam.getSiteId()).longValue());
      localEditor.putLong("userId", Long.valueOf(paramVodParam.getUserId()).longValue());
      localEditor.putString("userName", paramVodParam.getNickName());
      localEditor.putString("albAddress", str);
      ServiceType localServiceType1 = this.vodParam.getServiceType();
      ServiceType localServiceType2 = ServiceType.ST_TRAINING;
      int i = 0;
      if (localServiceType1 == localServiceType2)
        i = 1;
      localEditor.putInt("serviceType", i);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        GenseeLog.w("saveSource " + localException.toString());
    }
  }

  public static void setTcpProxy(PlayerEnv.IProxy paramIProxy)
  {
    PlayerEnv.setTcpProxy(paramIProxy);
  }

  private int submitVote(String paramString1, String paramString2)
  {
    doPostRequest(String.format("http://%s/xmlapi/apichannel", new Object[] { paramString1 }), paramString2, new GSOLComp.2(this));
    return -1;
  }

  public int answerVote(Context paramContext, VodPlayParam paramVodPlayParam, VoteMsg paramVoteMsg)
  {
    if ((paramVodPlayParam == null) || (paramVoteMsg == null))
      return -1;
    VodParam localVodParam = (VodParam)paramVodPlayParam;
    paramVoteMsg.setConfId(localVodParam.getVodId());
    paramVoteMsg.settId(localVodParam.getTid());
    paramVoteMsg.setUserId(localVodParam.getUserId());
    paramVoteMsg.setSiteId(localVodParam.getSiteId());
    paramVoteMsg.setName(localVodParam.getNickName());
    return submitVote(localVodParam.getDomain(), paramVoteMsg.getData());
  }

  public void getChatHistory(VodParam paramVodParam, int paramInt)
  {
    if (paramVodParam == null)
    {
      GenseeLog.w("getChatHistory vodParam is null");
      return;
    }
    getChatHistory(null, paramVodParam, paramInt);
  }

  public void getQaHistory(VodParam paramVodParam, int paramInt)
  {
    if (paramVodParam == null)
    {
      GenseeLog.w("getQaHistory vodParam is null");
      return;
    }
    getQAList(null, paramVodParam, false, paramInt);
  }

  public void initVod(InitParam paramInitParam)
  {
    accessVod(paramInitParam);
  }

  protected void onAccessResult(AccVodResEntity paramAccVodResEntity)
  {
    if (paramAccVodResEntity != null)
      loginVod(paramAccVodResEntity.getVodId());
  }

  public void setBox(boolean paramBoolean)
  {
    ((VodHttpHandler)this.mHttpHandler).setBox(true);
  }

  public void setVodListener(OnVodListener paramOnVodListener)
  {
    this.mListener = paramOnVodListener;
  }

  public static abstract interface OnVodListener
  {
    public abstract void onChatHistory(String paramString, List<ChatMsg> paramList, int paramInt, boolean paramBoolean);

    public abstract void onOlErr(int paramInt);

    public abstract void onQaHistory(String paramString, List<QAMsg> paramList, int paramInt, boolean paramBoolean);

    public abstract void onVodInited(VodParam paramVodParam);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.offline.GSOLComp
 * JD-Core Version:    0.6.0
 */