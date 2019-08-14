package com.tencent.a.a.a.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

final class a
{
  static File a(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists())
      return localFile;
    if (!localFile.getParentFile().exists())
      a(localFile.getParentFile().getAbsolutePath());
    localFile.mkdir();
    return localFile;
  }

  static List<String> a(File paramFile)
  {
    FileReader localFileReader = new FileReader(paramFile);
    BufferedReader localBufferedReader = new BufferedReader(localFileReader);
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      String str = localBufferedReader.readLine();
      if (str == null)
        break;
      localArrayList.add(str.trim());
    }
    localFileReader.close();
    localBufferedReader.close();
    return localArrayList;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.a.a.a.a.a
 * JD-Core Version:    0.6.0
 */