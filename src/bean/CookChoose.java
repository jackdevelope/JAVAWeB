package bean;

import javax.servlet.http.Cookie;

public class CookChoose {
    public Cookie CookiegetCookieByName(Cookie[] cookies,String cookieName) {
        if(cookies==null) {
            return null;
        }else {
            for(Cookie cookie:cookies) {
                if(cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
            return null;
        }
    }
}
