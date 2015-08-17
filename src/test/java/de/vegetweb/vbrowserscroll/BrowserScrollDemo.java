package de.vegetweb.vbrowserscroll;

import org.vaadin.addonhelpers.AbstractTest;

import com.vaadin.ui.*;
import com.vaadin.ui.Button.*;
import com.vaadin.ui.Notification.Type;

import de.vegetweb.vbrowserscroll.BrowserScroll.BrowserScrollListener;

public class BrowserScrollDemo extends AbstractTest {

    @Override
    public Component getTestComponent() {
        VerticalLayout layout = new VerticalLayout();
        final BrowserScroll browserScroll = new BrowserScroll();
        browserScroll.addBrowserScrollListener(new BrowserScrollListener() {
            @Override
            public void browserScrolled(BrowserScrollEvent event) {
                Notification.show("ScrollEvent", event.toString(),
                        Type.HUMANIZED_MESSAGE);
            }
        });
        layout.addComponent(browserScroll);

        final TextField topThresholdTextField = new TextField("Top threshold");
        Button topThresholdButton = new Button("Set top threshold",
                new ClickListener() {

                    @Override
                    public void buttonClick(ClickEvent event) {
                        try {
                            int topThreshold = Integer
                                    .valueOf(topThresholdTextField.getValue());
                            browserScroll.setTopThreshold(topThreshold);
                        } catch (NumberFormatException e) {

                        }

                    }
                });
        HorizontalLayout thresholdLayout = new HorizontalLayout(
                topThresholdTextField, topThresholdButton);
        thresholdLayout.setSpacing(true);
        thresholdLayout.setComponentAlignment(topThresholdButton,
                Alignment.BOTTOM_LEFT);
        layout.addComponent(thresholdLayout);
        for (int i = 0; i < 50; i++) {
            layout.addComponent(new Label("Label - " + i));
        }
        return layout;
    }

}
