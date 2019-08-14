package com.gensee.report;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.gensee.entity.LoginResEntity;
import com.gensee.utils.GenseeLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportInfo
{
  private String app;
  private Conf conf;
  private String time;
  private User user;

  public ReportInfo(Context paramContext)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date localDate = new Date();
    this.time = ("\"time\":\"" + localSimpleDateFormat.format(localDate) + "\",");
    this.app = getAppInfo(paramContext);
    this.conf = new Conf();
    this.user = new User();
  }

  private String getAppInfo(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    if (paramContext == null)
      return "";
    localHashMap.put("name", paramContext.getPackageName());
    localHashMap.put("version", getAppVersionName(paramContext));
    JSONObject localJSONObject = new JSONObject(localHashMap);
    return "\"app\":" + localJSONObject.toString() + ",";
  }

  // ERROR //
  private String getAppVersionName(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 104	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: aload_1
    //   5: invokevirtual 77	android/content/Context:getPackageName	()Ljava/lang/String;
    //   8: iconst_0
    //   9: invokevirtual 110	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   12: getfield 115	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   15: astore_3
    //   16: ldc 70
    //   18: aload_3
    //   19: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: istore 5
    //   24: iload 5
    //   26: ifeq +6 -> 32
    //   29: ldc 70
    //   31: astore_3
    //   32: aload_3
    //   33: areturn
    //   34: astore_2
    //   35: ldc 70
    //   37: astore_3
    //   38: aload_2
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   46: aload_3
    //   47: areturn
    //   48: astore 4
    //   50: goto -9 -> 41
    //
    // Exception table:
    //   from	to	target	type
    //   0	16	34	java/lang/Exception
    //   16	24	48	java/lang/Exception
  }

  private String getConfJsonInfo()
  {
    HashMap localHashMap = new HashMap();
    if (this.conf != null)
    {
      localHashMap.put("id", this.conf.getId());
      localHashMap.put("name", this.conf.getName());
      localHashMap.put("siteid", this.conf.getSiteid());
      localHashMap.put("sitename", this.conf.getSitename());
    }
    JSONObject localJSONObject = new JSONObject(localHashMap);
    return "\"conf\":" + localJSONObject.toString() + ",";
  }

  public static String getCpuName()
  {
    try
    {
      String[] arrayOfString = new BufferedReader(new FileReader("/proc/cpuinfo")).readLine().split(":\\s+", 2);
      for (int i = 0; ; i++)
      {
        if (i < arrayOfString.length)
          continue;
        String str = arrayOfString[1];
        return str;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return null;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  private String getOs()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "Android");
    localHashMap.put("version", Build.VERSION.RELEASE);
    localHashMap.put("apilevel", Build.VERSION.SDK);
    JSONObject localJSONObject = new JSONObject(localHashMap);
    return "\"os\":" + localJSONObject.toString() + ",";
  }

  private String getUserInfo()
  {
    HashMap localHashMap = new HashMap();
    if (this.user != null)
    {
      localHashMap.put("id", this.user.getId());
      localHashMap.put("name", this.user.getName());
      localHashMap.put("role", this.user.getRole());
    }
    JSONObject localJSONObject = new JSONObject(localHashMap);
    return "\"user\":" + localJSONObject.toString();
  }

  private String hardWareJsonInfo()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("device", Build.MODEL);
    String str1 = getCpuName();
    if (str1 != null)
      localHashMap.put("cpu", str1);
    String str2 = getTotalMemory();
    if (str2 != null)
      localHashMap.put("mem", str2);
    JSONObject localJSONObject = new JSONObject(localHashMap);
    try
    {
      Log.d("", "diagnose " + localJSONObject.toString(2));
      return "\"hardware\":" + localJSONObject.toString() + ",";
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  public Conf getConf()
  {
    return this.conf;
  }

  public String getTime()
  {
    return this.time;
  }

  // ERROR //
  public String getTotalMemory()
  {
    // Byte code:
    //   0: new 154	java/io/FileReader
    //   3: dup
    //   4: ldc 236
    //   6: invokespecial 157	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +115 -> 126
    //   14: new 152	java/io/BufferedReader
    //   17: dup
    //   18: aload_1
    //   19: sipush 8192
    //   22: invokespecial 239	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual 163	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore 8
    //   32: aload 8
    //   34: astore 4
    //   36: aload 4
    //   38: ifnull +3 -> 41
    //   41: aload_2
    //   42: ifnull +7 -> 49
    //   45: aload_2
    //   46: invokevirtual 242	java/io/BufferedReader:close	()V
    //   49: aload 4
    //   51: areturn
    //   52: astore 11
    //   54: aconst_null
    //   55: astore_2
    //   56: aconst_null
    //   57: astore 4
    //   59: aload_2
    //   60: ifnull -11 -> 49
    //   63: aload_2
    //   64: invokevirtual 242	java/io/BufferedReader:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore 5
    //   71: aload 5
    //   73: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore 10
    //   80: aconst_null
    //   81: astore_2
    //   82: aload 10
    //   84: astore 6
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 242	java/io/BufferedReader:close	()V
    //   94: aload 6
    //   96: athrow
    //   97: astore 7
    //   99: aload 7
    //   101: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   104: goto -10 -> 94
    //   107: astore 9
    //   109: aload 9
    //   111: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   114: aload 4
    //   116: areturn
    //   117: astore 6
    //   119: goto -33 -> 86
    //   122: astore_3
    //   123: goto -67 -> 56
    //   126: aconst_null
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_2
    //   131: goto -90 -> 41
    //
    // Exception table:
    //   from	to	target	type
    //   0	10	52	java/io/IOException
    //   14	26	52	java/io/IOException
    //   63	67	69	java/io/IOException
    //   0	10	78	finally
    //   14	26	78	finally
    //   90	94	97	java/io/IOException
    //   45	49	107	java/io/IOException
    //   26	32	117	finally
    //   26	32	122	java/io/IOException
  }

  public User getUser()
  {
    return this.user;
  }

  public void setConf(Conf paramConf)
  {
    this.conf = paramConf;
  }

  public void setLoginEntityInfo(LoginResEntity paramLoginResEntity)
  {
    this.conf.setId(paramLoginResEntity.getWebcastId());
    this.conf.setName(paramLoginResEntity.getWebcastSubject());
    this.conf.setSiteid(paramLoginResEntity.getSiteId());
    this.conf.setSitename(paramLoginResEntity.getWebUrl());
    this.user.setId(paramLoginResEntity.getUserId());
    this.user.setName(paramLoginResEntity.getNickName());
    this.user.setRole(paramLoginResEntity.getRole());
    writeInfo();
  }

  public void setTime(String paramString)
  {
    this.time = paramString;
  }

  public void setUser(User paramUser)
  {
    this.user = paramUser;
  }

  public void writeInfo()
  {
    GenseeLog.writeAppInfo("{\"report\":{" + this.time + hardWareJsonInfo() + getOs() + this.app + getConfJsonInfo() + getUserInfo() + "}}");
  }

  public class App
  {
    private String name;
    private String version;

    public App()
    {
    }

    public String getName()
    {
      return this.name;
    }

    public String getVersion()
    {
      return this.version;
    }

    public void setName(String paramString)
    {
      this.name = paramString;
    }

    public void setVersion(String paramString)
    {
      this.version = paramString;
    }

    public String toString()
    {
      return "App [name=" + this.name + ", version=" + this.version + "]";
    }
  }

  public class Conf
  {
    private String id;
    private String name;
    private String siteid;
    private String sitename;

    public Conf()
    {
    }

    public String getId()
    {
      return this.id;
    }

    public String getName()
    {
      return this.name;
    }

    public String getSiteid()
    {
      return this.siteid;
    }

    public String getSitename()
    {
      return this.sitename;
    }

    public void setId(String paramString)
    {
      this.id = paramString;
    }

    public void setName(String paramString)
    {
      this.name = paramString;
    }

    public void setSiteid(String paramString)
    {
      this.siteid = paramString;
    }

    public void setSitename(String paramString)
    {
      this.sitename = paramString;
    }

    public String toString()
    {
      return "Conf [id=" + this.id + ", name=" + this.name + ", siteid=" + this.siteid + ", sitename=" + this.sitename + "]";
    }
  }

  public class HardWare
  {
    private String cpu;
    private String device;
    private String mem;

    public HardWare()
    {
    }

    public String getCpu()
    {
      return this.cpu;
    }

    public String getDevice()
    {
      return this.device;
    }

    public String getMem()
    {
      return this.mem;
    }

    public void setCpu(String paramString)
    {
      this.cpu = paramString;
    }

    public void setDevice(String paramString)
    {
      this.device = paramString;
    }

    public void setMem(String paramString)
    {
      this.mem = paramString;
    }

    public String toString()
    {
      return "HardWare [device=" + this.device + ", cpu=" + this.cpu + ", mem=" + this.mem + "]";
    }
  }

  public class Os
  {
    private String apilevel;
    private String type;
    private String version;

    public Os()
    {
    }

    public String getApilevel()
    {
      return this.apilevel;
    }

    public String getType()
    {
      return this.type;
    }

    public String getVersion()
    {
      return this.version;
    }

    public void setApilevel(String paramString)
    {
      this.apilevel = paramString;
    }

    public void setType(String paramString)
    {
      this.type = paramString;
    }

    public void setVersion(String paramString)
    {
      this.version = paramString;
    }

    public String toString()
    {
      return "Os [type=" + this.type + ", version=" + this.version + ", apilevel=" + this.apilevel + "]";
    }
  }

  public class User
  {
    private String id;
    private String name;
    private String role;

    public User()
    {
    }

    public String getId()
    {
      return this.id;
    }

    public String getName()
    {
      return this.name;
    }

    public String getRole()
    {
      return this.role;
    }

    public void setId(String paramString)
    {
      this.id = paramString;
    }

    public void setName(String paramString)
    {
      this.name = paramString;
    }

    public void setRole(String paramString)
    {
      this.role = paramString;
    }

    public String toString()
    {
      return "User [id=" + this.id + ", name=" + this.name + ", role=" + this.role + "]";
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.report.ReportInfo
 * JD-Core Version:    0.6.0
 */