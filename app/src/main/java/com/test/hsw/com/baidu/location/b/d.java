package com.baidu.location.b;

import com.baidu.location.h.c;
import com.baidu.location.h.j;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.net.InetAddress;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  implements f
{
  private static d bw = null;
  private String bA = "loc.map.baidu.com";
  private String br = null;
  private long bs = 0L;
  private a bt = new a();
  private long bu = 0L;
  private String bv = null;
  private int bx = 0;
  private long by = 0L;
  private String bz = "dns.map.baidu.com";

  private d()
  {
    T();
  }

  private void Q()
  {
    String str1 = e.int + "/grtcf.dat";
    try
    {
      File localFile1 = new File(str1);
      if (!localFile1.exists())
      {
        File localFile2 = new File(e.int);
        if (!localFile2.exists())
          localFile2.mkdirs();
        if (localFile1.createNewFile())
        {
          RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile1, "rw");
          localRandomAccessFile1.seek(2L);
          localRandomAccessFile1.writeInt(0);
          localRandomAccessFile1.seek(8L);
          byte[] arrayOfByte1 = "1980_01_01:0".getBytes();
          localRandomAccessFile1.writeInt(arrayOfByte1.length);
          localRandomAccessFile1.write(arrayOfByte1);
          localRandomAccessFile1.seek(200L);
          localRandomAccessFile1.writeBoolean(false);
          localRandomAccessFile1.seek(800L);
          localRandomAccessFile1.writeBoolean(false);
          localRandomAccessFile1.close();
        }
      }
      else
      {
        RandomAccessFile localRandomAccessFile2 = new RandomAccessFile(localFile1, "rw");
        localRandomAccessFile2.seek(800L);
        String str2 = R();
        if (str2 != null)
        {
          localRandomAccessFile2.writeBoolean(true);
          byte[] arrayOfByte2 = str2.getBytes();
          localRandomAccessFile2.writeInt(arrayOfByte2.length);
          localRandomAccessFile2.write(arrayOfByte2);
        }
        while (true)
        {
          localRandomAccessFile2.close();
          return;
          localRandomAccessFile2.writeBoolean(false);
        }
      }
    }
    catch (Exception localException)
    {
      return;
    }
    catch (Error localError)
    {
    }
  }

  private String R()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.bv != null)
        localJSONObject.put("dnsServer", this.bv);
      if (this.br != null)
        localJSONObject.put("locServer", this.br);
      if (this.bA != null)
        localJSONObject.put("address", this.bA);
      if (this.bz != null)
        localJSONObject.put("dnsServerIp", this.bz);
      localJSONObject.put("DnsProxyTime", this.bs);
      localJSONObject.put("DnsExtraTime", this.bu);
      localJSONObject.put("DnsExtraUpdateTime", this.by);
      localJSONObject.put("enable", this.bx);
      String str = localJSONObject.toString();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private void T()
  {
    String str = e.int + "/grtcf.dat";
    try
    {
      File localFile = new File(str);
      if (localFile.exists())
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
        localRandomAccessFile.seek(800L);
        if (localRandomAccessFile.readBoolean())
        {
          int i = localRandomAccessFile.readInt();
          byte[] arrayOfByte = new byte[i];
          localRandomAccessFile.read(arrayOfByte, 0, i);
          jdMethod_case(new String(arrayOfByte));
        }
        localRandomAccessFile.close();
      }
      return;
    }
    catch (Error localError)
    {
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static d U()
  {
    if (bw == null)
      bw = new d();
    return bw;
  }

  private void jdMethod_case(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("dnsServer"))
        this.bv = localJSONObject.getString("dnsServer");
      if (localJSONObject.has("locServer"))
        this.br = localJSONObject.getString("locServer");
      if (localJSONObject.has("address"))
        this.bA = localJSONObject.getString("address");
      if (localJSONObject.has("locServer"))
        this.bz = localJSONObject.getString("dnsServerIp");
      if (localJSONObject.has("DnsProxyTime"))
        this.bs = localJSONObject.getLong("DnsProxyTime");
      if (localJSONObject.has("DnsExtraTime"))
        this.bu = localJSONObject.getLong("DnsExtraTime");
      if (localJSONObject.has("DnsExtraUpdateTime"))
        this.by = localJSONObject.getLong("DnsExtraUpdateTime");
      if (localJSONObject.has("enable"))
        this.bx = localJSONObject.getInt("enable");
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public String S()
  {
    String str = "loc.map.baidu.com";
    if ((this.bx == 1) && (System.currentTimeMillis() - this.bs < 360000L))
      str = this.bA;
    if (System.currentTimeMillis() - this.bs > 300000L)
      this.bt.aw();
    return str;
  }

  public String V()
  {
    boolean bool1 = System.currentTimeMillis() - this.bu < 3600000L;
    String str1 = null;
    if (bool1)
    {
      boolean bool2 = System.currentTimeMillis() - this.by < 43200000L;
      str1 = null;
      if (bool2)
      {
        String str2 = this.bv;
        str1 = null;
        if (str2 != null)
        {
          String str3 = this.br;
          str1 = null;
          if (str3 != null)
          {
            str1 = "&dsvr=" + this.bv + "&lsvr=" + this.br;
            this.bu = System.currentTimeMillis();
            Q();
          }
        }
      }
    }
    return str1;
  }

  private class a extends m
  {
    private boolean di = false;

    public a()
    {
    }

    public void au()
    {
      if ((d.jdMethod_for(d.this).equals("dns.map.baidu.com")) || (System.currentTimeMillis() - d.jdMethod_do(d.this) > 720000L))
        switch (c.a().cQ())
        {
        default:
          d.jdMethod_int(d.this, "dns.map.baidu.com");
        case 1:
        case 3:
        case 2:
        }
      while (true)
      {
        this.c5 = ("http://" + d.jdMethod_for(d.this) + ":80/remotedns?pid=lbs-geolocation");
        return;
        d.jdMethod_int(d.this, "111.13.100.247");
        continue;
        d.jdMethod_int(d.this, "180.97.33.196");
        continue;
        d.jdMethod_int(d.this, "111.206.37.190");
      }
    }

    void aw()
    {
      if (this.di)
        return;
      this.di = true;
      as();
    }

    void ax()
    {
      if (System.currentTimeMillis() - d.jdMethod_if(d.this) < 1200000L)
        d.jdMethod_int(d.this);
      while (true)
      {
        return;
        try
        {
          String str2 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { "net.dns1" });
          str1 = str2;
        }
        catch (Exception localException1)
        {
          try
          {
            while (true)
            {
              InetAddress localInetAddress2 = InetAddress.getByName("loc.map.baidu.com");
              localInetAddress1 = localInetAddress2;
              if ((localInetAddress1 == null) || (localInetAddress1.getHostAddress() == null) || (str1 == null) || ("".equals(str1)))
                break;
              d.jdMethod_do(d.this, str1);
              d.jdMethod_if(d.this, localInetAddress1.getHostAddress());
              d.jdMethod_do(d.this, System.currentTimeMillis());
              d.jdMethod_int(d.this);
              return;
              localException1 = localException1;
              String str1 = null;
            }
          }
          catch (Exception localException2)
          {
            while (true)
              InetAddress localInetAddress1 = null;
          }
        }
      }
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.c6 != null));
      try
      {
        JSONObject localJSONObject1 = new JSONObject(EntityUtils.toString(this.c6, "utf-8"));
        if ((localJSONObject1.getInt("errno") == 0) && (localJSONObject1.has("data")))
        {
          JSONArray localJSONArray = localJSONObject1.getJSONArray("data");
          JSONObject localJSONObject2 = localJSONArray.getJSONObject(0);
          JSONObject localJSONObject3 = localJSONArray.getJSONObject(1);
          if (localJSONObject2.has("loc.map.baidu.com"))
          {
            str1 = localJSONObject2.getJSONArray("loc.map.baidu.com").getJSONObject(0).getString("ip");
            boolean bool = localJSONObject3.has("dns.map.baidu.com");
            String str2 = null;
            if (bool)
              str2 = localJSONObject3.getJSONArray("dns.map.baidu.com").getJSONObject(0).getString("ip");
            if ((str1 != null) && (str2 != null))
            {
              d.jdMethod_int(d.this, str2);
              d.jdMethod_for(d.this, str1);
            }
            if (localJSONObject1.has("switch"))
              d.jdMethod_if(d.this, localJSONObject1.getInt("switch"));
            d.jdMethod_if(d.this, System.currentTimeMillis());
            ax();
          }
        }
        else
        {
          this.di = false;
          return;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          continue;
          String str1 = null;
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.d
 * JD-Core Version:    0.6.0
 */