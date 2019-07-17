package com.umeng.message;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

class MsgLogStore$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("umeng_message_log_cache_"));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.MsgLogStore.1
 * JD-Core Version:    0.6.0
 */