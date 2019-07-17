package com.gensee.parse;

import android.graphics.Color;
import com.gensee.pdu.AbsAnno;
import com.gensee.pdu.AnnoCircle;
import com.gensee.pdu.AnnoCleaner;
import com.gensee.pdu.AnnoFPoint;
import com.gensee.pdu.AnnoFreepen;
import com.gensee.pdu.AnnoFreepenEx;
import com.gensee.pdu.AnnoLineEx;
import com.gensee.pdu.AnnoPointerEx;
import com.gensee.pdu.AnnoRect;
import com.gensee.pdu.AnnoText;
import com.gensee.utils.GenseeLog;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class AnnotaionParse extends PullBase
{
  private static final String TAG = "AnnoParse";
  public static final String TAG_COMMAND = "command";
  public static final String TAG_EP = "ep";
  public static final String TAG_P = "p";
  protected AbsAnno anno;
  protected List<AnnoFPoint> points;
  protected int type;

  private AnnoCircle parseCircle(XmlPullParser paramXmlPullParser)
  {
    AnnoCircle localAnnoCircle = new AnnoCircle();
    parseCommen(localAnnoCircle, paramXmlPullParser);
    localAnnoCircle.setLinesize(getAttrByteValue(paramXmlPullParser, "linesize"));
    localAnnoCircle.setArgbColor(parseColor(getAttrStrValue(paramXmlPullParser, "color")));
    return localAnnoCircle;
  }

  private AnnoCleaner parseCleaner(XmlPullParser paramXmlPullParser)
  {
    AnnoCleaner localAnnoCleaner = new AnnoCleaner();
    parseCommen(localAnnoCleaner, paramXmlPullParser);
    localAnnoCleaner.setRemovedId(getAttrLongValue(paramXmlPullParser, "removed"));
    return localAnnoCleaner;
  }

  private int parseColor(String paramString)
  {
    int i = 0;
    if (paramString != null)
    {
      boolean bool = paramString.contains("#");
      i = 0;
      if (!bool);
    }
    try
    {
      String[] arrayOfString2 = paramString.split(",");
      arrayOfString1 = arrayOfString2;
      i = 0;
      if (arrayOfString1 != null)
      {
        int j = arrayOfString1.length;
        i = 0;
        if (j > 0)
        {
          i = Color.parseColor(arrayOfString1[0]);
          if ((arrayOfString1.length > 1) && ("1".equals(arrayOfString1[1])))
            i = 0xAF000000 | i & 0xFFFFFF;
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      while (true)
      {
        GenseeLog.e("AnnoParse", localException);
        String[] arrayOfString1 = null;
      }
    }
  }

  private void parseCommen(AbsAnno paramAbsAnno, XmlPullParser paramXmlPullParser)
  {
    paramAbsAnno.setType(this.type);
    paramAbsAnno.setId(getAttrLongValue(paramXmlPullParser, "id"));
    paramAbsAnno.setTimestamp(getAttrLongMcValue(paramXmlPullParser, "timestamp"));
  }

  private AnnoFreepen parseFreepen(XmlPullParser paramXmlPullParser)
  {
    AnnoFreepen localAnnoFreepen = new AnnoFreepen();
    parseCommen(localAnnoFreepen, paramXmlPullParser);
    localAnnoFreepen.setLinesize(getAttrByteValue(paramXmlPullParser, "linesize"));
    localAnnoFreepen.setArgbColor(parseColor(getAttrStrValue(paramXmlPullParser, "color")));
    return localAnnoFreepen;
  }

  private AnnoLineEx parseLineEx(XmlPullParser paramXmlPullParser)
  {
    AnnoLineEx localAnnoLineEx = new AnnoLineEx();
    parseCommen(localAnnoLineEx, paramXmlPullParser);
    localAnnoLineEx.setLinesize(getAttrByteValue(paramXmlPullParser, "linesize"));
    localAnnoLineEx.setArgbColor(parseColor(getAttrStrValue(paramXmlPullParser, "color")));
    byte b = getAttrByteValue(paramXmlPullParser, "style");
    if (b != -1)
      localAnnoLineEx.setLineType(b);
    return localAnnoLineEx;
  }

  private AnnoFPoint parsePoint(XmlPullParser paramXmlPullParser)
  {
    nextEventType(paramXmlPullParser);
    String str = paramXmlPullParser.getText();
    if ((str != null) && (!"".equals(str)))
    {
      String[] arrayOfString = str.split(",");
      if ((arrayOfString != null) && (arrayOfString.length == 2))
        return new AnnoFPoint(strToFloat(arrayOfString[0]), strToFloat(arrayOfString[1]));
    }
    return null;
  }

  private AnnoPointerEx parsePointerEx(XmlPullParser paramXmlPullParser)
  {
    AnnoPointerEx localAnnoPointerEx = new AnnoPointerEx();
    parseCommen(localAnnoPointerEx, paramXmlPullParser);
    byte b = getAttrByteValue(paramXmlPullParser, "style");
    if (b != -1)
      localAnnoPointerEx.setPointerType(b);
    return localAnnoPointerEx;
  }

  private AnnoRect parseRect(XmlPullParser paramXmlPullParser)
  {
    AnnoRect localAnnoRect = new AnnoRect();
    parseCommen(localAnnoRect, paramXmlPullParser);
    localAnnoRect.setLinesize(getAttrByteValue(paramXmlPullParser, "linesize"));
    localAnnoRect.setArgbColor(parseColor(getAttrStrValue(paramXmlPullParser, "color")));
    return localAnnoRect;
  }

  private AnnoText parseText(XmlPullParser paramXmlPullParser)
  {
    AnnoText localAnnoText = new AnnoText();
    parseCommen(localAnnoText, paramXmlPullParser);
    localAnnoText.setFontsize(getAttrByteValue(paramXmlPullParser, "fontsize"));
    localAnnoText.setArgbColor(parseColor(getAttrStrValue(paramXmlPullParser, "color")));
    return localAnnoText;
  }

  private float strToFloat(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      return 0.0F;
    try
    {
      float f = Float.valueOf(paramString).floatValue();
      return f;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      GenseeLog.e("AnnoParse", localNumberFormatException);
    }
    return 0.0F;
  }

  protected void endCommand(XmlPullParser paramXmlPullParser)
  {
    switch (this.type)
    {
    default:
      return;
    case 2:
    }
    if ((this.anno instanceof AnnoFreepen))
      ((AnnoFreepen)this.anno).setPoints(this.points);
    this.points = null;
  }

  protected void onEndDoc(XmlPullParser paramXmlPullParser)
  {
  }

  protected void onEndTag(String paramString, XmlPullParser paramXmlPullParser)
  {
    if ("command".equals(paramString))
      endCommand(paramXmlPullParser);
    do
      return;
    while ("p".equals(paramString));
    "ep".equals(paramString);
  }

  protected void onStartDoc(XmlPullParser paramXmlPullParser)
  {
  }

  protected void onStartTag(String paramString, XmlPullParser paramXmlPullParser)
  {
    if ("command".equals(paramString))
      startCommand(paramXmlPullParser);
    do
    {
      return;
      if (!"p".equals(paramString))
        continue;
      startP(paramXmlPullParser);
      return;
    }
    while (!"ep".equals(paramString));
    startEP(paramXmlPullParser);
  }

  protected void onStartText(XmlPullParser paramXmlPullParser)
  {
    if ((this.type == 4) && ((this.anno instanceof AnnoText)))
    {
      String str = paramXmlPullParser.getText();
      if ((str != null) && (!"".equals(str)))
        ((AnnoText)this.anno).setText(str);
    }
  }

  public AbsAnno parseAnnoXml(String paramString)
  {
    XmlPullParser localXmlPullParser = builXmlPullParser(paramString);
    if (localXmlPullParser != null)
      parser(localXmlPullParser);
    return this.anno;
  }

  protected void parseFreepenAnno(XmlPullParser paramXmlPullParser)
  {
    this.anno = parseFreepen(paramXmlPullParser);
  }

  protected AnnoFreepenEx parseFreepenEx(XmlPullParser paramXmlPullParser)
  {
    AnnoFreepenEx localAnnoFreepenEx = new AnnoFreepenEx();
    parseCommen(localAnnoFreepenEx, paramXmlPullParser);
    localAnnoFreepenEx.setLinesize(getAttrByteValue(paramXmlPullParser, "linesize"));
    localAnnoFreepenEx.setArgbColor(parseColor(getAttrStrValue(paramXmlPullParser, "color")));
    return localAnnoFreepenEx;
  }

  protected void parseFreepenExAnno(XmlPullParser paramXmlPullParser)
  {
  }

  protected void startCommand(XmlPullParser paramXmlPullParser)
  {
    this.type = getAttrIntValue(paramXmlPullParser, "type");
    switch (this.type)
    {
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    default:
      return;
    case 1:
      this.type = 9;
    case 9:
      this.anno = parsePointerEx(paramXmlPullParser);
      return;
    case 16:
      parseFreepenExAnno(paramXmlPullParser);
      return;
    case 2:
      parseFreepenAnno(paramXmlPullParser);
      return;
    case 5:
      this.anno = parseCircle(paramXmlPullParser);
      return;
    case 7:
      this.type = 8;
    case 8:
      this.anno = parseLineEx(paramXmlPullParser);
      return;
    case 6:
      this.anno = parseRect(paramXmlPullParser);
      return;
    case 4:
      this.anno = parseText(paramXmlPullParser);
      return;
    case 3:
    }
    this.anno = parseCleaner(paramXmlPullParser);
  }

  protected void startEP(XmlPullParser paramXmlPullParser)
  {
    AnnoFPoint localAnnoFPoint = parsePoint(paramXmlPullParser);
    if (localAnnoFPoint == null);
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (this.type)
            {
            case 1:
            case 2:
            case 3:
            case 9:
            default:
              return;
            case 4:
            case 5:
            case 7:
            case 8:
            case 6:
            }
          }
          while (!(this.anno instanceof AnnoText));
          ((AnnoText)this.anno).setRight(localAnnoFPoint.x);
          ((AnnoText)this.anno).setBottom(localAnnoFPoint.y);
          return;
        }
        while (!(this.anno instanceof AnnoCircle));
        ((AnnoCircle)this.anno).setRight(localAnnoFPoint.x);
        ((AnnoCircle)this.anno).setBottom(localAnnoFPoint.y);
        return;
      }
      while (!(this.anno instanceof AnnoLineEx));
      ((AnnoLineEx)this.anno).setRight(localAnnoFPoint.x);
      ((AnnoLineEx)this.anno).setBottom(localAnnoFPoint.y);
      return;
    }
    while (!(this.anno instanceof AnnoRect));
    ((AnnoRect)this.anno).setRight(localAnnoFPoint.x);
    ((AnnoRect)this.anno).setBottom(localAnnoFPoint.y);
  }

  protected void startP(XmlPullParser paramXmlPullParser)
  {
    AnnoFPoint localAnnoFPoint = parsePoint(paramXmlPullParser);
    if (localAnnoFPoint == null);
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              switch (this.type)
              {
              case 3:
              case 10:
              case 11:
              case 12:
              case 13:
              case 14:
              case 15:
              default:
                return;
              case 1:
              case 9:
              case 2:
              case 16:
              case 5:
              case 7:
              case 8:
              case 6:
              case 4:
              }
            }
            while (!(this.anno instanceof AnnoPointerEx));
            AnnoPointerEx localAnnoPointerEx = (AnnoPointerEx)this.anno;
            localAnnoPointerEx.setX(localAnnoFPoint.x);
            localAnnoPointerEx.setY(localAnnoFPoint.y);
            return;
            if (this.points == null)
              this.points = new ArrayList(1);
            this.points.add(localAnnoFPoint);
            return;
          }
          while (!(this.anno instanceof AnnoCircle));
          ((AnnoCircle)this.anno).setLeft(localAnnoFPoint.x);
          ((AnnoCircle)this.anno).setTop(localAnnoFPoint.y);
          return;
        }
        while (!(this.anno instanceof AnnoLineEx));
        ((AnnoLineEx)this.anno).setLeft(localAnnoFPoint.x);
        ((AnnoLineEx)this.anno).setTop(localAnnoFPoint.y);
        return;
      }
      while (!(this.anno instanceof AnnoRect));
      ((AnnoRect)this.anno).setLeft(localAnnoFPoint.x);
      ((AnnoRect)this.anno).setTop(localAnnoFPoint.y);
      return;
    }
    while (!(this.anno instanceof AnnoText));
    ((AnnoText)this.anno).setLeft(localAnnoFPoint.x);
    ((AnnoText)this.anno).setTop(localAnnoFPoint.y);
  }

  public <T> T toParse(InputStream paramInputStream)
  {
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.parse.AnnotaionParse
 * JD-Core Version:    0.6.0
 */