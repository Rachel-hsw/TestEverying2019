package com.baidu.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.location.b.f;
import java.util.ArrayList;
import java.util.List;

public final class BDLocation
  implements Parcelable, f
{
  public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
  public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
  public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
  public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
  public static final Parcelable.Creator CREATOR = new BDLocation.1();
  public static final int LOCATION_WHERE_IN_CN = 1;
  public static final int LOCATION_WHERE_OUT_CN = 0;
  public static final int LOCATION_WHERE_UNKNOW = 2;
  public static final int OPERATORS_TYPE_MOBILE = 1;
  public static final int OPERATORS_TYPE_TELECOMU = 3;
  public static final int OPERATORS_TYPE_UNICOM = 2;
  public static final int OPERATORS_TYPE_UNKONW = 0;
  public static final int TypeCacheLocation = 65;
  public static final int TypeCriteriaException = 62;
  public static final int TypeGpsLocation = 61;
  public static final int TypeNetWorkException = 63;
  public static final int TypeNetWorkLocation = 161;
  public static final int TypeNone = 0;
  public static final int TypeOffLineLocation = 66;
  public static final int TypeOffLineLocationFail = 67;
  public static final int TypeOffLineLocationNetworkFail = 68;
  public static final int TypeServerError = 167;
  private String k0 = null;
  private int k1 = 0;
  private double k2 = 4.9E-324D;
  private String k3 = null;
  private boolean k4 = false;
  private float k5 = 0.0F;
  private String k6 = null;
  private String k7 = null;
  private int k8;
  private String kE = null;
  private int kF = -1;
  private double kG = 4.9E-324D;
  private String kH = null;
  private boolean kI = false;
  private boolean kJ = false;
  private boolean kK = false;
  private String kL = null;
  private String kM = "";
  private float kN = -1.0F;
  private String kO = null;
  private double kP = 4.9E-324D;
  private boolean kQ = false;
  private Address kR = new Address.Builder().build();
  private boolean kS = false;
  private String kT = null;
  private String kU = null;
  private int kV = 1;
  private int kW = 0;
  private float kX = 0.0F;
  private boolean kY = false;
  private List kZ = null;

  public BDLocation()
  {
  }

  private BDLocation(Parcel paramParcel)
  {
    this.k1 = paramParcel.readInt();
    this.k6 = paramParcel.readString();
    this.kG = paramParcel.readDouble();
    this.k2 = paramParcel.readDouble();
    this.kP = paramParcel.readDouble();
    this.k5 = paramParcel.readFloat();
    this.kX = paramParcel.readFloat();
    this.kF = paramParcel.readInt();
    this.kN = paramParcel.readFloat();
    this.kH = paramParcel.readString();
    this.kW = paramParcel.readInt();
    this.kT = paramParcel.readString();
    this.k0 = paramParcel.readString();
    this.kU = paramParcel.readString();
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    String str6 = paramParcel.readString();
    paramParcel.readString();
    String str7 = paramParcel.readString();
    String str8 = paramParcel.readString();
    this.kR = new Address.Builder().country(str7).countryCode(str8).province(str1).city(str2).cityCode(str6).district(str3).street(str4).streetNumber(str5).build();
    boolean[] arrayOfBoolean = new boolean[7];
    this.k8 = paramParcel.readInt();
    this.kM = paramParcel.readString();
    this.kL = paramParcel.readString();
    this.kO = paramParcel.readString();
    this.k3 = paramParcel.readString();
    this.kV = paramParcel.readInt();
    try
    {
      paramParcel.readBooleanArray(arrayOfBoolean);
      this.kI = arrayOfBoolean[0];
      this.kJ = arrayOfBoolean[1];
      this.kS = arrayOfBoolean[2];
      this.k4 = arrayOfBoolean[3];
      this.kY = arrayOfBoolean[4];
      this.kQ = arrayOfBoolean[5];
      this.kK = arrayOfBoolean[6];
      label503: ArrayList localArrayList = new ArrayList();
      paramParcel.readList(localArrayList, Poi.class.getClassLoader());
      if (localArrayList.size() == 0)
      {
        this.kZ = null;
        return;
      }
      this.kZ = localArrayList;
      return;
    }
    catch (Exception localException)
    {
      break label503;
    }
  }

  public BDLocation(BDLocation paramBDLocation)
  {
    this.k1 = paramBDLocation.k1;
    this.k6 = paramBDLocation.k6;
    this.kG = paramBDLocation.kG;
    this.k2 = paramBDLocation.k2;
    this.kI = paramBDLocation.kI;
    this.kP = paramBDLocation.kP;
    this.kJ = paramBDLocation.kJ;
    this.k5 = paramBDLocation.k5;
    this.kS = paramBDLocation.kS;
    this.kX = paramBDLocation.kX;
    this.k4 = paramBDLocation.k4;
    this.kF = paramBDLocation.kF;
    this.kN = paramBDLocation.kN;
    this.k7 = paramBDLocation.k7;
    this.kY = paramBDLocation.kY;
    this.kE = paramBDLocation.kE;
    this.kQ = paramBDLocation.kQ;
    this.kR = new Address.Builder().country(paramBDLocation.kR.country).countryCode(paramBDLocation.kR.countryCode).province(paramBDLocation.kR.province).city(paramBDLocation.kR.city).cityCode(paramBDLocation.kR.cityCode).district(paramBDLocation.kR.district).street(paramBDLocation.kR.street).streetNumber(paramBDLocation.kR.streetNumber).build();
    this.kH = paramBDLocation.kH;
    this.kT = paramBDLocation.kT;
    this.k0 = paramBDLocation.k0;
    this.kV = paramBDLocation.kV;
    this.kW = paramBDLocation.kW;
    this.kK = paramBDLocation.kK;
    this.kU = paramBDLocation.kU;
    this.k8 = paramBDLocation.k8;
    this.kM = paramBDLocation.kM;
    this.kL = paramBDLocation.kL;
    this.kO = paramBDLocation.kO;
    this.k3 = paramBDLocation.k3;
    if (paramBDLocation.kZ == null)
    {
      this.kZ = null;
      return;
    }
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramBDLocation.kZ.size(); i++)
    {
      Poi localPoi = (Poi)paramBDLocation.kZ.get(i);
      localArrayList.add(new Poi(localPoi.getId(), localPoi.getName(), localPoi.getRank()));
    }
    this.kZ = localArrayList;
  }

  // ERROR //
  public BDLocation(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 100	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 102	com/baidu/location/BDLocation:k1	I
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 104	com/baidu/location/BDLocation:k6	Ljava/lang/String;
    //   14: aload_0
    //   15: ldc2_w 105
    //   18: putfield 108	com/baidu/location/BDLocation:kG	D
    //   21: aload_0
    //   22: ldc2_w 105
    //   25: putfield 110	com/baidu/location/BDLocation:k2	D
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 112	com/baidu/location/BDLocation:kI	Z
    //   33: aload_0
    //   34: ldc2_w 105
    //   37: putfield 114	com/baidu/location/BDLocation:kP	D
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 116	com/baidu/location/BDLocation:kJ	Z
    //   45: aload_0
    //   46: fconst_0
    //   47: putfield 118	com/baidu/location/BDLocation:k5	F
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 120	com/baidu/location/BDLocation:kS	Z
    //   55: aload_0
    //   56: fconst_0
    //   57: putfield 122	com/baidu/location/BDLocation:kX	F
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 124	com/baidu/location/BDLocation:k4	Z
    //   65: aload_0
    //   66: iconst_m1
    //   67: putfield 126	com/baidu/location/BDLocation:kF	I
    //   70: aload_0
    //   71: ldc 127
    //   73: putfield 129	com/baidu/location/BDLocation:kN	F
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 131	com/baidu/location/BDLocation:k7	Ljava/lang/String;
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 133	com/baidu/location/BDLocation:kY	Z
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 135	com/baidu/location/BDLocation:kE	Ljava/lang/String;
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 137	com/baidu/location/BDLocation:kL	Ljava/lang/String;
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 139	com/baidu/location/BDLocation:kO	Ljava/lang/String;
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 141	com/baidu/location/BDLocation:k3	Ljava/lang/String;
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 143	com/baidu/location/BDLocation:kQ	Z
    //   111: aload_0
    //   112: new 145	com/baidu/location/Address$Builder
    //   115: dup
    //   116: invokespecial 146	com/baidu/location/Address$Builder:<init>	()V
    //   119: invokevirtual 150	com/baidu/location/Address$Builder:build	()Lcom/baidu/location/Address;
    //   122: putfield 152	com/baidu/location/BDLocation:kR	Lcom/baidu/location/Address;
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 154	com/baidu/location/BDLocation:kH	Ljava/lang/String;
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 156	com/baidu/location/BDLocation:kT	Ljava/lang/String;
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 158	com/baidu/location/BDLocation:k0	Ljava/lang/String;
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield 160	com/baidu/location/BDLocation:kK	Z
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield 162	com/baidu/location/BDLocation:kW	I
    //   150: aload_0
    //   151: iconst_1
    //   152: putfield 164	com/baidu/location/BDLocation:kV	I
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 166	com/baidu/location/BDLocation:kU	Ljava/lang/String;
    //   160: aload_0
    //   161: ldc 168
    //   163: putfield 170	com/baidu/location/BDLocation:kM	Ljava/lang/String;
    //   166: aload_0
    //   167: aconst_null
    //   168: putfield 172	com/baidu/location/BDLocation:kZ	Ljava/util/List;
    //   171: aload_1
    //   172: ifnull +12 -> 184
    //   175: aload_1
    //   176: ldc 168
    //   178: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifeq +4 -> 185
    //   184: return
    //   185: new 294	org/json/JSONObject
    //   188: dup
    //   189: aload_1
    //   190: invokespecial 296	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   193: astore_2
    //   194: aload_2
    //   195: ldc_w 298
    //   198: invokevirtual 302	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   201: astore 4
    //   203: aload 4
    //   205: ldc_w 304
    //   208: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   211: invokestatic 314	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   214: istore 5
    //   216: aload_0
    //   217: iload 5
    //   219: invokevirtual 318	com/baidu/location/BDLocation:setLocType	(I)V
    //   222: aload_0
    //   223: aload 4
    //   225: ldc_w 320
    //   228: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   231: invokevirtual 323	com/baidu/location/BDLocation:setTime	(Ljava/lang/String;)V
    //   234: iload 5
    //   236: bipush 61
    //   238: if_icmpne +217 -> 455
    //   241: aload_2
    //   242: ldc_w 325
    //   245: invokevirtual 302	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   248: astore 6
    //   250: aload 6
    //   252: ldc_w 327
    //   255: invokevirtual 302	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   258: astore 7
    //   260: aload_0
    //   261: aload 7
    //   263: ldc_w 329
    //   266: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: invokestatic 335	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   272: invokevirtual 339	com/baidu/location/BDLocation:setLatitude	(D)V
    //   275: aload_0
    //   276: aload 7
    //   278: ldc_w 341
    //   281: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   284: invokestatic 335	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   287: invokevirtual 344	com/baidu/location/BDLocation:setLongitude	(D)V
    //   290: aload_0
    //   291: aload 6
    //   293: ldc_w 346
    //   296: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokestatic 352	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   302: invokevirtual 356	com/baidu/location/BDLocation:setRadius	(F)V
    //   305: aload_0
    //   306: aload 6
    //   308: ldc_w 358
    //   311: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   314: invokestatic 352	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   317: invokevirtual 361	com/baidu/location/BDLocation:setSpeed	(F)V
    //   320: aload_0
    //   321: aload 6
    //   323: ldc_w 363
    //   326: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: invokestatic 352	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   332: invokevirtual 366	com/baidu/location/BDLocation:setDirection	(F)V
    //   335: aload_0
    //   336: aload 6
    //   338: ldc_w 368
    //   341: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   344: invokestatic 314	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   347: invokevirtual 371	com/baidu/location/BDLocation:setSatelliteNumber	(I)V
    //   350: aload 6
    //   352: ldc_w 373
    //   355: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   358: istore 8
    //   360: iload 8
    //   362: ifeq +15 -> 377
    //   365: aload_0
    //   366: aload 6
    //   368: ldc_w 373
    //   371: invokevirtual 380	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   374: invokevirtual 383	com/baidu/location/BDLocation:setAltitude	(D)V
    //   377: aload 6
    //   379: ldc_w 385
    //   382: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   385: ifeq +49 -> 434
    //   388: aload_0
    //   389: aload 6
    //   391: ldc_w 385
    //   394: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   397: invokestatic 314	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   400: invokevirtual 388	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   403: aload_0
    //   404: getfield 164	com/baidu/location/BDLocation:kV	I
    //   407: ifne +40 -> 447
    //   410: aload_0
    //   411: ldc_w 390
    //   414: invokevirtual 393	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   417: return
    //   418: astore_3
    //   419: aload_3
    //   420: invokevirtual 396	java/lang/Exception:printStackTrace	()V
    //   423: aload_0
    //   424: iconst_0
    //   425: putfield 102	com/baidu/location/BDLocation:k1	I
    //   428: aload_0
    //   429: iconst_0
    //   430: putfield 133	com/baidu/location/BDLocation:kY	Z
    //   433: return
    //   434: aload_0
    //   435: iconst_1
    //   436: invokevirtual 388	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   439: goto -36 -> 403
    //   442: astore 9
    //   444: goto -41 -> 403
    //   447: aload_0
    //   448: ldc_w 398
    //   451: invokevirtual 393	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   454: return
    //   455: iload 5
    //   457: sipush 161
    //   460: if_icmpne +954 -> 1414
    //   463: aload_2
    //   464: ldc_w 325
    //   467: invokevirtual 302	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   470: astore 11
    //   472: aload 11
    //   474: ldc_w 327
    //   477: invokevirtual 302	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   480: astore 12
    //   482: aload_0
    //   483: aload 12
    //   485: ldc_w 329
    //   488: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: invokestatic 335	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   494: invokevirtual 339	com/baidu/location/BDLocation:setLatitude	(D)V
    //   497: aload_0
    //   498: aload 12
    //   500: ldc_w 341
    //   503: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   506: invokestatic 335	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   509: invokevirtual 344	com/baidu/location/BDLocation:setLongitude	(D)V
    //   512: aload_0
    //   513: aload 11
    //   515: ldc_w 346
    //   518: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   521: invokestatic 352	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   524: invokevirtual 356	com/baidu/location/BDLocation:setRadius	(F)V
    //   527: aload 11
    //   529: ldc_w 400
    //   532: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   535: ifeq +240 -> 775
    //   538: aload 11
    //   540: ldc_w 400
    //   543: invokevirtual 302	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   546: astore 25
    //   548: aload 25
    //   550: ldc_w 402
    //   553: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   556: ifeq +27 -> 583
    //   559: aload 25
    //   561: ldc_w 402
    //   564: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   567: astore 34
    //   569: aload 34
    //   571: invokestatic 408	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   574: ifne +116 -> 690
    //   577: aload_0
    //   578: aload 34
    //   580: putfield 137	com/baidu/location/BDLocation:kL	Ljava/lang/String;
    //   583: aload 25
    //   585: ldc_w 410
    //   588: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   591: ifeq +114 -> 705
    //   594: aload 25
    //   596: ldc_w 410
    //   599: invokevirtual 302	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   602: ldc_w 412
    //   605: invokevirtual 416	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   608: astore 28
    //   610: new 226	java/util/ArrayList
    //   613: dup
    //   614: invokespecial 227	java/util/ArrayList:<init>	()V
    //   617: astore 29
    //   619: iconst_0
    //   620: istore 30
    //   622: iload 30
    //   624: aload 28
    //   626: invokevirtual 421	org/json/JSONArray:length	()I
    //   629: if_icmpge +70 -> 699
    //   632: aload 28
    //   634: iload 30
    //   636: invokevirtual 424	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   639: astore 31
    //   641: aload 31
    //   643: ldc_w 426
    //   646: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   649: astore 32
    //   651: aload 29
    //   653: new 229	com/baidu/location/Poi
    //   656: dup
    //   657: aload 31
    //   659: ldc_w 428
    //   662: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   665: aload 32
    //   667: aload 31
    //   669: ldc_w 430
    //   672: invokevirtual 380	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   675: invokespecial 282	com/baidu/location/Poi:<init>	(Ljava/lang/String;Ljava/lang/String;D)V
    //   678: invokeinterface 286 2 0
    //   683: pop
    //   684: iinc 30 1
    //   687: goto -65 -> 622
    //   690: aload_0
    //   691: ldc 168
    //   693: putfield 137	com/baidu/location/BDLocation:kL	Ljava/lang/String;
    //   696: goto -113 -> 583
    //   699: aload_0
    //   700: aload 29
    //   702: putfield 172	com/baidu/location/BDLocation:kZ	Ljava/util/List;
    //   705: aload 25
    //   707: ldc_w 432
    //   710: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   713: ifeq +27 -> 740
    //   716: aload 25
    //   718: ldc_w 432
    //   721: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   724: astore 27
    //   726: aload 27
    //   728: invokestatic 408	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   731: ifne +9 -> 740
    //   734: aload_0
    //   735: aload 27
    //   737: putfield 139	com/baidu/location/BDLocation:kO	Ljava/lang/String;
    //   740: aload 25
    //   742: ldc_w 434
    //   745: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   748: ifeq +27 -> 775
    //   751: aload 25
    //   753: ldc_w 434
    //   756: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   759: astore 26
    //   761: aload 26
    //   763: invokestatic 408	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   766: ifne +9 -> 775
    //   769: aload_0
    //   770: aload 26
    //   772: putfield 141	com/baidu/location/BDLocation:k3	Ljava/lang/String;
    //   775: aload 11
    //   777: ldc_w 436
    //   780: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   783: ifeq +412 -> 1195
    //   786: aload 11
    //   788: ldc_w 436
    //   791: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   794: ldc_w 438
    //   797: invokevirtual 442	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   800: astore 15
    //   802: aload 15
    //   804: arraylength
    //   805: istore 16
    //   807: iload 16
    //   809: ifle +599 -> 1408
    //   812: aload 15
    //   814: iconst_0
    //   815: aaload
    //   816: astore 17
    //   818: iload 16
    //   820: iconst_1
    //   821: if_icmple +581 -> 1402
    //   824: aload 15
    //   826: iconst_1
    //   827: aaload
    //   828: astore 18
    //   830: iload 16
    //   832: iconst_2
    //   833: if_icmple +563 -> 1396
    //   836: aload 15
    //   838: iconst_2
    //   839: aaload
    //   840: astore 19
    //   842: iload 16
    //   844: iconst_3
    //   845: if_icmple +545 -> 1390
    //   848: aload 15
    //   850: iconst_3
    //   851: aaload
    //   852: astore 20
    //   854: iload 16
    //   856: iconst_4
    //   857: if_icmple +527 -> 1384
    //   860: aload 15
    //   862: iconst_4
    //   863: aaload
    //   864: astore 21
    //   866: iload 16
    //   868: iconst_5
    //   869: if_icmple +509 -> 1378
    //   872: aload 15
    //   874: iconst_5
    //   875: aaload
    //   876: astore 22
    //   878: iload 16
    //   880: bipush 6
    //   882: if_icmple +490 -> 1372
    //   885: aload 15
    //   887: bipush 6
    //   889: aaload
    //   890: astore 23
    //   892: aconst_null
    //   893: astore 24
    //   895: iload 16
    //   897: bipush 7
    //   899: if_icmple +10 -> 909
    //   902: aload 15
    //   904: bipush 7
    //   906: aaload
    //   907: astore 24
    //   909: aload_0
    //   910: new 145	com/baidu/location/Address$Builder
    //   913: dup
    //   914: invokespecial 146	com/baidu/location/Address$Builder:<init>	()V
    //   917: aload 23
    //   919: invokevirtual 197	com/baidu/location/Address$Builder:country	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   922: aload 24
    //   924: invokevirtual 200	com/baidu/location/Address$Builder:countryCode	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   927: aload 17
    //   929: invokevirtual 203	com/baidu/location/Address$Builder:province	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   932: aload 18
    //   934: invokevirtual 206	com/baidu/location/Address$Builder:city	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   937: aload 22
    //   939: invokevirtual 209	com/baidu/location/Address$Builder:cityCode	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   942: aload 19
    //   944: invokevirtual 212	com/baidu/location/Address$Builder:district	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   947: aload 20
    //   949: invokevirtual 215	com/baidu/location/Address$Builder:street	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   952: aload 21
    //   954: invokevirtual 218	com/baidu/location/Address$Builder:streetNumber	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   957: invokevirtual 150	com/baidu/location/Address$Builder:build	()Lcom/baidu/location/Address;
    //   960: putfield 152	com/baidu/location/BDLocation:kR	Lcom/baidu/location/Address;
    //   963: aload_0
    //   964: iconst_1
    //   965: putfield 133	com/baidu/location/BDLocation:kY	Z
    //   968: aload 11
    //   970: ldc_w 444
    //   973: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   976: ifeq +30 -> 1006
    //   979: aload_0
    //   980: aload 11
    //   982: ldc_w 444
    //   985: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   988: putfield 154	com/baidu/location/BDLocation:kH	Ljava/lang/String;
    //   991: aload_0
    //   992: getfield 154	com/baidu/location/BDLocation:kH	Ljava/lang/String;
    //   995: invokestatic 408	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   998: ifeq +8 -> 1006
    //   1001: aload_0
    //   1002: aconst_null
    //   1003: putfield 154	com/baidu/location/BDLocation:kH	Ljava/lang/String;
    //   1006: aload 11
    //   1008: ldc_w 446
    //   1011: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1014: ifeq +30 -> 1044
    //   1017: aload_0
    //   1018: aload 11
    //   1020: ldc_w 446
    //   1023: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1026: putfield 166	com/baidu/location/BDLocation:kU	Ljava/lang/String;
    //   1029: aload_0
    //   1030: getfield 166	com/baidu/location/BDLocation:kU	Ljava/lang/String;
    //   1033: invokestatic 408	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1036: ifeq +8 -> 1044
    //   1039: aload_0
    //   1040: aconst_null
    //   1041: putfield 166	com/baidu/location/BDLocation:kU	Ljava/lang/String;
    //   1044: aload 11
    //   1046: ldc_w 448
    //   1049: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1052: ifeq +30 -> 1082
    //   1055: aload_0
    //   1056: aload 11
    //   1058: ldc_w 448
    //   1061: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1064: putfield 156	com/baidu/location/BDLocation:kT	Ljava/lang/String;
    //   1067: aload_0
    //   1068: getfield 156	com/baidu/location/BDLocation:kT	Ljava/lang/String;
    //   1071: invokestatic 408	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1074: ifeq +8 -> 1082
    //   1077: aload_0
    //   1078: aconst_null
    //   1079: putfield 156	com/baidu/location/BDLocation:kT	Ljava/lang/String;
    //   1082: aload 11
    //   1084: ldc_w 450
    //   1087: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1090: ifeq +30 -> 1120
    //   1093: aload_0
    //   1094: aload 11
    //   1096: ldc_w 450
    //   1099: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1102: putfield 158	com/baidu/location/BDLocation:k0	Ljava/lang/String;
    //   1105: aload_0
    //   1106: getfield 158	com/baidu/location/BDLocation:k0	Ljava/lang/String;
    //   1109: invokestatic 408	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1112: ifeq +8 -> 1120
    //   1115: aload_0
    //   1116: aconst_null
    //   1117: putfield 158	com/baidu/location/BDLocation:k0	Ljava/lang/String;
    //   1120: aload 11
    //   1122: ldc_w 452
    //   1125: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1128: ifeq +26 -> 1154
    //   1131: aload 11
    //   1133: ldc_w 452
    //   1136: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1139: astore 14
    //   1141: aload 14
    //   1143: invokestatic 408	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1146: ifeq +62 -> 1208
    //   1149: aload_0
    //   1150: iconst_0
    //   1151: putfield 162	com/baidu/location/BDLocation:kW	I
    //   1154: aload 11
    //   1156: ldc_w 385
    //   1159: invokevirtual 377	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1162: ifeq +80 -> 1242
    //   1165: aload_0
    //   1166: aload 11
    //   1168: ldc_w 385
    //   1171: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1174: invokestatic 314	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1177: invokevirtual 388	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   1180: aload_0
    //   1181: getfield 164	com/baidu/location/BDLocation:kV	I
    //   1184: ifne +71 -> 1255
    //   1187: aload_0
    //   1188: ldc_w 390
    //   1191: invokevirtual 393	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   1194: return
    //   1195: aload_0
    //   1196: iconst_0
    //   1197: putfield 133	com/baidu/location/BDLocation:kY	Z
    //   1200: aload_0
    //   1201: aconst_null
    //   1202: invokevirtual 455	com/baidu/location/BDLocation:setAddrStr	(Ljava/lang/String;)V
    //   1205: goto -237 -> 968
    //   1208: aload 14
    //   1210: ldc_w 457
    //   1213: invokevirtual 292	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1216: ifeq +11 -> 1227
    //   1219: aload_0
    //   1220: iconst_0
    //   1221: putfield 162	com/baidu/location/BDLocation:kW	I
    //   1224: goto -70 -> 1154
    //   1227: aload_0
    //   1228: aload 14
    //   1230: invokestatic 461	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1233: invokevirtual 464	java/lang/Integer:intValue	()I
    //   1236: putfield 162	com/baidu/location/BDLocation:kW	I
    //   1239: goto -85 -> 1154
    //   1242: aload_0
    //   1243: iconst_1
    //   1244: invokevirtual 388	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   1247: goto -67 -> 1180
    //   1250: astore 13
    //   1252: goto -72 -> 1180
    //   1255: aload_0
    //   1256: ldc_w 398
    //   1259: invokevirtual 393	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   1262: return
    //   1263: aload_2
    //   1264: ldc_w 325
    //   1267: invokevirtual 302	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1270: astore 35
    //   1272: aload 35
    //   1274: ldc_w 327
    //   1277: invokevirtual 302	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1280: astore 36
    //   1282: aload_0
    //   1283: aload 36
    //   1285: ldc_w 329
    //   1288: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1291: invokestatic 335	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   1294: invokevirtual 339	com/baidu/location/BDLocation:setLatitude	(D)V
    //   1297: aload_0
    //   1298: aload 36
    //   1300: ldc_w 341
    //   1303: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1306: invokestatic 335	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   1309: invokevirtual 344	com/baidu/location/BDLocation:setLongitude	(D)V
    //   1312: aload_0
    //   1313: aload 35
    //   1315: ldc_w 346
    //   1318: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1321: invokestatic 352	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1324: invokevirtual 356	com/baidu/location/BDLocation:setRadius	(F)V
    //   1327: aload_0
    //   1328: aload 35
    //   1330: ldc_w 466
    //   1333: invokevirtual 308	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1336: invokestatic 471	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   1339: invokestatic 474	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1342: invokespecial 478	com/baidu/location/BDLocation:if	(Ljava/lang/Boolean;)V
    //   1345: aload_0
    //   1346: ldc_w 398
    //   1349: invokevirtual 393	com/baidu/location/BDLocation:setCoorType	(Ljava/lang/String;)V
    //   1352: return
    //   1353: iload 5
    //   1355: sipush 167
    //   1358: if_icmpne -1174 -> 184
    //   1361: aload_0
    //   1362: iconst_2
    //   1363: invokevirtual 388	com/baidu/location/BDLocation:setLocationWhere	(I)V
    //   1366: return
    //   1367: astore 10
    //   1369: goto -992 -> 377
    //   1372: aconst_null
    //   1373: astore 23
    //   1375: goto -483 -> 892
    //   1378: aconst_null
    //   1379: astore 22
    //   1381: goto -503 -> 878
    //   1384: aconst_null
    //   1385: astore 21
    //   1387: goto -521 -> 866
    //   1390: aconst_null
    //   1391: astore 20
    //   1393: goto -539 -> 854
    //   1396: aconst_null
    //   1397: astore 19
    //   1399: goto -557 -> 842
    //   1402: aconst_null
    //   1403: astore 18
    //   1405: goto -575 -> 830
    //   1408: aconst_null
    //   1409: astore 17
    //   1411: goto -593 -> 818
    //   1414: iload 5
    //   1416: bipush 66
    //   1418: if_icmpeq -155 -> 1263
    //   1421: iload 5
    //   1423: bipush 68
    //   1425: if_icmpne -72 -> 1353
    //   1428: goto -165 -> 1263
    //
    // Exception table:
    //   from	to	target	type
    //   185	234	418	java/lang/Exception
    //   241	360	418	java/lang/Exception
    //   403	417	418	java/lang/Exception
    //   447	454	418	java/lang/Exception
    //   463	583	418	java/lang/Exception
    //   583	619	418	java/lang/Exception
    //   622	684	418	java/lang/Exception
    //   690	696	418	java/lang/Exception
    //   699	705	418	java/lang/Exception
    //   705	740	418	java/lang/Exception
    //   740	775	418	java/lang/Exception
    //   775	807	418	java/lang/Exception
    //   812	818	418	java/lang/Exception
    //   824	830	418	java/lang/Exception
    //   836	842	418	java/lang/Exception
    //   848	854	418	java/lang/Exception
    //   860	866	418	java/lang/Exception
    //   872	878	418	java/lang/Exception
    //   885	892	418	java/lang/Exception
    //   902	909	418	java/lang/Exception
    //   909	968	418	java/lang/Exception
    //   968	1006	418	java/lang/Exception
    //   1006	1044	418	java/lang/Exception
    //   1044	1082	418	java/lang/Exception
    //   1082	1120	418	java/lang/Exception
    //   1120	1154	418	java/lang/Exception
    //   1180	1194	418	java/lang/Exception
    //   1195	1205	418	java/lang/Exception
    //   1208	1224	418	java/lang/Exception
    //   1227	1239	418	java/lang/Exception
    //   1255	1262	418	java/lang/Exception
    //   1263	1352	418	java/lang/Exception
    //   1361	1366	418	java/lang/Exception
    //   377	403	442	java/lang/Exception
    //   434	439	442	java/lang/Exception
    //   1154	1180	1250	java/lang/Exception
    //   1242	1247	1250	java/lang/Exception
    //   365	377	1367	java/lang/Exception
  }

  private String dC()
  {
    return this.kO;
  }

  private String dD()
  {
    return this.kM;
  }

  private String dE()
  {
    return this.k3;
  }

  private static String dF()
  {
    return Build.MODEL;
  }

  private void jdMethod_if(Boolean paramBoolean)
  {
    this.kQ = paramBoolean.booleanValue();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAdUrl(String paramString)
  {
    String str1 = String.valueOf(this.kG);
    String str2 = String.valueOf(this.k2);
    String str3 = dD();
    String str4 = dF();
    String str5 = Jni.E("ak=" + paramString + "&" + "lat=" + str1 + "&" + "lng=" + str2 + "&" + "cu=" + str3 + "&" + "mb=" + str4);
    return "http://lba.baidu.com/" + "?a=" + str5;
  }

  public String getAddrStr()
  {
    return this.kR.address;
  }

  public Address getAddress()
  {
    return this.kR;
  }

  public double getAltitude()
  {
    return this.kP;
  }

  public String getBuildingID()
  {
    return this.kT;
  }

  public String getBuildingName()
  {
    return this.k0;
  }

  public String getCity()
  {
    return this.kR.city;
  }

  public String getCityCode()
  {
    return this.kR.cityCode;
  }

  public String getCoorType()
  {
    return this.k7;
  }

  public String getCountry()
  {
    return this.kR.country;
  }

  public String getCountryCode()
  {
    return this.kR.countryCode;
  }

  public float getDerect()
  {
    return this.kN;
  }

  public float getDirection()
  {
    return this.kN;
  }

  public String getDistrict()
  {
    return this.kR.district;
  }

  public String getFloor()
  {
    return this.kH;
  }

  public double getLatitude()
  {
    return this.kG;
  }

  public int getLocType()
  {
    return this.k1;
  }

  public String getLocationDescribe()
  {
    return this.kL;
  }

  public int getLocationWhere()
  {
    return this.kV;
  }

  public double getLongitude()
  {
    return this.k2;
  }

  public String getNetworkLocationType()
  {
    return this.kU;
  }

  public int getOperators()
  {
    return this.k8;
  }

  public List getPoiList()
  {
    return this.kZ;
  }

  public String getProvince()
  {
    return this.kR.province;
  }

  public float getRadius()
  {
    return this.kX;
  }

  public int getSatelliteNumber()
  {
    this.k4 = true;
    return this.kF;
  }

  public String getSemaAptag()
  {
    return this.kL;
  }

  public float getSpeed()
  {
    return this.k5;
  }

  public String getStreet()
  {
    return this.kR.street;
  }

  public String getStreetNumber()
  {
    return this.kR.streetNumber;
  }

  public String getTime()
  {
    return this.k6;
  }

  public boolean hasAddr()
  {
    return this.kY;
  }

  public boolean hasAltitude()
  {
    return this.kI;
  }

  public boolean hasRadius()
  {
    return this.kS;
  }

  public boolean hasSateNumber()
  {
    return this.k4;
  }

  public boolean hasSpeed()
  {
    return this.kJ;
  }

  public void internalSet(int paramInt, String paramString)
  {
    if (paramString == null);
    do
      return;
    while (paramInt != 0);
    this.kM = paramString;
  }

  public boolean isCellChangeFlag()
  {
    return this.kQ;
  }

  public boolean isIndoorLocMode()
  {
    return this.kK;
  }

  public int isParkAvailable()
  {
    return this.kW;
  }

  public void setAddr(Address paramAddress)
  {
    if (paramAddress != null)
    {
      this.kR = paramAddress;
      this.kY = true;
    }
  }

  public void setAddrStr(String paramString)
  {
    this.kE = paramString;
    if (paramString == null)
    {
      this.kY = false;
      return;
    }
    this.kY = true;
  }

  public void setAltitude(double paramDouble)
  {
    this.kP = paramDouble;
    this.kI = true;
  }

  public void setBuildingID(String paramString)
  {
    this.kT = paramString;
  }

  public void setBuildingName(String paramString)
  {
    this.k0 = paramString;
  }

  public void setCoorType(String paramString)
  {
    this.k7 = paramString;
  }

  public void setDirection(float paramFloat)
  {
    this.kN = paramFloat;
  }

  public void setFloor(String paramString)
  {
    this.kH = paramString;
  }

  public void setIndoorLocMode(boolean paramBoolean)
  {
    this.kK = paramBoolean;
  }

  public void setLatitude(double paramDouble)
  {
    this.kG = paramDouble;
  }

  public void setLocType(int paramInt)
  {
    this.k1 = paramInt;
  }

  public void setLocationDescribe(String paramString)
  {
    this.kL = paramString;
  }

  public void setLocationWhere(int paramInt)
  {
    this.kV = paramInt;
  }

  public void setLongitude(double paramDouble)
  {
    this.k2 = paramDouble;
  }

  public void setNetworkLocationType(String paramString)
  {
    this.kU = paramString;
  }

  public void setOperators(int paramInt)
  {
    this.k8 = paramInt;
  }

  public void setParkAvailable(int paramInt)
  {
    this.kW = paramInt;
  }

  public void setPoiList(List paramList)
  {
    this.kZ = paramList;
  }

  public void setRadius(float paramFloat)
  {
    this.kX = paramFloat;
    this.kS = true;
  }

  public void setSatelliteNumber(int paramInt)
  {
    this.kF = paramInt;
  }

  public void setSpeed(float paramFloat)
  {
    this.k5 = paramFloat;
    this.kJ = true;
  }

  public void setTime(String paramString)
  {
    this.k6 = paramString;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.k1);
    paramParcel.writeString(this.k6);
    paramParcel.writeDouble(this.kG);
    paramParcel.writeDouble(this.k2);
    paramParcel.writeDouble(this.kP);
    paramParcel.writeFloat(this.k5);
    paramParcel.writeFloat(this.kX);
    paramParcel.writeInt(this.kF);
    paramParcel.writeFloat(this.kN);
    paramParcel.writeString(this.kH);
    paramParcel.writeInt(this.kW);
    paramParcel.writeString(this.kT);
    paramParcel.writeString(this.k0);
    paramParcel.writeString(this.kU);
    paramParcel.writeString(this.kR.province);
    paramParcel.writeString(this.kR.city);
    paramParcel.writeString(this.kR.district);
    paramParcel.writeString(this.kR.street);
    paramParcel.writeString(this.kR.streetNumber);
    paramParcel.writeString(this.kR.cityCode);
    paramParcel.writeString(this.kR.address);
    paramParcel.writeString(this.kR.country);
    paramParcel.writeString(this.kR.countryCode);
    paramParcel.writeInt(this.k8);
    paramParcel.writeString(this.kM);
    paramParcel.writeString(this.kL);
    paramParcel.writeString(this.kO);
    paramParcel.writeString(this.k3);
    paramParcel.writeInt(this.kV);
    boolean[] arrayOfBoolean = new boolean[7];
    arrayOfBoolean[0] = this.kI;
    arrayOfBoolean[1] = this.kJ;
    arrayOfBoolean[2] = this.kS;
    arrayOfBoolean[3] = this.k4;
    arrayOfBoolean[4] = this.kY;
    arrayOfBoolean[5] = this.kQ;
    arrayOfBoolean[6] = this.kK;
    paramParcel.writeBooleanArray(arrayOfBoolean);
    paramParcel.writeList(this.kZ);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.BDLocation
 * JD-Core Version:    0.6.0
 */