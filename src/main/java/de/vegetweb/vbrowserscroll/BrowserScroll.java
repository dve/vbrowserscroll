package de.vegetweb.vbrowserscroll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

@JavaScript({ "browserscroll.js", "browserscroll-connector.js", "jquery-1.11.3.min.js" })
public class BrowserScroll extends AbstractJavaScriptComponent {
	public interface BrowserScrollListener extends Serializable {
		public void browserScrolled(BrowserScrollEvent event);
	}

	private Collection<BrowserScrollListener> listeners = new ArrayList<BrowserScroll.BrowserScrollListener>();

	public BrowserScroll() {
		addFunction("onTop", new JavaScriptFunction() {
			@Override
			public void call(JSONArray arguments) throws JSONException {
				updateState(arguments);
				fireEvent(BrowserScrollEvent.top(getState().pos));
			}
		});
		addFunction("notOnTop", new JavaScriptFunction() {
			@Override
			public void call(JSONArray arguments) throws JSONException {
				updateState(arguments);
				fireEvent(BrowserScrollEvent.notTop(getState().pos));
			}
		});
	}

	protected void fireEvent(BrowserScrollEvent browserScrollEvent) {
		for (BrowserScrollListener listener : listeners) {
			listener.browserScrolled(browserScrollEvent);
		}

	}

	public void addBrowserScrollListener(BrowserScrollListener listener) {
		listeners.add(listener);
	}

	public void removeBrowserScrollListener(BrowserScrollListener listener) {
		listeners.remove(listener);
	}

	@Override
	protected BrowserScrollState getState() {
		return (BrowserScrollState) super.getState();
	}

	private void updateState(JSONArray arguments) throws JSONException {
		getState().pos = arguments.getInt(0);
	}
}
