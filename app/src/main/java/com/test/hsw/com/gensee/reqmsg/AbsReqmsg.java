package com.gensee.reqmsg;

public abstract class AbsReqmsg
  implements IReqmsg
{
  private String moduleType;

  protected abstract String createModuleBody();

  protected String getData(String paramString1, String paramString2)
  {
    this.moduleType = paramString1;
    return String.format("<module name=\"%s\" userid=\"%s\">\n", new Object[] { paramString1, paramString2 }) + createModuleBody() + "\n</module>";
  }

  public String getType()
  {
    return this.moduleType;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.reqmsg.AbsReqmsg
 * JD-Core Version:    0.6.0
 */