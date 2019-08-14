package org.android.agoo.c.b.b;

import android.text.TextUtils;
import com.umeng.message.b.ay;
import java.util.HashMap;
import org.android.agoo.c.b.b;
import org.android.agoo.c.b.e;
import org.android.agoo.c.b.j;
import org.android.spdy.SessionCb;
import org.android.spdy.SpdySession;
import org.android.spdy.SuperviseConnectInfo;

class c
  implements SessionCb
{
  c(a parama)
  {
  }

  public void spdyPingRecvCallback(SpdySession paramSpdySession, long paramLong, Object paramObject)
  {
    try
    {
      ay.c("SpdyClient", "spdyPingRecvCallback[" + paramLong + "]");
      if (a.c(this.a) == paramLong)
        return;
      a.b(this.a, paramLong);
      a.e(this.a).a(a.d(this.a), paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      a.a(this.a, b.e, new HashMap(), null);
    }
  }

  public void spdySessionCloseCallback(SpdySession paramSpdySession, Object paramObject, SuperviseConnectInfo paramSuperviseConnectInfo, int paramInt)
  {
    if (TextUtils.equals(a.a(this.a), (String)paramObject))
      this.a.a = e.c;
    try
    {
      a.e(this.a).b(a.d(this.a), a.f(this.a));
      label53: this.a.a = e.d;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label53;
    }
  }

  public void spdySessionConnectCB(SpdySession paramSpdySession, SuperviseConnectInfo paramSuperviseConnectInfo)
  {
    a.a(this.a, paramSuperviseConnectInfo.connectTime);
    ay.c("SpdyClient", "connect connect_time[" + paramSuperviseConnectInfo.connectTime + "] ");
  }

  public void spdySessionFailedError(SpdySession paramSpdySession, int paramInt, Object paramObject)
  {
    String str = (String)paramObject;
    if (TextUtils.equals(a.a(this.a), str))
    {
      ay.c("SpdyClient", "spdySessionFailedError[" + paramInt + "][" + paramObject + "]");
      this.a.a = e.c;
      a.b(this.a);
    }
    try
    {
      a.a(this.a, this.a.e, Integer.toString(paramInt), str);
      a.a(this.a, b.a(paramInt), new HashMap(), null);
      label115: this.a.a = e.d;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label115;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.b.b.c
 * JD-Core Version:    0.6.0
 */