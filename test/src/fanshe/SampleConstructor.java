package fanshe;

import  java.lang.reflect.*;  
public   class  SampleConstructor {  
    public   static   void  main(String[] args) {  
    A r = new  A();  
    printConstructors(r);  
    }  
      
    public   static   void  printConstructors(A r) {  
    Class c = r.getClass();  
    //获取指定类的类名   
    String className = c.getName();  
    try  {  
    //获取指定类的构造方法   
    Constructor[] theConstructors = c.getConstructors();  
    for ( int  i= 0 ; i<theConstructors.length; i++) {  
    //获取指定构造方法的参数的集合   
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
