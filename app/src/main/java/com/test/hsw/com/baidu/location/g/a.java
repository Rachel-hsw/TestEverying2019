package com.baidu.location.g;

import android.util.Xml;
import com.baidu.location.b.f;
import java.io.StringReader;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;

class a
  implements f
{
  public String i4 = "";
  public String i5 = "";
  private double i6 = 4.9E-324D;
  public String i7 = "";
  public String i8 = "";
  private boolean i9 = true;
  public String ja = "";
  public String jb = "";
  public String jc = "";
  public String jd = "";
  private float je = 0.0F;
  public String jf = "";
  private double jg = 4.9E-324D;
  private boolean jh = false;
  public String ji = "";

  public a()
  {
  }

  public a(String paramString)
  {
    try
    {
      XmlPullParser localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setInput(new StringReader(paramString));
      localXmlPullParser.next();
      int i = localXmlPullParser.getEventType();
      int j = 0;
      while (true)
      {
        i = localXmlPullParser.next();
        if (j == 0)
        {
          if (!localXmlPullParser.getName().equals("LocationRS"))
            if (!localXmlPullParser.getName().equals("ReverseGeoRS"))
              continue;
        }
        else
        {
          String str = localXmlPullParser.getName();
          if (str == null)
            continue;
          boolean bool1 = str.equals("latitude");
          if (bool1)
          {
            try
            {
              this.jg = Double.valueOf(localXmlPullParser.nextText()).doubleValue();
            }
            catch (Exception localException14)
            {
              this.i9 = false;
            }
            continue;
          }
          boolean bool2 = str.equals("longitude");
          if (bool2)
          {
            try
            {
              this.i6 = Double.valueOf(localXmlPullParser.nextText()).doubleValue();
            }
            catch (Exception localException13)
            {
              this.i9 = false;
            }
            continue;
          }
          boolean bool3 = str.equals("hpe");
          if (bool3)
          {
            try
            {
              this.je = Float.valueOf(localXmlPullParser.nextText()).floatValue();
            }
            catch (Exception localException12)
            {
              this.i9 = false;
            }
            continue;
          }
          boolean bool4 = str.equals("country");
          if (bool4);
          try
          {
            this.ja = localXmlPullParser.getAttributeValue(0);
            try
            {
              label346: this.i8 = localXmlPullParser.nextText();
            }
            catch (Exception localException11)
            {
            }
            continue;
            boolean bool5 = str.equals("province");
            if (bool5)
            {
              try
              {
                this.i7 = localXmlPullParser.nextText();
              }
              catch (Exception localException9)
              {
              }
              continue;
            }
            boolean bool6 = str.equals("region");
            if (bool6)
            {
              try
              {
                this.ji = localXmlPullParser.nextText();
              }
              catch (Exception localException8)
              {
              }
              continue;
            }
            boolean bool7 = str.equals("street-number");
            if (bool7)
            {
              try
              {
                this.i5 = localXmlPullParser.nextText();
              }
              catch (Exception localException7)
              {
              }
              continue;
            }
            boolean bool8 = str.equals("city");
            if (bool8)
            {
              try
              {
                this.jc = localXmlPullParser.nextText();
              }
              catch (Exception localException6)
              {
              }
              continue;
            }
            boolean bool9 = str.equals("address-line");
            if (bool9)
            {
              try
              {
                this.jf = localXmlPullParser.nextText();
              }
              catch (Exception localException5)
              {
              }
              continue;
            }
            boolean bool10 = str.equals("state");
            if (bool10)
            {
              try
              {
                this.i4 = localXmlPullParser.nextText();
              }
              catch (Exception localException4)
              {
              }
              continue;
            }
            boolean bool11 = str.equals("metro1");
            if (bool11)
            {
              try
              {
                this.jd = localXmlPullParser.nextText();
              }
              catch (Exception localException3)
              {
              }
              continue;
            }
            boolean bool12 = str.equals("metro2");
            if (bool12)
            {
              try
              {
                this.jb = localXmlPullParser.nextText();
              }
              catch (Exception localException2)
              {
              }
              continue;
            }
            if (!str.equals("error"))
              continue;
            this.i9 = false;
          }
          catch (Exception localException10)
          {
            break label346;
          }
          if (i == 1)
            break;
          switch (i)
          {
          case 0:
          case 1:
          case 3:
          default:
          case 2:
          }
        }
        j = 1;
      }
    }
    catch (Exception localException1)
    {
    }
  }

  public boolean cs()
  {
    return this.i9;
  }

  public double ct()
  {
    return this.jg;
  }

  public double cu()
  {
    return this.i6;
  }

  public float cv()
  {
    return this.je;
  }

  public String cw()
  {
    if (!this.i9)
      return null;
    Locale localLocale = Locale.CHINA;
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Double.valueOf(this.i6);
    arrayOfObject[1] = Double.valueOf(this.jg);
    arrayOfObject[2] = Float.valueOf(this.je);
    arrayOfObject[3] = this.i8;
    arrayOfObject[4] = this.jc;
    arrayOfObject[5] = this.jf;
    return String.format(localLocale, "&skyll=%.6f|%.6f|%.1f&skyflag=1&skyadd=%s|%s|%s", arrayOfObject);
  }

  public boolean cx()
  {
    int i = 1;
    if ((!this.i8.equals("China")) && (!this.i8.equals("Taiwan")) && (!this.ja.equals("HK")))
      i = 0;
    return i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.g.a
 * JD-Core Version:    0.6.0
 */