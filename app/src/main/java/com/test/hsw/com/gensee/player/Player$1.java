package com.gensee.player;

import com.gensee.chat.QaMsgQueue;
import com.gensee.entity.UserInfo;
import com.gensee.utils.GenseeLog;
import com.gensee.view.GSChatView;
import com.gensee.vote.OnVoteListener;
import com.gensee.vote.VotePlayerGroup;

class Player$1
  implements NativePlayer.OnNativeListener
{
  public void OnChatWithPersion(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    GenseeLog.d("Player", "OnChatWithPersion userId=" + paramInt1 + " sSendName=" + paramString1 + " text=" + paramString2 + " rich=" + paramString3);
    if (Player.access$2(this.this$0) != null)
      Player.access$2(this.this$0).onChatWithPerson(paramInt1, paramString1, paramString2, paramString3, paramInt2);
  }

  public void OnChatWithPublic(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    GenseeLog.d("Player", "OnChatWithPublic userId=" + paramInt1 + " sSendName=" + paramString1 + " text=" + paramString2 + " rich=" + paramString3);
    if (Player.access$2(this.this$0) != null)
      Player.access$2(this.this$0).onChatWithPublic(paramInt1, paramString1, paramString2, paramString3, paramInt2);
  }

  public void onAudioLevel(int paramInt)
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onAudioLevel(paramInt);
  }

  public void onCaching(boolean paramBoolean)
  {
    GenseeLog.d("Player", "onCaching isCaching = " + paramBoolean);
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onCaching(paramBoolean);
  }

  public void onChatEnable(boolean paramBoolean)
  {
    OnChatListener localOnChatListener;
    if (Player.access$2(this.this$0) != null)
    {
      localOnChatListener = Player.access$2(this.this$0);
      if (!paramBoolean)
        break label32;
    }
    label32: for (boolean bool = false; ; bool = true)
    {
      localOnChatListener.onRoomMute(bool);
      return;
    }
  }

  public void onDocSwitch(int paramInt, String paramString)
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onDocSwitch(paramInt, paramString);
  }

  public void onErr(int paramInt)
  {
    GenseeLog.d("Player", "onErr errCode = " + paramInt);
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onErr(paramInt);
  }

  public void onJoin(int paramInt)
  {
    GenseeLog.d("Player", "onJoin result = " + paramInt);
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onJoin(paramInt);
  }

  public void onLeave(int paramInt)
  {
    GenseeLog.d("Player", "onLeave reason = " + paramInt);
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onLeave(paramInt);
  }

  public void onMute(boolean paramBoolean)
  {
    if (Player.access$2(this.this$0) != null)
      Player.access$2(this.this$0).onMute(paramBoolean);
    if (Player.access$3(this.this$0) != null)
      Player.access$3(this.this$0).onQaMute(paramBoolean);
  }

  public void onPageSize(int paramInt1, int paramInt2, int paramInt3)
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onPageSize(paramInt1, paramInt2, paramInt3);
  }

  public void onPublicMsg(long paramLong, String paramString)
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onPublicMsg(paramLong, paramString);
  }

  public void onPublish(boolean paramBoolean)
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onPublish(paramBoolean);
    if (Player.access$2(this.this$0) != null)
      Player.access$2(this.this$0).onPublish(paramBoolean);
  }

  public void onQa(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (Player.access$3(this.this$0) != null)
      Player.access$3(this.this$0).onQa(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramInt2, paramLong, paramBoolean);
  }

  public void onQaEnable(boolean paramBoolean)
  {
    OnQaListener localOnQaListener;
    if (Player.access$3(this.this$0) != null)
    {
      localOnQaListener = Player.access$3(this.this$0);
      if (!paramBoolean)
        break label32;
    }
    label32: for (boolean bool = false; ; bool = true)
    {
      localOnQaListener.onRoomMute(bool);
      return;
    }
  }

  public void onReconnecting()
  {
    GenseeLog.d("Player", "onReconnecting");
    QaMsgQueue.getIns().release();
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onReconnecting();
    if (Player.access$2(this.this$0) != null)
      Player.access$2(this.this$0).onReconnection();
  }

  public void onRosterTotal(int paramInt)
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onRosterTotal(paramInt);
  }

  public void onSubject(String paramString)
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onSubject(paramString);
  }

  public void onUserJoin(UserInfo paramUserInfo)
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onUserJoin(paramUserInfo);
  }

  public void onUserLeave(UserInfo paramUserInfo)
  {
    if (Player.access$1(this.this$0) != null)
      Player.access$1(this.this$0).updateChatTarget(paramUserInfo, true);
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onUserLeave(paramUserInfo);
  }

  public void onUserUpdate(UserInfo paramUserInfo)
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onUserUpdate(paramUserInfo);
    if (Player.access$1(this.this$0) != null)
      Player.access$1(this.this$0).updateChatTarget(paramUserInfo, false);
  }

  public void onVideoBegin()
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onVideoBegin();
  }

  public void onVideoEnd()
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onVideoEnd();
  }

  public void onVotePublish(VotePlayerGroup paramVotePlayerGroup)
  {
    GenseeLog.d("Player", "onVotePublish voteGroup=" + paramVotePlayerGroup);
    if (Player.access$4(this.this$0) != null)
      Player.access$4(this.this$0).onVotePublish(paramVotePlayerGroup);
  }

  public void onVotePublishResult(VotePlayerGroup paramVotePlayerGroup)
  {
    GenseeLog.d("Player", "onVotePublishResult voteGroup=" + paramVotePlayerGroup);
    if (Player.access$4(this.this$0) != null)
      Player.access$4(this.this$0).onVotePublishResult(paramVotePlayerGroup);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.Player.1
 * JD-Core Version:    0.6.0
 */