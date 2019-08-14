package com.squareup.wire;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Redactor<T extends Message>
{
  private static final Redactor<?> a = new Redactor.1(null, null, null, null);
  private static final Map<Class<? extends Message>, Redactor> b = new LinkedHashMap();
  private final Constructor<?> c;
  private final List<Field> d;
  private final List<Field> e;
  private final List<Redactor<?>> f;

  Redactor(Constructor<?> paramConstructor, List<Field> paramList1, List<Field> paramList2, List<Redactor<?>> paramList)
  {
    this.c = paramConstructor;
    this.d = paramList1;
    this.e = paramList2;
    this.f = paramList;
  }

  // ERROR //
  public static <T extends Message> Redactor<T> get(Class<T> paramClass)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 36	com/squareup/wire/Redactor:b	Ljava/util/Map;
    //   8: aload_0
    //   9: invokeinterface 56 2 0
    //   14: checkcast 2	com/squareup/wire/Redactor
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +8 -> 27
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_3
    //   26: areturn
    //   27: new 58	com/squareup/wire/Redactor$a
    //   30: dup
    //   31: invokespecial 59	com/squareup/wire/Redactor$a:<init>	()V
    //   34: astore 4
    //   36: getstatic 36	com/squareup/wire/Redactor:b	Ljava/util/Map;
    //   39: aload_0
    //   40: aload 4
    //   42: invokeinterface 63 3 0
    //   47: pop
    //   48: new 65	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   55: aload_0
    //   56: invokevirtual 72	java/lang/Class:getName	()Ljava/lang/String;
    //   59: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 78
    //   64: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 85	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   73: astore 8
    //   75: new 87	java/util/ArrayList
    //   78: dup
    //   79: invokespecial 88	java/util/ArrayList:<init>	()V
    //   82: astore 9
    //   84: new 87	java/util/ArrayList
    //   87: dup
    //   88: invokespecial 88	java/util/ArrayList:<init>	()V
    //   91: astore 10
    //   93: new 87	java/util/ArrayList
    //   96: dup
    //   97: invokespecial 88	java/util/ArrayList:<init>	()V
    //   100: astore 11
    //   102: aload_0
    //   103: invokevirtual 92	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   106: astore 12
    //   108: aload 12
    //   110: arraylength
    //   111: istore 13
    //   113: iload_1
    //   114: iload 13
    //   116: if_icmpge +195 -> 311
    //   119: aload 12
    //   121: iload_1
    //   122: aaload
    //   123: astore 14
    //   125: aload 14
    //   127: invokevirtual 98	java/lang/reflect/Field:getModifiers	()I
    //   130: invokestatic 104	java/lang/reflect/Modifier:isStatic	(I)Z
    //   133: ifeq +6 -> 139
    //   136: goto +249 -> 385
    //   139: aload 14
    //   141: ldc 106
    //   143: invokevirtual 110	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   146: checkcast 106	com/squareup/wire/ProtoField
    //   149: astore 15
    //   151: aload 15
    //   153: ifnull +92 -> 245
    //   156: aload 15
    //   158: invokeinterface 114 1 0
    //   163: ifeq +82 -> 245
    //   166: aload 15
    //   168: invokeinterface 118 1 0
    //   173: getstatic 124	com/squareup/wire/Message$Label:REQUIRED	Lcom/squareup/wire/Message$Label;
    //   176: if_acmpne +36 -> 212
    //   179: new 126	java/lang/IllegalArgumentException
    //   182: dup
    //   183: ldc 128
    //   185: iconst_1
    //   186: anewarray 5	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload 14
    //   193: aastore
    //   194: invokestatic 134	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   197: invokespecial 137	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   200: athrow
    //   201: astore 7
    //   203: aload 7
    //   205: athrow
    //   206: astore_2
    //   207: ldc 2
    //   209: monitorexit
    //   210: aload_2
    //   211: athrow
    //   212: aload 9
    //   214: aload 8
    //   216: aload 14
    //   218: invokevirtual 138	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   221: invokevirtual 142	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   224: invokeinterface 148 2 0
    //   229: pop
    //   230: goto +155 -> 385
    //   233: astore 6
    //   235: new 150	java/lang/AssertionError
    //   238: dup
    //   239: aload 6
    //   241: invokespecial 153	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   244: athrow
    //   245: ldc 155
    //   247: aload 14
    //   249: invokevirtual 159	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   252: invokevirtual 163	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   255: ifeq +130 -> 385
    //   258: aload 8
    //   260: aload 14
    //   262: invokevirtual 138	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   265: invokevirtual 142	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   268: astore 16
    //   270: aload 16
    //   272: invokevirtual 159	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   275: invokestatic 165	com/squareup/wire/Redactor:get	(Ljava/lang/Class;)Lcom/squareup/wire/Redactor;
    //   278: astore 17
    //   280: aload 17
    //   282: getstatic 30	com/squareup/wire/Redactor:a	Lcom/squareup/wire/Redactor;
    //   285: if_acmpeq +100 -> 385
    //   288: aload 10
    //   290: aload 16
    //   292: invokeinterface 148 2 0
    //   297: pop
    //   298: aload 11
    //   300: aload 17
    //   302: invokeinterface 148 2 0
    //   307: pop
    //   308: goto +77 -> 385
    //   311: aload 9
    //   313: invokeinterface 168 1 0
    //   318: ifeq +37 -> 355
    //   321: aload 10
    //   323: invokeinterface 168 1 0
    //   328: ifeq +27 -> 355
    //   331: getstatic 30	com/squareup/wire/Redactor:a	Lcom/squareup/wire/Redactor;
    //   334: astore_3
    //   335: aload 4
    //   337: aload_3
    //   338: invokevirtual 171	com/squareup/wire/Redactor$a:a	(Lcom/squareup/wire/Redactor;)V
    //   341: getstatic 36	com/squareup/wire/Redactor:b	Ljava/util/Map;
    //   344: aload_0
    //   345: aload_3
    //   346: invokeinterface 63 3 0
    //   351: pop
    //   352: goto -330 -> 22
    //   355: new 2	com/squareup/wire/Redactor
    //   358: dup
    //   359: aload 8
    //   361: iconst_1
    //   362: anewarray 68	java/lang/Class
    //   365: dup
    //   366: iconst_0
    //   367: aload_0
    //   368: aastore
    //   369: invokevirtual 175	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   372: aload 9
    //   374: aload 10
    //   376: aload 11
    //   378: invokespecial 176	com/squareup/wire/Redactor:<init>	(Ljava/lang/reflect/Constructor;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V
    //   381: astore_3
    //   382: goto -47 -> 335
    //   385: iinc 1 1
    //   388: goto -275 -> 113
    //
    // Exception table:
    //   from	to	target	type
    //   48	113	201	java/lang/RuntimeException
    //   119	136	201	java/lang/RuntimeException
    //   139	151	201	java/lang/RuntimeException
    //   156	201	201	java/lang/RuntimeException
    //   212	230	201	java/lang/RuntimeException
    //   245	308	201	java/lang/RuntimeException
    //   311	335	201	java/lang/RuntimeException
    //   335	352	201	java/lang/RuntimeException
    //   355	382	201	java/lang/RuntimeException
    //   5	18	206	finally
    //   27	48	206	finally
    //   48	113	206	finally
    //   119	136	206	finally
    //   139	151	206	finally
    //   156	201	206	finally
    //   203	206	206	finally
    //   212	230	206	finally
    //   235	245	206	finally
    //   245	308	206	finally
    //   311	335	206	finally
    //   335	352	206	finally
    //   355	382	206	finally
    //   48	113	233	java/lang/Exception
    //   119	136	233	java/lang/Exception
    //   139	151	233	java/lang/Exception
    //   156	201	233	java/lang/Exception
    //   212	230	233	java/lang/Exception
    //   245	308	233	java/lang/Exception
    //   311	335	233	java/lang/Exception
    //   335	352	233	java/lang/Exception
    //   355	382	233	java/lang/Exception
  }

  public T redact(T paramT)
  {
    if (paramT == null)
      return null;
    Message.Builder localBuilder;
    try
    {
      localBuilder = (Message.Builder)this.c.newInstance(new Object[] { paramT });
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
        ((Field)localIterator.next()).set(localBuilder, null);
    }
    catch (Exception localException)
    {
      throw new AssertionError(localException.getMessage());
    }
    for (int i = 0; i < this.e.size(); i++)
    {
      Field localField = (Field)this.e.get(i);
      localField.set(localBuilder, ((Redactor)this.f.get(i)).redact((Message)localField.get(localBuilder)));
    }
    Message localMessage = localBuilder.build();
    return localMessage;
  }

  static class a<T extends Message> extends Redactor<T>
  {
    private Redactor<T> a;

    public a()
    {
      super(null, null, null);
    }

    public void a(Redactor<T> paramRedactor)
    {
      this.a = paramRedactor;
    }

    public T redact(T paramT)
    {
      if (this.a == null)
        throw new IllegalStateException("Delegate was not set.");
      return this.a.redact(paramT);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.wire.Redactor
 * JD-Core Version:    0.6.0
 */