/**
 * Copyright (c) 2005-2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Eclipse Public License (EPL).
 * Please see the license.txt included with this distribution for details.
 * Any modifications to this file must keep this entire header intact.
 */
/*
 * Author: atotic
 * Author: fabioz
 * 
 * Created: Jul 10, 2003
 */
package org.python.pydev.outline;

import java.util.List;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IActionBars;
import org.python.pydev.core.ExtensionHelper;
import org.python.pydev.editor.PyEdit;
import org.python.pydev.plugin.PydevPlugin;
import org.python.pydev.shared_ui.SharedUiPlugin;
import org.python.pydev.shared_ui.outline.BaseOutlinePage;
import org.python.pydev.shared_ui.utils.IViewWithControls;
import org.python.pydev.ui.IViewCreatedObserver;

/**
 * Outline page, displays the structure of the document in the editor window. 
 *
 * Partition outlining:<p>
 * PyDocumentProvider already partitions the document into strings/comments/other<p>
 * RawPartition is the simplest outline that shows this "raw" document partitioning<p>
 * raw partition was only used as an example, not useful in production<p>
 * 
 * @note: tests for the outline page are not directly for the outline page, but for its model, 
 * based on ParsedItems.
 **/
@SuppressWarnings({ "unchecked" })
public class PyOutlinePage extends BaseOutlinePage implements IViewWithControls {

    public PyOutlinePage(PyEdit editorView) {
        super(editorView, SharedUiPlugin.getImageCache(), "org.python.pydev");
        List<IViewCreatedObserver> participants = ExtensionHelper
                .getParticipants(ExtensionHelper.PYDEV_VIEW_CREATED_OBSERVER);
        for (IViewCreatedObserver iViewCreatedObserver : participants) {
            iViewCreatedObserver.notifyViewCreated(this);
        }
    }

    /**
     * 
     * @return the parsed model, so that it can be used elsewhere (in navigation)
     */
    public ParsedModel createParsedModel() {
        return new ParsedModel(this, (PyEdit) editorView);
    }

    /**
     * @return the preference store we should use
     */
    public IPreferenceStore getStore() {
        return PydevPlugin.getDefault().getPreferenceStore();
    }

    protected void createActions() {
        super.createActions();

        IActionBars actionBars = getSite().getActionBars();

        IMenuManager menuManager = actionBars.getMenuManager();
        menuManager.add(new OutlineHideCommentsAction(this, imageCache));
        menuManager.add(new OutlineHideImportsAction(this, imageCache));
        menuManager.add(new OutlineHideMagicObjectsAction(this, imageCache));
        menuManager.add(new OutlineHideFieldsAction(this, imageCache));
        menuManager.add(new OutlineHideNonPublicMembersAction(this, imageCache));
        menuManager.add(new OutlineHideStaticMethodsAction(this, imageCache));
    }

}
