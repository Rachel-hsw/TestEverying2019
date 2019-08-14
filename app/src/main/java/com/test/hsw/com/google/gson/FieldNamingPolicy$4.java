package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$4
{
  public String translateName(Field paramField)
  {
    return FieldNamingPolicy.access$200(paramField.getName(), "_").toLowerCase();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.FieldNamingPolicy.4
 * JD-Core Version:    0.6.0
 */