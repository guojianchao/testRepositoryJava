package demo;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * <p>Title: java反射中Method类invoke方法的用法</p> *
 * <p>Description: </p> *
 * <p>Copyright: Copyright (c) 2009</p> *
 * <p>Company: </p> *
 * @author zsw
 * @version 1.0
 */
public class InvokeTester {
    
    private String name;
    
    public void setName(String name){
        this.name = name;
    }    
    public String getName(){
        return name;
    }    
    
    public InvokeTester() {
    }

    public int add(int param1, int param2) {
        return param1 + param2;
    }
    public String echo(String mesg) {
        return "echo" + mesg;
    }

    public static void main(String[] args) {
        Class classType = InvokeTester.class;
        try {
            Object invokertester = classType.newInstance();   //1
            Method addMethod = classType.getMethod("add", new Class[] {  //2
                    int.class, int.class
            });

            Object result = addMethod.invoke(invokertester, new Object[] {        //3
                                             new Integer(100), new Integer(200)
            });

            System.out.println(result);
            //////////////////////
            Method echo = classType.getMethod("echo", new Class[] {String.class});
            Object obj = echo.invoke(invokertester,
                                     new Object[] {new String("jy is very good!!!")});
            System.out.println(obj.toString());
            
            ////////////////////
            InvokeTester test = new InvokeTester();   //1
            test.setName("fg");                      //2
            
            //Method[] methods;
            Method[] methods = test.getClass().getDeclaredMethods();  //3
            
            //循环查找获取id方法，并执行查看是否有返回值
                for (int i = 0; i < methods.length; i++) {
                    
                        //如果此方法有get和Id关键字则执行
                        if (methods[i].getName().indexOf("get") != -1 && methods[i].getName().indexOf("Name") != -1) {
                                try{
                                        // 获取此get方法返回值,判断是否有值,如果没有值说明即将执行的操作新增
                                        if (methods[i].invoke(test, null) == null) {  //4                                            
                                            System.out.println("此对象没有值！！！");                             
                                        } else {
                                               Object strName =  methods[i].invoke(test, null);
                                               System.out.println(strName);
                                        }
                                }catch(Exception e){
                                        System.out.print("");
                                }
                        }
                }
        } catch (IllegalAccessException ex) {
        } catch (InstantiationException ex) {
        } catch (SecurityException ex) {
        } catch (NoSuchMethodException ex) {
        } catch (InvocationTargetException ex) {
        } catch (IllegalArgumentException ex) {
        }
    }
}

