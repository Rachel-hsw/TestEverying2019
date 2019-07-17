package com.baidu.location.c;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.baidu.location.Address;
import com.baidu.location.Address.Builder;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.b.k;
import com.baidu.location.h.f;
import com.baidu.location.h.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

final class c
  implements com.baidu.location.b.b
{
  private static final String A = "-des";
  private static final String B = "CityCode";
  private static final String C = "City";
  private static final String[] D = { "CoorType", "Time", "LocType", "Longitude", "Latitude", "Radius", "NetworkLocationType", "Country", "CountryCode", "Province", "City", "CityCode", "District", "Street", "StreetNumber", "PoiList", "LocationDescription" };
  private static final String E = "NetworkLocationType";
  private static final String F = "CoorType";
  private static final String G = "PoiList";
  private static final SimpleDateFormat H = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
  private static final String I = "-minap";
  private static final String J = "-rgc";
  private static final String K = "true";
  private static final String L = "Country";
  private static final String M = "-com";
  private static final String N = "Latitude";
  private static final String O = "LocationDescription";
  private static final String P = "District";
  private static final String Q = "CountryCode";
  private static final String R = "gcj02";
  private static final String S = "Time";
  private static final String T = "Radius";
  private static final String U = "-log";
  private static final String V = "StreetNumber";
  private static final String W = "Longitude";
  private static final String X = "LocType";
  private static final String Y = "-loc";
  private static final String Z = "-poi";
  private static final String aa = "%f;%f;%d;%s";
  private static final String y = "Street";
  private static final String z = "Province";

  private c()
  {
    throw new AssertionError();
  }

  static Cursor jdMethod_if(BDLocation paramBDLocation)
  {
    String str1 = H.format(new Date(System.currentTimeMillis()));
    MatrixCursor localMatrixCursor = new MatrixCursor(D);
    Object[] arrayOfObject = new Object[D.length];
    arrayOfObject[localMatrixCursor.getColumnIndex("CoorType")] = "gcj02";
    arrayOfObject[localMatrixCursor.getColumnIndex("Time")] = str1;
    arrayOfObject[localMatrixCursor.getColumnIndex("LocType")] = Integer.valueOf(paramBDLocation.getLocType());
    arrayOfObject[localMatrixCursor.getColumnIndex("Longitude")] = Double.valueOf(paramBDLocation.getLongitude());
    arrayOfObject[localMatrixCursor.getColumnIndex("Latitude")] = Double.valueOf(paramBDLocation.getLatitude());
    arrayOfObject[localMatrixCursor.getColumnIndex("Radius")] = Float.valueOf(paramBDLocation.getRadius());
    arrayOfObject[localMatrixCursor.getColumnIndex("NetworkLocationType")] = paramBDLocation.getNetworkLocationType();
    Address localAddress = paramBDLocation.getAddress();
    String str9;
    String str8;
    String str7;
    String str6;
    String str5;
    String str4;
    String str3;
    String str2;
    if (localAddress != null)
    {
      str9 = localAddress.country;
      str8 = localAddress.countryCode;
      str7 = localAddress.province;
      str6 = localAddress.city;
      str5 = localAddress.cityCode;
      str4 = localAddress.district;
      str3 = localAddress.street;
      str2 = localAddress.streetNumber;
    }
    while (true)
    {
      arrayOfObject[localMatrixCursor.getColumnIndex("Country")] = str9;
      arrayOfObject[localMatrixCursor.getColumnIndex("CountryCode")] = str8;
      arrayOfObject[localMatrixCursor.getColumnIndex("Province")] = str7;
      arrayOfObject[localMatrixCursor.getColumnIndex("City")] = str6;
      arrayOfObject[localMatrixCursor.getColumnIndex("CityCode")] = str5;
      arrayOfObject[localMatrixCursor.getColumnIndex("District")] = str4;
      arrayOfObject[localMatrixCursor.getColumnIndex("Street")] = str3;
      arrayOfObject[localMatrixCursor.getColumnIndex("StreetNumber")] = str2;
      List localList = paramBDLocation.getPoiList();
      if (localList == null)
        arrayOfObject[localMatrixCursor.getColumnIndex("PoiList")] = null;
      while (true)
      {
        String str10 = paramBDLocation.getLocationDescribe();
        arrayOfObject[localMatrixCursor.getColumnIndex("LocationDescription")] = str10;
        localMatrixCursor.addRow(arrayOfObject);
        return localMatrixCursor;
        StringBuffer localStringBuffer = new StringBuffer();
        for (int i = 0; i < localList.size(); i++)
        {
          Poi localPoi = (Poi)localList.get(i);
          localStringBuffer.append(localPoi.getId()).append(";").append(localPoi.getName()).append(";").append(localPoi.getRank()).append(";|");
        }
        arrayOfObject[localMatrixCursor.getColumnIndex("PoiList")] = localStringBuffer.toString();
      }
      str2 = null;
      str3 = null;
      str4 = null;
      str5 = null;
      str6 = null;
      str7 = null;
      str8 = null;
      str9 = null;
    }
  }

  static BDLocation jdMethod_if(Cursor paramCursor)
  {
    BDLocation localBDLocation = new BDLocation();
    if ((paramCursor != null) && (paramCursor.getCount() > 0) && (paramCursor.moveToFirst()))
    {
      int i = paramCursor.getColumnIndex("LocType");
      Integer localInteger = null;
      if (i != -1)
        localInteger = Integer.valueOf(paramCursor.getInt(paramCursor.getColumnIndex("LocType")));
      int j = paramCursor.getColumnIndex("Latitude");
      Double localDouble1 = null;
      if (j != -1)
        localDouble1 = Double.valueOf(paramCursor.getDouble(paramCursor.getColumnIndex("Latitude")));
      int k = paramCursor.getColumnIndex("Longitude");
      Double localDouble2 = null;
      if (k != -1)
        localDouble2 = Double.valueOf(paramCursor.getDouble(paramCursor.getColumnIndex("Longitude")));
      int m = paramCursor.getColumnIndex("CoorType");
      String str1 = null;
      if (m != -1)
        str1 = paramCursor.getString(paramCursor.getColumnIndex("CoorType"));
      int n = paramCursor.getColumnIndex("NetworkLocationType");
      String str2 = null;
      if (n != -1)
        str2 = paramCursor.getString(paramCursor.getColumnIndex("NetworkLocationType"));
      int i1 = paramCursor.getColumnIndex("Radius");
      Float localFloat = null;
      if (i1 != -1)
        localFloat = Float.valueOf(paramCursor.getFloat(paramCursor.getColumnIndex("Radius")));
      int i2 = paramCursor.getColumnIndex("Time");
      String str3 = null;
      if (i2 != -1)
        str3 = paramCursor.getString(paramCursor.getColumnIndex("Time"));
      int i3 = paramCursor.getColumnIndex("Country");
      String str4 = null;
      if (i3 != -1)
        str4 = paramCursor.getString(paramCursor.getColumnIndex("Country"));
      int i4 = paramCursor.getColumnIndex("CountryCode");
      String str5 = null;
      if (i4 != -1)
        str5 = paramCursor.getString(paramCursor.getColumnIndex("CountryCode"));
      int i5 = paramCursor.getColumnIndex("Province");
      String str6 = null;
      if (i5 != -1)
        str6 = paramCursor.getString(paramCursor.getColumnIndex("Province"));
      int i6 = paramCursor.getColumnIndex("City");
      String str7 = null;
      if (i6 != -1)
        str7 = paramCursor.getString(paramCursor.getColumnIndex("City"));
      int i7 = paramCursor.getColumnIndex("CityCode");
      String str8 = null;
      if (i7 != -1)
        str8 = paramCursor.getString(paramCursor.getColumnIndex("CityCode"));
      int i8 = paramCursor.getColumnIndex("District");
      String str9 = null;
      if (i8 != -1)
        str9 = paramCursor.getString(paramCursor.getColumnIndex("District"));
      int i9 = paramCursor.getColumnIndex("Street");
      String str10 = null;
      if (i9 != -1)
        str10 = paramCursor.getString(paramCursor.getColumnIndex("Street"));
      int i10 = paramCursor.getColumnIndex("StreetNumber");
      String str11 = null;
      if (i10 != -1)
        str11 = paramCursor.getString(paramCursor.getColumnIndex("StreetNumber"));
      Address localAddress = new Address.Builder().country(str4).countryCode(str5).province(str6).city(str7).cityCode(str8).district(str9).street(str10).streetNumber(str11).build();
      int i11 = paramCursor.getColumnIndex("PoiList");
      ArrayList localArrayList = null;
      String str12;
      if (i11 != -1)
      {
        localArrayList = new ArrayList();
        str12 = paramCursor.getString(paramCursor.getColumnIndex("PoiList"));
        if (str12 == null);
      }
      try
      {
        String[] arrayOfString1 = str12.split("\\|");
        for (int i13 = 0; i13 < arrayOfString1.length; i13++)
        {
          String[] arrayOfString2 = arrayOfString1[i13].split(";");
          if (arrayOfString2.length < 3)
            continue;
          Poi localPoi = new Poi(arrayOfString2[0], arrayOfString2[1], Double.valueOf(arrayOfString2[2]).doubleValue());
          localArrayList.add(localPoi);
        }
        if (localArrayList.size() == 0)
          localArrayList = null;
        int i12 = paramCursor.getColumnIndex("LocationDescription");
        String str13 = null;
        if (i12 != -1)
          str13 = paramCursor.getString(paramCursor.getColumnIndex("LocationDescription"));
        localBDLocation.setTime(str3);
        localBDLocation.setRadius(localFloat.floatValue());
        localBDLocation.setLocType(localInteger.intValue());
        localBDLocation.setCoorType(str1);
        localBDLocation.setLatitude(localDouble1.doubleValue());
        localBDLocation.setLongitude(localDouble2.doubleValue());
        localBDLocation.setNetworkLocationType(str2);
        localBDLocation.setAddr(localAddress);
        localBDLocation.setPoiList(localArrayList);
        localBDLocation.setLocationDescribe(str13);
        return localBDLocation;
      }
      catch (Exception localException)
      {
        while (true)
        {
          if (localArrayList.size() != 0)
            continue;
          localArrayList = null;
        }
      }
      finally
      {
        if (localArrayList.size() != 0);
      }
    }
    localBDLocation.setLocType(67);
    return localBDLocation;
  }

  static String jdMethod_if(BDLocation paramBDLocation, int paramInt)
  {
    if ((paramBDLocation == null) || (paramBDLocation.getLocType() == 67))
    {
      Locale localLocale1 = Locale.CHINA;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = "1";
      arrayOfObject1[1] = Integer.valueOf(paramInt);
      localObject = String.format(localLocale1, "&ofl=%s|%d", arrayOfObject1);
      return localObject;
    }
    Locale localLocale2 = Locale.CHINA;
    Object[] arrayOfObject2 = new Object[5];
    arrayOfObject2[0] = "1";
    arrayOfObject2[1] = Integer.valueOf(paramInt);
    arrayOfObject2[2] = Double.valueOf(paramBDLocation.getLongitude());
    arrayOfObject2[3] = Double.valueOf(paramBDLocation.getLatitude());
    arrayOfObject2[4] = Integer.valueOf((int)paramBDLocation.getRadius());
    String str = String.format(localLocale2, "&ofl=%s|%d|%f|%f|%d", arrayOfObject2);
    if (paramBDLocation.getAddress() != null);
    for (Object localObject = str + "&ofaddr=" + paramBDLocation.getAddress().address; ; localObject = str)
    {
      if ((paramBDLocation.getPoiList() != null) && (paramBDLocation.getPoiList().size() > 0))
      {
        Poi localPoi = (Poi)paramBDLocation.getPoiList().get(0);
        StringBuilder localStringBuilder2 = new StringBuilder().append((String)localObject);
        Locale localLocale4 = Locale.US;
        Object[] arrayOfObject4 = new Object[2];
        arrayOfObject4[0] = localPoi.getId();
        arrayOfObject4[1] = localPoi.getName();
        localObject = String.format(localLocale4, "&ofpoi=%s|%s", arrayOfObject4);
      }
      if (com.baidu.location.b.c.bn == null)
        break;
      StringBuilder localStringBuilder1 = new StringBuilder().append((String)localObject);
      Locale localLocale3 = Locale.US;
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = com.baidu.location.b.c.bn;
      arrayOfObject3[1] = Float.valueOf(6.13F);
      return String.format(localLocale3, "&pack=%s&sdk=%.3f", arrayOfObject3);
    }
  }

  static String jdMethod_if(BDLocation paramBDLocation1, BDLocation paramBDLocation2, a parama)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBDLocation2 == null)
    {
      localStringBuffer.append("&ofcl=0");
      if (paramBDLocation1 != null)
        break label198;
      localStringBuffer.append("&ofwf=0");
      label32: if ((parama == null) || (!parama.jdField_byte))
        break label261;
      localStringBuffer.append("&rgcn=1");
      label51: if ((parama == null) || (!parama.jdField_int))
        break label272;
      localStringBuffer.append("&poin=1");
      label70: if ((parama == null) || (!parama.jdField_char))
        break label283;
      localStringBuffer.append("&desc=1");
    }
    while (true)
    {
      if (parama != null)
      {
        Locale localLocale3 = Locale.US;
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = Integer.valueOf(parama.jdField_do);
        localStringBuffer.append(String.format(localLocale3, "&aps=%d", arrayOfObject3));
      }
      return localStringBuffer.toString();
      Locale localLocale1 = Locale.US;
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = Double.valueOf(paramBDLocation2.getLongitude());
      arrayOfObject1[1] = Double.valueOf(paramBDLocation2.getLatitude());
      arrayOfObject1[2] = Integer.valueOf((int)paramBDLocation2.getRadius());
      localStringBuffer.append(String.format(localLocale1, "&ofcl=1|%f|%f|%d", arrayOfObject1));
      break;
      label198: Locale localLocale2 = Locale.US;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = Double.valueOf(paramBDLocation1.getLongitude());
      arrayOfObject2[1] = Double.valueOf(paramBDLocation1.getLatitude());
      arrayOfObject2[2] = Integer.valueOf((int)paramBDLocation1.getRadius());
      localStringBuffer.append(String.format(localLocale2, "&ofwf=1|%f|%f|%d", arrayOfObject2));
      break label32;
      label261: localStringBuffer.append("&rgcn=0");
      break label51;
      label272: localStringBuffer.append("&poin=0");
      break label70;
      label283: localStringBuffer.append("&desc=0");
    }
  }

  static String[] jdMethod_if(h paramh, f paramf, BDLocation paramBDLocation, String paramString, boolean paramBoolean, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramh != null)
      localStringBuffer.append(com.baidu.location.h.b.cU().jdMethod_new(paramh));
    if (paramf != null)
      localStringBuffer.append(paramf.e(30));
    if (localStringBuffer.length() > 0)
    {
      if (paramString != null)
        localStringBuffer.append(paramString);
      localArrayList.add("-loc");
      localArrayList.add(localStringBuffer.toString());
    }
    if (paramBDLocation != null)
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Double.valueOf(paramBDLocation.getLatitude());
      arrayOfObject[1] = Double.valueOf(paramBDLocation.getLongitude());
      arrayOfObject[2] = Integer.valueOf(paramBDLocation.getLocType());
      arrayOfObject[3] = paramBDLocation.getNetworkLocationType();
      String str = String.format(localLocale, "%f;%f;%d;%s", arrayOfObject);
      localArrayList.add("-com");
      localArrayList.add(str);
    }
    if (paramBoolean)
    {
      localArrayList.add("-log");
      localArrayList.add("true");
    }
    if (k.cf.equals("all"))
    {
      localArrayList.add("-rgc");
      localArrayList.add("true");
    }
    if (k.bP)
    {
      localArrayList.add("-poi");
      localArrayList.add("true");
    }
    if (k.bX)
    {
      localArrayList.add("-des");
      localArrayList.add("true");
    }
    localArrayList.add("-minap");
    localArrayList.add(Integer.toString(paramInt));
    String[] arrayOfString = new String[localArrayList.size()];
    localArrayList.toArray(arrayOfString);
    return arrayOfString;
  }

  static final class a
  {
    private static final String a = "cl=";
    private static final String jdField_case = "wf=";
    final boolean jdField_byte;
    final boolean jdField_char;
    final int jdField_do;
    final String jdField_else;
    final String jdField_for;
    final LinkedHashMap jdField_if;
    final boolean jdField_int;
    final boolean jdField_new;
    final BDLocation jdField_try;

    public a(String[] paramArrayOfString)
    {
      if (paramArrayOfString == null)
      {
        this.jdField_else = null;
        this.jdField_for = null;
        this.jdField_if = null;
        this.jdField_new = false;
        this.jdField_int = false;
        this.jdField_byte = false;
        this.jdField_try = null;
        this.jdField_char = false;
        this.jdField_do = 8;
        return;
      }
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      int i = 0;
      int j = 8;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      int k = 0;
      Object localObject = null;
      String str1 = null;
      String str2 = null;
      try
      {
        if (i < paramArrayOfString.length)
          if (paramArrayOfString[i].equals("-loc"))
          {
            str2 = paramArrayOfString[(i + 1)];
            String[] arrayOfString2 = str2.split("&");
            i1 = 0;
            if (i1 < arrayOfString2.length)
            {
              if (arrayOfString2[i1].startsWith("cl="))
              {
                str1 = arrayOfString2[i1].substring(3);
                break label591;
              }
              if (!arrayOfString2[i1].startsWith("wf="))
                break label591;
              String[] arrayOfString3 = arrayOfString2[i1].substring(3).split("\\|");
              i2 = 0;
              if (i2 >= arrayOfString3.length)
                break label591;
              String[] arrayOfString4 = arrayOfString3[i2].split(";");
              if (arrayOfString4.length < 2)
                break label597;
              localLinkedHashMap.put(arrayOfString4[0], Integer.valueOf(arrayOfString4[1]));
              break label597;
            }
          }
          else
          {
            if (!paramArrayOfString[i].equals("-com"))
              break label341;
            arrayOfString1 = paramArrayOfString[(i + 1)].split(";");
            if (arrayOfString1.length > 0)
              localBDLocation = new BDLocation();
          }
      }
      catch (Exception localException3)
      {
        while (true)
        {
          int i1;
          int i2;
          try
          {
            String[] arrayOfString1;
            localBDLocation.setLatitude(Double.valueOf(arrayOfString1[0]).doubleValue());
            localBDLocation.setLongitude(Double.valueOf(arrayOfString1[1]).doubleValue());
            localBDLocation.setLocType(Integer.valueOf(arrayOfString1[2]).intValue());
            localBDLocation.setNetworkLocationType(arrayOfString1[3]);
            localObject = localBDLocation;
            i += 2;
            continue;
            label341: if (!paramArrayOfString[i].equals("-log"))
              continue;
            if (!paramArrayOfString[(i + 1)].equals("true"))
              continue;
            k = 1;
            continue;
            if (!paramArrayOfString[i].equals("-rgc"))
              continue;
            if (!paramArrayOfString[(i + 1)].equals("true"))
              continue;
            bool2 = true;
            continue;
            if (!paramArrayOfString[i].equals("-poi"))
              continue;
            if (!paramArrayOfString[(i + 1)].equals("true"))
              continue;
            bool3 = true;
            continue;
            boolean bool5 = paramArrayOfString[i].equals("-minap");
            if (!bool5)
              continue;
            m = i + 1;
          }
          catch (Exception localException3)
          {
            try
            {
              BDLocation localBDLocation;
              int m;
              int n = Integer.valueOf(paramArrayOfString[m]).intValue();
              j = n;
              continue;
              if (!paramArrayOfString[i].equals("-des"))
                continue;
              boolean bool6 = paramArrayOfString[(i + 1)].equals("true");
              if (!bool6)
                continue;
              bool1 = true;
              continue;
              if (k != 0)
                continue;
              str2 = null;
              boolean bool4 = true;
              this.jdField_else = str2;
              this.jdField_for = str1;
              this.jdField_if = localLinkedHashMap;
              this.jdField_new = bool4;
              this.jdField_int = bool3;
              this.jdField_byte = bool2;
              this.jdField_do = j;
              this.jdField_try = localObject;
              this.jdField_char = bool1;
              return;
              localException1 = localException1;
              bool4 = false;
              continue;
              localException3 = localException3;
              localObject = localBDLocation;
              continue;
            }
            catch (Exception localException2)
            {
            }
            continue;
          }
          label591: i1++;
          continue;
          label597: i2++;
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.c
 * JD-Core Version:    0.6.0
 */