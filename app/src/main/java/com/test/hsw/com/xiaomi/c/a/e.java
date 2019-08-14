package com.xiaomi.c.a;

import com.xiaomi.a.a.c.c;
import com.xiaomi.d.d;
import java.text.SimpleDateFormat;
import java.util.Date;

class e
  implements d
{
  e(a parama)
  {
  }

  public void a(com.xiaomi.d.a parama)
  {
    c.c("SMACK " + a.a(this.a).format(new Date()) + " Connection reconnected (" + a.b(this.a).hashCode() + ")");
  }

  public void a(com.xiaomi.d.a parama, int paramInt, Exception paramException)
  {
    c.c("SMACK " + a.a(this.a).format(new Date()) + " Connection closed (" + a.b(this.a).hashCode() + ")");
  }

  public void a(com.xiaomi.d.a parama, Exception paramException)
  {
    c.c("SMACK " + a.a(this.a).format(new Date()) + " Reconnection failed due to an exception (" + a.b(this.a).hashCode() + ")");
    paramException.printStackTrace();
  }

  public void b(com.xiaomi.d.a parama)
  {
    c.c("SMACK " + a.a(this.a).format(new Date()) + " Connection started (" + a.b(this.a).hashCode() + ")");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.c.a.e
 * JD-Core Version:    0.6.0
 */