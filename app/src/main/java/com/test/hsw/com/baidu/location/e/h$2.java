package com.baidu.location.e;

import android.os.Environment;
import java.io.File;

class h$2 extends Thread
{
  public void run()
  {
    File localFile = new File(Environment.getExternalStorageDirectory() + "/baidu/tempdata", "intime.dat");
    h.jdMethod_if(this.a, localFile, "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.h.2
 * JD-Core Version:    0.6.0
 */