package com.gensee.parse;

import com.gensee.pdu.AbsAnno;
import com.gensee.pdu.AnnoFreepenEx;
import org.xmlpull.v1.XmlPullParser;

public class RtmpAnnotationParse extends AnnotaionParse
{
  private IAnnotationDraw iAnnotationDraw;

  public RtmpAnnotationParse(IAnnotationDraw paramIAnnotationDraw)
  {
    this.iAnnotationDraw = paramIAnnotationDraw;
  }

  protected void endCommand(XmlPullParser paramXmlPullParser)
  {
    switch (this.type)
    {
    default:
    case 16:
    }
    while (true)
    {
      super.endCommand(paramXmlPullParser);
      if (this.iAnnotationDraw != null)
        this.iAnnotationDraw.annoDraw(this.anno);
      return;
      if ((this.anno instanceof AnnoFreepenEx))
        ((AnnoFreepenEx)this.anno).setPoints(this.points);
      this.points = null;
    }
  }

  protected void parseFreepenAnno(XmlPullParser paramXmlPullParser)
  {
    this.type = 16;
    this.anno = parseFreepenEx(paramXmlPullParser);
  }

  protected AnnoFreepenEx parseFreepenEx(XmlPullParser paramXmlPullParser)
  {
    AnnoFreepenEx localAnnoFreepenEx = super.parseFreepenEx(paramXmlPullParser);
    String str = getAttrStrValue(paramXmlPullParser, "flag");
    if ((str != null) && (!"".equals(str)))
    {
      if (!"complete".equals(str))
        break label43;
      localAnnoFreepenEx.setStepType(0);
    }
    label43: 
    do
    {
      return localAnnoFreepenEx;
      if ("begin".equals(str))
      {
        localAnnoFreepenEx.setStepType(1);
        return localAnnoFreepenEx;
      }
      if (!"add".equals(str))
        continue;
      localAnnoFreepenEx.setStepType(2);
      return localAnnoFreepenEx;
    }
    while (!"end".equals(str));
    localAnnoFreepenEx.setStepType(3);
    return localAnnoFreepenEx;
  }

  protected void parseFreepenExAnno(XmlPullParser paramXmlPullParser)
  {
    this.anno = parseFreepenEx(paramXmlPullParser);
  }

  public static abstract interface IAnnotationDraw
  {
    public abstract void annoDraw(AbsAnno paramAbsAnno);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.parse.RtmpAnnotationParse
 * JD-Core Version:    0.6.0
 */