package com.gensee.media;

public class VODPlayer extends GSOLPlayer
{
  public VODPlayer()
  {
    setPlayerType(1);
  }

  public static abstract interface OnVodPlayListener extends GSOLPlayer.OnOLPlayListener
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.VODPlayer
 * JD-Core Version:    0.6.0
 */