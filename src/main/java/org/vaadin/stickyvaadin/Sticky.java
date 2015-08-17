package org.vaadin.stickyvaadin;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractComponent;

import de.vegetweb.AbstractJQueryExtension;

@JavaScript({ "jquery.sticky.js", "sticky.js" })
public class Sticky extends AbstractJQueryExtension {

    private static final long serialVersionUID = -2192286911089320484L;

    private boolean isSticky = false;

    public Sticky(AbstractComponent target) {
        extend(target);
        getState().stickyId = target.getId();
    }

    @Override
    protected StickyState getState() {
        return (StickyState) super.getState();
    }

    public void setTopSpacingInPx(int pxs) {
        if (isSticky) {
            makeUnSticky();
            getState().topSpacingInPx = pxs;
            makeSticky();
        } else {
            getState().topSpacingInPx = pxs;
        }
    }

    public void makeSticky() {
        callFunction("makeSticky");
        isSticky = true;
    }

    public void makeUnSticky() {
        callFunction("makeUnSticky");
        isSticky = false;
    }

    public boolean isSticky() {
        return isSticky;
    }
}
