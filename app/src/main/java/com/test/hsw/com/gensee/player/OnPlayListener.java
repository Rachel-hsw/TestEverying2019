package com.gensee.player;

import com.gensee.entity.UserInfo;

public abstract interface OnPlayListener
{
  public static final int JOIN_CONNECTING = 7;
  public static final int JOIN_CONNECT_FAILED = 8;
  public static final int JOIN_CONNECT_TIMEOUT = 9;
  public static final int JOIN_LICENSE = 12;
  public static final int JOIN_OK = 6;
  public static final int JOIN_RTMP_FAILED = 10;
  public static final int JOIN_TOO_EARLY = 11;
  public static final int LEAVE_CLOSE = 4;
  public static final int LEAVE_KICKOUT = 2;
  public static final int LEAVE_NORMAL = 1;
  public static final int LEAVE_TIMEOUT = 3;
  public static final int LEAVE_UNKNOWN = 5;

  public abstract void onAudioLevel(int paramInt);

  public abstract void onCaching(boolean paramBoolean);

  public abstract void onDocSwitch(int paramInt, String paramString);

  public abstract void onErr(int paramInt);

  public abstract void onJoin(int paramInt);

  public abstract void onLeave(int paramInt);

  public abstract void onPageSize(int paramInt1, int paramInt2, int paramInt3);

  public abstract void onPublicMsg(long paramLong, String paramString);

  public abstract void onPublish(boolean paramBoolean);

  public abstract void onReconnecting();

  public abstract void onRosterTotal(int paramInt);

  public abstract void onSubject(String paramString);

  public abstract void onUserJoin(UserInfo paramUserInfo);

  public abstract void onUserLeave(UserInfo paramUserInfo);

  public abstract void onUserUpdate(UserInfo paramUserInfo);

  public abstract void onVideoBegin();

  public abstract void onVideoEnd();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.OnPlayListener
 * JD-Core Version:    0.6.0
 */