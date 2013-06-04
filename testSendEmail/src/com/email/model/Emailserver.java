package com.email.model;



/**
 * Emailserver entity. @author MyEclipse Persistence Tools
 */

public class Emailserver  implements java.io.Serializable {


    // Fields    

     private String emailserverid;
     private String emailservername;
     private String emailserversuffix;


    // Constructors

    /** default constructor */
    public Emailserver() {
    }

	/** minimal constructor */
    public Emailserver(String emailserverid) {
        this.emailserverid = emailserverid;
    }
    
    /** full constructor */
    public Emailserver(String emailserverid, String emailservername, String emailserversuffix) {
        this.emailserverid = emailserverid;
        this.emailservername = emailservername;
        this.emailserversuffix = emailserversuffix;
    }

   
    // Property accessors

    public String getEmailserverid() {
        return this.emailserverid;
    }
    
    public void setEmailserverid(String emailserverid) {
        this.emailserverid = emailserverid;
    }

    public String getEmailservername() {
        return this.emailservername;
    }
    
    public void setEmailservername(String emailservername) {
        this.emailservername = emailservername;
    }

    public String getEmailserversuffix() {
        return this.emailserversuffix;
    }
    
    public void setEmailserversuffix(String emailserversuffix) {
        this.emailserversuffix = emailserversuffix;
    }
   








}