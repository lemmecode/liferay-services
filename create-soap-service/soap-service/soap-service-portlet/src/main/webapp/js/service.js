Liferay.Service.register("Liferay.Service.service", "com.lemmecode.service", "soap-service-portlet");

Liferay.Service.registerClass(
	Liferay.Service.service, "Test",
	{
		getLDAPAuthStatus: true
	}
);