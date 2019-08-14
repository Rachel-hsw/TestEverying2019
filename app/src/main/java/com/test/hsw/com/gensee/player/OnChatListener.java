package com.gensee.player;

public abstract interface OnChatListener
{
  public abstract void onChatWithPerson(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt);

  public abstract void onChatWithPublic(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt);

  public abstract void onMute(boolean paramBoolean);

  public abstract void onPublish(boolean paramBoolean);

  public abstract void onReconnection();

  public abstract void onRoomMute(boolean paramBoolean);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.OnChatListener
 * JD-Core Version:    0.6.0
 */