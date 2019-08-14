package com.gensee.parse;

import com.gensee.entity.PrivilegeItem;
import com.gensee.entity.PrivilegeRole;
import com.gensee.utils.GenseeLog;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class PrivilegeParser
{
  private static final String ATTR_BIT = "bit";
  private static final String ATTR_DESC = "desc";
  private static final String ATTR_FIXED = "fixed";
  private static final String ATTR_GRANTED = "granted";
  private static final String ATTR_ID = "id";
  private static final String ATTR_READONLY = "readonly";
  private static final String ATTR_TYPE = "type";
  private static final String NODE_PRIVILEGE = "priviledge";
  private static final String NODE_ROLE = "role";
  private static final String TAG = "PrivilegeParser";
  private List<PrivilegeRole> mRoles;
  private boolean priFixed;
  private String priId;
  private int pribit;
  private String pridesc;

  private void addRoleItem(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    while (true)
    {
      PrivilegeRole localPrivilegeRole1;
      List localList2;
      synchronized (this.mRoles)
      {
        Iterator localIterator = this.mRoles.iterator();
        if (localIterator.hasNext())
          continue;
        localPrivilegeRole1 = null;
        if (localPrivilegeRole1 != null)
          break label196;
        PrivilegeRole localPrivilegeRole2 = new PrivilegeRole();
        localPrivilegeRole2.setRole(paramInt);
        this.mRoles.add(localPrivilegeRole2);
        localPrivilegeRole3 = localPrivilegeRole2;
        localList2 = localPrivilegeRole3.getItems();
        if (localList2 == null)
        {
          ArrayList localArrayList = new ArrayList(0);
          localPrivilegeRole3.setItems(localArrayList);
          localObject2 = localArrayList;
          if (!paramBoolean1)
            continue;
          localPrivilegeRole3.addPriByBit(this.pribit);
          ((List)localObject2).add(new PrivilegeItem(this.priId, this.pribit, paramBoolean1, this.priFixed, paramBoolean2, this.pridesc));
          return;
          localPrivilegeRole1 = (PrivilegeRole)localIterator.next();
          if ((localPrivilegeRole1 == null) || (paramInt != localPrivilegeRole1.getRole()))
            continue;
        }
      }
      Object localObject2 = localList2;
      continue;
      label196: PrivilegeRole localPrivilegeRole3 = localPrivilegeRole1;
    }
  }

  private void endTag(String paramString, XmlPullParser paramXmlPullParser)
  {
    if ("priviledge".equals(paramString))
    {
      this.pribit = 0;
      this.pridesc = "";
      this.priFixed = false;
      this.priId = "";
      return;
    }
    "role".equals(paramString);
  }

  private String getAttributeValue(XmlPullParser paramXmlPullParser, String paramString)
  {
    if (paramString == null)
    {
      GenseeLog.e("PrivilegeParser", "getAttributeValue AttributeName  is null!");
      return null;
    }
    try
    {
      String str = paramXmlPullParser.getAttributeValue(null, paramString);
      return str;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      GenseeLog.e("PrivilegeParser", "getAttributeValue IndexOutOfBoundsException  that attr is " + paramString);
    }
    return paramString;
  }

  private int getInteger(String paramString)
  {
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      GenseeLog.e("PrivilegeParser", "getInteger  that value is  NumberFormatException" + paramString + " detail " + localNumberFormatException.toString());
    }
    return 0;
  }

  private void startTag(String paramString, XmlPullParser paramXmlPullParser)
  {
    if ("priviledge".equals(paramString))
    {
      this.priId = getAttributeValue(paramXmlPullParser, "id");
      this.pridesc = getAttributeValue(paramXmlPullParser, "desc");
      this.pribit = getInteger(getAttributeValue(paramXmlPullParser, "bit"));
      this.priFixed = Boolean.valueOf(getAttributeValue(paramXmlPullParser, "fixed")).booleanValue();
    }
    do
      return;
    while (!"role".equals(paramString));
    boolean bool1 = Boolean.valueOf(getAttributeValue(paramXmlPullParser, "granted")).booleanValue();
    boolean bool2 = Boolean.valueOf(getAttributeValue(paramXmlPullParser, "readonly")).booleanValue();
    addRoleItem(getInteger(getAttributeValue(paramXmlPullParser, "type")), bool1, bool2);
  }

  public List<PrivilegeRole> parsePrivilege(Reader paramReader)
  {
    try
    {
      localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      localXmlPullParser.setInput(paramReader);
      int i = localXmlPullParser.getEventType();
      int j = i;
      if (j == 1)
        return this.mRoles;
      str = localXmlPullParser.getName();
      switch (j)
      {
      case 1:
      default:
      case 0:
        while (true)
        {
          j = localXmlPullParser.next();
          break;
          this.mRoles = new ArrayList(0);
        }
      case 2:
      case 3:
      }
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      while (true)
      {
        GenseeLog.e("PrivilegeParser", localXmlPullParserException);
        continue;
        startTag(str, localXmlPullParser);
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        XmlPullParser localXmlPullParser;
        String str;
        GenseeLog.e("PrivilegeParser", localIOException);
        continue;
        endTag(str, localXmlPullParser);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.parse.PrivilegeParser
 * JD-Core Version:    0.6.0
 */