package de.vegetweb.vbrowserscroll;

import org.vaadin.addonhelpers.AbstractTest;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;

import de.vegetweb.vbrowserscroll.BrowserScroll.BrowserScrollListener;

public class BrowserScrollDemo extends AbstractTest {

	@Override
	public Component getTestComponent() {
		VerticalLayout layout = new VerticalLayout();
		BrowserScroll browserScroll = new BrowserScroll();
		browserScroll.addBrowserScrollListener(new BrowserScrollListener() {
			@Override
			public void browserScrolled(BrowserScrollEvent event) {
				Notification.show("ScrollEvent", event.toString(), Type.HUMANIZED_MESSAGE);
			}
		});
		layout.addComponent(browserScroll);
		for (int i = 0; i < 50; i++) {
			layout.addComponent(new Label("Label - " + i));
		}
		return layout;
	}

}
