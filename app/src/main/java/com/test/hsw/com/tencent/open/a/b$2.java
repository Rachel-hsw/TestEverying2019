package com.tencent.open.a;

import java.io.File;
import java.io.FileFilter;

class b$2
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    if (!paramFile.getName().endsWith(this.a.i()));
    do
      return false;
    while (b.d(paramFile) == -1);
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.a.b.2
 * JD-Core Version:    0.6.0
 */