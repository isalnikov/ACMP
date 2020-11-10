package ru.isalnikov.iteco;


public class Test4 {

    public String join(String[] args) {
        String result = "";
        for (String arg : args) {
            result += arg;
            result += ", ";
        }
        return result;
    }
    
    public String joinBest(String[] args) {
        String result = String.join(",", args);
        return result;
    }
}


//public class ru.isalnikov.iteco.Test4 {
//  public ru.isalnikov.iteco.Test4();
//    Code:
//       0: aload_0
//       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//       4: return
//
//  public java.lang.String join(java.lang.String[]);
//    Code:
//       0: ldc           #2                  // String
//       2: astore_2
//       3: aload_1
//       4: astore_3
//       5: aload_3
//       6: arraylength
//       7: istore        4
//       9: iconst_0
//      10: istore        5
//      12: iload         5
//      14: iload         4
//      16: if_icmpge     47
//      19: aload_3
//      20: iload         5
//      22: aaload
//      23: astore        6
//      25: aload_2
//      26: aload         6
//      28: invokedynamic #3,  0              // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
//      33: astore_2
//      34: aload_2
//      35: invokedynamic #4,  0              // InvokeDynamic #1:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
//      40: astore_2
//      41: iinc          5, 1
//      44: goto          12
//      47: aload_2
//      48: areturn
//
//  public java.lang.String joinBest(java.lang.String[]);
//    Code:
//       0: ldc           #5                  // String ,
//       2: aload_1
//       3: invokestatic  #6                  // Method java/lang/String.join:(Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Ljava/lang/String;
//       6: astore_2
//       7: aload_2
//       8: areturn
//}
//
