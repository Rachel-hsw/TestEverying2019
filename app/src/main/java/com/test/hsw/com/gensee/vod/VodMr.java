package com.gensee.vod;

import android.content.Context;
import com.gensee.entity.VodObject;
import com.gensee.entity.VodParam;
import com.gensee.utils.FileUtil;
import com.gensee.utils.StringUtil;
import java.util.HashMap;

public class VodMr
{
  private static VodMr ins;
  private String cachDir;
  private HashMap<String, VodParam> mHashVod = new HashMap(0);

  public static VodMr getIns()
  {
    if (ins == null)
      monitorenter;
    try
    {
      if (ins == null)
        ins = new VodMr();
      return ins;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static String getVodAlb(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)) && (!paramString.contains("http://")))
      paramString = "http://" + paramString;
    return paramString;
  }

  public String getCachDir()
  {
    return this.cachDir;
  }

  public VodParam getVodObjById(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)));
    do
      return null;
    while (!this.mHashVod.containsKey(paramString));
    return (VodParam)this.mHashVod.get(paramString);
  }

  public void initCachDir(Context paramContext)
  {
    if (this.cachDir == null)
      this.cachDir = FileUtil.getCachDir(paramContext, "vodplayer");
  }

  public VodObject putVodObj(VodObject paramVodObject)
  {
    if ((paramVodObject == null) || (StringUtil.isEmpty(paramVodObject.getVodId())))
      return null;
    return (VodObject)this.mHashVod.put(paramVodObject.getVodId(), paramVodObject);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vod.VodMr
 * JD-Core Version:    0.6.0
 */