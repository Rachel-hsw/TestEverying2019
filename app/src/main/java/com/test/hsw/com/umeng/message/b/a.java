package com.umeng.message.b;

import com.squareup.wire.Message.Builder;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;

public final class a<B extends Message.Builder>
{
  private static final int a = "$Builder".length();
  private static final Comparator<Field> b = new b();
  private final List<Field> c;

  // ERROR //
  public a(java.lang.Class<B> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 40	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 41	java/util/ArrayList:<init>	()V
    //   12: putfield 43	com/umeng/message/b/a:c	Ljava/util/List;
    //   15: aload_1
    //   16: invokevirtual 49	java/lang/Class:getName	()Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: iconst_0
    //   22: aload_2
    //   23: invokevirtual 23	java/lang/String:length	()I
    //   26: getstatic 25	com/umeng/message/b/a:a	I
    //   29: isub
    //   30: invokevirtual 53	java/lang/String:substring	(II)Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   38: astore 5
    //   40: aload 5
    //   42: invokevirtual 61	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   45: astore 6
    //   47: aload 6
    //   49: arraylength
    //   50: istore 7
    //   52: iconst_0
    //   53: istore 8
    //   55: iload 8
    //   57: iload 7
    //   59: if_icmpge +127 -> 186
    //   62: aload 6
    //   64: iload 8
    //   66: aaload
    //   67: astore 9
    //   69: aload 9
    //   71: ldc 63
    //   73: invokevirtual 69	java/lang/reflect/Field:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   76: checkcast 63	com/squareup/wire/ProtoField
    //   79: astore 10
    //   81: aload 10
    //   83: ifnull +35 -> 118
    //   86: aload 10
    //   88: invokeinterface 73 1 0
    //   93: getstatic 79	com/squareup/wire/Message$Label:REQUIRED	Lcom/squareup/wire/Message$Label;
    //   96: if_acmpne +22 -> 118
    //   99: aload_0
    //   100: getfield 43	com/umeng/message/b/a:c	Ljava/util/List;
    //   103: aload_1
    //   104: aload 9
    //   106: invokevirtual 80	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   109: invokevirtual 84	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   112: invokeinterface 90 2 0
    //   117: pop
    //   118: iinc 8 1
    //   121: goto -66 -> 55
    //   124: astore 4
    //   126: new 92	java/lang/AssertionError
    //   129: dup
    //   130: new 94	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   137: ldc 97
    //   139: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_2
    //   143: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokespecial 107	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   152: athrow
    //   153: astore 11
    //   155: new 92	java/lang/AssertionError
    //   158: dup
    //   159: new 94	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   166: ldc 109
    //   168: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 9
    //   173: invokevirtual 80	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   176: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokespecial 107	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   185: athrow
    //   186: aload_0
    //   187: getfield 43	com/umeng/message/b/a:c	Ljava/util/List;
    //   190: getstatic 32	com/umeng/message/b/a:b	Ljava/util/Comparator;
    //   193: invokestatic 115	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   196: return
    //
    // Exception table:
    //   from	to	target	type
    //   34	40	124	java/lang/ClassNotFoundException
    //   99	118	153	java/lang/NoSuchFieldException
  }

  public <B extends Message.Builder> void a(B paramB)
  {
    Object localObject1 = null;
    Object localObject2 = "";
    while (true)
    {
      int j;
      try
      {
        int i = this.c.size();
        j = 0;
        if (j >= i)
          continue;
        Field localField = (Field)this.c.get(j);
        if (localField.get(paramB) != null)
          break label136;
        if (localObject1 != null)
          break label154;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("\n  ");
        ((StringBuilder)localObject1).append(localField.getName());
        break label136;
        if (localObject1 != null)
          throw new IllegalStateException("Required field" + (String)localObject2 + " not set:" + localObject1);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError("Unable to access required fields");
      }
      return;
      label136: Object localObject3 = localObject2;
      Object localObject4 = localObject1;
      j++;
      localObject1 = localObject4;
      localObject2 = localObject3;
      continue;
      label154: localObject2 = "s";
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.a
 * JD-Core Version:    0.6.0
 */