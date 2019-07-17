package com.gensee.player;

import android.content.Context;
import com.gensee.chat.MsgQueue;
import com.gensee.chat.QaMsgQueue;
import com.gensee.common.PlayerEnv;
import com.gensee.db.PlayerDataBaseManager;
import com.gensee.entity.InitParam;
import com.gensee.entity.LoginResEntity;
import com.gensee.entity.UserInfo;
import com.gensee.media.AVConfig;
import com.gensee.net.RtmpReq;
import com.gensee.pdu.GSDocView;
import com.gensee.taskret.OnTaskRet;
import com.gensee.utils.GenseeLog;
import com.gensee.view.GSChatView;
import com.gensee.view.GSDocViewGx;
import com.gensee.view.GSQaView;
import com.gensee.view.GSVideoView;
import com.gensee.view.GSVoteView;
import com.gensee.vote.OnVoteListener;
import com.gensee.vote.VotePlayerGroup;

public class Player
  implements IPlayerChat, IPlayerQA, IPlayerVote
{
  protected static final String TAG = "Player";
  private GSChatView mChatView;
  private OnPlayListener mListener;
  private NativePlayer mPlayer = new NativePlayer();
  private OnQaListener mQaListener;
  private GSQaView mQaView;
  private NativePlayer.OnNativeListener nativeCallback = new Player.1(this);
  private OnChatListener onChatListener;
  private RtmpReq req;
  private UserInfo selfInfo;
  private OnVoteListener voteCallback;

  private boolean chat(String paramString1, String paramString2, int paramInt, OnTaskRet paramOnTaskRet)
  {
    return this.mPlayer.chat(paramString1, paramString2, paramInt, paramOnTaskRet);
  }

  private String getHttpAlbAddr(String paramString)
  {
    String str1;
    Object localObject;
    if (paramString != null)
    {
      if (!paramString.contains("tcp://"))
        break label83;
      String str3 = paramString.substring(paramString.indexOf("tcp://") + "tcp://".length());
      str1 = "http://";
      localObject = str3;
    }
    while (true)
    {
      if (localObject != null)
      {
        int i = ((String)localObject).indexOf(':');
        if (i > 0)
          localObject = ((String)localObject).substring(0, i);
      }
      paramString = str1 + (String)localObject;
      return paramString;
      label83: if (paramString.contains("http://"))
      {
        String str2 = paramString.substring(paramString.indexOf("http://") + "http://".length());
        str1 = "http://";
        localObject = str2;
        continue;
      }
      str1 = "";
      localObject = paramString;
    }
  }

  private int getIntValue(String paramString)
  {
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception localException)
    {
      GenseeLog.w(localException.toString());
    }
    return 0;
  }

  private void joinRoom(Context paramContext, LoginResEntity paramLoginResEntity)
  {
    if (paramLoginResEntity == null)
    {
      if (this.mListener != null)
        this.mListener.onJoin(-2);
      GenseeLog.w("joinRoom the info is null");
      return;
    }
    PlayerEnv.init(false, getIntValue(paramLoginResEntity.getServicetype()), AVConfig.getSampleRate(paramContext), new Player.4(this, paramLoginResEntity, paramContext));
  }

  public void audioSet(boolean paramBoolean)
  {
    this.mPlayer.closeAudio(paramBoolean, null);
  }

  public void chatToPersion(int paramInt, String paramString1, String paramString2, OnTaskRet paramOnTaskRet)
  {
    chat(paramString1, paramString2, paramInt, paramOnTaskRet);
  }

  public void chatToPublic(String paramString1, String paramString2, OnTaskRet paramOnTaskRet)
  {
    chat(paramString1, paramString2, 0, paramOnTaskRet);
  }

  public UserInfo getSelfInfo()
  {
    return this.selfInfo;
  }

  public void join(Context paramContext, InitParam paramInitParam, OnPlayListener paramOnPlayListener)
  {
    this.mListener = paramOnPlayListener;
    PlayerDataBaseManager localPlayerDataBaseManager = new PlayerDataBaseManager(paramContext.getApplicationContext());
    MsgQueue.getIns().initMsgDbHelper(localPlayerDataBaseManager);
    QaMsgQueue.getIns().initMsgDbHelper(localPlayerDataBaseManager);
    if (this.req != null)
      this.req.setCallback(null);
    this.req = new RtmpReq(paramContext, new Player.2(this, paramContext));
    this.req.setbAttendeeOnly(true);
    this.req.initWithGensee(paramInitParam);
  }

  public void leave()
  {
    if (this.req != null)
      this.req.setCallback(null);
    this.mPlayer.leave(new Player.3(this));
  }

  public boolean question(String paramString1, String paramString2)
  {
    return this.mPlayer.question(paramString1, paramString2, null);
  }

  public void release(Context paramContext)
  {
    if (this.mChatView != null)
      this.mChatView.release();
    if (this.mQaView != null)
      this.mQaView.release();
    MsgQueue.getIns().clear();
    QaMsgQueue.getIns().clear();
    MsgQueue.getIns().closedb();
    paramContext.deleteDatabase("GsPlayer.db");
    this.mPlayer.release(null);
  }

  public void setGSChatView(GSChatView paramGSChatView)
  {
    if (paramGSChatView != null)
    {
      this.mChatView = paramGSChatView;
      setOnChatListener(paramGSChatView);
      paramGSChatView.setModuleHandle(this);
    }
  }

  public void setGSDocView(GSDocView paramGSDocView)
  {
    this.mPlayer.setGSDocView(paramGSDocView);
  }

  public void setGSDocViewGx(GSDocViewGx paramGSDocViewGx)
  {
    this.mPlayer.setGSDocViewGx(paramGSDocViewGx);
  }

  public void setGSQaView(GSQaView paramGSQaView)
  {
    if (paramGSQaView != null)
    {
      this.mQaView = paramGSQaView;
      paramGSQaView.setModuleHandle(this);
      setOnQaListener(paramGSQaView);
    }
  }

  public void setGSVideoView(GSVideoView paramGSVideoView)
  {
    this.mPlayer.setGSVideoView(paramGSVideoView);
  }

  public void setGSVoteView(GSVoteView paramGSVoteView)
  {
    if (paramGSVoteView != null)
    {
      setOnVoteListener(paramGSVoteView);
      paramGSVoteView.setModuleHandle(this);
    }
  }

  public void setOnChatListener(OnChatListener paramOnChatListener)
  {
    this.onChatListener = paramOnChatListener;
  }

  public void setOnQaListener(OnQaListener paramOnQaListener)
  {
    this.mQaListener = paramOnQaListener;
  }

  public void setOnVoteListener(OnVoteListener paramOnVoteListener)
  {
    this.voteCallback = paramOnVoteListener;
  }

  public void videoSet(boolean paramBoolean)
  {
    this.mPlayer.closeVideo(paramBoolean, null);
  }

  public void voteSubmit(VotePlayerGroup paramVotePlayerGroup)
  {
    if ((paramVotePlayerGroup == null) || (this.selfInfo == null));
    label72: 
    do
    {
      return;
      int i;
      if (paramVotePlayerGroup.isM_bForce())
      {
        boolean bool2 = paramVotePlayerGroup.haveAllAnswer();
        i = 0;
        if (!bool2)
          i = 1;
      }
      while (true)
      {
        if (i == 0)
          break label72;
        if (this.voteCallback == null)
          break;
        this.voteCallback.onVoteSubmitRet(i);
        return;
        boolean bool1 = paramVotePlayerGroup.haveAnswer();
        i = 0;
        if (bool1)
          continue;
        i = 2;
      }
    }
    while (this.mPlayer == null);
    this.mPlayer.voteSubmit(paramVotePlayerGroup, this.selfInfo.getUserId(), this.selfInfo.getName(), null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.Player
 * JD-Core Version:    0.6.0
 */