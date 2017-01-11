/*
 * Copyright 2014 Roland Krüger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.highlighter.client.extension;

import com.google.gwt.resources.client.CssResource;

/**
 * {@link CssResource} interface for the component highlighter. This resource
 * interface provides two style names for the highlighter. The first style
 * {@link #parentOutline()} is set on the extended component's widget itself.
 * This can be used to style the component's widget itself. This style is
 * currently only set on the widget, but its CSS definition is empty. The second
 * style {@link #debugLabel()} will be set on the highlighting label itself. By
 * default, a pink background color is set for this label so that it stands out
 * when rendered in the browser.
 *
 * @author Roland Krüger
 */
public interface ComponentHighlighterStyle extends CssResource {
    /**
     * <p>
     * CSS style name set on the extended component's widget.
     * </p>
     * <p>
     * Note that by default the CSS definition for this style is empty. This style
     * is thought to be used to draw an eye-catching border around the extended
     * component's widget or anything similar. Unfortunately, this did not work
     * out as hoped for since adding a border around the widget through this
     * method disturbed Vaadin's layouting algorithm in such a way that in certain
     * situations (e.g. when decorating a table component) a number of client-side
     * exceptions where induced.
     * </p>
     *
     * @return parentOutline style
     */
    String parentOutline();

    /**
     * CSS style name set on the highlighting label span-element.
     *
     * @return debugLabel style
     */
    String debugLabel();
}
