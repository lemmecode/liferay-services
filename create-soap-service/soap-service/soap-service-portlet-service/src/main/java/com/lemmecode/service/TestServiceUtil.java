package com.lemmecode.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the test remote service. This utility wraps {@link com.lemmecode.service.impl.TestServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestService
 * @see com.lemmecode.service.base.TestServiceBaseImpl
 * @see com.lemmecode.service.impl.TestServiceImpl
 * @generated
 */
public class TestServiceUtil {
    private static TestService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.lemmecode.service.impl.TestServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */
    public static void clearService() {
        _service = null;
    }

    public static TestService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    TestService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    TestService.class.getName(), portletClassLoader);

            _service = new TestServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(TestServiceUtil.class,
                "_service");
            MethodCache.remove(TestService.class);
        }

        return _service;
    }

    public void setService(TestService service) {
        MethodCache.remove(TestService.class);

        _service = service;

        ReferenceRegistry.registerReference(TestServiceUtil.class, "_service");
        MethodCache.remove(TestService.class);
    }
}
