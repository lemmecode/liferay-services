package com.lemmecode.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;


public class TestServiceClp implements TestService {
    private ClassLoaderProxy _classLoaderProxy;

    public TestServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;
    }

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }
}
