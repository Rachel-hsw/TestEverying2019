package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aj extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("client_ip", paramArrayOfString[0]);
    localHashMap.put("course_name", paramArrayOfString[1]);
    localHashMap.put("course_intro", paramArrayOfString[2]);
    localHashMap.put("channel", paramArrayOfString[3]);
    localHashMap.put("amount", paramArrayOfString[4]);
    localHashMap.put("order_time", paramArrayOfString[5]);
    localHashMap.put("uid", paramArrayOfString[6]);
    localHashMap.put("course_id", paramArrayOfString[7]);
    if (paramArrayOfString != null);
    try
    {
      if (paramArrayOfString.length >= 9)
        localHashMap.put("scho_amount", paramArrayOfString[8]);
      label149: if (!((String)this.q.get(1)).equals(""))
        localHashMap.put("net", (String)this.q.get(1));
      localHashMap.put("clientType", (String)this.q.get(2));
      localHashMap.put("imei", (String)this.q.get(3));
      a(localHashMap);
      n.a().a("http://pay.kdzikao.com/pay", localHashMap, parama, paramInt);
      return;
    }
    catch (Exception localException)
    {
      break label149;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.aj
 * JD-Core Version:    0.6.0
 */