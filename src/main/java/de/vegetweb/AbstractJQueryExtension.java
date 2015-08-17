package de.vegetweb;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractJavaScriptExtension;

/**
 * Abstract base class for jQuery extensions. This is used so that the jQuery.js
 * file can be from a common package for all components.
 * 
 * @author dve
 *
 */
@JavaScript({ JQueryConfig.JQUERY_JS_FILE })
public abstract class AbstractJQueryExtension
        extends AbstractJavaScriptExtension {
    // This is used so that the jQuery.js file can be from a common package for
    // all components.
}
