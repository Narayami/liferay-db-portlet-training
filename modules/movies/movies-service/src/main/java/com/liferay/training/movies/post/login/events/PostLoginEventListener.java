package com.liferay.training.movies.post.login.events;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;

/**
 * @author tmachado
 */
@Component(
	immediate = true,
	property = {
		"key=login.events.post"
	},
	service = LifecycleAction.class
)
public class PostLoginEventListener implements LifecycleAction {
	
	private Log log = LogFactoryUtil.getLog(PostLoginEventListener.class);
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		try {			
			long companyId = PortalUtil.getDefaultCompanyId();
			User User = UserLocalServiceUtil.getDefaultUser(companyId);
			
			MailMessage mailMessage = new MailMessage();
			
			mailMessage.setSubject("Security Alert!");
			mailMessage.setBody("Liferay detected a login, if its not you, contact an admin ASAP");
			
			InternetAddress toAdress = new InternetAddress(User.getEmailAddress());

			InternetAddress fromAdress = new InternetAddress("do-not-replyt@liferay.com");
			
			mailMessage.setTo(toAdress);
			mailMessage.setFrom(fromAdress);
			
			MailServiceUtil.sendEmail(mailMessage);
			
		} catch (PortalException e) {
			log.error(e,e);
		} catch (AddressException e) {
			log.error(e,e);
		}
	}
}
