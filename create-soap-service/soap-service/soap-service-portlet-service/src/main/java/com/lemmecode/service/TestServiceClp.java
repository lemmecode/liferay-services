package com.lemmecode.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;


public class TestServiceClp implements TestService {
    private ClassLoaderProxy _classLoaderProxy;
    private MethodKey _getLDAPAuthStatusMethodKey0;

    public TestServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;

        _getLDAPAuthStatusMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
                "getLDAPAuthStatus");
    }

    public java.lang.String getLDAPAuthStatus() {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getLDAPAuthStatusMethodKey0);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }
}
