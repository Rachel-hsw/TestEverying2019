package com.withustudy.koudaizikao.activity;

import java.io.File;
import java.io.FilenameFilter;

class u
  implements FilenameFilter
{
  u(ImageSelectorActivity.c paramc)
  {
  }

  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".jpg")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpeg"));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.u
 * JD-Core Version:    0.6.0
 */