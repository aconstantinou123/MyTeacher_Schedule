package com.myteacher.Schedule.Security;

public class SecurityConstants {
    public static final String SECRET = "b3k60snNSUbtS4zidBgiYgSkXPMcdwta";
    public static final String REMEMBER_ME_SECRET = "uniqueAndSecret";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String RELOAD_URL = "/.~~spring-boot!~/restart";
}
