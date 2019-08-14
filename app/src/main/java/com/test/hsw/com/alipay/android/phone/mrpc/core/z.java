package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.android.phone.mrpc.core.a.c;
import com.alipay.android.phone.mrpc.core.a.d;
import com.alipay.android.phone.mrpc.core.a.e;
import com.alipay.android.phone.mrpc.core.a.f;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class z
{
  private static final ThreadLocal<Object> a = new ThreadLocal();
  private static final ThreadLocal<Map<String, Object>> b = new ThreadLocal();
  private byte c = 0;
  private AtomicInteger d;
  private x e;

  public z(x paramx)
  {
    this.e = paramx;
    this.d = new AtomicInteger();
  }

  public final Object a(Method paramMethod, Object[] paramArrayOfObject)
  {
    boolean bool1 = true;
    if ((Looper.myLooper() != null) && (Looper.myLooper() == Looper.getMainLooper()));
    for (boolean bool2 = bool1; bool2; bool2 = false)
      throw new IllegalThreadStateException("can't in main thread call rpc .");
    OperationType localOperationType = (OperationType)paramMethod.getAnnotation(OperationType.class);
    if (paramMethod.getAnnotation(ResetCookie.class) != null);
    Type localType;
    while (true)
    {
      localType = paramMethod.getGenericReturnType();
      paramMethod.getAnnotations();
      a.set(null);
      b.set(null);
      if (localOperationType != null)
        break;
      throw new IllegalStateException("OperationType must be set.");
      bool1 = false;
    }
    String str = localOperationType.value();
    int i = this.d.incrementAndGet();
    try
    {
      if (this.c == 0)
      {
        e locale = new e(i, str, paramArrayOfObject);
        if (b.get() != null)
          locale.a(b.get());
        byte[] arrayOfByte1 = locale.a();
        byte[] arrayOfByte2 = (byte[])new j(this.e.a(), paramMethod, i, str, arrayOfByte1, bool1).a();
        b.set(null);
        Object localObject = new d(localType, arrayOfByte2).a();
        if (localType != Void.TYPE)
          a.set(localObject);
      }
      return a.get();
    }
    catch (RpcException localRpcException)
    {
      localRpcException.setOperationType(str);
    }
    throw localRpcException;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.android.phone.mrpc.core.z
 * JD-Core Version:    0.6.0
 */