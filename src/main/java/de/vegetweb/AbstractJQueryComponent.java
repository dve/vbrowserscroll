package de.vegetweb;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * Abstract base class for jQuery components. This is used so that the jQuery.js
 * file can be from a common package for all components.
 * 
 * @author dve
 *
 */
@JavaScript({ JQueryConfig.JQUERY_JS_FILE })
public abstract class AbstractJQueryComponent
        extends AbstractJavaScriptComponent {
    // This is used so that the jQuery.js file can be from a common package for
    // all components.
}
