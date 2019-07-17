package org.android.spdy;

import java.util.List;
import java.util.Map;

public abstract interface Intenalcb
{
  public abstract void spdyDataChunkRecvCB(SpdySession paramSpdySession, boolean paramBoolean, long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  public abstract void spdyDataRecvCallback(SpdySession paramSpdySession, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2);

  public abstract void spdyDataSendCallback(SpdySession paramSpdySession, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2);

  public abstract void spdyOnStreamResponse(SpdySession paramSpdySession, long paramLong, Map<String, List<String>> paramMap, int paramInt);

  public abstract void spdyPingRecvCallback(SpdySession paramSpdySession, long paramLong, Object paramObject);

  public abstract void spdyRequestRecvCallback(SpdySession paramSpdySession, long paramLong, int paramInt);

  public abstract void spdySessionCloseCallback(SpdySession paramSpdySession, Object paramObject, SuperviseConnectInfo paramSuperviseConnectInfo, int paramInt);

  public abstract void spdySessionConnectCB(SpdySession paramSpdySession, SuperviseConnectInfo paramSuperviseConnectInfo);

  public abstract void spdySessionFailedError(SpdySession paramSpdySession, int paramInt, Object paramObject);

  public abstract void spdyStreamCloseCallback(SpdySession paramSpdySession, long paramLong, int paramInt1, int paramInt2, SuperviseData paramSuperviseData);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.spdy.Intenalcb
 * JD-Core Version:    0.6.0
 */