package com.lemmecode.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TestService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       TestService
 * @generated
 */
public class TestServiceWrapper implements TestService,
    ServiceWrapper<TestService> {
    private TestService _testService;

    public TestServiceWrapper(TestService testService) {
        _testService = testService;
    }

    public java.lang.String getLDAPAuthStatus() {
        return _testService.getLDAPAuthStatus();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public TestService getWrappedTestService() {
        return _testService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedTestService(TestService testService) {
        _testService = testService;
    }

    public TestService getWrappedService() {
        return _testService;
    }

    public void setWrappedService(TestService testService) {
        _testService = testService;
    }
}
