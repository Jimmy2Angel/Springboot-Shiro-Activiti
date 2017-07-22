package indi.baojie.supervision.shiro;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lollipop on 2017/6/20.
 * 解决shiro第一次重定向时候url带有jsessionid的问题
 */
public class MyShiroHttpServletResponse extends ShiroHttpServletResponse {
    public MyShiroHttpServletResponse(HttpServletResponse wrapped, ServletContext context, ShiroHttpServletRequest request) {
        super(wrapped, context, request);
    }

    @Override
    public String encodeRedirectURL(String url){
        /** 下面是ShiroHttpServletResponse源码，重写shiro的encodeRedirectURL方法，把url路径里的JSESSIONID去掉 **/
//        if (isEncodeable(toAbsolute(url))) {
//            return toEncoded(url, request.getSession().getId());
//        } else {
//            return url;
//        }
        return url;
    }
    @Override
    protected String toEncoded(String url, String sessionId) {
        if ((url == null) || (sessionId == null))
            return (url);

        String path = url;
        String query = "";
        String anchor = "";
        int question = url.indexOf('?');
        if (question >= 0) {
            path = url.substring(0, question);
            query = url.substring(question);
        }
        int pound = path.indexOf('#');
        if (pound >= 0) {
            anchor = path.substring(pound);
            path = path.substring(0, pound);
        }
        StringBuilder sb = new StringBuilder(path);
        /**  下面是ShiroHttpServletResponse源码，重写shiro的toEncoded方法使其不拼接JSESSIONID **/
//        if (sb.length() > 0) { // session id param can't be first.
//            sb.append(";");
//            sb.append(DEFAULT_SESSION_ID_PARAMETER_NAME);
//            sb.append("=");
//            sb.append(sessionId);
//        }
        sb.append(anchor);
        sb.append(query);
        return (sb.toString());

    }
}
