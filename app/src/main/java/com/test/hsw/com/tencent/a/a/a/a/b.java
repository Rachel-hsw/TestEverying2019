package com.tencent.a.a.a.a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

final class b extends f
{
  b(Context paramContext)
  {
    super(paramContext);
  }

  protected final boolean a()
  {
    return (h.a(this.e, "android.permission.WRITE_EXTERNAL_STORAGE")) && (Environment.getExternalStorageState().equals("mounted"));
  }

  protected final String b()
  {
    monitorenter;
    while (true)
    {
      try
      {
        Log.i("MID", "read mid from InternalStorage");
        File localFile = new File(Environment.getExternalStorageDirectory(), h.f("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="));
        try
        {
          Iterator localIterator = a.a(localFile).iterator();
          if (localIterator.hasNext())
          {
            String[] arrayOfString = ((String)localIterator.next()).split(",");
            if ((arrayOfString.length != 2) || (!arrayOfString[0].equals(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="))))
              continue;
            Log.i("MID", "read mid from InternalStorage:" + arrayOfString[1]);
            str = arrayOfString[1];
            monitorexit;
            return str;
          }
        }
        catch (IOException localIOException)
        {
          Log.w("MID", localIOException);
          str = null;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      String str = null;
    }
  }

  protected final void b(String paramString)
  {
    monitorenter;
    try
    {
      Log.i("MID", "write mid to InternalStorage");
      a.a(Environment.getExternalStorageDirectory() + "/" + h.f("6X8Y4XdM2Vhvn0I="));
      File localFile = new File(Environment.getExternalStorageDirectory(), h.f("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="));
      try
      {
        BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(localFile));
        localBufferedWriter.write(h.f("4kU71lN96TJUomD1vOU9lgj9Tw==") + "," + paramString);
        localBufferedWriter.write("\n");
        localBufferedWriter.close();
        monitorexit;
        return;
      }
      catch (Exception localException)
      {
        while (true)
          Log.w("MID", localException);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.a.a.a.a.b
 * JD-Core Version:    0.6.0
 */