package org.android.spdy;

public abstract interface SessionCb
{
  public abstract void spdyPingRecvCallback(SpdySession paramSpdySession, long paramLong, Object paramObject);

  public abstract void spdySessionCloseCallback(SpdySession paramSpdySession, Object paramObject, SuperviseConnectInfo paramSuperviseConnectInfo, int paramInt);

  public abstract void spdySessionConnectCB(SpdySession paramSpdySession, SuperviseConnectInfo paramSuperviseConnectInfo);

  public abstract void spdySessionFailedError(SpdySession paramSpdySession, int paramInt, Object paramObject);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.spdy.SessionCb
 * JD-Core Version:    0.6.0
 */