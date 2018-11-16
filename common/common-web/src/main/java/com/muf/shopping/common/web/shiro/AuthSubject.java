package com.muf.shopping.common.web.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * description:
 * @author: hutao
 * @date 2018/11/15 10:23
 */
public class AuthSubject extends DefaultWebSubjectFactory {
    @Override
    public Subject createSubject(SubjectContext context) {
        //不创建session
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
