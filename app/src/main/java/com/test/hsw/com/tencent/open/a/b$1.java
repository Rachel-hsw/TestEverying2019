package com.tencent.open.a;

import java.io.File;
import java.io.FileFilter;

final class b$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    if (!paramFile.isDirectory());
    do
      return false;
    while (b.a(paramFile) <= 0L);
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.a.b.1
 * JD-Core Version:    0.6.0
 */