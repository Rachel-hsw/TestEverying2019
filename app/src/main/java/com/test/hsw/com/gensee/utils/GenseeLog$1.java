package com.gensee.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

class GenseeLog$1
  implements Runnable
{
  public void run()
  {
    Date localDate = new Date();
    GenseeLog.access$1(GenseeLog.access$0().format(localDate) + " " + this.val$level + ":" + this.val$tag + ">" + this.val$text + "\n");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.utils.GenseeLog.1
 * JD-Core Version:    0.6.0
 */