/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.training.movies.model.listener;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.User;
import com.sun.mail.handlers.message_rfc822;
import com.liferay.portal.kernel.model.ModelListener;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	service = ModelListener.class
)
public class UserPostUpdateModelListener extends BaseModelListener<User> {

	private Log log = LogFactoryUtil.getLog(UserPostUpdateModelListener.class);
	
	@Override
	public void onBeforeUpdate(User model) throws ModelListenerException {
		
		try {
			MailMessage mailMessage = new MailMessage();
			
			mailMessage.setSubject("Security Alert: Account Settings!");
			mailMessage.setBody("Your Account Settings Have Been Changed!");
			
			InternetAddress toAddress = new InternetAddress(model.getEmailAddress());
			InternetAddress fromAddress = new InternetAddress("do-not-reply@liferay.com");
			
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			
			MailServiceUtil.sendEmail(mailMessage);
			
		}catch (AddressException e) {
			log.error(e,e);
		}
	}
}