package com.alipay.sdk.encrypt;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public final class d
{
  public static final String a = "SHA1WithRSA";
  private static final String b = "RSA";

  // ERROR //
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 22	java/security/spec/X509EncodedKeySpec
    //   5: dup
    //   6: aload_1
    //   7: invokestatic 27	com/alipay/sdk/encrypt/a:a	(Ljava/lang/String;)[B
    //   10: invokespecial 30	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   13: astore_3
    //   14: ldc 11
    //   16: invokestatic 36	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   19: aload_3
    //   20: invokevirtual 40	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   23: astore 9
    //   25: ldc 42
    //   27: invokestatic 47	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   30: astore 10
    //   32: aload 10
    //   34: iconst_1
    //   35: aload 9
    //   37: invokevirtual 51	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   40: aload_0
    //   41: ldc 53
    //   43: invokevirtual 58	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   46: astore 11
    //   48: aload 10
    //   50: invokevirtual 62	javax/crypto/Cipher:getBlockSize	()I
    //   53: istore 12
    //   55: new 64	java/io/ByteArrayOutputStream
    //   58: dup
    //   59: invokespecial 65	java/io/ByteArrayOutputStream:<init>	()V
    //   62: astore 13
    //   64: iconst_0
    //   65: istore 14
    //   67: iload 14
    //   69: aload 11
    //   71: arraylength
    //   72: if_icmpge +48 -> 120
    //   75: aload 11
    //   77: arraylength
    //   78: iload 14
    //   80: isub
    //   81: iload 12
    //   83: if_icmpge +125 -> 208
    //   86: aload 11
    //   88: arraylength
    //   89: iload 14
    //   91: isub
    //   92: istore 18
    //   94: aload 13
    //   96: aload 10
    //   98: aload 11
    //   100: iload 14
    //   102: iload 18
    //   104: invokevirtual 69	javax/crypto/Cipher:doFinal	([BII)[B
    //   107: invokevirtual 72	java/io/ByteArrayOutputStream:write	([B)V
    //   110: iload 14
    //   112: iload 12
    //   114: iadd
    //   115: istore 14
    //   117: goto -50 -> 67
    //   120: new 55	java/lang/String
    //   123: dup
    //   124: aload 13
    //   126: invokevirtual 76	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   129: invokestatic 79	com/alipay/sdk/encrypt/a:a	([B)Ljava/lang/String;
    //   132: invokespecial 82	java/lang/String:<init>	(Ljava/lang/String;)V
    //   135: astore 16
    //   137: aload 13
    //   139: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   142: aload 16
    //   144: areturn
    //   145: astore 6
    //   147: aconst_null
    //   148: astore 7
    //   150: aload 7
    //   152: ifnull +54 -> 206
    //   155: aload 7
    //   157: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore 8
    //   164: aconst_null
    //   165: areturn
    //   166: astore 4
    //   168: aload_2
    //   169: ifnull +7 -> 176
    //   172: aload_2
    //   173: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   176: aload 4
    //   178: athrow
    //   179: astore 17
    //   181: aload 16
    //   183: areturn
    //   184: astore 5
    //   186: goto -10 -> 176
    //   189: astore 4
    //   191: aload 13
    //   193: astore_2
    //   194: goto -26 -> 168
    //   197: astore 15
    //   199: aload 13
    //   201: astore 7
    //   203: goto -53 -> 150
    //   206: aconst_null
    //   207: areturn
    //   208: iload 12
    //   210: istore 18
    //   212: goto -118 -> 94
    //
    // Exception table:
    //   from	to	target	type
    //   2	64	145	java/lang/Exception
    //   155	160	162	java/io/IOException
    //   2	64	166	finally
    //   137	142	179	java/io/IOException
    //   172	176	184	java/io/IOException
    //   67	94	189	finally
    //   94	110	189	finally
    //   120	137	189	finally
    //   67	94	197	java/lang/Exception
    //   94	110	197	java/lang/Exception
    //   120	137	197	java/lang/Exception
  }

  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      PublicKey localPublicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a(paramString3)));
      Signature localSignature = Signature.getInstance("SHA1WithRSA");
      localSignature.initVerify(localPublicKey);
      localSignature.update(paramString1.getBytes("utf-8"));
      boolean bool = localSignature.verify(a.a(paramString2));
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private static PublicKey b(String paramString1, String paramString2)
    throws NoSuchAlgorithmException, Exception
  {
    X509EncodedKeySpec localX509EncodedKeySpec = new X509EncodedKeySpec(a.a(paramString2));
    return KeyFactory.getInstance(paramString1).generatePublic(localX509EncodedKeySpec);
  }

  // ERROR //
  private static String c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 110	java/security/spec/PKCS8EncodedKeySpec
    //   5: dup
    //   6: aload_1
    //   7: invokestatic 27	com/alipay/sdk/encrypt/a:a	(Ljava/lang/String;)[B
    //   10: invokespecial 111	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   13: astore_3
    //   14: ldc 11
    //   16: invokestatic 36	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   19: aload_3
    //   20: invokevirtual 115	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   23: astore 9
    //   25: ldc 42
    //   27: invokestatic 47	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   30: astore 10
    //   32: aload 10
    //   34: iconst_2
    //   35: aload 9
    //   37: invokevirtual 51	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   40: aload_0
    //   41: invokestatic 27	com/alipay/sdk/encrypt/a:a	(Ljava/lang/String;)[B
    //   44: astore 11
    //   46: aload 10
    //   48: invokevirtual 62	javax/crypto/Cipher:getBlockSize	()I
    //   51: istore 12
    //   53: new 64	java/io/ByteArrayOutputStream
    //   56: dup
    //   57: invokespecial 65	java/io/ByteArrayOutputStream:<init>	()V
    //   60: astore 13
    //   62: iconst_0
    //   63: istore 14
    //   65: iload 14
    //   67: aload 11
    //   69: arraylength
    //   70: if_icmpge +48 -> 118
    //   73: aload 11
    //   75: arraylength
    //   76: iload 14
    //   78: isub
    //   79: iload 12
    //   81: if_icmpge +122 -> 203
    //   84: aload 11
    //   86: arraylength
    //   87: iload 14
    //   89: isub
    //   90: istore 18
    //   92: aload 13
    //   94: aload 10
    //   96: aload 11
    //   98: iload 14
    //   100: iload 18
    //   102: invokevirtual 69	javax/crypto/Cipher:doFinal	([BII)[B
    //   105: invokevirtual 72	java/io/ByteArrayOutputStream:write	([B)V
    //   108: iload 14
    //   110: iload 12
    //   112: iadd
    //   113: istore 14
    //   115: goto -50 -> 65
    //   118: new 55	java/lang/String
    //   121: dup
    //   122: aload 13
    //   124: invokevirtual 76	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   127: invokespecial 116	java/lang/String:<init>	([B)V
    //   130: astore 16
    //   132: aload 13
    //   134: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   137: aload 16
    //   139: areturn
    //   140: astore 6
    //   142: aconst_null
    //   143: astore 7
    //   145: aload 7
    //   147: ifnull +54 -> 201
    //   150: aload 7
    //   152: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   155: aconst_null
    //   156: areturn
    //   157: astore 8
    //   159: aconst_null
    //   160: areturn
    //   161: astore 4
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 85	java/io/ByteArrayOutputStream:close	()V
    //   171: aload 4
    //   173: athrow
    //   174: astore 17
    //   176: aload 16
    //   178: areturn
    //   179: astore 5
    //   181: goto -10 -> 171
    //   184: astore 4
    //   186: aload 13
    //   188: astore_2
    //   189: goto -26 -> 163
    //   192: astore 15
    //   194: aload 13
    //   196: astore 7
    //   198: goto -53 -> 145
    //   201: aconst_null
    //   202: areturn
    //   203: iload 12
    //   205: istore 18
    //   207: goto -115 -> 92
    //
    // Exception table:
    //   from	to	target	type
    //   2	62	140	java/lang/Exception
    //   150	155	157	java/io/IOException
    //   2	62	161	finally
    //   132	137	174	java/io/IOException
    //   167	171	179	java/io/IOException
    //   65	92	184	finally
    //   92	108	184	finally
    //   118	132	184	finally
    //   65	92	192	java/lang/Exception
    //   92	108	192	java/lang/Exception
    //   118	132	192	java/lang/Exception
  }

  private static String d(String paramString1, String paramString2)
  {
    try
    {
      PKCS8EncodedKeySpec localPKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(a.a(paramString2));
      PrivateKey localPrivateKey = KeyFactory.getInstance("RSA").generatePrivate(localPKCS8EncodedKeySpec);
      Signature localSignature = Signature.getInstance("SHA1WithRSA");
      localSignature.initSign(localPrivateKey);
      localSignature.update(paramString1.getBytes("utf-8"));
      String str = a.a(localSignature.sign());
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.encrypt.d
 * JD-Core Version:    0.6.0
 */