package com.umeng.message.b;

import android.util.Log;
import java.util.Map;
import org.android.a;
import org.android.agoo.c.b.b;
import org.android.agoo.c.b.c;
import org.android.agoo.c.b.c.a;
import org.android.agoo.c.b.f;
import org.android.agoo.c.b.j;

class bi
  implements j
{
  bi(bh parambh)
  {
  }

  private void c(Object paramObject, long paramLong)
  {
    long l1 = 0L;
    if (bh.a(this.a) != l1)
    {
      long l2 = System.currentTimeMillis();
      l1 = l2 - bh.a(this.a);
      bh.b(this.a).c(l2);
    }
    while (true)
    {
      ay.c(bh.j(), "connect [onDisconnected] [" + paramObject.toString() + "] sessionId[" + paramLong + "]tcpKeepaliveInterval [" + l1 + "]");
      return;
      bh.b(this.a).c(l1);
    }
  }

  public void a(Object paramObject, long paramLong)
  {
    bh.a(this.a, System.currentTimeMillis());
    if (paramLong % 2L == 0L)
    {
      ay.c(bh.j(), "heart-->[" + paramObject.toString() + "][server_receive]");
      return;
    }
    ay.c(bh.j(), "heart-->[" + paramObject.toString() + "][client_receive]");
  }

  public void a(Object paramObject, long paramLong1, long paramLong2, Map<String, String> paramMap)
  {
    ay.c(bh.j(), "onConnected [" + paramObject.toString() + "]sessionId[" + paramLong1 + "]tcpConnectedInterval[" + paramLong2 + "]header[" + paramMap.toString() + "]");
    this.a.b.onHandleError("EVENT_CONNECTED");
    bh.a(this.a, System.currentTimeMillis());
    bh.b(this.a, System.currentTimeMillis());
    bh.b(this.a).a(bh.a(this.a), paramLong2);
    f localf = bh.d(this.a).a();
    ay.c(bh.j(), "onConnected initChannel[" + paramObject.toString() + "][" + bh.e(this.a).a() + "]-->targetChannel[" + localf.a() + "]");
    this.a.a(paramMap);
    this.a.a("action_get_his_message", 5000L);
    bh.a(this.a, paramObject, bh.a(this.a), (String)paramMap.get("hb"));
    a.d(this.a.c, 0);
    a.c(this.a.c, 0);
    aq.l(this.a.c);
  }

  // ERROR //
  public void a(Object paramObject, long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/umeng/message/b/bi:a	Lcom/umeng/message/b/bh;
    //   4: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   7: invokestatic 71	com/umeng/message/b/bh:a	(Lcom/umeng/message/b/bh;J)J
    //   10: pop2
    //   11: invokestatic 41	com/umeng/message/b/bh:j	()Ljava/lang/String;
    //   14: new 43	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   21: ldc 171
    //   23: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 12	com/umeng/message/b/bi:a	Lcom/umeng/message/b/bh;
    //   30: invokestatic 173	com/umeng/message/b/bh:c	(Lcom/umeng/message/b/bh;)J
    //   33: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   36: ldc 62
    //   38: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 68	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload 5
    //   49: ifnull +74 -> 123
    //   52: aload 5
    //   54: arraylength
    //   55: ifle +68 -> 123
    //   58: new 147	java/lang/String
    //   61: dup
    //   62: aload 5
    //   64: ldc 175
    //   66: invokespecial 178	java/lang/String:<init>	([BLjava/lang/String;)V
    //   69: astore 8
    //   71: invokestatic 41	com/umeng/message/b/bh:j	()Ljava/lang/String;
    //   74: new 43	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   81: ldc 180
    //   83: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 53	java/lang/Object:toString	()Ljava/lang/String;
    //   90: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 117
    //   95: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 8
    //   100: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 62
    //   105: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 68	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 12	com/umeng/message/b/bi:a	Lcom/umeng/message/b/bh;
    //   118: aload 8
    //   120: invokevirtual 183	com/umeng/message/b/bh:f	(Ljava/lang/String;)V
    //   123: return
    //   124: astore 9
    //   126: ldc 185
    //   128: astore 8
    //   130: invokestatic 41	com/umeng/message/b/bh:j	()Ljava/lang/String;
    //   133: new 43	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   140: ldc 187
    //   142: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 53	java/lang/Object:toString	()Ljava/lang/String;
    //   149: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc 117
    //   154: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 8
    //   159: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 62
    //   164: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: aload 9
    //   172: invokestatic 190	com/umeng/message/b/ay:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: return
    //   176: astore 9
    //   178: goto -48 -> 130
    //
    // Exception table:
    //   from	to	target	type
    //   58	71	124	java/lang/Throwable
    //   71	123	176	java/lang/Throwable
  }

  public void a(Object paramObject, long paramLong, b paramb, Map<String, String> paramMap, Throwable paramThrowable)
  {
    Log.d(bh.j(), "mPushHandler onError............error=" + paramb.b());
    c(paramObject, paramLong);
    bh.a(this.a, paramObject, paramb, paramMap, paramThrowable);
    if (bh.k() > 2)
      this.a.b.onHandleError("EVENT_SPDY_ERROR");
    bh.l();
  }

  public void b(Object paramObject, long paramLong)
  {
    Log.d(bh.j(), "mPushHandler onClose............");
    c(paramObject, paramLong);
    aq.a(this.a.c, bh.a(this.a), "onClose");
    this.a.e("agoo_action_heart");
    if (bh.k() > 2)
      this.a.b.onHandleError("EVENT_DISCONNECTED");
    bh.a(this.a, -1L);
    bh.l();
  }

  public void b(Object paramObject, long paramLong, String paramString, byte[] paramArrayOfByte)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bi
 * JD-Core Version:    0.6.0
 */