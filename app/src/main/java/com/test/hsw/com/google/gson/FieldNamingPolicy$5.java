package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$5
{
  public String translateName(Field paramField)
  {
    return FieldNamingPolicy.access$200(paramField.getName(), "-").toLowerCase();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.FieldNamingPolicy.5
 * JD-Core Version:    0.6.0
 */