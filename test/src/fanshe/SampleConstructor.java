package fanshe;

import  java.lang.reflect.*;  
public   class  SampleConstructor {  
    public   static   void  main(String[] args) {  
    A r = new  A();  
    printConstructors(r);  
    }  
      
    public   static   void  printConstructors(A r) {  
    Class c = r.getClass();  
    //��ȡָ���������   
    String className = c.getName();  
    try  {  
    //��ȡָ����Ĺ��췽��   
    Constructor[] theConstructors = c.getConstructors();  
    for ( int  i= 0 ; i<theConstructors.length; i++) {  
    //��ȡָ�����췽���Ĳ����ļ���   
    Class[] parameterTypes = theConstructors[i].getParameterTypes();  
      
    System.out.print(className + "(" );  
      
    for ( int  j= 0 ; j<parameterTypes.length; j++)  
    System.out.print(parameterTypes[j].getName() + " " );  
      
    System.out.println(")" );  
      
    }  
    }catch (Exception e) {  
    e.printStackTrace();  
    }  
    }  
  }  
