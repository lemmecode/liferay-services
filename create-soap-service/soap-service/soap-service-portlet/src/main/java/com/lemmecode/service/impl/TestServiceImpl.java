package com.lemmecode.service.impl;

import com.lemmecode.service.base.TestServiceBaseImpl;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * The implementation of the test remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.lemmecode.service.TestService} interface.
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author Brian Wing Shun Chan
 * @see com.lemmecode.service.base.TestServiceBaseImpl
 * @see com.lemmecode.service.TestServiceUtil
 */
public class TestServiceImpl extends TestServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.lemmecode.service.TestServiceUtil} to access the test remote service.
	 */

	public String getLDAPAuthStatus() {

		long company_id = 10154l;

		String ldapStatus = null;

		// Using portal-service method
		try {
			ldapStatus = PrefsPropsUtil.getString(company_id,
					PropsKeys.LDAP_AUTH_ENABLED);
			System.out.println("######portal-service#####" + ldapStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Using PortalClassInvoker to use portal-impl methods
		// Use com.liferay.portal.util.PrefsPropsUtil of portal-impl
		MethodKey testMethodKey = new MethodKey(
				"com.liferay.portal.util.PrefsPropsUtil", "getString",
				long.class, String.class);

		try {
			ldapStatus = (String) PortalClassInvoker.invoke(false,
					testMethodKey, company_id, PropsKeys.LDAP_AUTH_ENABLED);
			System.out.println("######PortalClassInvoker#####" + ldapStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Using liferay services
		// Update the preference value
		UnicodeProperties props = new UnicodeProperties();
		props.setProperty(PropsKeys.LDAP_AUTH_ENABLED, "junk");
		try {
			getCompanyLocalService().updatePreferences(company_id, props);
			ldapStatus = (String) PortalClassInvoker.invoke(false,
					testMethodKey, company_id, PropsKeys.LDAP_AUTH_ENABLED);
			System.out.println("######Services#####" + ldapStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ldapStatus;
	}
}
